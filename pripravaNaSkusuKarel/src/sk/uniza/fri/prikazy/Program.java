package sk.uniza.fri.prikazy;

import sk.uniza.fri.prostredie.Plocha;
import sk.uniza.fri.prostredie.Robot;

import java.util.ArrayList;


/**
 * 24. 5. 2021 - 13:29
 *
 * @author Filip
 */
public class Program {
    private ArrayList<IPrikazy> zoznamPrikazov;
    public Program() {
        this.zoznamPrikazov = new ArrayList<IPrikazy>();

    }

    public void pridajPrikaz(IPrikazy paPrikaz) {
        this.zoznamPrikazov.add(paPrikaz);
    }

    public void spusti(Plocha paPlocha) {
        Robot robot = paPlocha.dajRobota();
        for (IPrikazy i: this.zoznamPrikazov) {
            i.vykonaj(robot);
        }
        paPlocha.vypis();
        this.zoznamPrikazov.clear();
    }
}
