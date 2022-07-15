package sk.uniza.fri.policko;

/**
 * 29. 3. 2021 - 0:33
 *
 * @author Filip
 */
public interface IBojovnik {
    int getMaxUtocnuSilu();
    int getMaxObrannuSilu();
    IPolicko utok(IBojovnik cielUtoku,int silaUtoku);
    void upravaStavuSil(int oKolko);
    IPolicko kolonizacia(IPolicko novySvet, int pocetKolonizatorov);
}
