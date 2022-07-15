package sk.uniza.fri.tovar;

import java.sql.SQLOutput;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public class Oblecenie extends Tovar {
    private String farba;
    private String velkost;
    private String vyrobca;
    private static final double CENA_ZA_VESIAK = 0.3;

    public Oblecenie(int id, String nazov, double cena, String farba, String velkost, String vyrobca) {
        super(id, nazov, cena);
        this.farba = farba;
        this.velkost = velkost;
        this.vyrobca = vyrobca;
    }

    public String getFarba() {
        return this.farba;
    }

    public String getVelkost() {
        return this.velkost;
    }

    public String getVyrobca() {
        return this.vyrobca;
    }

    @Override
    public double dajNaklady() {
        return super.dajNaklady() + CENA_ZA_VESIAK;
    }

    @Override
    public String dajPopis() {
        return "Oblecenie" + super.dajPopis();
    }

    @Override
    public void vypis() {
        super.vypis();
        System.out.println(String.format("Farba:%s, Velkost:%s, Made by:%s", this.farba, this.velkost, this.vyrobca));
    }
}
