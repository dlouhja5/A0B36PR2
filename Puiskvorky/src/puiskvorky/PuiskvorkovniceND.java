/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kuba D
 */
public class PuiskvorkovniceND extends Canvas{
    private int width, height, sizeWidth, sizeHeight, sizeOfWidth, sizeOfHeight;
    private boolean[] krizky, kolecka;

    public PuiskvorkovniceND(int width, int height) {
        initiate(width, height, this.getWidth(), this.getHeight());
    }

    public PuiskvorkovniceND(int width, int height, int sizeWidth, int sizeHeight) {
        initiate(width, height, sizeWidth, sizeHeight);
    }
    
    private void initiate(int width, int height, int sizeWidth, int sizeHeight){
          //počet dílů na (šířku,      výšku),      šířka,          výška
        this.setBackground(Color.yellow);
        this.height=height;this.width=width;this.sizeHeight=sizeHeight;this.sizeWidth=sizeWidth;
        this.sizeOfHeight=sizeHeight/height;this.sizeOfWidth=sizeWidth/width;
        this.setSize(sizeWidth, sizeHeight);
        this.krizky=new boolean[height*width];this.kolecka=new boolean[height*width];
        for(int i=0;i<this.krizky.length;i++){
            this.krizky[i]=false;
            this.kolecka[i]=false;
        }
        
    }
    public void resizeIt(int sizeWidth, int sizeHeight){
        this.sizeHeight=sizeHeight;this.sizeWidth=sizeWidth;
        this.sizeOfHeight=sizeHeight/height;this.sizeOfWidth=sizeWidth/width;
        this.setSize(sizeWidth, sizeHeight);
        update(getGraphics());
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
}
