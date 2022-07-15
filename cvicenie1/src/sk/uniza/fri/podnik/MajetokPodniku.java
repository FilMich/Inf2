package sk.uniza.fri.podnik;
//import sk.uniza.fri.hlavnyBalik.HlavnaTrieda;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class MajetokPodniku {
    private String nazovPodniku;
    //upravene cviko 5
    private ArrayList<IOcenitelny> zoznam;


    public MajetokPodniku(String nazov) {
        this.nazovPodniku = nazov;
        //upravene cviko 5
        this.zoznam = new ArrayList<IOcenitelny>();
    }

    //upravene cviko 5
    public boolean addMajetok(IOcenitelny jeden) {

        return this.zoznam.add(jeden);
    }

    //upravene cviko 5
    public IOcenitelny odoberMajetok(int index) {
        if (index >= this.zoznam.size()) {
            return null;
        }
        IOcenitelny vyberany = this.zoznam.remove(index);
//        if (vyberany == null) { //tu by mohla byt vynimka
//                              //taky majetok nemame
//        }
        return vyberany;
    }

    //upravene cviko 5
    public IOcenitelny poskytniMajetok(int index) {
        if (index >= this.zoznam.size()) {
            return null;
        }
        IOcenitelny vyberany = this.zoznam.get(index);
        return vyberany;
    }

//    public String toString() {
//
//        String retazec = "Podnik " + this.nazovPodniku + "\n";
//        for (Sklad ocen : this.zoznam) {
//            retazec += ocen.toString()+"\n";
//
//        }
//        return retazec;
//    }

    public void vypisPodniku() {

        System.out.println("Podnik " + this.nazovPodniku);
        //upravene cviko 5
        for (IOcenitelny ocen : this.zoznam) {
            ocen.vypis();
            System.out.println();
        }

    }

    public String dajZoznamMajetku() {
        String zoznam1 = "";
        int i = 0;
        //upravene cviko 5
        for (IOcenitelny vec : this.zoznam) {
            zoznam1 = zoznam1 + i + "." + vec.dajPopis() + "\n";
            i++;
        }
        return zoznam1;
    }

    public int dajPocetKusovMajetku() {

        return this.zoznam.size();
    }

    public void vypisZoznamuTovarov() {
        HashMap<Integer, Tovar> zoznamTovarov = new HashMap();
        for (int i = 0; i < this.zoznam.size(); i++) {
            //upravene cviko 5
            IOcenitelny jeden = this.zoznam.get(i);
            if (jeden instanceof Sklad) {
                Sklad sklad = (Sklad)jeden;
                for (int j = 0; j < sklad.dajPocetPoloziek(); j++) {
                    PolozkaSkladu polozka = sklad.poskytniPolozku(j);
                    zoznamTovarov.put(polozka.getTovar().getIdTovaru(), polozka.getTovar());
                }
            }
        }
        System.out.println("Zoznam obchodovanych tovarov podniku");
        System.out.println("**************************************");
        Set<Integer> zoznam1 = zoznamTovarov.keySet();
        for (Integer prvok : zoznam1) {
            zoznamTovarov.get(prvok).vypis();
            System.out.println();
        }
    }
    //metody pre pracu so skladom
    //upravene cviko 5
    //keby cinnost v tejto metode nebola samostatne vydelena sem
    //dalsich 5 metod by sme museli menit
    public Sklad poskytniSklad(int cisloSkladu) {
        Sklad najdeny = null;
        for (int i = 0; i < this.zoznam.size(); i++) {
            IOcenitelny ocen = this.zoznam.get(i);
            if (ocen instanceof Sklad) {
                Sklad sklad = (Sklad)ocen;
                if (cisloSkladu == sklad.getCisloSkladu()) {
                    //je to hladany sklad
                    najdeny = sklad;
                    break;
                }
            }
        }
        return najdeny;
    }

    public boolean pridajTovarNaSklad(int cisloSkladu, PolozkaSkladu polozka) {
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad == null) {
            return false;
        } else {
            return sklad.pridajTovarNaSklad(polozka);
        }
    }

    public PolozkaSkladu zrusTovarZoSkladu(int cisloSkladu, int idTovaru) {
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad == null) {
            return null;
        } else {
            return sklad.zrusTovarZoSkladu(idTovaru);
        }
    }

    public String vypisSklad(int cisloSkladu) {
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad == null) {
            return "Dany sklad nebol najdeny";
        } else {
            return sklad.toString();
        }
    }

    public boolean odoberKusyTovaruNaSklade(int cisloSkladu, int idTovaru, int pocetKusov) {
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad == null)  {
            return false;
        } else {
            return sklad.odoberKusyTovaruNaSklade(idTovaru, pocetKusov);
        }
    }

    //pridane pre cviko 5
    public double dajNakladyZaSklad(int cisloSkladu) {
        double naklady = 0;
        Sklad sklad = this.poskytniSklad(cisloSkladu);
        if (sklad != null) {
            naklady = sklad.dajNaklady();
        }
        return naklady;
    }

    public double dajCelkoveNaklady() {
        double naklady = 0;
        for (IOcenitelny jeden : this.zoznam) {
            naklady += jeden.dajNaklady();
        }
        return naklady;
    }




}
