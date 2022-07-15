package sk.uniza.fri.tovar;

/**
 * 23. 2. 2021 - 10:45
 *
 * @author Filip
 */
public class Tovar {
    private int id;
    private String nazov;
    private double nakupnaCenaZaKs;

    public Tovar(int id, String nazov, double cena) {
        this.id = id;
        this.nazov = nazov;
        this.nakupnaCenaZaKs = cena;
    }
    public String getNazov() {
        return this.nazov;
    }

    public double getNakupnaCenaZaKs() {
        return this.nakupnaCenaZaKs;
    }
    public int getIdTovaru() {
        return this.id;
    }
    public String dajPopis() {

        return String.format("%d. %-20s ", this.id, this.nazov);
    }

    public void vypis() {
        System.out.print(String.format("%d. %-20s , v jednotkovejCene:%8.2f ", this.id, this.nazov, this.nakupnaCenaZaKs));
    }
}
