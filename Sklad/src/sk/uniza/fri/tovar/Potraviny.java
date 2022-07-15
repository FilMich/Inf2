package sk.uniza.fri.tovar;

/**
 * 25. 3. 2021 - 1:45
 *
 * @author Filip
 */
public class Potraviny extends Tovar {
    private int trvanlivostVMesiacoch;
    private String krajinaPovodu;
    private int teplotaUschovania;
    private static final double MESACNE_NAKLADY_NA_CHLADENIE_1_STUPNA = 0.0001;
    private static final int ZAKLADNA_TEPLOTA_CHLADENIA = 10;

    public Potraviny(int id, String nazov, double cena, int trvanlivostVMesiacoch, String krajinaPovodu, int teplotaUschovania) {
        super(id, nazov, cena);
        this.trvanlivostVMesiacoch = trvanlivostVMesiacoch;
        this.krajinaPovodu = krajinaPovodu;
        this.teplotaUschovania = teplotaUschovania;
    }

    public int getTrvanlivostVMesiacoch() {
        return this.trvanlivostVMesiacoch;
    }

    public String getKrajinaPovodu() {
        return this.krajinaPovodu;
    }

    public int getTeplotaUschovania() {
        return this.teplotaUschovania;
    }

    public Potraviny(int id, String nazov, double cena) {
        super(id, nazov, cena);
    }

    @Override
    public double dajNaklady() {
        return super.dajNaklady() - (this.teplotaUschovania * MESACNE_NAKLADY_NA_CHLADENIE_1_STUPNA);
    }

    @Override
    public String dajPopis() {
        return "Potraviny" + super.dajPopis();
    }

    @Override
    public void vypis() {
        super.vypis();
        System.out.println(String.format("Trvanlivost:%d, KrajinaPovodu:%s, TelpotaUschovania:%d ", this.trvanlivostVMesiacoch, this.krajinaPovodu, this.teplotaUschovania));
    }
}
