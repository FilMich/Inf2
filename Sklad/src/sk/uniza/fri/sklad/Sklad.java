package sk.uniza.fri.sklad;

import sk.uniza.fri.podnik.IOcenitelny;
import sk.uniza.fri.sklad.PolozkaSkladu;

import java.util.ArrayList;


public class Sklad implements IOcenitelny {
    private int cisloSkladu;
    private ArrayList<PolozkaSkladu> tovarNaSklade;
   
    public Sklad(int paCislo) {
        this.cisloSkladu = paCislo;
        this.tovarNaSklade = new ArrayList<PolozkaSkladu>();
    }
     
    public int getCisloSkladu() {

        return this.cisloSkladu;
    }
    
    //pomocna metoda na najdenie poradia tovaru evidovaneho podla id
    private int dajIndexTovaru(int idTovaru) {
        
        int poradieHladaneho = -1;
        int i = 0;
        for (PolozkaSkladu prezerany : this.tovarNaSklade) {
            if (prezerany.getTovar().getIdTovaru() == idTovaru) {
                poradieHladaneho = i;
                break;
            }
            i++;
        }
        return poradieHladaneho;
        
    }
    
    public boolean odoberKusyTovaruNaSklade(int idTovaru, int pocetKusov) {
        int poradieTovaru = this.dajIndexTovaru(idTovaru);
        if (poradieTovaru < 0) {
            return false;
        } else {
            return this.tovarNaSklade.get(poradieTovaru).odoberKusy(pocetKusov);
        }
    }
    
    public boolean pridajTovarNaSklad(PolozkaSkladu polozka) {
        int idNaSklade = this.dajIndexTovaru(polozka.getTovar().getIdTovaru());
        if (idNaSklade < 0) {
            // nemame taky tovar pridame ho kompletne ako novy tovar
            return this.tovarNaSklade.add(polozka);
        } else {
            //uz ho mame pridame mu len kusy 
            return this.tovarNaSklade.get(idNaSklade).pridajKusy(polozka.getPocetKusov());
            
        }            
    }
    
        
   //mozem zrusit len tovar, ktory uz nema kusy
    public PolozkaSkladu zrusTovarZoSkladu(int idTovaru) {
     
        PolozkaSkladu ruseny = null;
        int poradieRuseneho = this.dajIndexTovaru(idTovaru);
        
        if (poradieRuseneho > -1) {
            ruseny = this.tovarNaSklade.get(poradieRuseneho);
            //mozem zrusit len tovar, ktory uz nema kusy
            if (ruseny.getPocetKusov() != 0) {
                //tu by mohla byt vynimka a ruseni len tovaru s nulovym poctom
                ruseny = null;
            } else {
                ruseny = this.tovarNaSklade.remove(poradieRuseneho);
            }
        }
        return ruseny;
    }

    public void vypisSklad() {
        System.out.println("Zoznam tovaru na sklade cislo: " + this.cisloSkladu);
        System.out.println("-------------------------------------------------------");
        for (PolozkaSkladu poloz : this.tovarNaSklade) {
            poloz.vypis();
        }
    }
    
    /*public String toString() {
        String vysledok = "Zoznam tovaru na sklade cislo: " + this.cisloSkladu + "\n";
        vysledok += "------------------------------------------------------- \n";
        for (PolozkaSkladu poloz : this.tovarNaSklade) {
            vysledok += poloz.toString() + "\n";
        }
        return vysledok;
    }*/

    //doplnenene 3.cviko

    @Override
    public String dajPopis() {

        return String.format("Sklad cislo:%d ", this.cisloSkladu);
    }



    //doplnene pre HashMap
    public int dajPocetPoloziek() {

        return this.tovarNaSklade.size();
    }

    public PolozkaSkladu poskytniPolozku(int index) {
        if ((index < 0) || (index > this.tovarNaSklade.size()) ) {
            return null;
        } else {
            return this.tovarNaSklade.get(index);
        }
    }

    //doplnenene 5.cviko pre rozhranie Ocenitelny
    //naklady su naklady za tovar na sklade
    @Override
    public double dajNaklady() {
        double mesNakl = 0;
        for (PolozkaSkladu polozka : this.tovarNaSklade) {
            mesNakl += polozka.dajNaklady();
        }
        return mesNakl;
    }

    //alebo takto alebo refaktoringom zmenit nazov metody vypisSklad na vypis ,
    // ale potom VSADE kde sa to pouziva
    @Override
    public void vypis() {

        this.vypisSklad();
    }
}
