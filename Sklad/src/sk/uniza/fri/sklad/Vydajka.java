package sk.uniza.fri.sklad;

import java.util.ArrayList;
import java.util.List;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public class Vydajka extends SkladovyDoklad {
    private List<PolozkaSkladu> nevybavenePolozky;

    public Vydajka(Sklad sklad) {
        super(sklad);
        this.nevybavenePolozky = new ArrayList<PolozkaSkladu>();
    }

    public String vybavDoklad() {
        if (super.isVybaveny()) {
            return "Doklad uz bol vybaveny.";
        }
        String vysledok = "Doklad bol vybaveny :";
        int pocetPoloziek = super.dajPocetPoloziek();

        Sklad sklad = super.getCielovySklad();

        for (int i = 0; i < pocetPoloziek; i++) {
            PolozkaSkladu polozka = super.poskytniItuPolozku(i);
            if (!sklad.odoberKusyTovaruNaSklade(polozka.getTovar().getIdTovaru(), polozka.getPocetKusov())) {
                this.nevybavenePolozky.add(polozka);
            }
        }

        super.setVybaveny();
        vysledok = vysledok + "Okrem nasledovnych poloziek: \n";
        for (PolozkaSkladu pom : this.nevybavenePolozky) {
            vysledok = vysledok + pom.dajPopis() + "\n";
        }
        return vysledok;
    }

    @Override
    public String toString() {
        String vysledok = "*************VYDAJKA************** \n" + super.toString() + "\n ------NEVYBAVENE POLOZKY-------\n";
        for (PolozkaSkladu pom : this.nevybavenePolozky) {
            vysledok = vysledok + pom.dajPopis() + "\n";
        }
        return vysledok;
    }
}