package sk.uniza.fri.vozidla;

import sk.uniza.fri.preprava.IPrepravitelny;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public interface IVozitelny {

    double getKapacitaHmotnosti();
    int getKapacitaPoctu();
    boolean nalozPasaziera(IPrepravitelny pasazier);
    void vypis();
}
