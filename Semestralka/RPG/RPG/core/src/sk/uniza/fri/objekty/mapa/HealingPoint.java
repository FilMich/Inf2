package sk.uniza.fri.objekty.mapa;

import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.postavy.Hrac;

import javax.swing.JOptionPane;

/**
 * vytvorenie miesta kde sa doplna zivot hracovi
 */
public class HealingPoint extends Objekty {
    private boolean dobil = false;

    public HealingPoint(ManagerOfSources managerOfSources, int x, int y) {
        super(managerOfSources, TypPolicka.HEALINGPOINT, x, y);
    }

    /**
     * metoda na doplnenie zivota
     */
    @Override
    public void interakcia(Hrac hrac) {
        if (!dobil) {
            hrac.dobiZivot();
            this.dobil = true;
            JOptionPane.showMessageDialog(null, "dobil si si zivot na" + hrac.getZivot());
        }
    }
}
