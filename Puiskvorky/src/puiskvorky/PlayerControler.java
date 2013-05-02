/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.util.Observable;

/**
 *
 * @author Kuba D
 */
public class PlayerControler extends Observable implements Runnable{
    private Player hrac[];
    private Pole pole;
    private SitNaMice snm;
    private Thread vlakno;
    private boolean pokracuje = true, ceka;

    public PlayerControler(Player hrac1, Player hrac2, PuiskvorkovniceND canvas, int[] rozmery) throws Exception {
        this(canvas, rozmery);
        if(hrac1==null||hrac2==null){
            throw new Exception("Malo hracu!");
        }
        this.addObserver(this.hrac[0] = hrac1);
        this.addObserver(this.hrac[1] = hrac2);
        if(this.hrac[0] instanceof LocalPlayer)canvas.localUcho((LocalPlayer)this.hrac[0]);
        if(this.hrac[1] instanceof LocalPlayer)canvas.localUcho((LocalPlayer)this.hrac[1]);
        vlakno = new Thread(this, "PlayerContrlerThread");
        vlakno.start();
    }

    private PlayerControler(PuiskvorkovniceND canvas){
        this.snm = new SitNaMice();
        System.out.println("pc1.1");
        this.hrac = new Player[2];
        System.out.println("pc1.2");
        this.addObserver(canvas);
        System.out.println("pc1.3");
    }
    private PlayerControler(PuiskvorkovniceND canvas, int[] rozmery) throws Exception{
        this(canvas);
        switch(rozmery.length){
            case 3: this.pole = new Pole(rozmery[0], rozmery[1], rozmery[2]);break;
            case 2: this.pole = new Pole(rozmery[0], rozmery[1]);break;
            default: throw new Exception("Spatne rozmery.");
        }
    }
    private PlayerControler(PuiskvorkovniceND canvas, int i, int j){
        this(canvas);
        System.out.println("pc2.1");
        this.pole = new Pole(i, j);
        System.out.println("pc2.2");
    }
    private PlayerControler(PuiskvorkovniceND canvas, int i, int j, int k){
        this(canvas);
        this.pole = new Pole(i, j, k);
    }
    public PlayerControler(String jmeno1, String jmeno2, PuiskvorkovniceND canvas, int i, int j){
        this(canvas, i, j);
        System.out.println("pc3.1");
        this.addObserver(this.hrac[0] = new LocalPlayer(jmeno1, KK.KRIZEK));
        System.out.println("pc3.2");
        this.addObserver(this.hrac[1] = new LocalPlayer(jmeno2, KK.KOLECKO));
        System.out.println("pc3.3");
        canvas.localUcho((LocalPlayer)this.hrac[0]);
        System.out.println("pc3.4");
        canvas.localUcho((LocalPlayer)this.hrac[1]);
        System.out.println("pc3.5");
        vlakno = new Thread(this, "PlayerContrlerThread");
        vlakno.start();
        System.out.println("pc3.6");
    }

    @Override
    public void run() {
        Mic m;
        for(int a=0;pokracuje;){
            for(ceka=true;ceka;){
                m = this.hrac[a].hraj();
                if(snm.neobsahovalo(m)){
                    this.notifyObservers(m);
                    ceka=false;
                    this.pole.pozice(m.getI(), m.getJ(), m.getCo());
                    if(!(pole.vRade(5)==KK.PRAZDNE))pokracuje=false;
                }
            }
            if(a==0)a=1;else a=0;
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
