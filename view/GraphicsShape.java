package view;

import java.awt.Graphics2D;
import java.awt.Color;


/**
 * Write a description of class GraphicsShape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GraphicsShape {
    protected int xc, yc;
    protected Color color;
    protected GraphicsShape (int xc, int yc, Color color) {
        this.xc = xc;
        this.yc = yc;
        this.color = color;
    }
    
    public void setCenter (int x, int y) {
        xc = x;
        yc = y;
    }
    
    public abstract void paint (Graphics2D g);
}
