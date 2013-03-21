/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.awt.Canvas;

/**
 *
 * @author Kuba D
 */
public class PuiskvorkovniceND extends Canvas{
    private int wid, height, sizeWid, sizeHeight;
    
    private void initiate(int wid, int height, int sizeWid, int sizeHeight){
        this.height=height;this.wid=wid;this.sizeHeight=sizeHeight;this.sizeWid=sizeWid;
        this.setSize(wid*sizeWid, height*sizeHeight);
        
    }
}
