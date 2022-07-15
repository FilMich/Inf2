package sk.uniza.fri.hlavnyBalik;

import sk.uniza.fri.preprava.ManazerPrepravy;
import sk.uniza.fri.preprava.Zivocich;
import sk.uniza.fri.preprava.Osoba;
import sk.uniza.fri.vozidla.Kamion;

/*
 * 
 */

/**
 *
 * @author vaclavko
 * @version 1/2015
 */
public class HlavnaTrieda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Osoba os1 = new Osoba ("Jozko", "Vesely", 1997);
        System.out.println(os1.getPopis());
        System.out.println("je schopne prevozu:" + os1.jeSchopnyPrevozu());
        
        Zivocich ziv1 = new Zivocich(4 );
        ziv1.setNazovZivocicha("koala");
        System.out.println(ziv1.getPopis() );
        System.out.println("je schopne prevozu:" + ziv1.jeSchopnyPrevozu());
        Osoba os2 = new Osoba ("Karol", "Mudry", 1992);
        Osoba os3 = new Osoba ("Andrej", "Vlnka", 1987);
        Osoba os4 = new Osoba ("Michal", "Medved", 1959);
        Zivocich ziv2 = new Zivocich(2);
        ziv2.setNazovZivocicha("orol skalny");
        Zivocich ziv3 = new Zivocich(8 );
        ziv3.setNazovZivocicha("tarantula");
        
        
        ManazerPrepravy maPr = new ManazerPrepravy();
        maPr.prijmiPasaziera(os1);
        maPr.prijmiPasaziera(ziv1);
        maPr.prijmiPasaziera(os2);
        maPr.prijmiPasaziera(ziv2);
        maPr.prijmiPasaziera(os3);
        maPr.prijmiPasaziera(ziv3);
        maPr.prijmiPasaziera(os4);
        System.out.println(maPr.dajZoznamPrijatych());
        
        Kamion kam1 = new Kamion(2000);
        kam1.nalozPasaziera(ziv1);
        kam1.nalozPasaziera(os1);
        kam1.nalozPasaziera(ziv2);
        kam1.nalozPasaziera(os2);
        kam1.nalozPasaziera(ziv3);
        kam1.nalozPasaziera(os3);
        kam1.nalozPasaziera(os4);
        
        
        kam1.vypis();
    }
    
}
