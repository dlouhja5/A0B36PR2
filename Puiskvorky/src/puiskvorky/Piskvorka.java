/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

/**
 *
 * @author Kuba D
 */
public class Piskvorka {

    /**
     * @param args the command line arguments
     */
    public KK[][] piskvorky;
    public int[] konec;
    protected int vyherni;
    protected int kolecek, krizku, prazdnoty;
    public PuiskvorkovniceND puis;
    public Piskvorka(int piskvorky, int vyherni,PuiskvorkovniceND puis){
        this.puis=puis;
        if(piskvorky>70){
            piskvorky=70;
        }
        if(piskvorky<3){
            piskvorky=3;
        }
        if(vyherni>piskvorky||vyherni<3){
            vyherni=5;
            if(vyherni>piskvorky){
                vyherni=piskvorky;
            }
        }
        this.vyherni = vyherni;
        kolecek = 0; krizku = 0; prazdnoty = piskvorky*piskvorky;
        konec = new int[3];konec[0]=-1;konec[1]=-1;konec[2]=-1;
        this.piskvorky = new KK[piskvorky][piskvorky];
        for(int i=0; i<piskvorky; i++){
            for(int j=0; j<piskvorky; j++){
                this.piskvorky[i][j] = KK.PRAZDNE;
            }
        }
    }
    public Piskvorka(int piskvorky){
        if(piskvorky>70){
            piskvorky=70;
        }
        if(piskvorky<3){
            piskvorky=3;
        }
        if(piskvorky<5){
            vyherni=piskvorky;
        }else{
            vyherni = 5;
        }
        kolecek = 0; krizku = 0; prazdnoty = piskvorky*piskvorky;
        konec = new int[3];konec[0]=-1;konec[1]=-1;konec[2]=-1;
        this.piskvorky = new KK[piskvorky][piskvorky];
        for(int i=0; i<piskvorky; i++){
            for(int j=0; j<piskvorky; j++){
                this.piskvorky[i][j] = KK.PRAZDNE;
            }
        }
    }
    public Piskvorka(){
        int piskvorky = 9;
        vyherni = 5;
        kolecek = 0; krizku = 0; prazdnoty = piskvorky*piskvorky;
        konec = new int[3];konec[0]=-1;konec[1]=-1;konec[2]=-1;
        this.piskvorky = new KK[piskvorky][piskvorky];
        for(int i=0; i<piskvorky; i++){
            for(int j=0; j<piskvorky; j++){
                this.piskvorky[i][j] = KK.PRAZDNE;
            }
        }
    }
    public int[] vyherni(){//0-svisle,1-vodorovne,2-zlevyhorni,3zpravyhorni
        int[] vrat = {-1, -1, -1};
        int i, j, kolecka, krizky;
        for(i=0, kolecka=0, krizky=0; i<piskvorky.length; i++,kolecka=0,krizky=0){
            for(j=0; j<piskvorky.length; j++){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=0;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=0;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
        }
        for(j=0, kolecka=0, krizky=0; j<piskvorky.length; j++,kolecka=0,krizky=0){
            for(i=0; i<piskvorky.length; i++){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=1;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=1;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
        }
        for(int jj=0; jj<piskvorky.length; jj++){
            for(i=0,j=jj,kolecka=0,krizky=0; j<piskvorky.length; i++,j++){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=2;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=2;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
            for(i=jj+1,j=0,kolecka=0,krizky=0; i<piskvorky.length; i++,j++){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=2;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=2;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
            for(i=0,j=jj,kolecka=0,krizky=0; i<piskvorky.length&&j>=0; i++,j--){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=3;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=3;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
            for(i=jj,j=this.piskvorky.length-1,kolecka=0,krizky=0; i<piskvorky.length&&j>=0; i++,j--){
                if(this.piskvorky[i][j]==KK.KOLECKO){
                    if(++kolecka==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=3;
                        return vrat;
                    }
                    krizky=0;
                }else{if(this.piskvorky[i][j]==KK.KRIZEK){
                    if(++krizky==vyherni){
                        vrat[0]=i;vrat[1]=j;vrat[2]=3;
                        return vrat;
                    }
                    kolecka=0;
                }else{
                    kolecka=0;krizky=0;
                }}
            }
        }
        return vrat;
    }
    public void dalsiTah(int i, int j){
        hracTah(i, j);
    }
    protected void hracTah(int i, int j){
        if(konec[0]==-1){
            if(i<this.piskvorky.length&&j<this.piskvorky[0].length&&i>=0&&j>=0){
                if(this.piskvorky[i][j]==KK.PRAZDNE){
                    puis.pridej(i, j, this.piskvorky[i][j]=setTah());
                    konec = vyherni();
                }
            }
        }
    }
    public KK naTahu(){
        if(this.krizku==this.kolecek){
            return KK.KRIZEK;
        }
        if(this.krizku==this.kolecek+1){
            return KK.KOLECKO;
        }
        return KK.PRAZDNE;
    }
    protected KK setTah(){
        if(this.prazdnoty>0){
            if(this.krizku==this.kolecek){
                this.krizku++;this.prazdnoty--;
                return KK.KRIZEK;
            }
            if(this.krizku==this.kolecek+1){
                this.kolecek++;this.prazdnoty--;
                return KK.KOLECKO;
            }
        }
        return KK.PRAZDNE;
    }
    protected KK unsetTah(){
        if(this.krizku==this.kolecek&&this.kolecek>0){
            this.kolecek--;
            return KK.KRIZEK;
        }
        if(this.krizku==this.kolecek+1){
            this.krizku--;
            return KK.KOLECKO;
        }
        return KK.PRAZDNE;
    }

    public int getPrazdnoty() {
        return prazdnoty;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
