package sk.uniza.fri;

/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura.
 * Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty.
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * <p>
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra)
 * a poslite jej spravu hraj.
 * <p>
 * Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 *
 * @author Michael Kolling, David J. Barnes
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class Hra {
    private Parser parser;
    private Miestnost aktualnaMiestnost;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        this.vytvorMiestnosti();
        this.parser = new Parser();
    }

    /**
     * Vytvori mapu hry - miestnosti.
     */
    private void vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");
        //******upravene vyuzite nove metody
        // inicializacia miestnosti = nastavenie vychodov
        terasa.nastavVychod("vychod", aula);
        terasa.nastavVychod("juh", labak);
        terasa.nastavVychod("zapad", bufet);
        aula.nastavVychod("zapad", terasa);
        bufet.nastavVychod("vychod", terasa);
        labak.nastavVychod("sever", terasa);
        labak.nastavVychod("vychod", kancelaria);
        kancelaria.nastavVychod("zapad", labak);

        this.aktualnaMiestnost = terasa;  // startovacia miestnost hry
    }

    /**
     * Hlavna metoda hry.
     * Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.

        boolean jeKoniec;

        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonajPrikaz(prikaz);
        } while (!jeKoniec);

        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        System.out.print("Teraz si v miestnosti ");
        this.aktualnaMiestnost.vypisInfo();
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    private boolean vykonajPrikaz(Prikaz prikaz) {
        boolean jeKoniec = false;

        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            default:
                return false;
        }
    }

    // implementacie prikazov:

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    private void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();
        //****vyuzitie novej metody
        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        Miestnost novaMiestnost = this.aktualnaMiestnost.getVychod(smer);
        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            System.out.print("Teraz si v miestnosti ");
            this.aktualnaMiestnost.vypisInfo();
        }
    }


    /**
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * Prikaz ukoncenia nema parameter.
     *
     * @return true, if this command quits the game, false otherwise.
     * @return true, ak prikaz konci hru, inak false.
     */
    private boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

}
