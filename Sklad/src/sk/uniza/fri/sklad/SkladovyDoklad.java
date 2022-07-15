package sk.uniza.fri.sklad;

import java.util.ArrayList;
import java.util.List;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public abstract class SkladovyDoklad {
    private Sklad cielovySklad;
    private boolean vybaveny;
    private List<PolozkaSkladu> polozkyDokladu;


    public SkladovyDoklad(Sklad paSklad) {

        this.cielovySklad = paSklad;
        this.vybaveny = false;
        this.polozkyDokladu = new ArrayList<PolozkaSkladu>();
    }

    public Sklad getCielovySklad() {

        return this.cielovySklad;
    }

    public boolean isVybaveny() {

        return this.vybaveny;
    }


    //TU
    protected void setVybaveny() {

        this.vybaveny = true;
    }


    public boolean pridajPolozkuDoDokladu(PolozkaSkladu paPolozka) {
        if (this.vybaveny) {
            return false;
        }
        if (paPolozka.getPocetKusov() <= 0) {
            return false;
        } else {
            return this.polozkyDokladu.add(paPolozka);
        }
    }

    //mozeme aj tu skusit
    private int dajIndexPolozky(int paIdTovaru) {
        int poradie = -1;
        int i = 0;
        boolean nasiel = false;
        while ((i < this.polozkyDokladu.size()) && (!nasiel)) {
            if (this.polozkyDokladu.get(i).getTovar().getIdTovaru() == paIdTovaru) {
                poradie = i;
                nasiel = true;
            }
            i++;
        }
        return poradie;
    }

    public PolozkaSkladu odoberPolozkuPodlaIdTovaru(int paIdTovaru) {

        int poradie = this.dajIndexPolozky(paIdTovaru);
        if (poradie >= 0) {
            return this.polozkyDokladu.remove(poradie);
        } else {
            return null;
        }

    }

    public PolozkaSkladu odoberPolozkuPodlaIndexu(int paIndex) {

        return this.polozkyDokladu.remove(paIndex);
    }

    //tu
    protected int dajPocetPoloziek() {

        return this.polozkyDokladu.size();
    }

    //aj tu
    protected PolozkaSkladu poskytniItuPolozku(int paIndex) {

        return this.polozkyDokladu.get(paIndex);
    }

    public String toString() {
        String vysledok = "Skladovy doklad pre sklad cislo:" + this.cielovySklad.getCisloSkladu() + "\n";

        for (PolozkaSkladu polozka : this.polozkyDokladu) {
            vysledok = vysledok + polozka.dajPopis() + "\n";
        }
        vysledok = vysledok + " je v stave:";
        if (this.vybaveny) {
            vysledok += "vybaveny \n";
        } else {
            vysledok += "nevybaveny \n";
        }
        return vysledok;
    }

    public abstract String vybavDoklad();
}

