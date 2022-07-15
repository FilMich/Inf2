package sk.uniza.fri.preprava;

import java.text.DateFormat;
import java.util.Date;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class Osoba implements IPrepravitelny {
    private String meno;
    private String priezvisko;
    private final int rokNarodenia;

    public Osoba(String meno, String priezvisko, int rokNarodenia) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.rokNarodenia = rokNarodenia;
    }

    @Override
    public double getVahu() {
        int hmotnost = 58;
        int vek = this.getVek();
        if (vek > 25) {
            hmotnost += this.meno.length();
        }
        if (vek > 35) {
            hmotnost += this.priezvisko.length();
        }
        if (vek > 45) {
            int roky = vek - 40;
            hmotnost += (roky / 2);
        }
        return hmotnost;
    }

    @Override
    public boolean jeSchopnyPrevozu() {
        return (this.getVek() >= 18);
    }

    @Override
    public void vypis() {
        System.out.println(String.format("%s %s narodeny v : %d vazi : %8.2f kg", this.meno, this.priezvisko, this.rokNarodenia, this.getVahu()));
    }

    @Override
    public String getPopis() {
        return String.format("%s %s narodeny v : %d vazi : %8.2f kg", this.meno, this.priezvisko, this.rokNarodenia, this.getVahu());
    }

    public int getVek() {
        int vek = 0;
        Date datum = new Date();
        DateFormat format1 = DateFormat.getDateInstance();
        String dnesnyDatum = format1.format(datum);
        int dlzka = dnesnyDatum.length();
        int terajsiRok = Integer.parseInt(dnesnyDatum.substring(dlzka - 4, dlzka));
        vek = terajsiRok - this.rokNarodenia;
        return vek;
    }

}
