package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

public class LohnsteuerInput {

    /**
     * Jahreshinzurechnungsbetrag in Cents (ggf. 0)
     */
    BigDecimal JHINZU = new BigDecimal(0);

    /**
     * Kapitalauszahlungen/Abfindungen bei Versorgungsbezuegen fuer mehrere Jahre in Cents (ggf. 0)
     */
    BigDecimal VKAPA = new BigDecimal(0);

    /**
     * Voraussichtliche Sonderzahlungen im Kalenderjahr des Versorgungsbeginns <br>
     *              bei Versorgungsempfaengern ohne Sterbegeld, Kapitalauszahlungen/Abfindungen <br>
     *              bei Versorgungsbezuegen in Cents
     */
    BigDecimal VBEZS = new BigDecimal(0);

    /**
     * In RE4 enthaltene Versorgungsbezuege in Cents (ggf. 0)
     */
    BigDecimal VBEZ = new BigDecimal(0);

    /**
     * Jahr, in dem der Versorgungsbezug erstmalig gewaehrt wurde; werden <br>
     *              mehrere Versorgungsbezuege gezahlt, so gilt der aelteste erstmalige Bezug
     */
    int VJAHR = 0;

    /**
     * In JRE4 enthaltene Entschädigungen nach § 24 Nummer 1 EStG in Cent
     */
    BigDecimal JRE4ENT = BigDecimal.ZERO;

    /**
     * 1, wenn bei der sozialen Pflegeversicherung die Besonderheiten in Sachsen zu berücksichtigen sind bzw.<br>
     *                      zu berücksichtigen wären, sonst 0.
     */
    int PVS = 0;

    /**
     * Lohnzahlungszeitraum:<br>
     *              1 = Jahr<br>
     *              2 = Monat<br>
     *              3 = Woche<br>
     *              4 = Tag
     */
    int LZZ = 0;

    /**
     * 1 = der Arbeitnehmer ist im Lohnzahlungszeitraum in der gesetzlichen<br>
     *              Rentenversicherung versicherungsfrei und gehoert zu den in<br>
     *              § 10 c Abs. 3 EStG genannten Personen.<br>
     *              Bei anderen Arbeitnehmern ist „0“ einzusetzen.<br>
     *              Fuer die Zuordnung sind allein die dem Arbeitgeber ohnehin bekannten<br>
     *              Tatsachen ma&szlig;gebend; zusaetzliche Ermittlungen braucht<br>
     *              der Arbeitgeber nicht anzustellen.
     */
    int KRV = 0;

    /**
     * Einkommensbezogener Zusatzbeitragssatz eines gesetzlich krankenversicherten Arbeitnehmers, <br>
     * 		 auf dessen Basis der an die Kran-kenkasse zu zahlende Zusatzbeitrag berechnet wird,<br>
     * 		 in Prozent (bspw. 0,90 für 0,90 %) mit 2 Dezimalstellen. <br>
     * 		 Der von der Kranken-kasse festgesetzte Zusatzbeitragssatz ist bei Abweichungen unmaßgeblich.
     */
    BigDecimal KVZ = new BigDecimal(0);

    /**
     * Jahresfreibetrag nach Ma&szlig;gabe der Eintragungen auf der<br>
     *              Lohnsteuerkarte in Cents (ggf. 0)
     */
    BigDecimal JFREIB = new BigDecimal(0);

    /**
     * In JRE4 enthaltene Versorgungsbezuege in Cents (ggf. 0)
     */
    BigDecimal JVBEZ = new BigDecimal(0);

    /**
     * Religionsgemeinschaft des Arbeitnehmers lt. Lohnsteuerkarte (bei<br>
     *              keiner Religionszugehoerigkeit = 0)
     */
    int R = 0;

    /**
     * 1, wenn er der Arbeitnehmer den Zuschlag zur sozialen Pflegeversicherung<br>
     *                      zu zahlen hat, sonst 0.
     */
    int PVZ = 0;

