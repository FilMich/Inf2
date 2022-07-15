package sk.uniza.fri;


import sk.uniza.fri.prikazy.Krok;
import sk.uniza.fri.prikazy.Program;
import sk.uniza.fri.prikazy.Vlavo;
import sk.uniza.fri.prikazy.Vpravo;
import sk.uniza.fri.prostredie.Plocha;

/**
 * Created by IntelliJ IDEA.
 * User: Filip
 * Date: 24. 5. 2021
 * Time: 13:29
 */
public class Main {
    public static void main(String[] args) {
        //TODO Write your code
        System.out.println("Hello world");
        Program program = new Program();
        Plocha plocha = new Plocha();
        program.pridajPrikaz(new Krok());
        program.pridajPrikaz(new Krok());
        program.pridajPrikaz(new Vlavo());
        program.pridajPrikaz(new Krok());
        program.pridajPrikaz(new Krok());
        program.pridajPrikaz(new Krok());
        program.pridajPrikaz(new Vpravo());
        program.spusti(plocha);
    }
}
