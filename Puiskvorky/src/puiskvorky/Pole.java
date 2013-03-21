/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

/**
 *
 * @author Kuba D
 */
public class Pole {
    public KK[] pole;
    public int i, j, k;
    public Pole(int i,int j){
        this(i,j,1);
    }
    public Pole(int i, int j, int k){
        this.i=i;this.j=j;this.k=k;
        pole = new KK[i*j*k];
        for(;k>0;k--){
            for(j=this.j;j>0;j--){
                for(i=this.i;i>0;i--){
                    pole[k*this.j*this.i+j*this.i+i-1] = KK.PRAZDNE;
                }
            }
        }
    }
    public KK pozice(int i, int j){
        return pozice(i,j,0);
    }
    public KK pozice(int i, int j, int k){
        return pole[i*this.j*this.k+j*this.k+k];
    }
    public void pozice(int i, int j, KK co){
        pozice(i,j,0,co);
    }
    public void pozice(int i, int j, int k, KK co){
        pole[i*this.j*this.k+j*this.k+k]=co;
    }
}
