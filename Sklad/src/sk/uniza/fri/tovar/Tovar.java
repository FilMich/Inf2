package sk.uniza.fri.tovar;


import sk.uniza.fri.podnik.IOcenitelny;

/**
 * 
 * 
 * @author (vaclavko) 
 * @version (1/2015)
 */
public class Tovar implements IOcenitelny {
    private int id;
    private String nazov;
    private double nakupnaCenaZaKs;
    
        
    public Tovar(int id, String nazov, double cena) {
        this.nazov = nazov;
        this.nakupnaCenaZaKs = cena;
        this.id = id; 
    }

    public String getNazov() {

        return this.nazov;
    }
    
    public double getNakupCenaZaKs() {

        return this.nakupnaCenaZaKs;
    }
    
    public int getIdTovaru() {

        return this.id;
    }
    

    /*public String toString() {
        return String.format("%d. %-20s , v jednotkovejCene:%8.2f ", this.id, this.nazov, this.nakupnaCenaZaKs);
    }*/

    //doplnene cviko 5 pre rozhranie Ocenitelny
    @Override
    public double dajNaklady() {

        return this.nakupnaCenaZaKs;
    }


    @Override
    public String dajPopis() {

        return String.format("%d. %-20s ", this.id, this.nazov);
    }

    @Override
    public void vypis() {
        System.out.print(String.format("%d. %-20s , v jednotkovejCene:%8.2f ", this.id, this.nazov, this.nakupnaCenaZaKs));
    }


}
