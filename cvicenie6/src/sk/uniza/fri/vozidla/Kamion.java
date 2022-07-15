package sk.uniza.fri.vozidla;

import sk.uniza.fri.preprava.IPrepravitelny;

import java.util.ArrayList;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class Kamion implements IVozitelny {
    private double kapacitaHmotnosti;
    private double nalozenaVaha = 0;
    private ArrayList<IPrepravitelny> pasazieri;
    private final int kapacitaPoctu = 100;

    public Kamion(double kapacitaHmotnosti) {
        this.kapacitaHmotnosti = kapacitaHmotnosti;
        this.pasazieri = new ArrayList<IPrepravitelny>();
    }

    public int getKapacitaPoctu() {
        return this.kapacitaPoctu;
    }

    public double getKapacitaHmotnosti() {
        return this.kapacitaHmotnosti;
    }

    public int getKapacituPoctu() {
        return 0;
    }

    public String getVystup() {
        String ret = "";
        String.format("Kamion : nosnost =  %8.2f kg ma nalozenu vahi:  %8.2f kg s pasaziermi: \n", this.kapacitaHmotnosti, this.nalozenaVaha);
        for (IPrepravitelny p : this.pasazieri
        ) {
            ret = ret + p.getPopis();
        }
        return ret;
    }
    public boolean nalozPasaziera(IPrepravitelny pasazier) {

        boolean navrat = false;
        //doplnene cviko 8 Motorka je aj Prepravitelny
        //Kamion vie prepravit aj Prepravitelneho,
        //ale takeho, ktoreho kapacita poctu <3
        if (pasazier instanceof IVozitelny) {
            //int pocet = pasazier.getKapacituPoctu();
            int pocet = ((IVozitelny)pasazier).getKapacitaPoctu();
            if (pocet > 2) {
                return false;
            }
        }
        double vaha = pasazier.getVahu(); //polymorfizmus

        if (this.nalozenaVaha + vaha <= this.kapacitaHmotnosti) {
            this.pasazieri.add(pasazier);
            this.nalozenaVaha += vaha;
            navrat = true;

        }

        return navrat ;
    }
    public void vypis() {

        System.out.println(String.format(" Kamion :  nosnosť = %10.2f kg má naloženú váhu: "
                + "%10.2f kg s pasaziermi: %n",  this.kapacitaHmotnosti, this.nalozenaVaha ));
        for (IPrepravitelny zasielka : pasazieri) {
            zasielka.vypis(); //polymorfizmus
        }
    }
}
