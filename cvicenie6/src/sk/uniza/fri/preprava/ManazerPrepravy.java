package sk.uniza.fri.preprava;

import sk.uniza.fri.vozidla.IVozitelny;

import java.util.ArrayList;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public class ManazerPrepravy {

    private ArrayList<IPrepravitelny> pripraveniPasazieri;
    //pridane 7.cviko
    private IVozitelny vozidlo;


    public ManazerPrepravy() {

        this.pripraveniPasazieri = new ArrayList<IPrepravitelny> ();
    }

    public boolean prijmiPasaziera(IPrepravitelny zasielka ) {
        if (zasielka.jeSchopnyPrevozu()) {
            return this.pripraveniPasazieri.add( zasielka );

        } else {
            return false;
        }

    }

    public String dajZoznamPrijatych() {
        StringBuilder vysledok = new StringBuilder();

        vysledok.append("Zoznam pripravených pasažierov \n");
        vysledok.append("****************************** \n");
        int i = 0;
        for ( IPrepravitelny jeden : this.pripraveniPasazieri ) {
            // tu k retazcu pripajame retazec reprezentujuci jedneho Prepravitelneho,
            //t.j. alebo Zivocich alebo Osoba
            //a jeho getpopis nam da ten pripajany retazec
            vysledok.append( String.format("%5d. %-25s \n", ++i, jeden.getPopis() ));
        }
        vysledok.append("****** koniec zoznamu ******** \n");

        return vysledok.toString();
    }

    //nove 7. cviko
    public String pristavVozidlo(IVozitelny voz) {
        if (this.vozidlo != null) {
            return "Uz je vozidlo pristavene, nemozem pristavit dalsie.";
        } else {
            this.vozidlo = voz;
            return "Vozidlo bolo uspesne pristavene";
        }
    }

    public String nalozeniePasazierov() {

        if (this.vozidlo == null) {
            return "Nebolo pristavene vozidlo!";
        }

        String vysledok = "";
        boolean koniec = false;
        //kym sa zmestia do vozidla a mame este pasazierov plnime
        //zo zoznamu pripravenych do vozidla
        //ti co sa nezmestia, ostanu v zozname pripravenych a
        //cakaju na dalsie vozidlo
        while ((!koniec ) && (this.pripraveniPasazieri.size() > 0)) {
            //cyklus for each nemozeme pouzit, lebo menime kontajner
            //berieme ich v poradi ako prisli
            IPrepravitelny jeden = this.pripraveniPasazieri.get( 0 );

            if ( this.vozidlo.nalozPasaziera( jeden)) {
                vysledok = vysledok + this.pripraveniPasazieri.remove( 0 ).getPopis() + "\n" ;
                // tu k retazcu pripajame retazec reprezentujuci jedneho Prepravitelneho,
                //ale POZOR!!!! Prepravitelny nema metodu toString
                //teda dochadza tu k implicitnej konverzii na dany dynamicky typ
                //t.j. alebo Zivocich alebo Osoba
                //a jeho toString nam da ten pripajany retazec
            } else {
                //vozidlo je plne
                koniec = true;
            }

        }
        return vysledok;

    }

    public void odjazdVozidla() {
        this.vozidlo = null;
    }

    public void vypis() {
        System.out.println("Manazer prepravy \n *************************");
        System.out.println(this.dajZoznamPrijatych());
        if (this.vozidlo != null) {
            System.out.println("Pristavene je vozidlo: ");
            this.vozidlo.vypis(); //polymorfizmus
        }

    }


}