    /**
     * Vorsorgungsbezug im Januar 2005 bzw. fuer den ersten vollen Monat<br>
     *              in Cents
     */
    BigDecimal VBEZM = new BigDecimal(0);

    /**
     * In der Lohnsteuerkarte des Arbeitnehmers eingetragener Freibetrag fÃ¼r<br>
     *              den Lohnzahlungszeitraum in Cent
     */
    BigDecimal LZZFREIB = new BigDecimal(0);

    /**
     * In der Lohnsteuerkarte des Arbeitnehmers eingetragener Freibetrag<br>
     *              fuer den Lohnzahlungszeitraum in Cents
     */
    BigDecimal WFUNDF = new BigDecimal(0);

    /**
     * Steuerpflichtiger Arbeitslohn vor Beruecksichtigung der Freibetraege<br>
     *              fuer Versorgungsbezuege, des Altersentlastungsbetrags und des auf<br>
     *              der Lohnsteuerkarte fuer den Lohnzahlungszeitraum eingetragenen<br>
     *              Freibetrags in Cents.
     */
    BigDecimal RE4 = new BigDecimal(0);

    /**
     * Dem Arbeitgeber mitgeteilte Zahlungen des Arbeitnehmers zur privaten<br>
     *                  Kranken- bzw. Pflegeversicherung im Sinne des §10 Abs. 1 Nr. 3 EStG 2010<br>
     *                  als Monatsbetrag in Cent (der Wert ist inabhängig vom Lohnzahlungszeitraum immer<br>
     *                  als Monatsbetrag anzugeben).
     */
    BigDecimal PKPV = new BigDecimal(0);

    /**
     * Steuerklasse:<br>
     *              1 = I<br>
     *              2 = II<br>
     *              3 = III<br>
     *              4 = IV<br>
     *              5 = V<br>
     *              6 = VI
     */
    int STKL = 0;

    /**
     * 1, wenn die Anwendung des Faktorverfahrens gewählt wurden (nur in Steuerklasse IV)
     */
    int af = 1;

    /**
     * 1, wenn die Anwendung des Faktorverfahrens gewählt wurden (nur in Steuerklasse IV)
     */
    int AF = 0;

    /**
     * eingetragener Faktor mit drei Nachkommastellen
     */
    double f = 0;

    /**
     * In SONSTB enthaltene Versorgungsbezuege einschliesslich Sterbegeld <br>
     *             in Cents (ggf. 0)
     */
    BigDecimal VBS = new BigDecimal(0);

    /**
     * In der Lohnsteuerkarte des Arbeitnehmers eingetragener Hinzurechnungsbetrag<br>
     *              fÃ¼r den Lohnzahlungszeitraum in Cent
     */
    BigDecimal LZZHINZU = new BigDecimal(0);

    /**
     * In der Lohnsteuerkarte des Arbeitnehmers eingetragener Hinzurechnungsbetrag<br>
     *              fuer den Lohnzahlungszeitraum in Cents
     */
    BigDecimal HINZUR = new BigDecimal(0);

    /**
     * Sonstige Bezuege (ohne Verguetung aus mehrjaehriger Taetigkeit) einschliesslich <br>
     *              Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen, <br>
     *              soweit es sich nicht um Bezuege fuer mehrere Jahre handelt in Cents (ggf. 0)
     */
    BigDecimal SONSTB = new BigDecimal(0);

    /**
     * Sterbegeld bei Versorgungsbezuegen sowie Kapitalauszahlungen/Abfindungen, <br>
     *              soweit es sich nicht um Bezuege fuer mehrere Jahre handelt <br>
     *              (in SONSTB enthalten) in Cents
     */
    BigDecimal STERBE = new BigDecimal(0);

    /**
     * Auf die Vollendung des 64. Lebensjahres folgende <br>
     *              Kalenderjahr (erforderlich, wenn ALTER1=1)
     */
    int AJAHR = 0;

    /**
     * Zahl der Freibetraege fuer Kinder (eine Dezimalstelle, nur bei Steuerklassen<br>
     *              I, II, III und IV)
     */
    BigDecimal ZKF = new BigDecimal(0);

