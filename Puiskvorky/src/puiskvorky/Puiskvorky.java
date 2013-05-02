/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Kuba D
 */
public class Puiskvorky extends JFrame {

    private PuiskvorkovniceND puis;
    private final static int okrajx=17, okrajy=39;
    private NewGame ng=null;
    private PlayerControler cont;
    private Thread resizing=null;
    public Puiskvorky(){
        super("Test");
        this.setSize(400+okrajx, 400+okrajy);
        this.setLayout(new BorderLayout());
        this.add(puis = new PuiskvorkovniceND(10,10,400,400,0),BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        novaHra();
        /*ng = new NewGame(11, 11, 5, 0, 0, "Hrac1", "Hrac2", false);
        novaHra1();*/
        try {
            this.resized();
        } catch (InterruptedException ex) {
            Logger.getLogger(Puiskvorky.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void novaHra(){
        NewGame ng1 = new NewGame(5, 5, 3, 0, 0, "Hrac1", "Hrac2", false);
        ng1.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object o1) {
                ng=(NewGame)o1;
                novaHra1();
                System.out.println("update");
            }
        });
        NovaGame nh = new NovaGame(this, rootPaneCheckingEnabled, ng1);
        nh.test();
        nh.setVisible(true);
            while(!(ng1.isNova()||ng1.getvRade()==-1));
            if(ng1.isNova()){
                ng=ng1;
                novaHra1();
                System.out.println("after while");
            }
    }
    private void novaHra1(){
        this.remove(this.puis);
        this.add(this.puis = new PuiskvorkovniceND(ng.getNaSirku(), ng.getNaDelku(), 400, 400));
        System.out.println("nh2");
        this.cont = new PlayerControler(ng.getJmeno1(), ng.getJmeno2(), puis, ng.getNaSirku(), ng.getNaDelku());
        System.out.println("nh3");
    }
    /*private PuiskvorkovniceND novaHra2(){
        Object[] opt = {"", "", ""};//texty tlacitek
        int i = JOptionPane.showOptionDialog(this, "",//text nad tlacitky
                "",//titulek okna
                JOptionPane.YES_NO_CANCEL_OPTION,//odpovedi a pocet tlacitek
                JOptionPane.PLAIN_MESSAGE,//zobrazeni ikony
                null, opt, opt[0]);
        return null;
    }*/
    private void resized() throws InterruptedException{
        this.resizing = new Thread(){
            @Override
            public void run(){
                while(true){
                    System.out.println("true");
                    puis.resizeIt(getWidth()-okrajx, getHeight()-okrajy);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Puiskvorky.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("false");
                    }
                }
            }
        };
        this.resizing.start();
        //this.resizing.setDaemon(true);
    }
    public void resize() throws InterruptedException{
            this.puis.resizeIt(this.getWidth()-okrajx, this.getHeight()-okrajy);
    }
    public static void main(String[] args) throws InterruptedException {
        Puiskvorky p = new Puiskvorky();
        //new Puiskvorky().resized();
    }
}
