package sk.uniza.fri.vozidla;

import sk.uniza.fri.preprava.IPrepravitelny;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class Motorka implements IPrepravitelny, IVozitelny {
    private static final int KAPACITA_HMOSNOSTI = 300;
    private static final int KAPACITA_POCTU = 1;
    private IPrepravitelny nalozenyPasazier;
    private double vaha = 500;

    public Motorka() {
    }
    public String getVystup() {
        String ret = "Motorka   " ;
        if (this.nalozenyPasazier == null) {
            ret += "zatial nema nalozeneho pasaziera.";
        } else {
            ret += "ma nalozeneho : " + this.nalozenyPasazier.getPopis();
        }
        return ret;
    }

    @Override
    public double getKapacitaHmotnosti() {
        return this.KAPACITA_HMOSNOSTI;
    }

    @Override
    public int getKapacitaPoctu() {
        return this.KAPACITA_POCTU;
    }

    public boolean nalozPasaziera(IPrepravitelny pasazier) {
        if (this.nalozenyPasazier == null) {
            this.nalozenyPasazier = pasazier;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getVahu() {
        return this.vaha;
    }

    @Override
    public boolean jeSchopnyPrevozu() {
        return (this.nalozenyPasazier == null);
    }

    public void vypis() {
        String ret = "Motorka   " ;
        if (this.nalozenyPasazier == null) {
            ret += "zatial nema nalozeneho pasaziera.";
        } else {
            ret += "ma nalozeneho : " + this.nalozenyPasazier.getPopis();
        }
        System.out.println(ret);
    }

    @Override
    public String getPopis() {
        String ret = "Motorka   " ;
        if (this.nalozenyPasazier == null) {
            ret += "zatial nema nalozeneho pasaziera.";
        } else {
            ret += "ma nalozeneho : " + this.nalozenyPasazier.getPopis();
        }
        return ret;
    }
}
