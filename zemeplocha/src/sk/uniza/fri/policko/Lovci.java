package sk.uniza.fri.policko;

import javax.swing.*;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Lovci extends Policko implements ILovci, IBojovnik {

    public Lovci(int pocetObyvatelov, int rovnobezka, int poludnik) {
        super(pocetObyvatelov, rovnobezka, poludnik);
        super.setFarba("Orange");
    }

    @Override
    public String toString() {
        return "Lovci" + super.toString();
    }

    @Override
    public String dajPopis() {
        return "Lovci" + super.dajPopis();
    }

    @Override
    public IPolicko lov(IPolicko ciel, int pocetLovcov) {
        int potrava = ciel.getPocetObyvatelov();
        if (potrava == 0) {
            return ciel;
        }
        if (potrava <= pocetLovcov) {
            return new Policko(0, ciel.getRovnobezka(), ciel.getPoludnik());
        } else {
            ciel.setPocetObyvatelov(potrava - pocetLovcov);
            return ciel;
        }
    }

    @Override
    public int getMaxUtocnuSilu() {

        return this.getPocetObyvatelov();
    }

    //nove zemeplocha3
    @Override
    public int getMaxObrannuSilu() {

        return this.getPocetObyvatelov();
    }

    //nove zemeplocha3
    @Override
    //navratova hodnota je upravene alebo nove policko ktore na danych suradniciach bude po utoku
    public IPolicko utok(IBojovnik cielUtoku, int silaUtoku) {

        IPolicko vysledok = null;
        IPolicko protivnik = (IPolicko)cielUtoku;

        int silaObrany = cielUtoku.getMaxObrannuSilu();
        int nasiOstali = silaUtoku - silaObrany;
        if (nasiOstali >= 0 ) {
            //zvitazili sme, vyplienili sme policko
            //cast nam padli - ti co padnu uz sa nevratia
            this.upravaStavuSil(silaObrany);
            vysledok = new Policko(0, protivnik.getRovnobezka(), protivnik.getPoludnik());
        } else {
            //prehnali sme to s utokom, ubranili sa
            //nejaki mu tiez padli, ale nasi uz vsetci vyslani sa nevratia
            cielUtoku.upravaStavuSil(silaUtoku);
            this.upravaStavuSil(silaUtoku);
            vysledok = protivnik;

        }

        return vysledok;
    }

    //nove zemeplocha3
    public void upravaStavuSil(int oKolko) {

        int novyStav = this.getPocetObyvatelov() - oKolko;
        if (novyStav >= 0) { //padla cast obyvatelov
            this.setPocetObyvatelov(novyStav);
        } else { //padli vsetci
            this.setPocetObyvatelov(0);
        }


    }

    //nove zemeplocha3
    @Override
    public IPolicko kolonizacia(IPolicko novySvet, int pocetKolonizatorov) {
        IPolicko vysledok =  null;
        if (novySvet.getPocetObyvatelov() == 0) {
            vysledok = new Lovci(pocetKolonizatorov, novySvet.getRovnobezka(), novySvet.getPoludnik());
            this.upravaStavuSil(pocetKolonizatorov);
        } else {
            JOptionPane.showMessageDialog( null, "Zabudni...Tu su obyvatelia..Chod si inam kolonizovat!!!");
            vysledok = novySvet;
        }
        return vysledok;
    }
}
