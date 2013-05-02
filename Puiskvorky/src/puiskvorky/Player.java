/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Kuba D
 */
public class Player implements Observer {
    protected String name;
    protected KK kdo;
    protected Mic mic;

    public Player(String name, KK kdo) {
        this.name = name;
        this.kdo = kdo;
        this.mic = new Mic(-1, -1, KK.PRAZDNE);
    }
    public Mic hraj(){
        return this.mic;
    }
    @Override
    public void update(Observable o, Object o1) {
        if(o1 instanceof Mic){
            if(o instanceof PlayerControler){
                this.mic = (Mic)o1;
            }else{
                this.mic = (Mic)o1;
                this.mic = new Mic(mic.getI(),mic.getJ(),this.kdo);
            }
        }else{
            throw new UnsupportedOperationException("Not supported this.");
        }
    }
}