    /**
     * Voraussichtlicher Jahresarbeitslohn ohne sonstige Bezuege und<br>
     *              ohne Verguetung fuer mehrjaehrige Taetigkeit in Cents (ggf. 0)<br>
     *              Anmerkung: Die Eingabe dieses Feldes ist erforderlich bei Eingabe<br>
     *              „sonstiger Bezuege“ (Feld SONSTB) oder bei Eingabe der „Verguetung<br>
     *              fuer mehrjaehrige Taetigkeit“ (Feld VMT).
     */
    BigDecimal JRE4 = new BigDecimal(0);

    /**
     * Zahl der Monate, fuer die Versorgungsbezuege gezahlt werden (nur<br>
     *              erforderlich bei Jahresberechnung (LZZ = 1)
     */
    int ZMVB = 0;

    /**
     * In SONSTB enthaltene Entschädigungen nach § 24 Nummer 1 EStG in Cent
     */
    BigDecimal SONSTENT = BigDecimal.ZERO;

    /**
     * 1, wenn das 64. Lebensjahr zu Beginn des Kalenderjahres vollendet wurde, in dem <br>
     *              der Lohnzahlungszeitraum endet (§ 24 a EStG), sonst = 0
     */
    int ALTER1 = 0;

    /**
     * Krankenversicherung:<br>
     *                  0 = gesetzlich krankenversicherte Arbeitnehmer<br>
     *                  1 = ausschließlich privat krankenversicherte Arbeitnehmer OHNE Arbeitgeberzuschuss<br>
     *                  2 = ausschließlich privat krankenversicherte Arbeitnehmer MIT Arbeitgeberzuschuss
     */
    int PKV = 0;

    /**
     * Verguetung fuer mehrjaehrige Taetigkeit ohne Kapitalauszahlungen/Abfindungen bei <br>
     *              Versorgungsbezuegen in Cents (ggf. 0)
     */
    BigDecimal VMT = new BigDecimal(0);

    /**
     * in VKAPA und VMT enthaltene Entschädigungen nach §24 Nummer 1 EStG in Cent
     */
    BigDecimal ENTSCH = new BigDecimal(0);

    public BigDecimal getJHINZU() {
        return JHINZU;
    }

    public void setJHINZU(BigDecimal JHINZU) {
        this.JHINZU = JHINZU;
    }

    public BigDecimal getVKAPA() {
        return VKAPA;
    }

    public void setVKAPA(BigDecimal VKAPA) {
        this.VKAPA = VKAPA;
    }

    public BigDecimal getVBEZS() {
        return VBEZS;
    }

    public void setVBEZS(BigDecimal VBEZS) {
        this.VBEZS = VBEZS;
    }

    public BigDecimal getVBEZ() {
        return VBEZ;
    }

    public void setVBEZ(BigDecimal VBEZ) {
        this.VBEZ = VBEZ;
    }

    public int getVJAHR() {
        return VJAHR;
    }

    public void setVJAHR(int VJAHR) {
        this.VJAHR = VJAHR;
    }

    public BigDecimal getJRE4ENT() {
        return JRE4ENT;
    }

    public void setJRE4ENT(BigDecimal JRE4ENT) {
        this.JRE4ENT = JRE4ENT;
    }

    public int getPVS() {
        return PVS;
    }

    public void setPVS(int PVS) {
        this.PVS = PVS;
    }

    public int getLZZ() {
        return LZZ;
    }

    public void setLZZ(int LZZ) {
        this.LZZ = LZZ;
    }

    public int getKRV() {
        return KRV;
    }

    public void setKRV(int KRV) {
        this.KRV = KRV;
    }

    public BigDecimal getKVZ() {
        return KVZ;
    }

    public void setKVZ(BigDecimal KVZ) {
        this.KVZ = KVZ;
    }

    public BigDecimal getJFREIB() {
        return JFREIB;
    }

