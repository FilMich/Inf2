package sk.uniza.fri.objekty.mapa;

import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.postavy.Hrac;

/**
 * vytvorenie stromu ako hranice
 */
public class Strom extends Objekty {
    private boolean daSaPrejst = false;

    public Strom(ManagerOfSources managerOfSources, int x, int y) {
        super(managerOfSources, TypPolicka.TREE, x, y);
    }


    @Override
    public void interakcia(Hrac hrac) {

    }
}
