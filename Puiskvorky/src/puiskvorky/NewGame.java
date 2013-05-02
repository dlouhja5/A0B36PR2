/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.io.Serializable;
import java.util.Observable;

/**
 *
 * @author Kuba D
 */
public class NewGame extends Observable implements Serializable{
    private int naSirku, naDelku, vRade, hrac1, hrac2;
    private String jmeno1, jmeno2;
    private boolean nova;

    public NewGame(int naSirku, int naDelku, int vRade, int hrac1, int hrac2, String jmeno1, String jmeno2, boolean nova) {
        this.naSirku = naSirku;
        this.naDelku = naDelku;
        this.vRade = vRade;
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.jmeno1 = jmeno1;
        this.jmeno2 = jmeno2;
        this.nova = nova;
    }

    public int getHrac1() {
        return hrac1;
    }

    public int getHrac2() {
        return hrac2;
    }

    public String getJmeno1() {
        return jmeno1;
    }

    public String getJmeno2() {
        return jmeno2;
    }

    public int getNaDelku() {
        return naDelku;
    }

    public int getNaSirku() {
        return naSirku;
    }

    public int getvRade() {
        return vRade;
    }

    public boolean isNova() {
        return nova;
    }

//    @Override
//    public void notifyObservers(Object o) {
//        super.notifyObservers(o);
//    }

    @Override
    public void notifyObservers() {
        super.notifyObservers(this);
    }
    public void set(int naSirku, int naDelku, int vRade, int hrac1, int hrac2, String jmeno1, String jmeno2, boolean nova){
        this.naSirku = naSirku;
        this.naDelku = naDelku;
        this.vRade = vRade;
        this.hrac1 = hrac1;
        this.hrac2 = hrac2;
        this.jmeno1 = jmeno1;
        this.jmeno2 = jmeno2;
        this.nova = nova;
    }
}
