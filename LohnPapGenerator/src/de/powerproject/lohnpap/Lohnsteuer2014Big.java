package de.powerproject.lohnpap;

import java.math.BigDecimal;

/**
 * 
 * @author Lohnsteuer Generator by Marcel Lehmann (power-project.de) 
 * @date Fri Dec 11 09:37:35 CET 2015
 * 
 */

public class Lohnsteuer2014Big {

	/**  Stand: 2013-11-18, 10:25 */
	/**  ZIVIT Düsseldorf*/

	/**   EINGABEPARAMETER  */

	/**  1, wenn die Anwendung des Faktorverfahrens gewählt wurden (nur in Steuerklasse IV) */
	public int af = 1;

	/**  Auf die Vollendung des 64. Lebensjahres folgende<br>
             Kalenderjahr (erforderlich, wenn ALTER1=1) */
	public int AJAHR = 0;

	/**  1, wenn das 64. Lebensjahr zu Beginn des Kalenderjahres vollendet wurde, in dem<br>
             der Lohnzahlungszeitraum endet (§ 24 a EStG), sonst = 0 */
	public int ALTER1 = 0;

	/**  in VKAPA und VMT enthaltene Entschädigungen nach §24 Nummer 1 EStG in Cent */
	public BigDecimal ENTSCH = new BigDecimal(0);

	/**  eingetragener Faktor mit drei Nachkommastellen */
	public double f = 1.0;

	/**  Jahresfreibetrag nach Maßgabe der Eintragungen auf der<br>
             Lohnsteuerkarte in Cents (ggf. 0) */
	public BigDecimal JFREIB = new BigDecimal(0);

	/**  Jahreshinzurechnungsbetrag in Cents (ggf. 0) */
	public BigDecimal JHINZU = new BigDecimal(0);

	/**  Voraussichtlicher Jahresarbeitslohn ohne sonstige Bezüge und ohne Vergütung für mehrjährige Tätigkeit in Cent. <br>
             Anmerkung: Die Eingabe dieses Feldes (ggf. 0) ist erforderlich bei Eingabe „sonsti-ger Bezüge“ (Feld SONSTB) <br>
             oder bei Eingabe der „Vergütung für mehrjährige Tätigkeit“ (Feld VMT).<br>
             Sind in einem vorangegangenen Abrechnungszeitraum bereits sonstige Bezüge gezahlt worden, so sind sie dem <br>
             voraussichtlichen Jahresarbeitslohn hinzuzurechnen. Vergütungen für mehrere Jahres aus einem vorangegangenen <br>
             Abrechnungszeitraum sind in voller Höhe hinzuzurechnen. */
	public BigDecimal JRE4 = new BigDecimal(0);

	/**  In JRE4 enthaltene Versorgungsbezuege in Cents (ggf. 0) */
	public BigDecimal JVBEZ = new BigDecimal(0);

	/** Merker für die Vorsorgepauschale<br>
			2 = der Arbeitnehmer ist NICCHT in der gesetzlichen Rentenversicherung versichert.<br>
			<br>
			1 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die <br>
				Beitragsbemessungsgrenze OST.<br>
				<br>
			0 = der Arbeitnehmer ist in der gesetzlichen Rentenversicherung versichert, es gilt die <br>
				Beitragsbemessungsgrenze WEST. */
	public int KRV = 0;

	/**  Lohnzahlungszeitraum:<br>
             1 = Jahr<br>
             2 = Monat<br>
             3 = Woche<br>
             4 = Tag */
	public int LZZ = 0;

	/**  In der Lohnsteuerkarte des Arbeitnehmers eingetragener Freibetrag für<br>
             den Lohnzahlungszeitraum in Cent */
	public BigDecimal LZZFREIB = new BigDecimal(0);

	/**  In der Lohnsteuerkarte des Arbeitnehmers eingetragener Hinzurechnungsbetrag<br>
             für den Lohnzahlungszeitraum in Cent */
	public BigDecimal LZZHINZU = new BigDecimal(0);

	/**  Dem Arbeitgeber mitgeteilte Zahlungen des Arbeitnehmers zur privaten<br>
             Kranken- bzw. Pflegeversicherung im Sinne des §10 Abs. 1 Nr. 3 EStG 2010<br>
             als Monatsbetrag in Cent (der Wert ist inabhängig vom Lohnzahlungszeitraum immer <br>
             als Monatsbetrag anzugeben).*/
	public BigDecimal PKPV = new BigDecimal(0);

	/**  Krankenversicherung:<br>
             0 = gesetzlich krankenversicherte Arbeitnehmer<br>
             1 = ausschließlich privat krankenversicherte Arbeitnehmer OHNE Arbeitgeberzuschuss<br>
             2 = ausschließlich privat krankenversicherte Arbeitnehmer MIT Arbeitgeberzuschuss */
	public int PKV = 0;

	/**  1, wenn bei der sozialen Pflegeversicherung die Besonderheiten in Sachsen zu berücksichtigen sind bzw. <br>
        	 	zu berücksichtigen wären, sonst 0. */
	public int PVS = 0;

	/**  1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung <br>
        	 	zu zahlen hat, sonst 0. */
	public int PVZ = 0;

	/**  Religionsgemeinschaft des Arbeitnehmers lt. Lohnsteuerkarte (bei<br>
             keiner Religionszugehoerigkeit = 0) */
	public int R = 0;

	/**  Steuerpflichtiger Arbeitslohn vor Beruecksichtigung der Freibetraege<br>
             fuer Versorgungsbezuege, des Altersentlastungsbetrags und des auf<br>
             der Lohnsteuerkarte fuer den Lohnzahlungszeitraum eingetragenen<br>
             Freibetrags in Cents. */
	public BigDecimal RE4 = new BigDecimal(0);

	/**  Sonstige Bezuege (ohne Verguetung aus mehrjaehriger Taetigkeit) einschliesslich<br>
             Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,<br>
             soweit es sich nicht um Bezuege fuer mehrere Jahre handelt in Cents (ggf. 0) */
	public BigDecimal SONSTB = new BigDecimal(0);

	/**  Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen,<br>
             soweit es sich nicht um Bezuege fuer mehrere Jahre handelt<br>
             (in SONSTB enthalten) in Cents */
	public BigDecimal STERBE = new BigDecimal(0);

	/**  Steuerklasse:<br>
             1 = I<br>
             2 = II<br>
             3 = III<br>
             4 = IV<br>
             5 = V<br>
             6 = VI */
	public int STKL = 0;

	/**  In RE4 enthaltene Versorgungsbezuege in Cents (ggf. 0) */
	public BigDecimal VBEZ = new BigDecimal(0);

	/**  Vorsorgungsbezug im Januar 2005 bzw. fuer den ersten vollen Monat<br>
             in Cents*/
	public BigDecimal VBEZM = new BigDecimal(0);

	/**  Voraussichtliche Sonderzahlungen im Kalenderjahr des Versorgungsbeginns<br>
             bei Versorgungsempfaengern ohne Sterbegeld, Kapitalauszahlungen/Abfindungen<br>
             bei Versorgungsbezuegen in Cents*/
	public BigDecimal VBEZS = new BigDecimal(0);

	/**  In SONSTB enthaltene Versorgungsbezuege einschliesslich Sterbegeld<br>
            in Cents (ggf. 0) */
	public BigDecimal VBS = new BigDecimal(0);

	/**  Jahr, in dem der Versorgungsbezug erstmalig gewaehrt wurde; werden<br>
             mehrere Versorgungsbezuege gezahlt, so gilt der aelteste erstmalige Bezug */
	public int VJAHR = 0;

	/**  Kapitalauszahlungen / Abfindungen / Nachzahlungen bei Versorgungsbezügen <br>
             für mehrere Jahre in Cent (ggf. 0) */
	public BigDecimal VKAPA = new BigDecimal(0);

