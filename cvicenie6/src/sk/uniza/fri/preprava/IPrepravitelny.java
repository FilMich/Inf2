package sk.uniza.fri.preprava;

/**
 * 15. 3. 2021 - 20:22
 *
 * @author Filip
 */
public interface IPrepravitelny {
    double getVahu();
    boolean jeSchopnyPrevozu();
    void vypis();
    String getPopis();
}
