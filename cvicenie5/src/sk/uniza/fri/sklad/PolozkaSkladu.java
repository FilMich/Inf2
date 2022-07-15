package sk.uniza.fri.sklad;


import sk.uniza.fri.tovar.Tovar;


/**
 * 23. 2. 2021 - 10:45
 *
 * @author Filip
 */
public class PolozkaSkladu {
    private Tovar tovar;
    private int pocetKusov;

    public PolozkaSkladu(Tovar tovar, int pocet) {
        this.tovar = tovar;
        this.pocetKusov = pocet;
    }

    public Tovar getTovar() {
        return this.tovar;
    }

    public int getPocetKusov() {
        return this.pocetKusov;
    }

    public void vypis() {
        this.tovar.vypis();
        System.out.println(String.format(" v pocte:%6d ks", this.pocetKusov));

    }
    public boolean odoberKusy(int pocetDaj) {
        if (pocetDaj > this.pocetKusov) {
            return false;
        } else {
            this.pocetKusov -= pocetDaj;
            return true;
        }
    }
    public boolean pridajKusy(int pocetPridaj) {
        if (pocetPridaj < 1) {
            return false;
        } else {
            this.pocetKusov += pocetPridaj;
            return true;
        }
    }
    public String dajPopis() {
        return this.tovar.dajPopis() + " " + this.pocetKusov;
    }
}
