package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

/**
 * 4. 5. 2021 - 10:11
 *
 * @author Filip
 */
public class ObdlznikGUIbod1 extends JFrame {
    private Obdlznik obdlznik;

    public ObdlznikGUIbod1 (int x, int y) {
        this.obdlznik = new Obdlznik(x, y);

        this.setLocation(100, 100);
        this.setSize(800, 500);
        this.setResizable(true);
        this.setTitle("Aplikacia pre obdlznik");

        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        System.out.println("DPI = " + t.getScreenSize() + " * Screen:" + d.width + "*" + d.height);
        final int castOkna = 50;
        this.setLocation(d.width * (100 - castOkna) / 100 / 2, d.height * (100 - castOkna) / 100 / 2);

        this.setVisible(true);
        this.toFront();
    }
}
