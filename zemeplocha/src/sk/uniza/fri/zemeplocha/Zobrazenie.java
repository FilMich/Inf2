package sk.uniza.fri.zemeplocha;
import sk.uniza.fri.policko.IPolicko;
/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public class Zobrazenie {
    private final Obdlznik[][] zobrazenie;
    private final int pocetPolicok;

    public Zobrazenie(int pocetPolicok) {
        this.pocetPolicok = pocetPolicok;
        this.zobrazenie = new Obdlznik[this.pocetPolicok][this.pocetPolicok];

        for (int i = 0; i < this.zobrazenie.length; i++) {
            for (int j = 0; j < this.zobrazenie[i].length; j++) {
                this.zobrazenie[i][j] = new Obdlznik();
                this.zobrazenie[i][j].zmenPolohu((j * 50), (i * 50));
                this.zobrazenie[i][j].zmenStrany(50, 50);

                this.zobrazenie[i][j].zmenFarbu("white");
            }
        }
    }
    private void nastavZobrazenie(Zemeplocha zem) {
        for (int i = 0; i < this.zobrazenie.length; i++) {
            for (int j = 0; j < this.zobrazenie[i].length; j++) {
                IPolicko pole = zem.getPolicko(i, j);
                String farba = pole.getFarba();
                this.zobrazenie[i][j].zmenFarbu(farba);
            }
        }
    }

    public void skry() {
        for (int i = 0; i < this.zobrazenie.length; i++) {
            for (int j = 0; j < this.zobrazenie[i].length; j++) {
                this.zobrazenie[i][j].skry();

            }
        }
    }

    public void zobraz(Zemeplocha zem) {
        this.nastavZobrazenie(zem);
        for (int i = 0; i < this.zobrazenie.length; i++) {
            for (int j = 0; j < this.zobrazenie[i].length; j++) {
                this.zobrazenie[i][j].zobraz();

            }
        }
    }
}
