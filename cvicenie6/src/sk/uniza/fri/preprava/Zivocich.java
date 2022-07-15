package sk.uniza.fri.preprava;

import java.sql.SQLOutput;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class Zivocich implements IPrepravitelny{
    private int pocetKoncatin;
    private double vaha = 100;
    private String nazovZivocicha;

    public Zivocich(int pocetKoncatin) {
        this.pocetKoncatin = pocetKoncatin;
        this.nazovZivocicha = "Zivocich";

    }

    public int getPocetKoncatin() {
        return this.pocetKoncatin;
    }

    public double getVaha() {
        return this.vaha;
    }

    public String getNazovZivocicha() {
        return this.nazovZivocicha;
    }

    public void setPocetKoncatin(int pocetKoncatin) {
        this.pocetKoncatin = pocetKoncatin;
    }

    public void setVaha(double vaha) {
        this.vaha = vaha;
    }

    public void setNazovZivocicha(String nazovZivocicha) {
        this.nazovZivocicha = nazovZivocicha;
    }

    @Override
    public double getVahu() {
        if (this.nazovZivocicha.length() < 5) {
            this.vaha *= pocetKoncatin;
        } else {
            this.vaha -= (pocetKoncatin / 2);
        }
        return this.vaha;
    }

    @Override
    public boolean jeSchopnyPrevozu() {
        return (this.pocetKoncatin > 0);
    }

    @Override
    public void vypis() {
        System.out.println(String.format("ja som %s a mam %d koncatin a vazim %8.2f kg", this.nazovZivocicha, this.pocetKoncatin, this.getVahu()));
    }

    @Override
    public String getPopis() {
        return String.format("ja som %s a mam %d koncatin a vazim %8.2f kg", this.nazovZivocicha, this.pocetKoncatin, this.getVahu());
    }
}
