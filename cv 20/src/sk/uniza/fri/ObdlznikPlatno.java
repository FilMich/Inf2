package sk.uniza.fri;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * 
 * @author (vaclavko) 
 * @version (1/2015)
 */
public class ObdlznikPlatno extends JComponent {
    
    private Obdlznik obd;
    
    public ObdlznikPlatno(Obdlznik paObd) {
        this.obd = paObd;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D)g;
        
        //vykreslime
        this.obd.zobrazSa(gg, getWidth() * 10 / 100, getHeight() * 5 / 100);
        
        gg.setColor(Color.MAGENTA);
        gg.drawString("Nasa skvela aplikacia ", getWidth() - 120, getHeight() - 20);
    }
}
