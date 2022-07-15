package sk.uniza.fri.sklad;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public class Prijemka extends SkladovyDoklad {

    public Prijemka(Sklad  sklad) {

        super(sklad);
    }

    public String vybavDoklad() {
        if (super.isVybaveny()) {
            return "Doklad uz bol vybaveny.";
        }
        String vysledok = "Doklad bol vybaveny v pocte poloziek:";
        int pocetPoloziek = super.dajPocetPoloziek();
        int pocetVybavenych = 0;
        Sklad sklad = super.getCielovySklad();

        for (int i = 0; i < pocetPoloziek; i++) {
            PolozkaSkladu polozka = super.poskytniItuPolozku(i) ;
            if (sklad.pridajTovarNaSklad(polozka)) {
                pocetVybavenych++;
            }
        }

        super.setVybaveny();
        vysledok = vysledok + pocetVybavenych;
        return vysledok;
    }

    @Override
    public String toString() {

        return "*************PRIJEMKA************** \n" + super.toString();
    }





}