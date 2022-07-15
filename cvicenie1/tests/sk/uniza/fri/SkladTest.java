package sk.uniza.fri;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.uniza.fri.sklad.PolozkaSkladu;
import sk.uniza.fri.sklad.Sklad;
import sk.uniza.fri.tovar.Tovar;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 19.2.2021 - 15:51
 *
 * @author vaclavko
 */
class SkladTest {
    private Tovar t1 ;
    private Tovar t2 ;
    private Tovar t3 ;
    private PolozkaSkladu polSk1;
    private PolozkaSkladu polSk2;
    private PolozkaSkladu polSk3;
    private Sklad sklad25 ;


    @BeforeEach
    void setUp() {
        this.t1 = new Tovar(100, "ponozky", 2.5);
        this.t2 = new Tovar(101, "pancuchy", 4.5);
        this.t3 = new Tovar(102, "sal", 8.5);
        this.polSk1 = new PolozkaSkladu(t1, 10);
        this.polSk2 = new PolozkaSkladu(t2, 20);
        this.polSk3 = new PolozkaSkladu(t3, 30);
        this.sklad25 = new Sklad(25);
        this.sklad25.pridajTovarNaSklad(polSk1);
        this.sklad25.pridajTovarNaSklad(polSk2);
        this.sklad25.pridajTovarNaSklad(polSk3);
        //this.sklad25.vypisSklad();
        System.out.println("*************************************");

    }

    @AfterEach
    void tearDown() {
        System.out.println("HURA!!!!! TESTOVANIE SOM UKONCIL!!!!!");

    }

    @Test
    void name() {
    }

    @Test
    public void testPridanieTovaru() {


        assertTrue(this.sklad25.pridajTovarNaSklad(polSk1));

    }
    //schvalne nespravne napisany test
    @Test
    public void testTestu(){
        assertEquals(true,false);
    }

    @Test
    public void testZrusenieTovaruZoSkladu(){


        this.sklad25.vypisSklad();

        assertNull(this.sklad25.zrusTovarZoSkladu(102));
    }

    @Test
    public void testSpravneZrusenieTovaruZoSkladu(){


        this.sklad25.vypisSklad();
        this.sklad25.odoberKusyTovaruNaSklade(102, 30);
        this.sklad25.vypisSklad();
        assertNotNull(this.sklad25.zrusTovarZoSkladu(102));
    }

    @Test
    public void testCisloSkladu(){
        assertEquals(25,this.sklad25.getCisloSkladu());
    }

}