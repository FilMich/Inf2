package sk.uniza.fri.hlavnyBalik;

import sk.uniza.fri.policko.IBojovnik;
import sk.uniza.fri.policko.ILovci;
import sk.uniza.fri.policko.IPolicko;
import sk.uniza.fri.policko.Lovci;
import sk.uniza.fri.zemeplocha.Zemeplocha;
import sk.uniza.fri.zemeplocha.Zobrazenie;

import javax.swing.*;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Hra {
    private Zemeplocha zem;
    private Zobrazenie obraz;

    public Hra(int pocetPolicok) {
        JOptionPane.showMessageDialog( null, "VITAJTE NA KONTINENTE ZVANOM ZEMEPLOCHA! :");
        this.zem = new Zemeplocha(pocetPolicok);
        this.zem.nastavPolicka();
        this.obraz = new Zobrazenie(pocetPolicok);
        this.obraz.zobraz(this.zem);
    }
    public void hraj() {
        boolean koniec = false;
        while (!koniec) {
            String retazec = "chces prezerat policko - stlac 1 \n chces lov - stlac 2 \n chces skoncit - stlac 0";
            int volba = Integer.parseInt(JOptionPane.showInputDialog(null, retazec));
            switch (volba) {
                case 1 :
                    this.vyberPolicko("prezeras policko");
                    break;
                case 2 :
                    this.lov();
                    this.obraz.skry();
                    this.obraz.zobraz(this.zem);
                    break;
                case 0 :
                    if (JOptionPane.showConfirmDialog(null, "chces skoncit ?", "zvolte moznost", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        koniec = true;
                    }
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "Zle zvolena volba. Skus znovu");
                    break;
            }
        }
        System.exit(0);
    }

    public boolean existujePolicko(int rovnobezka, int poludnik) {
        return (this.zem.getPolicko(rovnobezka, poludnik) == null);
    }
    public void vypisPolicko(int rovnobezka, int poludnik) {
        if (this.existujePolicko(rovnobezka, poludnik)) {
            IPolicko policko = this.zem.getPolicko(rovnobezka, poludnik);
            JOptionPane.showMessageDialog(null, "Suradnice: " + rovnobezka + "-" + poludnik + "\n" + policko.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Policko neexistuje");
        }
    }
    public IPolicko vyberPolicko(String nadpis) {
        IPolicko vratene = null;
        int rovnobeznik = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj rovnobezku", nadpis, JOptionPane.QUESTION_MESSAGE));
        int poudnik = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj poludnik", nadpis, JOptionPane.QUESTION_MESSAGE));
        this.vypisPolicko(rovnobeznik, poudnik);
        if (this.existujePolicko(rovnobeznik, poudnik)) {
            vratene = this.zem.getPolicko(rovnobeznik, poudnik);
        }
        return vratene;
    }
    public void lov() {
        IPolicko hladosi = this.vyberPolicko("zadaj hladosov");
        IPolicko jedlo = this.vyberPolicko("zadaj jedlo");
        if ((hladosi != null) && (jedlo != null)) {
            if ((hladosi instanceof ILovci) && (!(jedlo instanceof IBojovnik)) && (!(jedlo instanceof ILovci))) {
                Lovci lovci = (Lovci)hladosi;
                int pocetHladosov = Integer.parseInt(JOptionPane.showInputDialog(null, "Zadaj pocet hladosov na love"));
                if (pocetHladosov > ((IPolicko)lovci).getPocetObyvatelov()) {
                    JOptionPane.showMessageDialog(null, "Zvoleni lovci nemaju taky pocet obyvatelov");
                } else {
                    IPolicko novePolicko = lovci.lov(jedlo, pocetHladosov);
                    this.zem.setPolicko(novePolicko, novePolicko.getRovnobezka(), novePolicko.getPoludnik());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Zvolene policka nemozu byt ucasnici lovu");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Zle zvolene hodnoty. Skus znovu");
        }
    }
    public void kolonizacia() {

        IPolicko kolonizator = this.vyberPolicko("Zadaj kolonizatora");
        IPolicko volne = this.vyberPolicko("Zadaj obsadzovane policko");
        if ((kolonizator != null) && (volne != null)) {
            //ideme kolonizovat, ak to vieme
            if (kolonizator instanceof IBojovnik) {
                IBojovnik bojovnik = (IBojovnik)kolonizator;
                int pocetKolonizatorov = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Zadaj pocet kolonizatorov."));
                if (pocetKolonizatorov > kolonizator.getPocetObyvatelov()) {
                    //tolko obyvatelov policko nema
                    JOptionPane.showMessageDialog(null, "Zvoleni kolonizatori nemaju taky pocet obyvatelov.");
                } else {
                    //uz naozaj kolonizujeme
                    IPolicko novePolicko = bojovnik.kolonizacia(volne, pocetKolonizatorov);
                    this.zem.setPolicko(novePolicko, novePolicko.getRovnobezka(), novePolicko.getPoludnik());
                }
            } else {
                //zle vybrane policko, nevie tento kolonizovat
                JOptionPane.showMessageDialog(null, "Zle zvolene policko - nevie kolonizovat.");
            }
        } else {
            //zle vybrane policko, utocnik alebo obranca je null
            JOptionPane.showMessageDialog(null, "Zle zvolene hodnoty.Skus zadat znova.");
        }
    }
}
