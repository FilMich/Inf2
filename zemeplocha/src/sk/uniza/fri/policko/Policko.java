package sk.uniza.fri.policko;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Policko implements IPolicko {
    private int pocetObyvatelov;
    private String farba;
    private int rovnobezka;
    private int poludnik;

    public Policko(int pocetObyvatelov, int rovnobezka, int poludnik) {
        this.pocetObyvatelov = pocetObyvatelov;
        this.rovnobezka = rovnobezka;
        this.poludnik = poludnik;
        this.farba = "white";
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public void setRovnobezka(int rovnobezka) {
        this.rovnobezka = rovnobezka;
    }

    public void setPoludnik(int poludnik) {
        this.poludnik = poludnik;
    }

    @Override
    public int getPocetObyvatelov() {
        return this.pocetObyvatelov;
    }

    @Override
    public void setPocetObyvatelov(int novyPocet) {
        this.pocetObyvatelov = novyPocet;
    }

    @Override
    public String getFarba() {
        return this.farba;
    }

    @Override
    public String toString() {
        return "Policko ma pocet obyvatelov = " + this.pocetObyvatelov;
    }

    @Override
    public String dajPopis() {
        return "Policko";
    }

    @Override
    public int getRovnobezka() {
        return this.rovnobezka;
    }

    @Override
    public int getPoludnik() {
        return this.poludnik;
    }
}
