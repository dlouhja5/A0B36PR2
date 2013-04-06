/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Kuba D
 */
public class OknoTest extends JFrame{
    PuiskvorkovniceND puis;
    public OknoTest(){
        super("Test");
        this.setSize(400+17, 400+39);
        this.setLayout(new BorderLayout());
        this.add(puis = new PuiskvorkovniceND(10,10,400,400),BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    public static void main(String[] args) {
        OknoTest a=new OknoTest();
        try {
            a.puis.pridej(5, 5, KK.KRIZEK);
            a.puis.pridej(5, 6, KK.KOLECKO);
            Thread.sleep(3000);
            a.puis.pridej(6, 6, KK.KRIZEK);
            Thread.sleep(3000);
            a.puis.pridej(7, 7, KK.KOLECKO);
            Thread.sleep(3000);
            a.puis.pridej(4, 6, KK.KRIZEK);
            Thread.sleep(3000);
            a.puis.pridej(3, 7, KK.KOLECKO);
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OknoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.dispose();
        
    }
    
}
