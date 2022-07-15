package sk.uniza.fri.tovar;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public class Elektro extends Tovar {
    private char trieda;
    private int prikon;
    private int rokyZaruky;
    private static final double CENA_ZA_KRABICU = 1.2;

    public Elektro(int id, String nazov, double cena, char trieda, int prikon, int rokyZaruky) {
        super(id, nazov, cena);
        this.trieda = trieda;
        this.prikon = prikon;
        this.rokyZaruky = rokyZaruky;
    }

    public char getTrieda() {
        return this.trieda;
    }

    public int getPrikon() {
        return this.prikon;
    }

    public int getRokyZaruky() {
        return this.rokyZaruky;
    }

    public Elektro(int id, String nazov, double cena) {
        super(id, nazov, cena);
    }

    @Override
    public double dajNaklady() {
        return super.dajNaklady() + CENA_ZA_KRABICU;
    }

    @Override
    public String dajPopis() {
        return "Elektro" + super.dajPopis();
    }

    @Override
    public void vypis() {
        super.vypis();
        System.out.println(String.format("Trieda:%ch, Prikon:%d, Zaruka:%d", this.trieda, this.prikon, this.rokyZaruky));
    }
}
