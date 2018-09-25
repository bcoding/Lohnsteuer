package de.powerproject.lohnpap.pap;

import java.math.BigDecimal;

public class LohnsteuerOutput {

    /**
     * Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers zur<br>
     * 			 privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf. auch<br>
     * 			 die Mindestvorsorgepauschale) in Cent beim laufenden Arbeitslohn. Für Zwecke der Lohn-<br>
     * 			 steuerbescheinigung sind die einzelnen Ausgabewerte außerhalb des eigentlichen Lohn-<br>
     * 			 steuerbescheinigungsprogramms zu addieren; hinzuzurechnen sind auch die Ausgabewerte<br>
     * 			 VKVSONST
     */
    BigDecimal VKVLZZ = new BigDecimal(0);

    /**
     * Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE <br>
     * 				über dem Grundfreibetrag bei der Berechnung der sonstigen Bezüge, in Cent
     */
    BigDecimal WVFRBM = new BigDecimal(0);

    /**
     * Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE über <br>
     * 				dem Grundfreibetrag bei der Berechnung des laufenden Arbeitslohns, in Cent
     */
    BigDecimal WVFRB = new BigDecimal(0);

    /**
     * Verbrauchter Freibetrag bei Berechnung des laufenden Arbeitslohns, in Cent
     */
    BigDecimal VFRB = new BigDecimal(0);

    /**
     * Bemessungsgrundlage fuer die Kirchenlohnsteuer in Cents
     */
    BigDecimal BK = new BigDecimal(0);

    /**
     * Für die weitergehende Berücksichtigung des Steuerfreibetrags nach dem DBA Türkei verfügbares ZVE über dem Grundfreibetrag <br>
     * 				bei der Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent
     */
    BigDecimal WVFRBO = new BigDecimal(0);

    /**
     * Bemessungsgrundlage der sonstigen Einkuenfte (ohne Verguetung<br>
     *              fuer mehrjaehrige Taetigkeit) fuer die Kirchenlohnsteuer in Cents
     */
    BigDecimal BKS = new BigDecimal(0);

    /**
     * Bemessungsgrundlage der sonstigen Einkuenfte (ohne Verguetung<br>
     *              fuer mehrjaehrige Taetigkeit) fuer die Kirchenlohnsteuer in Cents
     */
    BigDecimal BKV = new BigDecimal(0);

    /**
     * Fuer den Lohnzahlungszeitraum einzubehaltender Solidaritaetszuschlag<br>
     *              in Cents
     */
    BigDecimal SOLZLZZ = new BigDecimal(0);

    /**
     * Lohnsteuer fuer sonstige Einkuenfte (ohne Verguetung fuer mehrjaehrige<br>
     *              Taetigkeit) in Cents
     */
    BigDecimal STS = new BigDecimal(0);

    /**
     * Lohnsteuer fuer Verguetung fuer mehrjaehrige Taetigkeit in Cents
     */
    BigDecimal STV = new BigDecimal(0);

    /**
     * Fuer den Lohnzahlungszeitraum einzubehaltende Lohnsteuer in Cents
     */
    BigDecimal LSTLZZ = new BigDecimal(0);

    /**
     * Solidaritaetszuschlag fuer die Verguetung fuer mehrjaehrige Taetigkeit in<br>
     *              Cents
     */
    BigDecimal SOLZV = new BigDecimal(0);

    /**
     * Für den Lohnzahlungszeitraum berücksichtigte Beiträge des Arbeitnehmers<br>
     *              zur privaten Basis-Krankenversicherung und privaten Pflege-Pflichtversicherung (ggf.<br>
     *              auch die Mindestvorsorgepauschale) in Cent bei sonstigen Bezügen. Der Ausgabewert kann<br>
     *              auch negativ sein. Für tarifermäßigt zu besteuernde Vergütungen für mehrjährige<br>
     *              Tätigkeiten enthält der PAP keinen entsprechenden Ausgabewert.
     */
    BigDecimal VKVSONST = new BigDecimal(0);

    /**
     * Verbrauchter Freibetrag bei Berechnung der sonstigen Bezüge, in Cent
     */
    BigDecimal VFRBS2 = new BigDecimal(0);

    /**
     * Solidaritaetszuschlag fuer sonstige Bezuege (ohne Verguetung fuer mehrjaehrige<br>
     *              Taetigkeit) in Cents
     */
    BigDecimal SOLZS = new BigDecimal(0);

    /**
     * Verbrauchter Freibetrag bei Berechnung des voraussichtlichen Jahresarbeitslohns, in Cent
     */
    BigDecimal VFRBS1 = new BigDecimal(0);

    public BigDecimal getVKVLZZ() {
        return VKVLZZ;
    }

    public void setVKVLZZ(BigDecimal VKVLZZ) {
        this.VKVLZZ = VKVLZZ;
    }

    public BigDecimal getWVFRBM() {
        return WVFRBM;
    }

    public void setWVFRBM(BigDecimal WVFRBM) {
        this.WVFRBM = WVFRBM;
    }

    public BigDecimal getWVFRB() {
        return WVFRB;
    }

    public void setWVFRB(BigDecimal WVFRB) {
        this.WVFRB = WVFRB;
    }

    public BigDecimal getVFRB() {
        return VFRB;
    }

    public void setVFRB(BigDecimal VFRB) {
        this.VFRB = VFRB;
    }

    public BigDecimal getBK() {
        return BK;
    }

    public void setBK(BigDecimal BK) {
        this.BK = BK;
    }

    public BigDecimal getWVFRBO() {
        return WVFRBO;
    }

    public void setWVFRBO(BigDecimal WVFRBO) {
        this.WVFRBO = WVFRBO;
    }

    public BigDecimal getBKS() {
        return BKS;
    }

    public void setBKS(BigDecimal BKS) {
        this.BKS = BKS;
    }

    public BigDecimal getBKV() {
        return BKV;
    }

    public void setBKV(BigDecimal BKV) {
        this.BKV = BKV;
    }

    public BigDecimal getSOLZLZZ() {
        return SOLZLZZ;
    }

    public void setSOLZLZZ(BigDecimal SOLZLZZ) {
        this.SOLZLZZ = SOLZLZZ;
    }

    public BigDecimal getSTS() {
        return STS;
    }

    public void setSTS(BigDecimal STS) {
        this.STS = STS;
    }

    public BigDecimal getSTV() {
        return STV;
    }

    public void setSTV(BigDecimal STV) {
        this.STV = STV;
    }

    public BigDecimal getLSTLZZ() {
        return LSTLZZ;
    }

    public void setLSTLZZ(BigDecimal LSTLZZ) {
        this.LSTLZZ = LSTLZZ;
    }

    public BigDecimal getSOLZV() {
        return SOLZV;
    }

    public void setSOLZV(BigDecimal SOLZV) {
        this.SOLZV = SOLZV;
    }

    public BigDecimal getVKVSONST() {
        return VKVSONST;
    }

    public void setVKVSONST(BigDecimal VKVSONST) {
        this.VKVSONST = VKVSONST;
    }

    public BigDecimal getVFRBS2() {
        return VFRBS2;
    }

    public void setVFRBS2(BigDecimal VFRBS2) {
        this.VFRBS2 = VFRBS2;
    }

    public BigDecimal getSOLZS() {
        return SOLZS;
    }

    public void setSOLZS(BigDecimal SOLZS) {
        this.SOLZS = SOLZS;
    }

    public BigDecimal getVFRBS1() {
        return VFRBS1;
    }

    public void setVFRBS1(BigDecimal VFRBS1) {
        this.VFRBS1 = VFRBS1;
    }
}
