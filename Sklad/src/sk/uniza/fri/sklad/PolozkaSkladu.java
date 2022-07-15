package sk.uniza.fri.sklad;


import sk.uniza.fri.podnik.IOcenitelny;
import sk.uniza.fri.podnik.IOcenitelny;
import sk.uniza.fri.tovar.Tovar;


public class PolozkaSkladu implements IOcenitelny {
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
    
    
    /*public String toString() {

        return this.tovar.toString() + String.format(" v pocte:%6d ks", this.pocetKusov);
    }*/

    @Override
    public void vypis() {
        this.tovar.vypis();
        System.out.println(String.format(" v pocte:%6d ks", this.pocetKusov));

    }
    
    public boolean odoberKusy(int pocetDaj) {
        if ((pocetDaj > 0) && (this.pocetKusov >= pocetDaj)) {
            this.pocetKusov -= pocetDaj;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean pridajKusy(int pocetPridaj) {
        if (pocetPridaj > 0) {
            this.pocetKusov += pocetPridaj;
            return true;
        } else {
            return false;
        }   
    }

    @Override
    public String dajPopis() {

        return this.tovar.dajPopis() + String.format(" v pocte:%6d ks", this.pocetKusov);
    }

    //doplnene cviko 5
    @Override
    public double dajNaklady() {

        return this.tovar.dajNaklady() * this.pocetKusov;
    }
}
