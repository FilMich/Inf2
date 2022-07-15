package sk.uniza.fri.mapa;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import sk.uniza.fri.enumy.TypPolicka;
import sk.uniza.fri.manazer.ManagerOfSources;
import sk.uniza.fri.objekty.Objekty;
import sk.uniza.fri.objekty.mapa.HealingPoint;
import sk.uniza.fri.objekty.mapa.Podlaha;
import sk.uniza.fri.objekty.mapa.Portal;
import sk.uniza.fri.objekty.mapa.Strom;
import sk.uniza.fri.objekty.postavy.Robot;
import sk.uniza.fri.objekty.postavy.Zombie;

import java.util.Random;

/**
 * vytvori prvu miestnost
 */
public class PrvaMiestnost implements IMiestnost {
    private Array<Objekty> objekty;
    private Array<Objekty> interaktivneObjekty;
    private ManagerOfSources managerOfSources;
    private SpriteBatch batch;
    private Random random;

    public PrvaMiestnost(ManagerOfSources managerOfSources, SpriteBatch batch) {
        this.interaktivneObjekty = new Array<>();
        this.objekty = new Array<>();
        this.managerOfSources = managerOfSources;
        this.batch = batch;
        this.random = new Random();
    }

    /**
     * metoda na vytvorenie miestnosti
     */
    @Override
    public void vytvorMiestnost() {
        for (int xPodlaha = 5; xPodlaha < 24; xPodlaha++) {
            for (int yPodlaha = 2; yPodlaha < 14; yPodlaha++) {
                this.objekty.add(new Podlaha(this.managerOfSources, xPodlaha, yPodlaha, TypPolicka.GREEN));
            }
        }

        for (int x = 5; x < 24; x++) {
            for (int y = 2; y < 14; y++) {
                this.objekty.add(new Strom(this.managerOfSources, x, 2));
                this.objekty.add(new Strom(this.managerOfSources, 5, y));
                this.objekty.add(new Strom(this.managerOfSources, x, 13));
                this.objekty.add(new Strom(this.managerOfSources, 23, y));

            }
        }
    }

    /**
     * metoda na nakreslenie miestnosti
     */
    @Override
    public void nakresliMiestnost() {
        for (Objekty gameObject : this.objekty) {
            gameObject.nakresli(this.batch);
        }
    }

    /**
     * metoda na vytvorenie interaktivneho objektu
     */
    @Override
    public void vytvorInteraktivneObjekty() {
        int randomPortalX = this.random.nextInt(16);
        int randomPortalY = this.random.nextInt(10);
        this.interaktivneObjekty.add(new Portal(this.managerOfSources, randomPortalX + 7, randomPortalY + 3));

        int randomHealX = this.random.nextInt(16);
        int randomHealY = this.random.nextInt(10);
        if (randomHealX != randomPortalX) {
            if (randomHealY != randomPortalY) {
                this.interaktivneObjekty.add(new HealingPoint(this.managerOfSources, randomHealX + 7, randomHealY + 3));
            } else {
                this.interaktivneObjekty.add(new HealingPoint(this.managerOfSources, randomHealX + 7, randomHealY + 2));
            }
        } else {
            this.interaktivneObjekty.add(new HealingPoint(this.managerOfSources, randomHealX + 6, randomHealY + 3));
        }
        int randomPocet = random.nextInt(5) + 1;
        for (int i = 0; i < randomPocet; i++) {
            int randomX = random.nextInt(16);
            int randomY = random.nextInt(10);
            int randomZivot = random.nextInt(100);
            int randomUtok = random.nextInt(20);
            boolean robot = random.nextBoolean();
            if (robot) {
                this.interaktivneObjekty.add(new Robot(this.managerOfSources, randomX + 7, randomY + 3, randomZivot, randomUtok));
            } else {
                this.interaktivneObjekty.add(new Zombie(this.managerOfSources, randomX + 7, randomY + 3, randomZivot, randomUtok));
            }

        }
    }

    /**
     * metoda na nakreslenie interaktivneho objektu
     */
    @Override
    public void nakresliInteraktivneObjekty() {
        for (Objekty o : this.interaktivneObjekty) {
            o.nakresli(this.batch);
        }
    }

    @Override
    public Array<Objekty> getObjekty() {
        return this.objekty;
    }

    @Override
    public Array<Objekty> getInteraktivneObjekty() {
        return this.interaktivneObjekty;
    }
}
