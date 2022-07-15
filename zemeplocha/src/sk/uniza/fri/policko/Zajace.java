package sk.uniza.fri.policko;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Zajace extends Policko {

    public Zajace(int pocetObyvatelov, int rovnobezka, int poludnik) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("green");
    }

    @Override
    public String toString() {
        return "Zajace" + super.toString();
    }

    @Override
    public String dajPopis() {
        return "Zajace" + super.dajPopis();
    }
}
