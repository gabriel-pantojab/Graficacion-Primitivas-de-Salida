package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;


/**
 * Write a description of class GraphicSquare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphicSquare extends GraphicsShape {
    private int xTL, yTL, width, height;
    
    public GraphicSquare(int xc, int yc, Color color, int xTL, int yTL, int width, int height) {
        super(xc, yc, color);
        this.xTL = xTL;
        this.yTL = yTL;
        this.width = width;
        this.height = height;
    }
    
    public void paint (Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        g.drawRect(xTL*Constants.GRID_SCALE + xc, -yTL*Constants.GRID_SCALE + yc, width*Constants.GRID_SCALE, height*Constants.GRID_SCALE);
    }
}
