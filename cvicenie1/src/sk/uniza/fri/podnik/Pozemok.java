package sk.uniza.fri.podnik;

/**
 * 23. 2. 2021 - 10:45
 *
 * @author Filip
 */
public class Pozemok implements IOcenitelny {

    private String nazov;
    private double sirka;
    private double dlzka;
    private double cenaPrenajmuZaM2;

    public Pozemok(String nazov, double sirka, double dlzka, double cenaPrenajmu) {
        this.nazov = nazov;
        this.sirka = sirka;
        this.dlzka = dlzka;
        this.cenaPrenajmuZaM2 = cenaPrenajmu;
    }

    public String getNazov() {

        return this.nazov;
    }

    public double getSirku() {

        return this.sirka;
    }

    public double getDlzku() {

        return this.dlzka;
    }

    public double getCenuPrenajmu() {

        return this.cenaPrenajmuZaM2;
    }

    public void setCenuPrenajmu(double paNovaCena) {

        this.cenaPrenajmuZaM2 = paNovaCena;
    }

//    public String toString() {
//        return String.format("Pozemok %s s rozmermi %8.2f m x %8.2f m ",this.nazov, this.sirka, this.dlzka);
//    }


    //doplnene cviko5 rozhranie ocenitelny
    //plochapozemku krat cena prenajmu za meter stvorcovy
    @Override
    public double dajNaklady() {

        return this.sirka * this.dlzka * this.cenaPrenajmuZaM2;
    }

    @Override
    public String dajPopis() {

        return String.format("Pozemok %s ", this.nazov);
    }

    @Override
    public void vypis() {
        System.out.println(String.format("Pozemok %s s rozmermi %8.2f m x %8.2f m ", this.nazov, this.sirka, this.dlzka));
    }
}
