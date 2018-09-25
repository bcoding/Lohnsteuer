package de.powerproject.lohnpap.generator;

import static com.github.javaparser.ast.Modifier.*;
import static com.github.javaparser.ast.expr.AssignExpr.Operator.ASSIGN;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.WildcardType;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.printer.PrettyPrinter;

/**
 * Copyright 2015-2016 Marcel Lehmann
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * @author Marcel Lehmann
 */

public class Generator {

    public static final List<PapFile> PAP_FILES;

    static {
        PAP_FILES = new ArrayList<>();
        // neueste Eintrag immer oben und Ende = null
        PAP_FILES.add(new PapFile("Lohnsteuer2018.xml", 2018, 1, null));
        PAP_FILES.add(new PapFile("Lohnsteuer2017.xml", 2017, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2016.xml", 2016, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2015Dezember.xml", 2015, 12, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2015.xml", 2015, 1, 11));
        PAP_FILES.add(new PapFile("Lohnsteuer2014.xml", 2014, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2013.xml", 2013, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2012.xml", 2012, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2011Dezember.xml", 2011, 12, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2011.xml", 2011, 1, 11));
        PAP_FILES.add(new PapFile("Lohnsteuer2010.xml", 2010, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2009.xml", 2009, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2008.xml", 2008, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2007.xml", 2007, 1, 12));
        PAP_FILES.add(new PapFile("Lohnsteuer2006.xml", 2006, 1, 12));
    }

    public static void generatePapFiles(Path targetDir) throws Exception {

        try {
            targetDir = targetDir.resolve(Paths.get("de", "powerproject", "lohnpap", "pap"));
            targetDir.toFile().mkdirs();

            Map<String, Parser.VarWithComment> allInputVars = new HashMap<>();
            Map<String, Parser.VarWithComment> allOutputVars = new HashMap<>();

            final CompilationUnit lohnEnumUnit = new CompilationUnit();
            final EnumDeclaration lohnsteuerPap = lohnEnumUnit.addEnum("LohnsteuerPap", PUBLIC);
            final ConstructorDeclaration enumConstructor = lohnsteuerPap.addConstructor();

            final BlockStmt body = new BlockStmt();
            enumConstructor.setBody(body);
            for(String field : Arrays.asList("year", "fromMonth", "toMonth")) {
                addEnumParameter(lohnsteuerPap, enumConstructor, body, field, Integer.class);
            }

            final String name = "de.powerproject.lohnpap.pap.LohnsteuerInterface";

            final ClassOrInterfaceType type = new ClassOrInterfaceType(null, new SimpleName(Class.class.getName()), new NodeList<>(new WildcardType(new ClassOrInterfaceType(name))));
            enumConstructor.addParameter(type, "papClass");
            body.addStatement(new AssignExpr(new FieldAccessExpr(new ThisExpr(), "papClass"), new NameExpr("papClass"), ASSIGN));
            lohnsteuerPap.addField(type, "papClass", PRIVATE).createGetter();

            for (PapFile pf : PAP_FILES) {
                final Parser.PapParseResult result = new Parser(pf, targetDir).parse();
                allInputVars.putAll(result.getInputVars());
                allOutputVars.putAll(result.getOutputVars());

                final ClassOrInterfaceDeclaration papClass = createPapClass(result, pf);
                papClass.addImplementedType(name);
                final CompilationUnit compilationUnit = new CompilationUnit();
                compilationUnit.addType(papClass);
                compilationUnit.addImport(BigDecimal.class);
                write(targetDir, compilationUnit);

                final EnumConstantDeclaration decl = lohnsteuerPap.addEnumConstant(pf.name.toUpperCase());
                decl.addArgument(new IntegerLiteralExpr(pf.year));
                decl.addArgument(new IntegerLiteralExpr(pf.from));
                decl.addArgument(pf.to != null ? new IntegerLiteralExpr(pf.to) : new NullLiteralExpr());
                decl.addArgument(new ClassExpr(new ClassOrInterfaceType(compilationUnit.getPackageDeclaration().get().getNameAsString() + "." + papClass.getNameAsString())));
            }

            write(targetDir, lohnEnumUnit);

//            createBean(targetDir, allInputVars, "LohnsteuerInput");
//            createBean(targetDir, allOutputVars, "LohnsteuerOutput");
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void addEnumParameter(EnumDeclaration lohnsteuerPap, ConstructorDeclaration enumConstructor,
                                         BlockStmt body, String field, Class<?> paramClass) {
        enumConstructor.addParameter(paramClass, field);
        body.addStatement(new AssignExpr(new FieldAccessExpr(new ThisExpr(), field), new NameExpr(field), ASSIGN));
        lohnsteuerPap.addField(paramClass, field, PRIVATE).createGetter();
    }

    private static void createBean(Path targetDir, Map<String, Parser.VarWithComment> allInputVars, String className) throws IOException {
        CompilationUnit unit = new CompilationUnit();
        unit.addImport(BigDecimal.class);
        final ClassOrInterfaceDeclaration lohnsteuerInput = unit.addClass(className, PUBLIC);
        allInputVars.values().stream()
                .map(var -> {
                    final FieldDeclaration declaration = lohnsteuerInput.addField(var.getType(), var.getName());
                    if(var.getComment() != null) {
                        declaration.setJavadocComment(var.getComment());
                    }
                    final VariableDeclarator variableDeclarator = new VariableDeclarator(
                            declaration.getCommonType(),
                            var.getName(),
                            JavaParser.parseExpression(var.getDefault()));
                    declaration.setVariables(new NodeList<>(variableDeclarator));
                    return declaration;
                }).collect(Collectors.toList()).stream().forEach(field -> {
            field.createGetter();
            field.createSetter();
        });
        write(targetDir, unit);
    }

    private static void write(Path targetDir, CompilationUnit compilationUnit) throws IOException {
        compilationUnit.setPackageDeclaration("de.powerproject.lohnpap.pap");
        final FileOutputStream fos = new FileOutputStream(targetDir.resolve(Paths.get(compilationUnit.getTypes().get(0).getNameAsString() + ".java")).toFile());
        OutputStreamWriter w = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(w);
        bw.write(new PrettyPrinter().print(compilationUnit));
        bw.flush();
        bw.close();
    }

    private static ClassOrInterfaceDeclaration createPapClass(Parser.PapParseResult result,
                                                              PapFile papFile) {
        try {
            final ClassOrInterfaceDeclaration papClas = new ClassOrInterfaceDeclaration(PUBLIC.toEnumSet(), false, papFile.getName());

            result.getConstants().forEach(constant ->
            {
                final FieldDeclaration declaration = papClas.addField(constant.getType(), constant.getName(), PRIVATE, FINAL, STATIC);
                final VariableDeclarator variableDeclarator = new VariableDeclarator(
                        declaration.getCommonType(),
                        constant.getName(),
                        parseInitializer(constant, declaration));
                declaration.setVariables(new NodeList<>(variableDeclarator));
            });

            for (Map.Entry<String, Parser.VarWithComment> e : result.getInternalVars().entrySet()) {
                final Parser.VarWithComment value = e.getValue();
                final FieldDeclaration declaration = papClas.addField(value.getType(), value.getName(), PRIVATE);
                declaration.setVariables(new NodeList<>(new VariableDeclarator(
                        declaration.getCommonType(),
                        value.getName(),
                        JavaParser.parseExpression(value.getDefault())
                )));
            }

            final ClassOrInterfaceType lohnsteuerOutput = new ClassOrInterfaceType("LohnsteuerOutput");
            papClas.addField(lohnsteuerOutput, "output", PRIVATE);

            final ClassOrInterfaceType lohnsteuerInput = new ClassOrInterfaceType("LohnsteuerInput");
            papClas.addField(lohnsteuerInput, "input", PRIVATE);

            final ConstructorDeclaration constructor = papClas.addConstructor(PUBLIC);
            constructor.addParameter(new Parameter(lohnsteuerInput, "input"));
            final BlockStmt constructorBody = new BlockStmt();
            constructor.setBody(constructorBody);
            constructorBody.addStatement(new AssignExpr(
                    new FieldAccessExpr(new ThisExpr(), "input"),
                    new NameExpr("input"),
                    ASSIGN
            ));

            result.getMethods().forEach(meth -> updateInputAndOutputAccess(meth, result.getInputVars(), result.getOutputVars()));

            final MethodDeclaration calculate = papClas.addMethod("calculate", PUBLIC);
            calculate.setType(new ClassOrInterfaceType("LohnsteuerOutput"));
            final Optional<MethodDeclaration> main = result.getMethods().stream()
                    .filter(md -> md.getNameAsString().equals("main")).findFirst();
            final BlockStmt body = main.get().getBody().get();
            body.addStatement(0, new AssignExpr(
                    new NameExpr("output"),
                    new ObjectCreationExpr(null, new ClassOrInterfaceType("LohnsteuerOutput"), new NodeList<>()),
                    ASSIGN));
            body.addStatement(new ReturnStmt(new NameExpr("output")));
            calculate.setBody(body);

            result.getMethods().stream()
                    .filter(md -> !md.getNameAsString().equals("main"))
                    .forEach(papClas::addMember);

            return papClas;
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private static Expression parseInitializer(Parser.Const constant, FieldDeclaration declaration) {
        return declaration.getCommonType().isArrayType() ?
                parseArrayInitializer(declaration.getCommonType(), constant.getValue()) : JavaParser.parseExpression(constant.getValue());
    }

    private static void updateInputAndOutputAccess(MethodDeclaration methodDeclaration,
                                                   Map<String, Parser.VarWithComment> inputVars,
                                                   Map<String, Parser.VarWithComment> outputVars) {
        methodDeclaration.getBody().ifPresent(body -> {
            final GenericVisitorAdapter<Visitable, Object> visitor = new GenericVisitorAdapter<Visitable, Object>() {
                @Override
                public Visitable visit(NameExpr n, Object arg) {
                    String name = n.getNameAsString();
                    if (outputVars.containsKey(name)) {
                        final Node parent = n.getParentNode().get();
                        parent.replace(n, new FieldAccessExpr(new NameExpr("output"), name));
                    }
                    if (inputVars.containsKey(name)) {
                        final Node parent = n.getParentNode().get();
                        parent.replace(n, new FieldAccessExpr(new NameExpr("input"), name));
                    }
                    return super.visit(n, arg);
                }
            };
            body.accept(visitor, new Object());
        });
    }

    private static Expression parseArrayInitializer(Type commonType, String expression) {
        final List<Expression> elements = Arrays.stream(expression.substring(1, expression.length() - 1).split(","))
                .map(str -> (Expression) JavaParser.parseExpression(str)).collect(Collectors.toList());
        return new ArrayInitializerExpr(new NodeList<>(elements));
    }
}
