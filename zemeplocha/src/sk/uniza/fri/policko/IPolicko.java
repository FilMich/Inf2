package sk.uniza.fri.policko;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public interface IPolicko {
    int getPocetObyvatelov();
    void setPocetObyvatelov(int novyPocet);
    String getFarba();
    String toString();
    String dajPopis();
    int getRovnobezka();
    int getPoludnik();
}
