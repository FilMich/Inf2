package sk.uniza.fri.prikazy;

import sk.uniza.fri.prostredie.Robot;

/**
 * 24. 5. 2021 - 13:29
 *
 * @author Filip
 */
public class Krok implements IPrikazy {
    @Override
    public void vykonaj(Robot paRobot) {
        paRobot.krok();
    }
}
