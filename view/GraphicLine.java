package view;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Point;


/**
 * Write a description of class GraphicLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GraphicLine extends GraphicsShape {
    private int xI, yI, xF, yF;
    public GraphicLine(int xc, int yc, Color color, int xI, int yI, int xF, int yF) {
        super(xc, yc, color);
        this.xI = xI;
        this.yI = yI;
        this.xF = xF;
        this.yF = yF;
    }
    
    public Point startPoint () {
        return new Point(xI, yI);    
    }
    
    public Point endPoint () {
        return new Point(xF, yF);    
    }
    
    @Override
    public void paint (Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawLine(xI*Constants.GRID_SCALE + xc, -yI*Constants.GRID_SCALE + yc,
                    xF*Constants.GRID_SCALE + xc, -yF*Constants.GRID_SCALE + yc);
    }
}
