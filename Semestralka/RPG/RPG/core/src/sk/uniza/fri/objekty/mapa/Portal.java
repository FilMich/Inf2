package sk.uniza.fri.objekty.mapa;

import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.postavy.Hrac;

/**
 * vytvorenie portalu
 */
public class Portal extends Objekty {
    private boolean daSaPrejst = true;

    public Portal(ManagerOfSources managerOfSources, int x, int y) {
        super(managerOfSources, TypPolicka.PORTAL, x, y);
    }

    @Override
    public void interakcia(Hrac hrac) {

    }
}
