package sk.uniza.fri.hlavnyBalik;

//import sk.uniza.fri.hlavnyBalik.HlavnaTrieda;
import sk.uniza.fri.podnik.MajetokPodniku;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;




/**
 *
 * @author vaclavko
 * @version 01/2019
 */
public class HlavnaTrieda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MajetokPodniku podnik1 = new MajetokPodniku("Moj podnik");
               
        System.out.println("********************");
        
        Sklad sklad1 = new Sklad(25);
        podnik1.addMajetok(sklad1);
        Sklad sklad2 = new Sklad(42);
        podnik1.addMajetok(sklad2);
        podnik1.vypisPodniku();
        
        System.out.println("********************");
        
        Tovar tov1 = new Tovar(101, "ponozky", 2.5);
        Tovar tov2 = new Tovar(102, "pancuchy", 4.5);
        Tovar tov3 = new Tovar(103, "sal", 8.5);
        
        PolozkaSkladu polSk1 = new PolozkaSkladu(tov1, 12);
        PolozkaSkladu polSk12 = new PolozkaSkladu(tov1, 20);
        PolozkaSkladu polSk3 = new PolozkaSkladu(tov2, 30);
        PolozkaSkladu polSk4 = new PolozkaSkladu(tov3, 7);
        
        podnik1.pridajTovarNaSklad(25, polSk1);
        podnik1.pridajTovarNaSklad(25, polSk12);
        podnik1.pridajTovarNaSklad(25, polSk4);
        
        podnik1.pridajTovarNaSklad(42, polSk12);
        podnik1.pridajTovarNaSklad(42, polSk3);
        podnik1.vypisPodniku();
        
        
        System.out.println("***************");
        System.out.println("Zoznam majetku:\n" + podnik1.dajZoznamMajetku());
        
        podnik1.vypisZoznamuTovarov();
        System.out.println();

        System.out.println("****odoberam kusy nad limit ***********");
        podnik1.odoberKusyTovaruNaSklade(25, 101, 100);
        podnik1.vypisPodniku();
        
        System.out.println("***pokus o zrusenie************");

        PolozkaSkladu zrusena = null;
        zrusena = podnik1.zrusTovarZoSkladu(25, 101);
        if (zrusena == null) {
            System.out.println("Nepodarilo sa zrusit polozku");
        } else {
            System.out.println("zrusili sme polozku>");
            zrusena.vypis();
        }
        podnik1.vypisPodniku();
        
        System.out.println("****znova odoberam kusy***********");
        podnik1.odoberKusyTovaruNaSklade(25, 101, 32);
        podnik1.vypisPodniku();
        
        System.out.println("****znova pokus o zrusenie***********");
        zrusena = podnik1.zrusTovarZoSkladu(25, 101);
        if (zrusena == null) {
            System.out.println("Nepodarilo sa zrusit polozku");
        } else {
            System.out.println("zrusili sme polozku>");
            zrusena.vypis();
        }
        podnik1.vypisPodniku();
    }
}
