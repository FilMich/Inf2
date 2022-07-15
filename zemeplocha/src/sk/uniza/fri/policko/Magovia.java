

package sk.uniza.fri.policko;

import javax.swing.JOptionPane;

/**
 *
 * @author vaclavko
 */
public class Magovia extends Policko implements IBojovnik {
    
    private int nekonecnaMagickaSila = Integer.MAX_VALUE;
    private String cteneMeno;
    private boolean jeDoma = false;
    
    public Magovia(int pocet, String meno, int rovnobezka, int poludnik) {
        super(1, rovnobezka, poludnik);
        super.setFarba("red");
        if (pocet > 0) {
            this.jeDoma = true;
        }
        this.cteneMeno = meno;
    }

    public String getCteneMeno() {

        return this.cteneMeno;
    }
    
    

    @Override
    public String toString() {
        String text = "je prave doma";
        if (!this.jeDoma) {
            text = " NIE " + text;
        }
        return "MAG " + this.cteneMeno + " S NEKONECNOU MAGICKOU SILOU" + text; 
    }

    @Override
    public String dajPopis() {

        return "MAG " + this.cteneMeno;
    }

    @Override
    public int getMaxUtocnuSilu() {

        return this.nekonecnaMagickaSila;
    }

    @Override
    public int getMaxObrannuSilu() {

        return this.nekonecnaMagickaSila;
    }

    @Override
    //navratova hodnota je nove policko ktore na danych suradniciach bude po utoku 
    public IPolicko utok(IBojovnik cielUtoku, int silaUtoku) {
        //vyhrava vzdy ten mag, ktory vrhol zaklinadlo ako prvy
        if ((cielUtoku instanceof Magovia) && this.cteneMeno.equals(((Magovia)cielUtoku).getCteneMeno())) {
            JOptionPane.showMessageDialog( null, "Tak som zabudol, ze toto uzemie mi tiez patri... ");
            return (IPolicko)cielUtoku;
        }
        IPolicko novePolicko = null;
        JOptionPane.showMessageDialog( null, "Vsetko obyvatelstvo skamenelo po utoku zaklinadlom "
                + this.dajPopis());
        novePolicko = new Magovia(0, this.getCteneMeno(), ((IPolicko)cielUtoku).getRovnobezka(), ((IPolicko)cielUtoku).getPoludnik());
            
        
        return novePolicko;
    }
    
    public void upravaStavuSil(int oKolko) {
        
        //mame stabilne sily
        
        
    }

    @Override
    public IPolicko kolonizacia(IPolicko novySvet, int pocetKolonizatorov) {
        IPolicko vysledok =  null;
        if (novySvet.getPocetObyvatelov() == 0) {
            vysledok = new Magovia(0, this.cteneMeno, novySvet.getRovnobezka(), novySvet.getPoludnik());
            //this.upravaStavuSil(pocetKolonizatorov);
        } else {
            JOptionPane.showMessageDialog( null, "Vase ctene magovstvo, nechajte nas prosim tak!!!");
            vysledok = novySvet;
        }
        return vysledok;
    }

}
