package sk.uniza.fri.podnik;

import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 23. 2. 2021 - 10:45
 *
 * @author Filip
 */
public class MajetokPodniku {
    private String nazovPodniku;
    private ArrayList<Sklad> zoznam;

    public MajetokPodniku(String nazovPodniku) {
        this.nazovPodniku = nazovPodniku;
        this.zoznam = new ArrayList<Sklad>();
    }
    public boolean addMajetok(Sklad sklad) {
        if (sklad != null) {
            this.zoznam.add(sklad);
            return true;
        } else {
            return false;
        }
    }
    public Sklad odoberMajetok(int index) {
        if (index > this.zoznam.size() || index < 0) {
            return null;
        } else {
            Sklad s = null;
            s = this.zoznam.get(index);
            this.zoznam.remove(index);
            return s;
        }
    }
    public Sklad poskytniMajetok(int index) {
        if (index > this.zoznam.size() || index < 0) {
            return null;
        } else {
            return this.zoznam.get(index);
        }
    }
    public void vypisPodniku() {
        for (Sklad s: this.zoznam) {
            s.vypisSklad();
            System.out.println();
        }
    }
    public String dajZoznamMajetku() {
        String st = "";
        int i = 0;
        for (Sklad s: this.zoznam) {
            st = st + i + "." + s.dajPopis() + "\n";
            i++;
        }
        return st;
    }
    public int dajPocetKusovMajetku() {
        return this.zoznam.size();
    }
    public Sklad poskytniSklad(int cisloSkladu) {
        Sklad st = null;
        for (Sklad s : this.zoznam) {
            if (s.getCisloSkladu() == cisloSkladu) {
                st = s;
            } else {
                st = null;
            }
        }
        return st;
    }

    public boolean pridajTovarNaSklad(int cisloSkladu, PolozkaSkladu polozka) {
        if (cisloSkladu > this.zoznam.size() || polozka == null) {
            return false;
        } else {
            this.poskytniSklad(cisloSkladu).pridajTovarNaSklad(polozka);
            return true;
        }
    }
    public PolozkaSkladu zrusTovarZoSkladu(int cisloSkladu, int idTovaru) {
        if (this.poskytniSklad(cisloSkladu) == null) {
            return null;
        } else {
            return this.poskytniSklad(cisloSkladu).zrusTovarZoSkladu(idTovaru);
        }
    }
    public void vypisSklad(int cisloSkladu) {
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad == null) {
            System.out.println("nenasiel");
        } else {
            sklad.vypisSklad();
        }
    }
    public boolean odoberKusyTovaruNaSklade(int cisloSkladu, int idTovaru, int pocetKusov) {
        if (cisloSkladu < 0 || cisloSkladu > zoznam.size()) {
            Sklad sklad = this.poskytniSklad(cisloSkladu);
            if (sklad != null) {
                sklad.odoberKusyTovaruNaSklade(idTovaru, pocetKusov);
            }
            return true;
        } else {
            return false;
        }
    }
    public void vypisZoznamuTovarov() {
        HashMap<Integer, Tovar> zoznamT = new HashMap();
        for (Sklad s: this.zoznam) {                                    //kazdy sklad
            Sklad sklad = s;                                            //pomocna premenna pre sklad
            for (int i = 0; i < sklad.dajPocetPoloziek(); i++) {        //kazda polozka v sklade
                PolozkaSkladu p = sklad.poskytniPolozku(i);             //pomocna premenna pre polozku
                zoznamT.put(p.getTovar().getIdTovaru(), p.getTovar());  //naplnenie zoznamu
            }
        }
        Set<Integer> zoznamTovarov = zoznamT.keySet();                  //set klucov
        System.out.println("Zoznam obchodovanych tovarov podniku");
        System.out.println("**************************************");
        for (Integer p: zoznamTovarov) {                                //foreach vypis
            zoznamT.get(p).vypis();
            System.out.println();
        }
    }
}