	/**  Vergütung für mehrjährige Tätigkeit ohne Kapitalauszahlungen und ohne Abfindungen <br>
			 bei Versorgungsbezügen in Cent (ggf. 0) */
	public BigDecimal VMT = new BigDecimal(0);

	/**  Zahl der Freibetraege fuer Kinder (eine Dezimalstelle, nur bei Steuerklassen<br>
             I, II, III und IV) */
	public BigDecimal ZKF = new BigDecimal(0);

	/**  Zahl der Monate, fuer die Versorgungsbezuege gezahlt werden (nur<br>
             erforderlich bei Jahresberechnung (LZZ = 1) */
	public int ZMVB = 0;

	/**  In JRE4 enthaltene Entschädigungen nach § 24 Nummer 1 EStG in Cent */
	public BigDecimal JRE4ENT = BigDecimal.ZERO;

	/**  In SONSTB enthaltene Entschädigungen nach § 24 Nummer 1 EStG in Cent */
	public BigDecimal SONSTENT = BigDecimal.ZERO;

	/**   AUSGABEPARAMETER  */

	/**  Bemessungsgrundlage fuer die Kirchenlohnsteuer in Cents */
	public BigDecimal BK = new BigDecimal(0);

	/**  Bemessungsgrundlage der sonstigen Einkuenfte (ohne Verguetung<br>
             fuer mehrjaehrige Taetigkeit) fuer die Kirchenlohnsteuer in Cents */
	public BigDecimal BKS = new BigDecimal(0);
	public BigDecimal BKV = new BigDecimal(0);

	/**  Fuer den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents */
	public BigDecimal LSTLZZ = new BigDecimal(0);

	/**  Fuer den Lohnzahlungszeitraum einzubehaltender Solidaritaetszuschlag<br>
             in Cents */
	public BigDecimal SOLZLZZ = new BigDecimal(0);

	/**  Solidaritaetszuschlag fuer sonstige Bezuege (ohne Verguetung fuer mehrjaehrige<br>
             Taetigkeit) in Cents */
	public BigDecimal SOLZS = new BigDecimal(0);

	/**  Solidaritaetszuschlag fuer die Verguetung fuer mehrjaehrige Taetigkeit in<br>
             Cents */
	public BigDecimal SOLZV = new BigDecimal(0);

	/**  Lohnsteuer fuer sonstige Einkuenfte (ohne Verguetung fuer mehrjaehrige<br>
             Taetigkeit) in Cents */
	public BigDecimal STS = new BigDecimal(0);

	/**  Lohnsteuer fuer Verguetung fuer mehrjaehrige Taetigkeit in Cents */
	public BigDecimal STV = new BigDecimal(0);

	/**  Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers zur<br>
			 privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. auch<br>
			 die Mindestvorsorgepauschale) in Cent beim laufenden Arbeitslohn. Für Zwecke der Lohn-<br>
			 steuerbescheinigung sind die einzelnen Ausgabewerte außerhalb des eigentlichen Lohn-<br>
			 steuerbescheinigungsprogramms zu addieren; hinzuzurechnen sind auch die Ausgabewerte<br>
			 VKVSONST */
	public BigDecimal VKVLZZ = new BigDecimal(0);

	/**  Neu 2014 Ursprünglich INTERNAL definiert */

	/**  Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers <br>
			 zur privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. <br>
			 auch die Mindestvorsorgepauschale) in Cent bei sonstigen Bezügen. Der Ausgabewert kann<br>
			 auch negativ sein. Für tarifermäßigt zu besteuernde Vergütungen für mehrjährige <br>
			 Tätigkeiten enthält der PAP keinen entsprechenden Ausgabewert. */
	public BigDecimal VKVSONST = new BigDecimal(0);

	/** Neu 2014 Ursprünglich INTERNAL definiert */

	/**   INTERNE FELDER  */

	/**  spezielles ZVE f. Einkommensteuer-Berechnung, dieses darf negativ werden. */
	public BigDecimal zveEkSt = new BigDecimal(0);
	public BigDecimal zveGemeinsam = new BigDecimal(0);

	/**  Altersentlastungsbetrag nach Alterseinkünftegesetz in €,<br>
             Cent (2 Dezimalstellen) */
	public BigDecimal ALTE = new BigDecimal(0);

	/**  Arbeitnehmer-Pauschbetrag in EURO */
	public BigDecimal ANP = new BigDecimal(0);

	/**  Auf den Lohnzahlungszeitraum entfallender Anteil von Jahreswerten<br>
             auf ganze Cents abgerundet */
	public BigDecimal ANTEIL1 = new BigDecimal(0);

	/**  Bemessungsgrundlage für Altersentlastungsbetrag in €, Cent<br>
             (2 Dezimalstellen) */
	public BigDecimal BMG = new BigDecimal(0);

	/**  Differenz zwischen ST1 und ST2 in EURO */
	public BigDecimal DIFF = new BigDecimal(0);

	/**  Entlastungsbetrag fuer Alleinerziehende in EURO */
	public BigDecimal EFA = new BigDecimal(0);

	/**  Versorgungsfreibetrag in €, Cent (2 Dezimalstellen) */
	public BigDecimal FVB = new BigDecimal(0);

	/**  Versorgungsfreibetrag in €, Cent (2 Dezimalstellen) für die Berechnung<br>
             der Lohnsteuer für den sonstigen Bezug */
	public BigDecimal FVBSO = new BigDecimal(0);

	/**  Zuschlag zum Versorgungsfreibetrag in EURO */
	public BigDecimal FVBZ = new BigDecimal(0);

	/**  Zuschlag zum Versorgungsfreibetrag in EURO fuer die Berechnung<br>
             der Lohnsteuer beim sonstigen Bezug */
	public BigDecimal FVBZSO = new BigDecimal(0);

	/**  Maximaler Altersentlastungsbetrag in € */
	public BigDecimal HBALTE = new BigDecimal(0);

	/**  Massgeblicher maximaler Versorgungsfreibetrag in € */
	public BigDecimal HFVB = new BigDecimal(0);

	/**  Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in €,Cent<br>
             (2 Dezimalstellen) */
	public BigDecimal HFVBZ = new BigDecimal(0);

	/**  Massgeblicher maximaler Zuschlag zum Versorgungsfreibetrag in €, Cent<br>
             (2 Dezimalstellen) für die Berechnung der Lohnsteuer für den<br>
             sonstigen Bezug */
	public BigDecimal HFVBZSO = new BigDecimal(0);

	/**  Nummer der Tabellenwerte fuer Versorgungsparameter */
	public int J = 0;

	/**  Jahressteuer nach § 51a EStG, aus der Solidaritaetszuschlag und<br>
             Bemessungsgrundlage fuer die Kirchenlohnsteuer ermittelt werden in EURO */
	public BigDecimal JBMG = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechneter LZZFREIB in €, Cent<br>
             (2 Dezimalstellen) */
	public BigDecimal JLFREIB = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnete LZZHINZU in €, Cent<br>
             (2 Dezimalstellen) */
	public BigDecimal JLHINZU = new BigDecimal(0);

	/**  Jahreswert, dessen Anteil fuer einen Lohnzahlungszeitraum in<br>
             UPANTEIL errechnet werden soll in Cents */
	public BigDecimal JW = new BigDecimal(0);

	/**  Nummer der Tabellenwerte fuer Parameter bei Altersentlastungsbetrag */
	public int K = 0;

	/**  Merker für Berechnung Lohnsteuer für mehrjährige Tätigkeit.<br>
			 0 = normale Steuerberechnung<br>
			 1 = Steuerberechnung für mehrjährige Tätigkeit<br>
			 2 = entfällt */
	public int KENNVMT = 0;

	/**  Summe der Freibetraege fuer Kinder in EURO */
	public BigDecimal KFB = new BigDecimal(0);

