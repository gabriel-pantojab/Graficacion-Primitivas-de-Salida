package view;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Point;


/**
 * Write a description of class GraphicCircle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GraphicCircle extends GraphicsShape {
    private int xC, yC, radio;
    public GraphicCircle(int xc, int yc, Color color, int xC, int yC, int radio) {
        super(xc, yc, color);
        this.xC =xC;
        this.yC = yC;
        this.radio = radio;
    }
    
    public Point center () {
        return new Point(xC, yC);
    }
    
    public int radio () {
        return radio;
    }
    
    public void paint (Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawOval((xC-radio)*Constants.GRID_SCALE + xc, -(yC+radio)*Constants.GRID_SCALE + yc, 2*radio*Constants.GRID_SCALE, 2*radio*Constants.GRID_SCALE);
    }
}
