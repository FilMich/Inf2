package sk.uniza.fri.objekty.mapa;

import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.postavy.Hrac;

/**
 * vytvorenie podlahy
 */
public class Podlaha extends Objekty {
    public Podlaha(ManagerOfSources managerOfSources, int x, int y, TypPolicka typPolicka) {
        super(managerOfSources, typPolicka, x, y);
    }

    @Override
    public void interakcia(Hrac hrac) {

    }
}
