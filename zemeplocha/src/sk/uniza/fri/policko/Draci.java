

package sk.uniza.fri.policko;

//import javax.swing.*;

/**
 *
 * @author vaclavko
 */
public class Draci extends Lovci {
    //nove zemeplocha4
    
    private int pocetHlav;

    public Draci(int pocet, int pocetHlav, int rovnobezka, int poludnik) {
        super(pocet, rovnobezka, poludnik);
        super.setFarba("black");
        this.pocetHlav = pocetHlav;
    }

    public int getPocetHlav() {

        return this.pocetHlav;
    }
    
    

    @Override
    public String toString() {
        return "Draci s poctom hlav " + this.pocetHlav + " a je ich tu " + super.getPocetObyvatelov(); 
    }

    @Override
    public String dajPopis() {

        return "Draci s poctom hlav " + this.pocetHlav ;
    }

    @Override
    public int getMaxUtocnuSilu() {

        return this.getPocetObyvatelov() * this.pocetHlav;
    }

    @Override
    public int getMaxObrannuSilu() {

        return this.getPocetObyvatelov() * this.pocetHlav;
    }

    @Override
    public void upravaStavuSil(int oKolko) {
        int rusime = oKolko / this.pocetHlav;
        super.upravaStavuSil(rusime);
        
        
    }

    //ked sa podari kolonizovat, tak novy svet obsadia Draci a nie Lovci
    @Override
    public IPolicko kolonizacia(IPolicko novySvet, int pocetKolonizatorov) {
        IPolicko vysledok =  super.kolonizacia(novySvet, pocetKolonizatorov);
        if (vysledok instanceof Lovci) {
            vysledok = new Draci(pocetKolonizatorov, this.pocetHlav, novySvet.getRovnobezka(), novySvet.getPoludnik());

        }
        return vysledok;
    }

    //ked ideme na lov, tak kazda hlava chce jest..
    @Override
    public IPolicko lov(IPolicko ciel, int pocetLovcov) {

        return super.lov(ciel, pocetLovcov * this.pocetHlav);
    }

    // utok musime prekryvat + prekryli sme upravu stavu sil
    //lenze sme potrebovali vediet ako utocia predkovia, aby sme vedeli co prekryt
    //to nie je uplne v poriadku, ze vieme ako presne nejaku cinnost robi predok!!!!
    @Override
    public IPolicko utok(IBojovnik cielUtoku, int silaUtoku) {
        return super.utok(cielUtoku, silaUtoku * this.pocetHlav);
    }
}
