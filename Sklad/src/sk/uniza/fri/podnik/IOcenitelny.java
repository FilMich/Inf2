package sk.uniza.fri.podnik;


/**
 * Write a description of interface Ocenitelny here.
 * 
 * @author (vaclavko) 
 * @version (1/2014)
 */
public interface IOcenitelny {

    //zisti, ze kolko penazi je nutne na prevadzku daneho
    //objektu 
    double dajNaklady();
    //kratky popis objektu
    String dajPopis();
    //dlhsi ukecany vypis na konzolu
    void vypis();
    
}
