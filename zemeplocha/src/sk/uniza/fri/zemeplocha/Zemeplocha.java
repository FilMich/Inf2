package sk.uniza.fri.zemeplocha;

import sk.uniza.fri.policko.IPolicko;
import sk.uniza.fri.policko.Lovci;
import sk.uniza.fri.policko.Policko;
import sk.uniza.fri.policko.Zajace;
import sk.uniza.fri.policko.Magovia;

import javax.swing.*;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Zemeplocha {
    private final int pocetPolicok;
    private IPolicko[][] policka;

    public Zemeplocha(int pocetPolicok) {
        this.pocetPolicok = pocetPolicok;
        this.policka = new Policko[pocetPolicok][pocetPolicok];
        for (int i = 0; i < this.policka.length; i++) {
            for (int j = 0; j < this.policka.length; j++) {
                this.policka[i][j] = new Policko(0, i, j);
            }
        }
    }
    public IPolicko getPolicko(int rovnobezka, int poludnik) {
        if ((rovnobezka > 0) && (rovnobezka < this.pocetPolicok) && (poludnik > 0) && (poludnik < this.pocetPolicok)) {
            return this.policka[rovnobezka][poludnik];
        } else {
            return null;
        }
    }
    public boolean setPolicko(IPolicko vkladanePolicko, int rovnobezka, int poludnik) {
        if ((rovnobezka > 0) && (rovnobezka < this.pocetPolicok) && (poludnik > 0) && (poludnik < this.pocetPolicok)) {
            this.policka[rovnobezka][poludnik] = vkladanePolicko;
            return true;
        } else {
            return false;
        }
    }

    public int getPocetPolicok() {
        return this.pocetPolicok;
    }
    public void nastavPolicka() {
        int cislo = 1;
        for (int i = 0; i < this.policka.length; i++) {
            for (int j = 0; j < this.policka.length; j++) {
                this.policka[i][j] = new Zajace(25, i, j);
                if ((cislo % 3) == 0) {
                    this.policka[i][j] = new Lovci(20, i, j);
                }
                cislo++;
            }
            this.policka[pocetPolicok - 1][pocetPolicok - 1] = new Policko(0, pocetPolicok - 1, pocetPolicok - 1);
        }
    }
    private void nastavMaga() {

        String meno = JOptionPane.showInputDialog(null, "Zadaj ctene meno velkeho maga");
        boolean hotovo = false;
        int rovnobezka = -1;
        int poludnik = -1;
        while (!hotovo) {
            rovnobezka = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Zadaj rovnobezku policka, kde zije mag"));
            poludnik = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Zadaj poludnik policka , kde zije mag"));
            if ((rovnobezka >= 0) && (rovnobezka < this.getPocetPolicok())
                    && (poludnik >= 0) && (poludnik < this.getPocetPolicok())) {
                hotovo = true;
            } else {
                JOptionPane.showInputDialog(null, "Si nerob srandu a zadaj znova");
            }
        }
        this.policka[rovnobezka][poludnik] = new Magovia(1, meno, rovnobezka, poludnik);

    }

    //nove zemeplocha4
    public void kuzloMnozenia() {
        int cislo = 0;
        int pridame = 0;
        for (int i = 0; i < this.policka.length; i++) {
            for (int j = 0; j < this.policka[i].length; j++) {
                cislo = this.policka[i][j].getPocetObyvatelov();
                if (cislo > 0) {
                    pridame = cislo / 2;
                }
                this.policka[i][j].setPocetObyvatelov(cislo + pridame);
            }
        }
        JOptionPane.showMessageDialog( null, "Najvacsi z magov spustil kuzlo mnozenia \n"
                + "sposobujuce zmenu polulacie!!!") ;



    }
}
