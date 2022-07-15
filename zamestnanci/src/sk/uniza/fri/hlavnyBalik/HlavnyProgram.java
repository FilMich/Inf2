package sk.uniza.fri.hlavnyBalik;

//import zamestnanci.ZoznamZamestnancovMoj;
import sk.uniza.fri.zamestnanci.Zamestnanec;
import zamestnanci.Zamestnanec;
import zamestnanci.ZoznamZamestnancov;



public class HlavnaTriedaRiesenie {

    public static void main(String[] args) {

        Zamestnanec zamestna1 = new Zamestnanec(100, "Karol Smely", 1500);
        Zamestnanec zamestna2 = new Zamestnanec(101, "Janka Cistotna", 600);
        Zamestnanec zamestna3 = new Zamestnanec(102, "Alica Krasna", 800);
        Zamestnanec zamestna4 = new Zamestnanec(103, "Jozef Megakoder", 1200);
        Zamestnanec zamestna5 = new Zamestnanec(104, "Petra Krasna", 450);
        Zamestnanec zamestna6 = new Zamestnanec(105, "Zuzana Testerova", 500);
        Zamestnanec zamestna7 = new Zamestnanec(106, "Andrej Koder", 1000);
        Zamestnanec zamestna8 = new Zamestnanec(107, "Ivetka Kontrolna", 800);
        Zamestnanec zamestna9 = new Zamestnanec(108, "Milan Systemovy", 900);


        ZoznamZamestnancovMoj podnik1 = new ZoznamZamestnancovMoj();

        podnik1.addZamestnanca(zamestna1);
        podnik1.addZamestnanca(zamestna2);
        podnik1.addZamestnanca(zamestna3);
        podnik1.addZamestnanca(zamestna4);
        podnik1.addZamestnanca(zamestna5);
        podnik1.addZamestnanca(zamestna6);
        podnik1.addZamestnanca(zamestna7);
        podnik1.addZamestnanca(zamestna8);
        podnik1.addZamestnanca(zamestna9);


        System.out.println(podnik1);
        podnik1.zapisDoTextovehoSuboru("zamestnanci.txt");
        podnik1.citajOdmenyZTextovehoSuboru("odmeny.txt");

        System.out.println("***************** s odmenami z textoveho *************");
        System.out.println(podnik1);
        HlavnaTriedaRiesenie.zapisOdmenyDoBinarnehoSuboru("odmeny.dat");


        podnik1.citajOdmenyZBinarnehoSuboru("odmeny.dat");



        System.out.println("***************** s odmenami z binarneho suboru *************");
        System.out.println(podnik1);


        System.out.println("***************** Serializacia *************");
        try {
            PracaSoSuborom.vlozObjektDoSuboru(podnik1, "zamestnanci.dat");
            podnik1 = null; // zrusime povodny objekt
            Object objekt = PracaSoSuborom.vyberObjektZoSuboru("zamestnanci.dat");
            //bezpecne pretypovanie
            if (objekt instanceof ZoznamZamestnancovMoj) {
                ZoznamZamestnancovMoj zoznam2 = (ZoznamZamestnancovMoj)objekt;
                System.out.println("***************** DESerializacia *************");
                //vypiseme  novy objekt
                System.out.println(zoznam2.toString());
            }
        } catch (ClassNotFoundException nex) {
            //obaja su potomkovia Exception, takze na poradi nezalezi
            System.out.println("Doslo k chybe - nenajdena trieda***" + nex.getMessage());
        } catch (IOException ioex) {
            System.out.println("Doslo k chybe - vstupy vystupy***" + ioex.getMessage());

        } catch (Exception ex) {
            //zachytenie vsetkych dalsich vynimiek, napriklad pretypovanie by nevyslo
            System.out.println("Doslo k inej chybe***" + ex.getMessage());
        }

    }



    //doplnene cvicenie s binarnym suborom cv.17-18
    public static void zapisOdmenyDoBinarnehoSuboru(String nazovSuboru) {
        Scanner klav = new Scanner(System.in);
        DataOutputStream subor = null;

        try {
            FileOutputStream fos = new FileOutputStream(nazovSuboru);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            subor = new DataOutputStream(bos);
            int este = 1;
            while (este > 0) {
                System.out.println("Zadaj id zamestnanca");
                int id = klav.nextInt();
                subor.writeInt(id);
                System.out.println("Zadaj vysku odmeny zamestnanca");
                int suma = klav.nextInt();
                subor.writeInt(suma);
                System.out.println("Ak chces zadat dalsieho zamestnanca, stlac 1, ak nie stlac 0");
                este = klav.nextInt();
            }



        } catch (IOException e) {
            // neskor tu moze byt nasa vlastna vynimka
            System.out.println("Nepodarilo sa vlozit odmeny do suboru" + e.getMessage());

        } finally {
            if (subor != null )  {
                try {
                    //close moze vyvolat vynimku
                    subor.close();
                } catch (IOException e) {
                    System.out.println("Chyba pri zatvarani suboru " + e.getMessage());
                }
            }

        }
    }

}