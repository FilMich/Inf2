package sk.uniza.fri.vozidla;

import sk.uniza.fri.preprava.IPrepravitelny;
import sk.uniza.fri.preprava.Osoba;

import java.util.ArrayList;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class Minivan implements IPrepravitelny{
    private double kapacitaHmotnosti;
    private int kapacitaPoctu;
    private double nalozenaVaha;
    private ArrayList<IPrepravitelny> pasazieri;

    public Minivan(Osoba sofer, double kapacitaHmotnosti, int kapacitaPoctu) {
        this.kapacitaHmotnosti = kapacitaHmotnosti;
        this.kapacitaPoctu = kapacitaPoctu;
        this.nalozenaVaha += sofer.getVahu();
        this.pasazieri.add(sofer);
        this.pasazieri = new ArrayList<>();

    }

    public double getKapacitaHmotnosti() {
        return this.kapacitaHmotnosti;
    }

    public int getKapacitaPoctu() {
        return this.kapacitaPoctu;
    }
    //58:00
    public String getVystup() {
        String ret = "";
        String.format("Prepravny minivan : pocet = %d , nasnost :  %7.2f ", this.kapacitaPoctu , this.kapacitaHmotnosti);
        for (IPrepravitelny p : this.pasazieri
             ) {
            ret += p.getPopis();
        }
        return ret;
    }

    @Override
    public double getVahu() {
        return 0;
    }

    @Override
    public boolean jeSchopnyPrevozu() {
        return false;
    }

    public void vypis() {

    }

    @Override
    public String getPopis() {
        return null;
    }

    public boolean nalozPasaziera(IPrepravitelny pasazier) {
        if ((this.kapacitaHmotnosti - this.nalozenaVaha) < pasazier.getVahu() && this.pasazieri.size() - 1 > this.kapacitaPoctu) {
            return false;
        } else {
            this.pasazieri.add(pasazier);
            this.nalozenaVaha += pasazier.getVahu();
            return true;
        }
    }
}
