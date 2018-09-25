package de.powerproject.lohnpap.generator;

import static com.github.javaparser.ast.Modifier.PROTECTED;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.type.VoidType;

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

public class Parser {

    private Path path;
    private PapFile pf;

    private boolean failed = false;

    Parser(PapFile pf, Path path) throws Exception {
        this.pf = pf;
        this.path = path;
    }

    PapParseResult parse() throws Exception {

        System.out.println("parse file " + pf.xmlfileName);

        SAXParserFactory f = SAXParserFactory.newInstance();
        SAXParser p = f.newSAXParser();

        p.setProperty("http://xml.org/sax/properties/lexical-handler", new PAPCommentReader());

        PapHandler h = new PapHandler();
        p.parse(getClass().getResourceAsStream("/" + pf.xmlfileName), h);

        if (failed) {
            throw new IOException("error occurred");
        }

        return new PapParseResult(h.constants, h.methods,
                h.inputVars,
                h.outputVars,
                h.internalVars);
    }

    private boolean variables;
    private String lastComment = null;

    protected String getAndClearLastComment() throws IOException {

        if (lastComment != null) {
            if (!lastComment.isEmpty()) {
                return lastComment;
            }
            lastComment = null;
        }
        return null;
    }

    class PapHandler extends DefaultHandler {

        private MethodDeclaration currentMethodDeclaration;
        private BlockStmt currentBlock;
        private Map<String, VarWithComment> inputVars = new HashMap<String, VarWithComment>();
        private Map<String, VarWithComment> outputVars = new HashMap<String, VarWithComment>();
        private Map<String, VarWithComment> internalVars = new HashMap<String, VarWithComment>();
        private List<MethodDeclaration> methods = new ArrayList<>();
        private List<Const> constants = new ArrayList<>();
        private Stack<BlockStmt> blockStack = new Stack<>();
        private Stack<IfStmt> ifStack = new Stack<>();

