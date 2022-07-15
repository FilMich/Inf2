package sk.uniza.fri;

import java.awt.*;
import java.util.*;

/**
  Trieda Obdlznik.
 * 
 * @author (Vaclavko) 
 * @version (1/2015)
 */
public class Obdlznik {
    // atributy instancie 
    private int sirka;
    private int vyska; // sirka a dlzka obdlznika
    
      
    /**
     * konstruktor triedy Obdlznik s prarametrami - vytvori obdlznik s danymi rozmermi
     * @param  sirka je sirka obdlznika
     * @param  vyska bude vyska obdlznika
     */
    public Obdlznik(int sirka, int vyska)  {
        // inicializacia rozmerov obdlznika
        this.sirka = sirka;   
        this.vyska = vyska;
    }

    
    
    //metody
    /**
     * vrati obsah obdlznika
     */
    public int dajObsah() {
        int pomocna = 0;
        
        pomocna = this.sirka * this.vyska;
        return pomocna ;
    }
    
    /**
     * vrati obvod obdlznika
     */
    public int dajObvod() {
        int pomocna = 0;
        
        pomocna = 2 * (this.sirka + this.vyska);
        return pomocna ;
    }
    /**
      * vrati velkost uhlopriecky obdlznika 
      */
    public double dajUhlopriecku() {
        int pomocna;
         
        pomocna = this.sirka * this.sirka + this.vyska * this.vyska;
        return Math.sqrt(pomocna);  // volanie metody sqrt abstraktnej triedy Math

    }


    public void zmenRozmery (int oKolkoSirka, int oKolkoVyska) {
        this.sirka += oKolkoSirka;
        this.vyska += oKolkoVyska;
    }
        
    public void zmenRozmery(int oKolko) {
        this.sirka += oKolko;
        this.vyska += oKolko;
    }
       
    public String toString() {

        return "[Obdlznik so stranami:" + this.sirka + "x" + this.vyska + "]";
    }
     
    //doplnenie pre vykreslenie    
    public void zobrazSa(Graphics2D gg, int poziciaX, int poziciaY) {
        gg.drawString(this.toString(), poziciaX, poziciaY);
        gg.drawString(new Date().toString(), poziciaX + 20, poziciaY + 50);
    }
}
