/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.io.Serializable;

/**
 *
 * @author Kuba D
 */
public enum KK implements Serializable{
    PRAZDNE,
    KRIZEK,
    KOLECKO;
    public KK reverse(){
        switch(this){
            case KRIZEK:    return KOLECKO;
            case KOLECKO:   return KRIZEK;
            default:        return PRAZDNE;
        }
    }
}