        PapHandler() {
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {

            try {
                if ("VARIABLES".equals(qName)) {
                    variables = true;
                } else if ("INPUT".equals(qName) || "OUTPUT".equals(qName) || "INTERNAL".equals(qName)) {
                    String type = attributes.getValue("type");
                    String name = attributes.getValue("name");

                    final VarWithComment var = new VarWithComment(name, getAndClearLastComment(), type, attributes.getValue("default"));

                    if ("INTERNAL".equals(qName)) {
                        internalVars.put(name, var);
                    } else if ("INPUT".equals(qName)) {
                        inputVars.put(name, var);
                    } else if ("OUTPUT".equals(qName)) {
                        outputVars.put(name, var);
                    }
                } else if ("CONSTANT".equals(qName)) {
                    String type = attributes.getValue("type");
                    String name = attributes.getValue("name");
                    String value = attributes.getValue("value");
                    constants.add(new Const(type, name, value));
                } else if ("EXECUTE".equals(qName)) {
                    String method = attributes.getValue("method");
                    currentBlock.addStatement(new MethodCallExpr(method));
                } else if ("METHOD".equals(qName) || "MAIN".equals(qName)) {
                    String methodName = attributes.getValue("name");
                    if (methodName == null) {
                        currentMethodDeclaration = new MethodDeclaration(PROTECTED.toEnumSet(), new VoidType(), "main");
                    } else {
                        currentMethodDeclaration = new MethodDeclaration(PROTECTED.toEnumSet(), new VoidType(), methodName);
                    }
                    methods.add(currentMethodDeclaration);
                    addBlock();
                    currentMethodDeclaration.setBody(currentBlock);
                } else if ("EVAL".equals(qName)) {
                    String exec = attributes.getValue("exec");
                    if (!exec.endsWith(";")) {
                        exec = exec + ";";
                    }
                    currentBlock.addStatement(JavaParser.parseStatement(exec));
                } else if ("IF".equals(qName)) {
                    final IfStmt ifStmt = addIf();
                    String expr = attributes.getValue("expr");
                    ifStmt.setCondition(JavaParser.parseExpression(expr));
                    currentBlock.addStatement(ifStmt);
                } else if ("THEN".equals(qName)) {
                    addBlock();
                    ifStack.peek().setThenStmt(currentBlock);
                } else if ("ELSE".equals(qName)) {
                    addBlock();
                    ifStack.peek().setElseStmt(currentBlock);
                }
            } catch (Exception e) {
                e.printStackTrace();
                failed = true;
            }
        }

        private IfStmt addIf() {
            IfStmt ifStmt = new IfStmt();
            ifStack.push(ifStmt);
            return ifStmt;
        }

        private BlockStmt addBlock() {
            final BlockStmt blockStmt = new BlockStmt();
            blockStack.push(blockStmt);
            currentBlock = blockStmt;
            return blockStmt;
        }

        private void popBlock() {
            blockStack.pop();
            currentBlock = blockStack.peek();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            try {
                if ("VARIABLES".equals(qName)) {
                    variables = false;
                } else if ("CONSTANTS".equals(qName)) {
                    boolean processingConstants = false;
                } else if ("METHOD".equals(qName)) {
                    currentMethodDeclaration = null;
                    popBlock();
                } else if ("THEN".equals(qName)) {
                    popBlock();
                } else if ("IF".equals(qName)) {
                    ifStack.pop();
                } else if ("ELSE".equals(qName)) {
                    popBlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
                failed = true;
            }
        }
    }


    static class VarWithComment {
        private final String name;
        private final String comment;
        private final String type;
        private final String def;

        VarWithComment(String name, String comment, String type, String def) {
            this.name = name;
            this.comment = comment;
            this.type = type;
            this.def = def;
        }

        public String getComment() {
            return comment;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDefault() {
            String result = def;
            if (result == null) {
                if ("BigDecimal".equals(type)) {
                    result = "new BigDecimal(0)";
                } else {
                    result = "0";
                }
            }
            if ("int".equals(type)) {
                result = String.valueOf(Double.valueOf(result).intValue());
            }

            if (result == null) {
                throw new RuntimeException();
            }

            return result;
        }
    }

    static class Const {
        private final String type;
        private final String name;
        private final String value;

        public Const(String type, String name, String value) {
            this.type = type;
            this.name = name;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    class PAPCommentReader implements LexicalHandler {

        private int count = 0;

        @Override
        public void startDTD(String name, String publicId, String systemId) throws SAXException {
        }

        @Override
        public void endDTD() throws SAXException {
        }

        @Override
        public void startEntity(String name) throws SAXException {
        }

        @Override
        public void endEntity(String name) throws SAXException {
        }

        @Override
        public void startCDATA() throws SAXException {
        }

        @Override
        public void endCDATA() throws SAXException {
        }

        @Override
        public void comment(char[] ch, int start, int length) throws SAXException {

            try {

                String comment = new String(ch, start, length).trim();

                if (!comment.isEmpty()) {

                    count++;

                    if (lastComment != null) {

//                        printComment(lastComment);
                        lastComment = null;
                    }

                    comment = comment.replace("\n", "<br>\n");

                    if (count > 1) {
                        if (variables) {
                            lastComment = comment;
                            return;
                        }
                    }

//                    printComment(comment);

                }

            } catch (Exception e) {
                e.printStackTrace();
                failed = true;
            }
        }
    }

    class PapParseResult {
        private final List<Const> constants;
        private final List<MethodDeclaration> methods;
        private final Map<String, VarWithComment> inputVars;
        private final Map<String, VarWithComment> outputVars;
        private final Map<String, VarWithComment> internalVars;

        public PapParseResult(List<Const> constants,
                              List<MethodDeclaration> methods,
                              Map<String, VarWithComment> inputVars,
                              Map<String, VarWithComment> outputVars,
                              Map<String, VarWithComment> internalVars) {
            this.constants = constants;
            this.methods = methods;
            this.inputVars = inputVars;
            this.outputVars = outputVars;
            this.internalVars = internalVars;
        }

        public List<MethodDeclaration> getMethods() {
            return methods;
        }

        public List<Const> getConstants() {
            return constants;
        }

        public Map<String, VarWithComment> getInputVars() {
            return inputVars;
        }

        public Map<String, VarWithComment> getOutputVars() {
            return outputVars;
        }

        public Map<String, VarWithComment> getInternalVars() {
            return internalVars;
        }

    }
}

//class PapOutputWriter extends AbstractWriter {
//
//    public PapOutputWriter(String fileName) throws IOException {
//
//        super(fileName);
//
//        writeln("package de.powerproject.lohnpap.pap;");
//        writeln();
//        writeln("import java.math.BigDecimal;");
//        writeln();
//        writeln("/**");
//        writeln(" * ");
//        writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) ");
//        writeln(" * @date " + new Date());
//        writeln(" * ");
//        writeln(" */");
//        writeln();
//        writeln("public class LohnsteuerOutput {");
//
//        incIndent();
//
//        writeln();
//    }
//
//    @Override
//    public void close() throws IOException {
//
//        decIndent();
//
//        writeln("}");
//
//        super.close();
//    }
//}

//class PapWrapperWriter extends AbstractWriter {
//
//    public PapWrapperWriter(String fileName) throws IOException {
//
//        super(fileName);
//
//        writeln("package de.powerproject.lohnpap.pap;");
//        writeln();
//        writeln("import java.util.Date;");
//        writeln("import java.util.Calendar;");
//        writeln();
//        writeln("/**");
//        writeln(" * ");
//        writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer)");
//        writeln(" * @date " + new Date());
//        writeln(" * ");
//        writeln(" */");
//        writeln();
//        writeln("public class Lohnsteuer {");
//        appendln();
//        incIndent();
//
//        writeln("public static LohnsteuerInterface getInstance() {");
//        writeln("	return getInstance(null);");
//        writeln("}");
//
//        appendln();
//
//        writeln("public static LohnsteuerInterface getInstance(Date date) {");
//        incIndent();
//        appendln();
//        writeln("if (date != null) {");
//        incIndent();
//
//        appendln();
//
//        writeln("Calendar cal = Calendar.getInstance();");
//        writeln("cal.setTime(date);");
//        writeln("int year = cal.get(Calendar.YEAR);");
//        writeln("int month = cal.get(Calendar.MONTH) + 1;");
//
//        appendln();
//
//        PapFile last = null;
//
//        for (PapFile pap : Generator.PAP_FILES) {
//
//            if (pap.to == null) {
//
//                last = pap;
//
//                writeln("if (year >= " + pap.year + " && month >= " + pap.from + ") {");
//                writeln("	return new " + pap.name + "();");
//                writeln("}");
//
//            } else if (pap.from == pap.to) {
//
//                writeln("if (year == " + pap.year + " && month == " + pap.from + ") {");
//                writeln("	return new " + pap.name + "();");
//                writeln("}");
//
//            } else {
//
//                writeln("if (year == " + pap.year + " && month >= " + pap.from + " && month <= " + pap.to + ") {");
//                writeln("	return new " + pap.name + "();");
//                writeln("}");
//
//            }
//        }
//
//        writeln("throw new IllegalArgumentException(\"Illegal Date \" + date + \"\");");
//
//        decIndent();
//        writeln("}");
//        appendln();
//        writeln("return new " + last.name + "();");
//        decIndent();
//        writeln("}");
//    }
//
//    @Override
//    public void close() throws IOException {
//
//        decIndent();
//
//        write("}");
//
//        super.close();
//    }
//}

//class PapWriter extends AbstractWriter {
//
//    private String className, internalName;
//
//    public PapWriter(PapFile p, File targetDir, String internalName) throws IOException {
//
//        super(targetDir + File.separator + File.separator + p.name + ".java");
//        this.className = p.name;
//        this.internalName = internalName;
//
//        writeln("package de.powerproject.lohnpap.pap;");
//        writeln();
//        writeln("import java.math.BigDecimal;");
//        writeln();
//        writeln("/**");
//        writeln(" * ");
//        writeln(" * @author Marcel Lehmann (https://github.com/MarcelLehmann/Lohnsteuer) ");
//        writeln(" * @date " + new Date());
//        writeln(" * ");
//        writeln(" */");
//        writeln();
//        writeln("public class " + p.name + " implements LohnsteuerInterface {");
//        appendln();
//        incIndent();
//    }
//
//    @Override
//    protected void write(String s, boolean tab, boolean newLine) throws IOException {
//
//        if (s != null && internalName != null) {
//            s = s.replace(internalName, className);
//        }
//
//        super.write(s, tab, newLine);
//    }
//
//    @Override
//    public void close() throws IOException {
//
//        decIndent();
//
//        write("}");
//
//        super.close();
//    }
//}

