/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Kuba D
 */
public class PuiskvorkovniceND extends Canvas implements Observer{
    private int width, height, sizeWidth, sizeHeight, sizeOfWidth, sizeOfHeight;
    private boolean[] krizky, kolecka;
    private int num = 0;
    private Mic mic = new Mic(-1,-1,KK.PRAZDNE);
    private Observable observable;

    public PuiskvorkovniceND(int width, int height) {
        initiate(width, height, this.getWidth(), this.getHeight());
        this.prihravac();
    }

    public PuiskvorkovniceND(int width, int height, int sizeWidth, int sizeHeight) {
        initiate(width, height, sizeWidth, sizeHeight);
        this.prihravac();
    }
    public PuiskvorkovniceND(int width, int height, int sizeWidth, int sizeHeight, int test) {
        initiate(width, height, sizeWidth, sizeHeight);
    }
    private void initiate(int width, int height, int sizeWidth, int sizeHeight){
          //počet dílů na (šířku,      výšku),      šířka,          výška
        this.setBackground(Color.WHITE);
        this.height=height;this.width=width;this.sizeHeight=sizeHeight;this.sizeWidth=sizeWidth;
        this.sizeOfHeight=sizeHeight/height;this.sizeOfWidth=sizeWidth/width;
        this.setSize(sizeWidth, sizeHeight);
        this.krizky=new boolean[height*width];this.kolecka=new boolean[height*width];
        for(int i=0;i<this.krizky.length;i++){
            this.krizky[i]=false;
            this.kolecka[i]=false;
        }
        posluchac();
        this.repaint();
    }
    private void posluchac(){
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me){
                if(me.getX()<sizeWidth&&me.getY()<sizeHeight&&me.getX()>-1&&me.getY()>-1){
                    prihraj(new Mic(me.getX()/sizeOfWidth, me.getY()/sizeOfHeight, KK.PRAZDNE));
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseReleased(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseEntered(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    private void prihravac(){
        this.observable = new Observable() {
            
        };
    }
    public void prihraj(Mic m){
        if(this.observable!=null){
            this.observable.notifyObservers(mic = m);
        }else{
            pridej(m.getI(), m.getJ());
        }
    }
    public void localUcho(LocalPlayer lp){
        this.observable.addObserver(lp);
    }
    public void resizeIt(int sizeWidth, int sizeHeight){
        this.sizeHeight=sizeHeight;this.sizeWidth=sizeWidth;
        this.sizeOfHeight=sizeHeight/height;this.sizeOfWidth=sizeWidth/width;
        this.setSize(sizeWidth, sizeHeight);
        repaint();
    }
    @Override
    public void paint(Graphics g){
        for(int i=0;i<this.sizeHeight;i+=this.sizeOfHeight){
            g.drawLine(0, i, this.sizeWidth, i);
        }
        for(int i=0;i<this.sizeWidth;i+=this.sizeOfWidth){
            g.drawLine(i, 0, i, this.sizeHeight);
        }
        for(int i=0;i<this.width;i++){
            for(int j=0;j<this.height;j++){
                if(krizky[i*this.width+j]){
                    g.drawLine(this.sizeOfWidth*i, this.sizeOfHeight*j, this.sizeOfWidth*(i+1), this.sizeOfHeight*(j+1));
                    g.drawLine(this.sizeOfWidth*(i+1), this.sizeOfHeight*j, this.sizeOfWidth*i, this.sizeOfHeight*(j+1));
                }
                if(kolecka[i*this.width+j]){
                    g.drawOval(this.sizeOfWidth*i, this.sizeOfHeight*j, this.sizeOfWidth, this.sizeOfHeight);
                }
            }
        }
    }
    private void pridej(int i, int j){
        if(num%2==0){
            pridej(i, j, KK.KRIZEK);
        }else{
            pridej(i, j, KK.KOLECKO);
        }
        num++;
    }
    public void pridej(int i, int j, KK co){
        if(co==KK.KRIZEK){
            this.krizky[i*this.width+j]=true;
            repaint();
            return;
        }
        if(co==KK.KOLECKO){
            this.kolecka[i*this.width+j]=true;
            repaint();
            return;
        }
        if(co==KK.PRAZDNE){
            this.kolecka[i*this.width+j]=false;
            this.krizky[i*this.width+j]=false;
            repaint();
        }
    }

    public int getSizeOfWidth() {
        return sizeOfWidth;
    }

    public int getSizeOfHeight() {
        return sizeOfHeight;
    }

    public int getSizeWidth() {
        return sizeWidth;
    }

    public int getSizeHeight() {
        return sizeHeight;
    }

    @Override
    public void update(Observable o, Object o1) {
        if(o1 instanceof Mic){
            Mic m = (Mic)o1;
            if(m.getCo()==KK.KRIZEK){
                this.krizky[m.getI()*this.width+m.getJ()]=true;
                this.kolecka[m.getI()*this.width+m.getJ()]=false;
            }else{if(m.getCo()==KK.KOLECKO){
                this.kolecka[m.getI()*this.width+m.getJ()]=true;
                this.krizky[m.getI()*this.width+m.getJ()]=false;
            }else{
                this.krizky[m.getI()*this.width+m.getJ()]=false;
                this.kolecka[m.getI()*this.width+m.getJ()]=false;
            }}
//            switch(m.getCo()){
//                case KK.KRIZEK: this.krizky[m.getI()*this.width+m.getJ()]=true;
//                                this.kolecka[m.getI()*this.width+m.getJ()]=false;
//                                break;
//                case KK.KOLECKO:    this.kolecka[m.getI()*this.width+m.getJ()]=true;
//                                    this.krizky[m.getI()*this.width+m.getJ()]=false;
//                                    break;
//                case KK.PRAZDNE:    this.krizky[m.getI()*this.width+m.getJ()]=false;
//                                    this.kolecka[m.getI()*this.width+m.getJ()]=false;
//                                    break;
//            }
            repaint();
        }else{
            System.out.println("Nepodporuje.");throw new UnsupportedOperationException("Not supported this.");
        }
    }
}
