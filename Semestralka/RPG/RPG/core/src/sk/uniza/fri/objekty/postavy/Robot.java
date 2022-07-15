package sk.uniza.fri.objekty.postavy;

import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.objekty.Objekty;

import javax.swing.JOptionPane;

/**
 * vytvorenie nepriatela typu robot
 */
public class Robot extends Objekty {
    private int zivot;
    private int utok;
    private boolean zivy = true;

    public Robot(ManagerOfSources managerOfSources, int x, int y, int zivot, int utok) {
        super(managerOfSources, TypPolicka.ENEMY_ROBOT, x, y);
        this.zivot = zivot;
        this.utok = utok;
    }

    /**
     * metoda na bojovanie
     */
    @Override
    public void interakcia(Hrac hrac) {
        if (!zivy) {
            return;
        }
        while (this.zivot > 0 && hrac.getZivot() > 0) {
            this.zivot -= hrac.getUtok();
            hrac.setZivot(this.utok);
        }
        if (hrac.getZivot() > 0) {
            this.zivy = false;
            JOptionPane.showMessageDialog(null, "vyhral hrdina");
        } else {
            JOptionPane.showMessageDialog(null, "vyhral robot");
            this.zivy = false;
        }
    }
}