	/**  Beitragssatz des Arbeitgebers zur Krankenversicherung */
	public BigDecimal KVSATZAG = new BigDecimal(0);

	/**  Beitragssatz des Arbeitnehmers zur Krankenversicherung */
	public BigDecimal KVSATZAN = new BigDecimal(0);

	/**  Kennzahl fuer die Einkommensteuer-Tabellenart:<br>
             1 = Grundtabelle<br>
             2 = Splittingtabelle */
	public int KZTAB = 0;

	/**  Jahreslohnsteuer in EURO */
	public BigDecimal LSTJAHR = new BigDecimal(0);

	/**  Zwischenfelder der Jahreslohnsteuer in Cent */
	public BigDecimal LST1 = new BigDecimal(0);
	public BigDecimal LST2 = new BigDecimal(0);
	public BigDecimal LST3 = new BigDecimal(0);
	public BigDecimal LSTOSO = new BigDecimal(0);
	public BigDecimal LSTSO = new BigDecimal(0);

	/**  Mindeststeuer fuer die Steuerklassen V und VI in EURO */
	public BigDecimal MIST = new BigDecimal(0);

	/**  Beitragssatz des Arbeitgebers zur Pflegeversicherung */
	public BigDecimal PVSATZAG = new BigDecimal(0);

	/**  Beitragssatz des Arbeitnehmers zur Pflegeversicherung */
	public BigDecimal PVSATZAN = new BigDecimal(0);

	/**  Rechenwert in Gleitkommadarstellung */
	public BigDecimal RW = new BigDecimal(0);

	/**  Sonderausgaben-Pauschbetrag in EURO */
	public BigDecimal SAP = new BigDecimal(0);

	/**  Freigrenze fuer den Solidaritaetszuschlag in EURO */
	public BigDecimal SOLZFREI = new BigDecimal(0);

	/**  Solidaritaetszuschlag auf die Jahreslohnsteuer in EURO, C (2 Dezimalstellen) */
	public BigDecimal SOLZJ = new BigDecimal(0);

	/**  Zwischenwert fuer den Solidaritaetszuschlag auf die Jahreslohnsteuer<br>
             in EURO, C (2 Dezimalstellen) */
	public BigDecimal SOLZMIN = new BigDecimal(0);

	/**  Tarifliche Einkommensteuer in EURO */
	public BigDecimal ST = new BigDecimal(0);

	/**  Tarifliche Einkommensteuer auf das 1,25-fache ZX in EURO */
	public BigDecimal ST1 = new BigDecimal(0);

	/**  Tarifliche Einkommensteuer auf das 0,75-fache ZX in EURO */
	public BigDecimal ST2 = new BigDecimal(0);

	/**  Zwischenfeld zur Ermittlung der Steuer auf Vergütungen für mehrjährige Tätigkeit */
	public BigDecimal STOVMT = new BigDecimal(0);

	/**  Bemessungsgrundlage fuer den Versorgungsfreibetrag in Cents */
	public BigDecimal VBEZB = new BigDecimal(0);

	/**  Bemessungsgrundlage für den Versorgungsfreibetrag in Cent für<br>
             den sonstigen Bezug */
	public BigDecimal VBEZBSO = new BigDecimal(0);

	/**  Hoechstbetrag der Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
	public BigDecimal VHB = new BigDecimal(0);

	/**  Vorsorgepauschale in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSP = new BigDecimal(0);

	/**  Vorsorgepauschale nach Alterseinkuenftegesetz in EURO, C */
	public BigDecimal VSPN = new BigDecimal(0);

	/**  Zwischenwert 1 bei der Berechnung der Vorsorgepauschale nach<br>
             dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSP1 = new BigDecimal(0);

	/**  Zwischenwert 2 bei der Berechnung der Vorsorgepauschale nach<br>
             dem Alterseinkuenftegesetz in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSP2 = new BigDecimal(0);

	/**  Vorsorgepauschale mit Teilbeträgen für die gesetzliche Kranken- und <br>
			 soziale Pflegeversicherung nach fiktiven Beträgen oder ggf. für die<br>
			 private Basiskrankenversicherung und private Pflege-Pflichtversicherung <br>
			 in Euro, Cent (2 Dezimalstellen) */
	public BigDecimal VSP3 = new BigDecimal(0);

	/**  Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 3 EStG in EURO */
	public BigDecimal VSPKURZ = new BigDecimal(0);

	/**  Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 2 EStG in EURO */
	public BigDecimal VSPMAX1 = new BigDecimal(0);

	/**  Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 3 EStG in EURO */
	public BigDecimal VSPMAX2 = new BigDecimal(0);

	/**  Vorsorgepauschale nach § 10c Abs. 2 Satz 2 EStG vor der Hoechstbetragsberechnung<br>
             in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSPO = new BigDecimal(0);

	/**  Fuer den Abzug nach § 10c Abs. 2 Nrn. 2 und 3 EStG verbleibender<br>
             Rest von VSPO in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSPREST = new BigDecimal(0);

	/**  Hoechstbetrag der Vorsorgepauschale nach § 10c Abs. 2 Nr. 1 EStG<br>
             in EURO, C (2 Dezimalstellen) */
	public BigDecimal VSPVOR = new BigDecimal(0);

	/**  Zu versteuerndes Einkommen gem. § 32a Abs. 1 und 2 EStG €, C<br>
             (2 Dezimalstellen) */
	public BigDecimal X = new BigDecimal(0);