    public void setJFREIB(BigDecimal JFREIB) {
        this.JFREIB = JFREIB;
    }

    public BigDecimal getJVBEZ() {
        return JVBEZ;
    }

    public void setJVBEZ(BigDecimal JVBEZ) {
        this.JVBEZ = JVBEZ;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public int getPVZ() {
        return PVZ;
    }

    public void setPVZ(int PVZ) {
        this.PVZ = PVZ;
    }

    public BigDecimal getVBEZM() {
        return VBEZM;
    }

    public void setVBEZM(BigDecimal VBEZM) {
        this.VBEZM = VBEZM;
    }

    public BigDecimal getLZZFREIB() {
        return LZZFREIB;
    }

    public void setLZZFREIB(BigDecimal LZZFREIB) {
        this.LZZFREIB = LZZFREIB;
    }

    public BigDecimal getWFUNDF() {
        return WFUNDF;
    }

    public void setWFUNDF(BigDecimal WFUNDF) {
        this.WFUNDF = WFUNDF;
    }

    public BigDecimal getRE4() {
        return RE4;
    }

    public void setRE4(BigDecimal RE4) {
        this.RE4 = RE4;
    }

    public BigDecimal getPKPV() {
        return PKPV;
    }

    public void setPKPV(BigDecimal PKPV) {
        this.PKPV = PKPV;
    }

    public int getSTKL() {
        return STKL;
    }

    public void setSTKL(int STKL) {
        this.STKL = STKL;
    }

    public int getAf() {
        return af;
    }

    public void setAf(int af) {
        this.af = af;
    }

    public int getAF() {
        return AF;
    }

    public void setAF(int AF) {
        this.AF = AF;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    public BigDecimal getVBS() {
        return VBS;
    }

    public void setVBS(BigDecimal VBS) {
        this.VBS = VBS;
    }

    public BigDecimal getLZZHINZU() {
        return LZZHINZU;
    }

    public void setLZZHINZU(BigDecimal LZZHINZU) {
        this.LZZHINZU = LZZHINZU;
    }

    public BigDecimal getHINZUR() {
        return HINZUR;
    }

    public void setHINZUR(BigDecimal HINZUR) {
        this.HINZUR = HINZUR;
    }

    public BigDecimal getSONSTB() {
        return SONSTB;
    }

    public void setSONSTB(BigDecimal SONSTB) {
        this.SONSTB = SONSTB;
    }

    public BigDecimal getSTERBE() {
        return STERBE;
    }

    public void setSTERBE(BigDecimal STERBE) {
        this.STERBE = STERBE;
    }

    public int getAJAHR() {
        return AJAHR;
    }

    public void setAJAHR(int AJAHR) {
        this.AJAHR = AJAHR;
    }

    public BigDecimal getZKF() {
        return ZKF;
    }

    public void setZKF(BigDecimal ZKF) {
        this.ZKF = ZKF;
    }

    public BigDecimal getJRE4() {
        return JRE4;
    }

    public void setJRE4(BigDecimal JRE4) {
        this.JRE4 = JRE4;
    }

    public int getZMVB() {
        return ZMVB;
    }

    public void setZMVB(int ZMVB) {
        this.ZMVB = ZMVB;
    }

    public BigDecimal getSONSTENT() {
        return SONSTENT;
    }

    public void setSONSTENT(BigDecimal SONSTENT) {
        this.SONSTENT = SONSTENT;
    }

    public int getALTER1() {
        return ALTER1;
    }

    public void setALTER1(int ALTER1) {
        this.ALTER1 = ALTER1;
    }

    public int getPKV() {
        return PKV;
    }

    public void setPKV(int PKV) {
        this.PKV = PKV;
    }

    public BigDecimal getVMT() {
        return VMT;
    }

    public void setVMT(BigDecimal VMT) {
        this.VMT = VMT;
    }

    public BigDecimal getENTSCH() {
        return ENTSCH;
    }

    public void setENTSCH(BigDecimal ENTSCH) {
        this.ENTSCH = ENTSCH;
    }
}
