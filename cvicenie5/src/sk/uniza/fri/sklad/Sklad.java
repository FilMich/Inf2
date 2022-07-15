package sk.uniza.fri.sklad;
import sk.uniza.fri.sklad.PolozkaSkladu;
import java.util.ArrayList;

/**
 * 23. 2. 2021 - 10:45
 *
 * @author Filip
 */
public class Sklad {
    private ArrayList<PolozkaSkladu> tovarNaSklade;
    private int cisloSkladu;

    public Sklad(int cisloSkladu) {
        this.cisloSkladu = cisloSkladu;
        this.tovarNaSklade = new ArrayList<PolozkaSkladu>();
    }

    public int getCisloSkladu() {
        return this.cisloSkladu;
    }

    private ArrayList<PolozkaSkladu> getTovarNaSklade() {
        return this.tovarNaSklade;
    }

    private int dajIndexTovaru(int idTovaru) {
        for (int i = 0; i < this.tovarNaSklade.size(); i++) {
            if (this.tovarNaSklade.get(i).getTovar().getIdTovaru() == idTovaru) {
                return i;
            }
        }
        return -1; //nenasiel sa tovar
    }
    public boolean pridajTovarNaSklad(PolozkaSkladu tovar) {
        if (!this.tovarNaSklade.contains(tovar)) {
            this.tovarNaSklade.add(tovar);
            return true;
        } else {
            int id = tovar.getTovar().getIdTovaru();
            int index = dajIndexTovaru(id);
            return this.tovarNaSklade.get(index).pridajKusy(tovar.getPocetKusov());
        }
    }

    public boolean pridajKusyTovaruNaSklad(int idTovaru, int pocetKusov) {
        int index = dajIndexTovaru(idTovaru);
        if (index < 0 || pocetKusov < 1) {
            return false;
        } else {
            return this.tovarNaSklade.get(index).pridajKusy(pocetKusov);
        }
    }

    public boolean odoberKusyTovaruNaSklade(int idTovaru, int pocetKusov) {
        int index = dajIndexTovaru(idTovaru);
        if (index < 0 || pocetKusov < 1) {
            return false;
        } else {
            return this.tovarNaSklade.get(index).odoberKusy(pocetKusov);
        }
    }

    public PolozkaSkladu zrusTovarZoSkladu(int idTovaru) {
        int index = this.dajIndexTovaru(idTovaru);
        if (index == -1) {
            return null;
        } else if (this.tovarNaSklade.get(index).getPocetKusov() == 0) {
            return this.tovarNaSklade.remove(index);
        } else {
            return null;
        }
    }

    public void vypisSklad() {
        System.out.println(" " + this.cisloSkladu);
        for (PolozkaSkladu p : this.tovarNaSklade) {
            p.vypis();
        }
    }
    public int dajPocetPoloziek() {
        return this.tovarNaSklade.size();
    }

    public String dajPopis() {
        return "cislo skladu" + this.cisloSkladu;
    }
    public PolozkaSkladu poskytniPolozku(int index) {
        return this.tovarNaSklade.get(index);
    }
}
