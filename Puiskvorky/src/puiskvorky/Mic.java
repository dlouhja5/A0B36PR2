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
public class Mic extends Throwable implements Serializable {
    
    private int i;

    /**
     * Get the value of i
     *
     * @return the value of i
     */
    public int getI() {
        return i;
    }
    private int j;

    /**
     * Get the value of j
     *
     * @return the value of j
     */
    public int getJ() {
        return j;
    }
    private KK co;

    /**
     * Get the value of co
     *
     * @return the value of co
     */
    public KK getCo() {
        return co;
    }

    public Mic(int i, int j, KK co) {
        this.i = i;
        this.j = j;
        this.co = co;
    }

    public Mic(int i, int j, KK co, String string) {
        super(string);
        this.i = i;
        this.j = j;
        this.co = co;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mic other = (Mic) obj;
        if (this.i != other.i) {
            return false;
        }
        if (this.j != other.j) {
            return false;
        }
        if (this.co != other.co) {
            return false;
        }
        return true;
    }

    public boolean equalij(Mic m) {
        if(m == null) {
            return false;
        }
        if (this.i != m.i) {
            return false;
        }
        if (this.j != m.j) {
            return false;
        }
        return true;
    }
    public boolean equalij(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mic other = (Mic) obj;
        if (this.i != other.i) {
            return false;
        }
        if (this.j != other.j) {
            return false;
        }
        return true;
    }

}