	/**  gem. § 32a Abs. 1 EStG (6 Dezimalstellen) */
	public BigDecimal Y = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen)<br>
             nach Abzug der Freibeträge nach § 39 b Abs. 2 Satz 3 und 4. */
	public BigDecimal ZRE4 = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen) */
	public BigDecimal ZRE4J = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnetes RE4 in €, C (2 Dezimalstellen)<br>
             nach Abzug des Versorgungsfreibetrags und des Alterentlastungsbetrags<br>
             zur Berechnung der Vorsorgepauschale in €, Cent (2 Dezimalstellen) */
	public BigDecimal ZRE4VP = new BigDecimal(0);

	/**  Feste Tabellenfreibeträge (ohne Vorsorgepauschale) in €, Cent<br>
             (2 Dezimalstellen) */
	public BigDecimal ZTABFB = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnetes (VBEZ abzueglich FVB) in<br>
             EURO, C (2 Dezimalstellen) */
	public BigDecimal ZVBEZ = new BigDecimal(0);

	/**  Auf einen Jahreslohn hochgerechnetes VBEZ in €, C (2 Dezimalstellen) */
	public BigDecimal ZVBEZJ = new BigDecimal(0);

	/**  Zu versteuerndes Einkommen in €, C (2 Dezimalstellen) */
	public BigDecimal ZVE = new BigDecimal(0);

	/**  Zwischenfelder zu X fuer die Berechnung der Steuer nach § 39b<br>
             Abs. 2 Satz 7 EStG in € */
	public BigDecimal ZX = new BigDecimal(0);
	public BigDecimal ZZX = new BigDecimal(0);
	public BigDecimal HOCH = new BigDecimal(0);
	public BigDecimal VERGL = new BigDecimal(0);

	/**  Jahreswert der berücksichtigten Beiträge zur privaten Basis-Krankenversicherung und <br>
			  privaten Pflege-Pflichtversicherung (ggf. auch die Mindestvorsorgepauschale) in Cent. */
	public BigDecimal VKV = new BigDecimal(0);

	/**  Tabelle fuer die Vomhundertsaetze des Versorgungsfreibetrags */
	private static final BigDecimal[] TAB1 = {BigDecimal.valueOf (0.0), BigDecimal.valueOf (0.4),                BigDecimal.valueOf (0.384), BigDecimal.valueOf (0.368),                BigDecimal.valueOf (0.352), BigDecimal.valueOf (0.336),                BigDecimal.valueOf (0.32), BigDecimal.valueOf (0.304),                BigDecimal.valueOf (0.288), BigDecimal.valueOf (0.272),                BigDecimal.valueOf (0.256), BigDecimal.valueOf (0.24),                BigDecimal.valueOf (0.224), BigDecimal.valueOf (0.208),                BigDecimal.valueOf (0.192), BigDecimal.valueOf (0.176),                BigDecimal.valueOf (0.16), BigDecimal.valueOf (0.152),                BigDecimal.valueOf (0.144), BigDecimal.valueOf (0.136),                BigDecimal.valueOf (0.128), BigDecimal.valueOf (0.12),                BigDecimal.valueOf (0.112), BigDecimal.valueOf (0.104),                BigDecimal.valueOf (0.096), BigDecimal.valueOf (0.088),                BigDecimal.valueOf (0.08), BigDecimal.valueOf (0.072),                BigDecimal.valueOf (0.064), BigDecimal.valueOf (0.056),                BigDecimal.valueOf (0.048), BigDecimal.valueOf (0.04),                BigDecimal.valueOf (0.032), BigDecimal.valueOf (0.024),                BigDecimal.valueOf (0.016), BigDecimal.valueOf (0.008),                BigDecimal.valueOf (0.0)};

	/**  Tabelle fuer die Hoechstbetrage des Versorgungsfreibetrags */
	private static final BigDecimal[] TAB2 = {BigDecimal.valueOf (0), BigDecimal.valueOf (3000),                  BigDecimal.valueOf (2880), BigDecimal.valueOf (2760),                  BigDecimal.valueOf (2640), BigDecimal.valueOf (2520),                  BigDecimal.valueOf (2400), BigDecimal.valueOf (2280),                  BigDecimal.valueOf (2160), BigDecimal.valueOf (2040),                  BigDecimal.valueOf (1920), BigDecimal.valueOf (1800),                  BigDecimal.valueOf (1680), BigDecimal.valueOf (1560),                  BigDecimal.valueOf (1440), BigDecimal.valueOf (1320),                  BigDecimal.valueOf (1200), BigDecimal.valueOf (1140),                  BigDecimal.valueOf (1080), BigDecimal.valueOf (1020),                  BigDecimal.valueOf (960), BigDecimal.valueOf (900),                  BigDecimal.valueOf (840), BigDecimal.valueOf (780),                  BigDecimal.valueOf (720), BigDecimal.valueOf (660),                  BigDecimal.valueOf (600), BigDecimal.valueOf (540),                  BigDecimal.valueOf (480), BigDecimal.valueOf (420),                  BigDecimal.valueOf (360), BigDecimal.valueOf (300),                  BigDecimal.valueOf (240), BigDecimal.valueOf (180),                  BigDecimal.valueOf (120), BigDecimal.valueOf (60),                  BigDecimal.valueOf (0)};

	/**  Tabelle fuer die Zuschlaege zum Versorgungsfreibetrag */
	private static final BigDecimal[] TAB3 = {BigDecimal.valueOf (0), BigDecimal.valueOf (900),                  BigDecimal.valueOf (864), BigDecimal.valueOf (828),                  BigDecimal.valueOf (792), BigDecimal.valueOf (756),                  BigDecimal.valueOf (720), BigDecimal.valueOf (684),                  BigDecimal.valueOf (648), BigDecimal.valueOf (612),                  BigDecimal.valueOf (576), BigDecimal.valueOf (540),                  BigDecimal.valueOf (504), BigDecimal.valueOf (468),                  BigDecimal.valueOf (432), BigDecimal.valueOf (396),                  BigDecimal.valueOf (360), BigDecimal.valueOf (342),                  BigDecimal.valueOf (324), BigDecimal.valueOf (306),                  BigDecimal.valueOf (288), BigDecimal.valueOf (270),                  BigDecimal.valueOf (252), BigDecimal.valueOf (234),                  BigDecimal.valueOf (216), BigDecimal.valueOf (198),                  BigDecimal.valueOf (180), BigDecimal.valueOf (162),                  BigDecimal.valueOf (144), BigDecimal.valueOf (126),                  BigDecimal.valueOf (108), BigDecimal.valueOf (90),                  BigDecimal.valueOf (72), BigDecimal.valueOf (54),                  BigDecimal.valueOf (36), BigDecimal.valueOf (18),                  BigDecimal.valueOf (0)};

	/**  Tabelle fuer die Vomhundertsaetze des Altersentlastungsbetrags */
	private static final BigDecimal[] TAB4 = {BigDecimal.valueOf (0.0), BigDecimal.valueOf (0.4),                  BigDecimal.valueOf (0.384), BigDecimal.valueOf (0.368),                  BigDecimal.valueOf (0.352), BigDecimal.valueOf (0.336),                  BigDecimal.valueOf (0.32), BigDecimal.valueOf (0.304),                  BigDecimal.valueOf (0.288), BigDecimal.valueOf (0.272),                  BigDecimal.valueOf (0.256), BigDecimal.valueOf (0.24),                  BigDecimal.valueOf (0.224), BigDecimal.valueOf (0.208),                  BigDecimal.valueOf (0.192), BigDecimal.valueOf (0.176),                  BigDecimal.valueOf (0.16), BigDecimal.valueOf (0.152),                  BigDecimal.valueOf (0.144), BigDecimal.valueOf (0.136),                  BigDecimal.valueOf (0.128), BigDecimal.valueOf (0.12),                  BigDecimal.valueOf (0.112), BigDecimal.valueOf (0.104),                  BigDecimal.valueOf (0.096), BigDecimal.valueOf (0.088),                  BigDecimal.valueOf (0.08), BigDecimal.valueOf (0.072),                  BigDecimal.valueOf (0.064), BigDecimal.valueOf (0.056),                  BigDecimal.valueOf (0.048), BigDecimal.valueOf (0.04),                  BigDecimal.valueOf (0.032), BigDecimal.valueOf (0.024),                  BigDecimal.valueOf (0.016), BigDecimal.valueOf (0.008),                  BigDecimal.valueOf (0.0)};

	/**  Tabelle fuer die Hoechstbetraege des Altersentlastungsbetrags */
	private static final BigDecimal[] TAB5 = {BigDecimal.valueOf (0), BigDecimal.valueOf (1900),                  BigDecimal.valueOf (1824), BigDecimal.valueOf (1748),                  BigDecimal.valueOf (1672), BigDecimal.valueOf (1596),                  BigDecimal.valueOf (1520), BigDecimal.valueOf (1444),                  BigDecimal.valueOf (1368), BigDecimal.valueOf (1292),                  BigDecimal.valueOf (1216), BigDecimal.valueOf (1140),                  BigDecimal.valueOf (1064), BigDecimal.valueOf (988),                  BigDecimal.valueOf (912), BigDecimal.valueOf (836),                  BigDecimal.valueOf (760), BigDecimal.valueOf (722),                  BigDecimal.valueOf (684), BigDecimal.valueOf (646),                  BigDecimal.valueOf (608), BigDecimal.valueOf (570),                  BigDecimal.valueOf (532), BigDecimal.valueOf (494),                  BigDecimal.valueOf (456), BigDecimal.valueOf (418),                  BigDecimal.valueOf (380), BigDecimal.valueOf (342),                  BigDecimal.valueOf (304), BigDecimal.valueOf (266),                  BigDecimal.valueOf (228), BigDecimal.valueOf (190),                  BigDecimal.valueOf (152), BigDecimal.valueOf (114),                  BigDecimal.valueOf (76), BigDecimal.valueOf (38),                  BigDecimal.valueOf (0)};

	/**  Zahlenkonstanten fuer im Plan oft genutzte BigDecimal Werte */
	private static final BigDecimal ZAHL0 = BigDecimal.ZERO;
	private static final BigDecimal ZAHL1 = BigDecimal.ONE;
	private static final BigDecimal ZAHL2 = new BigDecimal(2);
	private static final BigDecimal ZAHL3 = new BigDecimal(3);
	private static final BigDecimal ZAHL4 = new BigDecimal(4);
	private static final BigDecimal ZAHL5 = new BigDecimal(5);
	private static final BigDecimal ZAHL6 = new BigDecimal(6);
	private static final BigDecimal ZAHL7 = new BigDecimal(7);
	private static final BigDecimal ZAHL8 = new BigDecimal(8);
	private static final BigDecimal ZAHL9 = new BigDecimal(9);
	private static final BigDecimal ZAHL10 = BigDecimal.TEN;
	private static final BigDecimal ZAHL11 = new BigDecimal(11);
	private static final BigDecimal ZAHL12 = new BigDecimal(12);
	private static final BigDecimal ZAHL100 = new BigDecimal(100);
	private static final BigDecimal ZAHL360 = new BigDecimal(360);
	private static final BigDecimal ZAHL500 = new BigDecimal(500);
	private static final BigDecimal ZAHL700 = new BigDecimal(700);
	private static final BigDecimal ZAHL1000 = new BigDecimal(1000);

	/**  Rentenbemessungs-Grenze neue Bundesländer in EUR */

	/**  Neuer Wert  2014 */
	private static final BigDecimal RENTBEMESSUNGSGR_OST = new BigDecimal(60000);

	/**  Rentenbemessungs-Grenze alte Bundesländer in EUR */

	/**  Neuer Wert 2014 */
	private static final BigDecimal RENTBEMESSUNGSGR_WEST = new BigDecimal(71400);

	/**  PROGRAMMABLAUFPLAN, PAP Seite 12 */
	public void main() {

		MRE4JL();
		VBEZBSO= BigDecimal.ZERO;
		KENNVMT= 0;
		MRE4();
		MRE4ABZ();
		MZTABFB();
		MLSTJAHR();
		LSTJAHR= ST.multiply(BigDecimal.valueOf(f)).setScale(0,BigDecimal.ROUND_DOWN);
		JW= LSTJAHR.multiply(ZAHL100);
		UPLSTLZZ();
		UPVKVLZZ();
		if(ZKF.compareTo (BigDecimal.ZERO) == 1) {
			ZTABFB= (ZTABFB.add (KFB)).setScale (2, BigDecimal.ROUND_DOWN);
			MRE4ABZ();
			MLSTJAHR();
			JBMG= ST.multiply(BigDecimal.valueOf(f)).setScale(0, BigDecimal.ROUND_DOWN);
		} else {
			JBMG= LSTJAHR;
		}
		MSOLZ();
		MSONST();
		MVMT();
	}

	/**  Ermittlung des Jahresarbeitslohns nach § 39 b Abs. 2 Satz 2 EStG, PAP Seite 12 */
	private void MRE4JL() {

		if(LZZ == 1) {
			ZRE4J= RE4.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= VBEZ.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			JLFREIB= LZZFREIB.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			JLHINZU= LZZHINZU.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		} else {
			if(LZZ == 2) {
				ZRE4J= (RE4.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				ZVBEZJ= (VBEZ.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				JLFREIB= (LZZFREIB.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				JLHINZU= (LZZHINZU.multiply (ZAHL12)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
			} else {
				if(LZZ == 3) {
					ZRE4J= (RE4.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					ZVBEZJ= (VBEZ.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					JLFREIB= (LZZFREIB.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
					JLHINZU= (LZZHINZU.multiply (ZAHL360)).divide (ZAHL700, 2, BigDecimal.ROUND_DOWN);
				} else {
					ZRE4J= (RE4.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					ZVBEZJ= (VBEZ.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					JLFREIB= (LZZFREIB.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
					JLHINZU= (LZZHINZU.multiply (ZAHL360)).divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
				}
			}
		}
		if(af == 0) {
			f= 1;
		}
	}

	/**  Freibeträge für Versorgungsbezüge, Altersentlastungsbetrag (§ 39b Abs. 2 Satz 3 EStG), PAP Seite 13 */
	private void MRE4() {

		if(ZVBEZJ.compareTo (BigDecimal.ZERO) == 0) {
			FVBZ= BigDecimal.ZERO;
			FVB= BigDecimal.ZERO;
			FVBZSO= BigDecimal.ZERO;
			FVBSO= BigDecimal.ZERO;
		} else {
			if(VJAHR < 2006) {
				J= 1;
			} else {
				if(VJAHR < 2040) {
					J= VJAHR - 2004;
				} else {
					J= 36;
				}
			}
			if(LZZ == 1) {
				VBEZB= (VBEZM.multiply (BigDecimal.valueOf (ZMVB))).add (VBEZS);
				HFVB= TAB2[J].divide (ZAHL12).multiply (BigDecimal.valueOf (ZMVB));
				FVBZ= TAB3[J].divide (ZAHL12).multiply (BigDecimal.valueOf (ZMVB)).setScale (0, BigDecimal.ROUND_UP);
			} else {
				VBEZB= ((VBEZM.multiply (ZAHL12)).add (VBEZS)).setScale (2, BigDecimal.ROUND_DOWN);
				HFVB= TAB2[J];
				FVBZ= TAB3[J];
			}
			FVB= ((VBEZB.multiply (TAB1[J]))).divide (ZAHL100).setScale (2, BigDecimal.ROUND_UP);
			if(FVB.compareTo (HFVB) == 1) {
				FVB = HFVB;
			}
			FVBSO= (FVB.add((VBEZBSO.multiply (TAB1[J])).divide (ZAHL100))).setScale (2, BigDecimal.ROUND_UP);
			if(FVBSO.compareTo (TAB2[J]) == 1) {
				FVBSO = TAB2[J];
			}
			HFVBZSO= (((VBEZB.add(VBEZBSO)).divide (ZAHL100)).subtract (FVBSO)).setScale (2, BigDecimal.ROUND_DOWN);
			FVBZSO= (FVBZ.add((VBEZBSO).divide (ZAHL100))).setScale (0, BigDecimal.ROUND_UP);
			if(FVBZSO.compareTo (HFVBZSO) == 1) {
				FVBZSO = HFVBZSO.setScale(0, BigDecimal.ROUND_UP);
			}
			if(FVBZSO.compareTo (TAB3[J]) == 1) {
				FVBZSO = TAB3[J];
			}
			HFVBZ= ((VBEZB.divide (ZAHL100)).subtract (FVB)).setScale (2, BigDecimal.ROUND_DOWN);
			if(FVBZ.compareTo (HFVBZ) == 1) {
				FVBZ = HFVBZ.setScale (0, BigDecimal.ROUND_UP);
			}
		}
		MRE4ALTE();
	}

	/**  Altersentlastungsbetrag (§ 39b Abs. 2 Satz 3 EStG), PAP Seite 14 */
	private void MRE4ALTE() {

		if(ALTER1 == 0) {
			ALTE= BigDecimal.ZERO;
		} else {
			if(AJAHR < 2006) {
				K= 1;
			} else {
				if(AJAHR < 2040) {
					K= AJAHR - 2004;
				} else {
					K= 36;
				}
			}
			BMG= ZRE4J.subtract (ZVBEZJ);/**  Lt. PAP muss hier auf ganze EUR gerundet werden */
			ALTE = (BMG.multiply(TAB4[K])).setScale(0, BigDecimal.ROUND_UP);
			HBALTE= TAB5[K];
			if(ALTE.compareTo (HBALTE) == 1) {
				ALTE= HBALTE;
			}
		}
	}

	/**  Ermittlung des Jahresarbeitslohns nach Abzug der Freibeträge nach § 39 b Abs. 2 Satz 3 und 4 EStG, PAP Seite 16 */
	private void MRE4ABZ() {

		ZRE4= (ZRE4J.subtract (FVB).subtract   (ALTE).subtract (JLFREIB).add (JLHINZU)).setScale (2, BigDecimal.ROUND_DOWN);
		if(ZRE4.compareTo (BigDecimal.ZERO) == -1) {
			ZRE4= BigDecimal.ZERO;
		}
		ZRE4VP= ZRE4J;
		if(KENNVMT == 2) {
			ZRE4VP = ZRE4VP.subtract(ENTSCH.divide(ZAHL100)).setScale(2,BigDecimal.ROUND_DOWN);
		}
		ZVBEZ = ZVBEZJ.subtract(FVB).setScale(2, BigDecimal.ROUND_DOWN);
		if(ZVBEZ.compareTo(BigDecimal.ZERO) == -1) {
			ZVBEZ = BigDecimal.ZERO;
		}
	}

	/**  Ermittlung der festen Tabellenfreibeträge (ohne Vorsorgepauschale), PAP Seite 17 */
	private void MZTABFB() {

		ANP= BigDecimal.ZERO;
		if(ZVBEZ.compareTo (BigDecimal.ZERO) >= 0 && ZVBEZ.compareTo(FVBZ) == -1) {
			FVBZ = BigDecimal.valueOf(ZVBEZ.longValue());
		}
		if(STKL < 6) {
			if(ZVBEZ.compareTo (BigDecimal.ZERO) == 1) {
				if((ZVBEZ.subtract (FVBZ)).compareTo (BigDecimal.valueOf (102)) == -1) {
					ANP= (ZVBEZ.subtract (FVBZ)).setScale (0, BigDecimal.ROUND_UP);
				} else {
					ANP= BigDecimal.valueOf (102);
				}
			}
		} else {
			FVBZ= BigDecimal.valueOf (0);
			FVBZSO= BigDecimal.valueOf (0);
		}
		if(STKL < 6) {
			if(ZRE4.compareTo(ZVBEZ) == 1) {
				if(ZRE4.subtract(ZVBEZ).compareTo(ZAHL1000) == -1) {
					ANP = ANP.add(ZRE4).subtract(ZVBEZ).setScale(0,BigDecimal.ROUND_UP);
				} else {
					ANP = ANP.add(ZAHL1000);
				}
			}
		}
		KZTAB= 1;
		if(STKL == 1) {
			SAP= BigDecimal.valueOf (36);
			KFB= (ZKF.multiply (BigDecimal.valueOf (7008))).setScale (0, BigDecimal.ROUND_DOWN);
		} else {
			if(STKL == 2) {
				EFA= BigDecimal.valueOf (1308);
				SAP= BigDecimal.valueOf (36);
				KFB= (ZKF.multiply (BigDecimal.valueOf (7008))).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				if(STKL == 3) {
					KZTAB= 2;
					SAP= BigDecimal.valueOf (36);
					KFB= (ZKF.multiply (BigDecimal.valueOf (7008))).setScale (0, BigDecimal.ROUND_DOWN);
				} else {
					if(STKL == 4) {
						SAP= BigDecimal.valueOf (36);
						KFB= (ZKF.multiply (BigDecimal.valueOf (3504))).setScale (0, BigDecimal.ROUND_DOWN);
					} else {
						if(STKL == 5) {
							SAP= BigDecimal.valueOf (36);
							KFB= BigDecimal.ZERO;
						} else {
							KFB= BigDecimal.ZERO;
						}
					}
				}
			}
		}
		ZTABFB= (EFA.add (ANP).add (SAP).add (FVBZ)).setScale (2, BigDecimal.ROUND_DOWN);
	}

	/**  Ermittlung Jahreslohnsteuer, PAP Seite 18 */
	private void MLSTJAHR() {

		UPEVP();
		if(KENNVMT != 1) {
			ZVE= (ZRE4.subtract (ZTABFB).subtract (VSP)).setScale (2, BigDecimal.ROUND_DOWN);
			UPMLST();
		} else {
			ZVE= (ZRE4.subtract (ZTABFB).subtract (VSP).subtract ((VMT).divide (ZAHL100)).subtract ((VKAPA).divide (ZAHL100))).setScale (2, BigDecimal.ROUND_DOWN);
			if(ZVE.compareTo (BigDecimal.ZERO) == -1) {
				 ZVE = ZVE.add(VMT.divide(ZAHL100)).add(VKAPA.divide(ZAHL100)).divide(ZAHL5).setScale(2,BigDecimal.ROUND_DOWN);
				UPMLST();
				ST= (ST.multiply (ZAHL5)).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				UPMLST();
				STOVMT= ST;
				ZVE= (ZVE.add(((VMT.add (VKAPA)).divide (ZAHL500)))).setScale (2, BigDecimal.ROUND_DOWN);
				UPMLST();
				ST= (((ST.subtract (STOVMT)).multiply (ZAHL5)).add (STOVMT)).setScale (0, BigDecimal.ROUND_DOWN);
			}
		}
	}

	private void UPVKVLZZ() {

		UPVKV();
		JW = VKV;
		UPANTEIL();
		VKVLZZ = ANTEIL1;
	}

	private void UPVKV() {

		if(PKV > 0) {
			if(VSP2.compareTo(VSP3) == 1) {
				VKV = VSP2.multiply(ZAHL100);
			} else {
				VKV = VSP3.multiply(ZAHL100);
			}
		} else {
			VKV = BigDecimal.ZERO;
		}
	}

	private void UPLSTLZZ() {

		JW = LSTJAHR.multiply(ZAHL100);
		UPANTEIL();
		LSTLZZ = ANTEIL1;
	}

	/**  PAP Seite 20 Ermittlung der Jahreslohnsteuer aus dem Einkommensteuertarif */
	private void UPMLST() {

		if(ZVE.compareTo (ZAHL1) == -1) {
			ZVE= BigDecimal.ZERO;
			X= BigDecimal.ZERO;
		} else {
			X= (ZVE.divide (BigDecimal.valueOf(KZTAB))).setScale (0, BigDecimal.ROUND_DOWN);
		}
		if(STKL < 5) {
			UPTAB14();/**  Neu 2014 */
		} else {
			MST5_6();
		}
	}

	/**  	Vorsorgepauschale (§ 39b Absatz 2 Satz 5 Nummer 3 und Absatz 4 EStG)<br>
  			Achtung: Es wird davon ausgegangen, dass	<br>
  				a) Es wird davon ausge-gangen, dassa) für die BBG (Ost) 60.000 Euro und für die BBG (West) 71.400 Euro festgelegt wird sowie<br>
  				b) der Beitragssatz zur Rentenversicherung auf 18,9 % gesenkt wird.<br>
  			<br>
  			PAP Seite 21  */
	/**  Neu 2014 */
	private void UPEVP() {

		if(KRV > 1) {
			VSP1= BigDecimal.ZERO;
		} else {
			if(KRV == 0) {/**  Neuer Wert 2014 */
				if(ZRE4VP.compareTo(RENTBEMESSUNGSGR_WEST) == 1) {
					ZRE4VP = RENTBEMESSUNGSGR_WEST;
				}
			} else {/**  Neuer Wert 2014 */
				if(ZRE4VP.compareTo(RENTBEMESSUNGSGR_OST) == 1) {
					ZRE4VP = RENTBEMESSUNGSGR_OST;
				}
			}/**  Neuer Wert 2014 */
			VSP1 = (ZRE4VP.multiply(BigDecimal.valueOf(0.56))).setScale(2,BigDecimal.ROUND_DOWN);
			VSP1 = (VSP1.multiply(BigDecimal.valueOf(0.0945))).setScale(2,BigDecimal.ROUND_DOWN);
		}
		VSP2 = (ZRE4VP.multiply(BigDecimal.valueOf(0.12))).setScale(2,BigDecimal.ROUND_DOWN);
		if(STKL == 3) {
			VHB = BigDecimal.valueOf(3000);
		} else {
			VHB = BigDecimal.valueOf(1900);
		}
		if(VSP2.compareTo (VHB) == 1) {
			VSP2= VHB;
		}
		VSPN= (VSP1.add (VSP2)).setScale (0, BigDecimal.ROUND_UP);
		MVSP();
		if(VSPN.compareTo (VSP) == 1) {
			VSP= VSPN.setScale (2, BigDecimal.ROUND_DOWN);
		}
	}

	/**  Vorsorgepauschale (§39b Abs. 2 Satz 5 Nr 3 EStG) Vergleichsberechnung fuer Guenstigerpruefung, PAP Seite 22 */
	/**  Neu 2014 */
	private void MVSP() {
/**  Neuer Wert 2014 */
		if(ZRE4VP.compareTo( BigDecimal.valueOf(48600) ) == 1) {/**  Neuer Wert 2014 */
			ZRE4VP = BigDecimal.valueOf(48600);
		}
		if(PKV > 0) {
			if(STKL == 6) {
				VSP3 = BigDecimal.ZERO;
			} else {
				VSP3 = PKPV.multiply(ZAHL12).divide(ZAHL100);
				if(PKV == 2) {
					KVSATZAG = BigDecimal.valueOf(0.07).setScale(5);
					if(PVS == 1) {
						PVSATZAG = BigDecimal.valueOf(0.00525).setScale(5);
					} else {
						PVSATZAG = BigDecimal.valueOf(0.01025).setScale(5);
					}
					VSP3 = VSP3.subtract(ZRE4VP.multiply(KVSATZAG.add(PVSATZAG))).setScale(2, BigDecimal.ROUND_DOWN);
				}
			}
		} else {
			KVSATZAN = BigDecimal.valueOf(0.079).setScale(5);
			if(PVS == 1) {
				PVSATZAN = BigDecimal.valueOf(0.01525).setScale(5);
			} else {
				PVSATZAN = BigDecimal.valueOf(0.01025).setScale(5);
			}
			if(PVZ == 1) {
				PVSATZAN = PVSATZAN.add(BigDecimal.valueOf(0.0025));
			}
			VSP3 = ZRE4VP.multiply(KVSATZAN.add(PVSATZAN)).setScale(2, BigDecimal.ROUND_DOWN);
		}
		VSP = VSP3.add(VSP1).setScale(0, BigDecimal.ROUND_UP);
	}

	private void UMVSP() {

		VSPVOR = (VSPVOR.subtract(ZRE4VP.multiply(BigDecimal.valueOf(0.16)))).setScale(2, BigDecimal.ROUND_DOWN);
		if(VSPVOR.compareTo(BigDecimal.ZERO) == -1) {
			VSPVOR = BigDecimal.ZERO;
		}
		if(VSPO.compareTo(VSPVOR) == 1) {
			VSP = VSPVOR;
			VSPREST = VSPO.subtract(VSPVOR);
			if(VSPREST.compareTo(VSPMAX1) == 1) {
				VSP = VSP.add(VSPMAX1);
				VSPREST = (VSPREST.subtract(VSPMAX1)).divide(ZAHL2, 2,BigDecimal.ROUND_UP);
				if(VSPREST.compareTo(VSPMAX2) == 1) {
					VSP = (VSP.add(VSPMAX2)).setScale(0,BigDecimal.ROUND_DOWN);
				} else {
					VSP = (VSP.add(VSPREST)).setScale(0,BigDecimal.ROUND_DOWN);
				}
			} else {
				VSP = (VSP.add(VSPREST)).setScale(0, BigDecimal.ROUND_DOWN);
			}
		} else {
			VSP = VSPO.setScale(0, BigDecimal.ROUND_DOWN);
		}
	}

	/**  Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Abs. 2 Satz 7 EStG), PAP Seite 23 */
	/**  Neu 2014 */
	private void MST5_6() {

		ZZX= X;
		if(ZZX.compareTo (BigDecimal.valueOf (26441)) == 1) {
			ZX= BigDecimal.valueOf (26441);
			UP5_6();
			if(ZZX.compareTo (BigDecimal.valueOf (200584)) == 1) {
				ST= (ST.add ((BigDecimal.valueOf (200584).subtract (BigDecimal.valueOf (26441))).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
				ST= (ST.add ((ZZX.subtract (BigDecimal.valueOf (200584))).multiply (BigDecimal.valueOf (0.45)))).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				ST= (ST.add ((ZZX.subtract (BigDecimal.valueOf (26441))).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);
			}
		} else {
			ZX= ZZX;
			UP5_6();
			if(ZZX.compareTo (BigDecimal.valueOf (9763)) == 1) /**  Neuer Wert 2014 */{
				VERGL= ST;
				ZX= BigDecimal.valueOf (9763);/**  Neuer Wert 2014 */
				UP5_6();
				HOCH= (ST.add ((ZZX.subtract (BigDecimal.valueOf (9763))).multiply (BigDecimal.valueOf (0.42)))).setScale (0, BigDecimal.ROUND_DOWN);/**  Neuer Wert 2014 */
				if(HOCH.compareTo (VERGL) == -1) {
					ST= HOCH;
				} else {
					ST= VERGL;
				}
			}
		}
	}

	/**  Unterprogramm zur Lohnsteuer fuer die Steuerklassen V und VI (§ 39b Abs. 2 Satz 7 EStG), PAP Seite 24 */
	private void UP5_6() {

		X= (ZX.multiply (BigDecimal.valueOf (1.25))).setScale (2, BigDecimal.ROUND_DOWN);
		UPTAB14();/**  Neu 2014 */
		ST1= ST;
		X= (ZX.multiply (BigDecimal.valueOf (0.75))).setScale (2, BigDecimal.ROUND_DOWN);
		UPTAB14();/**  Neu 2014 */
		ST2= ST;
		DIFF= (ST1.subtract (ST2)).multiply (ZAHL2);
		MIST= (ZX.multiply (BigDecimal.valueOf (0.14))).setScale (0, BigDecimal.ROUND_DOWN);
		if(MIST.compareTo (DIFF) == 1) {
			ST= MIST;
		} else {
			ST= DIFF;
		}
	}

	/**  Solidaritaetszuschlag, PAP Seite 25 */
	private void MSOLZ() {

		SOLZFREI= BigDecimal.valueOf (972 * KZTAB);
		if(JBMG.compareTo (SOLZFREI) == 1) {
			SOLZJ= (JBMG.multiply (BigDecimal.valueOf (5.5))).divide(ZAHL100).setScale(2, BigDecimal.ROUND_DOWN);
			SOLZMIN= (JBMG.subtract (SOLZFREI)).multiply (BigDecimal.valueOf (20)).divide (ZAHL100).setScale (2, BigDecimal.ROUND_DOWN);
			if(SOLZMIN.compareTo (SOLZJ) == -1) {
				SOLZJ= SOLZMIN;
			}
			JW= SOLZJ.multiply (ZAHL100).setScale (0, BigDecimal.ROUND_DOWN);
			UPANTEIL();
			SOLZLZZ= ANTEIL1;
		} else {
			SOLZLZZ= BigDecimal.ZERO;
		}
		if(R > 0) {
			JW= JBMG.multiply (ZAHL100);
			UPANTEIL();
			BK= ANTEIL1;
		} else {
			BK= BigDecimal.ZERO;
		}
	}

	/**  Anteil von Jahresbetraegen fuer einen LZZ (§ 39b Abs. 2 Satz 9 EStG), PAP Seite 26 */
	private void UPANTEIL() {

		if(LZZ == 1) {
			ANTEIL1= JW;
		} else {
			if(LZZ == 2) {
				ANTEIL1= JW.divide (ZAHL12, 0, BigDecimal.ROUND_DOWN);
			} else {
				if(LZZ == 3) {
					ANTEIL1= (JW.multiply (ZAHL7)).divide (ZAHL360, 0, BigDecimal.ROUND_DOWN);
				} else {
					ANTEIL1= JW.divide (ZAHL360, 0, BigDecimal.ROUND_DOWN);
				}
			}
		}
	}

	/**  Berechnung sonstiger Bezuege nach § 39b Abs. 3 Saetze 1 bis 8 EStG), PAP Seite 27 */
	private void MSONST() {

		LZZ= 1;
		if(ZMVB == 0) {
			ZMVB= 12;
		}
		if(SONSTB.compareTo (BigDecimal.ZERO) == 0) {
			VKVSONST= BigDecimal.ZERO;
			LSTSO= BigDecimal.ZERO;
			STS= BigDecimal.ZERO;
			SOLZS= BigDecimal.ZERO;
			BKS= BigDecimal.ZERO;
		} else {
			MOSONST();
			UPVKV();
			VKVSONST = VKV;
			ZRE4J= ((JRE4.add (SONSTB)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= ((JVBEZ.add (VBS)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			VBEZBSO= STERBE;
			MRE4SONST();
			MLSTJAHR();
			UPVKV();
			VKVSONST = VKV.subtract(VKVSONST);
			LSTSO= ST.multiply (ZAHL100);/**  	lt. PAP muss hier auf ganze EUR aufgerundet werden, <br>
        			allerdings muss der Wert in Cent vorgehalten werden,<br>
        			deshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'<br>
        			wieder die Multiplikation mit 100 */
			STS = LSTSO.subtract(LSTOSO).multiply(BigDecimal.valueOf(f)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN).multiply(ZAHL100);
			if(STS.compareTo (BigDecimal.ZERO) == -1) {
				STS= BigDecimal.ZERO;
			}
			SOLZS= STS.multiply (BigDecimal.valueOf (5.5)).divide (ZAHL100, 0, BigDecimal.ROUND_DOWN);
			if(R > 0) {
				BKS= STS;
			} else {
				BKS= BigDecimal.ZERO;
			}
		}
	}

	/**  Berechnung der Verguetung fuer mehrjaehrige Taetigkeit nach § 39b Abs. 3 Satz 9 und 10 EStG), PAP Seite 28 */
	private void MVMT() {

		if(VKAPA.compareTo (BigDecimal.ZERO) == -1) {
			VKAPA= BigDecimal.ZERO;
		}
		if((VMT.add (VKAPA)).compareTo (BigDecimal.ZERO) == 1) {
			if(LSTSO.compareTo (BigDecimal.ZERO) == 0) {
				MOSONST();
				LST1= LSTOSO;
			} else {
				LST1= LSTSO;
			}
			VBEZBSO= STERBE.add (VKAPA);
			ZRE4J= ((JRE4.add (SONSTB).add (VMT).add (VKAPA)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			ZVBEZJ= ((JVBEZ.add (VBS).add (VKAPA)).divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
			KENNVMT = 2;
			MRE4SONST();
			MLSTJAHR();
			LST3= ST.multiply (ZAHL100);
			MRE4ABZ();
			ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100)).subtract(SONSTENT.divide(ZAHL100));
			KENNVMT= 1;
			MLSTJAHR();
			LST2= ST.multiply (ZAHL100);
			STV= LST2.subtract (LST1);
			LST3= LST3.subtract (LST1);
			if(LST3.compareTo (STV) == -1) {
				STV= LST3;
			}
			if(STV.compareTo (BigDecimal.ZERO) == -1) {
				STV= BigDecimal.ZERO;
			} else {/** 	<br>
	        		lt. PAP muss hier auf ganze EUR abgerundet werden.<br>
   	        	Allerdings muss auch hier der Wert in Cent vorgehalten werden,<br>
        			weshalb nach dem Aufrunden auf ganze EUR durch 'divide(ZAHL100, 0, BigDecimal.ROUND_DOWN)'<br>
        			wieder die Multiplikation mit 100 erfolgt.<br>
        		*/
				STV = STV.multiply(BigDecimal.valueOf(f)).divide(ZAHL100, 0, BigDecimal.ROUND_DOWN).multiply(ZAHL100);
			}
			SOLZV= ((STV.multiply (BigDecimal.valueOf (5.5))).divide (ZAHL100)).setScale (0, BigDecimal.ROUND_DOWN);
			if(R > 0) {
				BKV= STV;
			} else {
				BKV= BigDecimal.ZERO;
			}
		} else {
			STV= BigDecimal.ZERO;
			SOLZV= BigDecimal.ZERO;
			BKV= BigDecimal.ZERO;
		}
	}

	/**  Sonderberechnung ohne sonstige Bezüge für Berechnung bei sonstigen Bezügen oder Vergütung für mehrjährige Tätigkeit, PAP Seite 29 */
	private void MOSONST() {

		ZRE4J= (JRE4.divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
		ZVBEZJ= (JVBEZ.divide (ZAHL100)).setScale (2, BigDecimal.ROUND_DOWN);
		JLFREIB= JFREIB.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		JLHINZU= JHINZU.divide (ZAHL100, 2, BigDecimal.ROUND_DOWN);
		MRE4();
		MRE4ABZ();
		ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100));
		MZTABFB();
		MLSTJAHR();
		LSTOSO= ST.multiply (ZAHL100);
	}

	/**  Sonderberechnung mit sonstige Bezüge für Berechnung bei sonstigen Bezügen oder Vergütung für mehrjährige Tätigkeit, PAP Seite 29 */
	private void MRE4SONST() {

		MRE4();
		FVB= FVBSO;
		MRE4ABZ();
		ZRE4VP = ZRE4VP.subtract(JRE4ENT.divide(ZAHL100)).subtract(SONSTENT.divide(ZAHL100));
		FVBZ= FVBZSO;
		MZTABFB();
	}

	/**  Tarifliche Einkommensteuer §32a EStG, PAP Seite 30 */
	/**  Neu 2014 */
	private void UPTAB14() {

		if(X.compareTo (BigDecimal.valueOf (8355)) == -1) /**  Neuer Wert 2014 */{
			ST= BigDecimal.ZERO;
		} else {
			if(X.compareTo (BigDecimal.valueOf (13470)) == -1) {
				Y= (X.subtract (BigDecimal.valueOf (8354))).divide (BigDecimal.valueOf (10000), 6, BigDecimal.ROUND_DOWN);/**  Neuer Wert 2014 */
				RW= Y.multiply (BigDecimal.valueOf (974.58));/**  Neuer Wert 2014 */
				RW= RW.add (BigDecimal.valueOf (1400));
				ST= (RW.multiply (Y)).setScale (0, BigDecimal.ROUND_DOWN);
			} else {
				if(X.compareTo (BigDecimal.valueOf (52882)) == -1) {
					Y= (X.subtract (BigDecimal.valueOf (13469))).divide (BigDecimal.valueOf (10000), 6, BigDecimal.ROUND_DOWN);
					RW= Y.multiply (BigDecimal.valueOf (228.74));
					RW= RW.add (BigDecimal.valueOf (2397));
					RW= RW.multiply (Y);
					ST= (RW.add (BigDecimal.valueOf (971))).setScale (0, BigDecimal.ROUND_DOWN);/**  Neuer Wert 2014 */
				} else {
					if(X.compareTo (BigDecimal.valueOf (250731)) == -1) {/**  Neuer Wert 2014 */
						ST= ((X.multiply (BigDecimal.valueOf (0.42))).subtract (BigDecimal.valueOf (8239))).setScale (0, BigDecimal.ROUND_DOWN);
					} else {/**  Neuer Wert 2014 */
						ST= ((X.multiply (BigDecimal.valueOf (0.45))).subtract (BigDecimal.valueOf (15761))).setScale (0, BigDecimal.ROUND_DOWN);
					}
				}
			}
		}
		ST= ST.multiply (BigDecimal.valueOf (KZTAB));
	}

}