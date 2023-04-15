package view;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;


/**
 * Write a description of class GraphicTriangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphicTriangle extends GraphicsShape{
    int xV1, yV1, xV2, yV2, xV3, yV3;
    public GraphicTriangle(int xc, int yc, Color color, int xV1, int yV1, int xV2, int yV2, int xV3, int yV3) {
        super(xc, yc, color);
        this.xV1 = xV1;
        this.yV1 = yV1;
        this.xV2 = xV2;
        this.yV2 = yV2;
        this.xV3 = xV3;
        this.yV3 = yV3;
    }
    
    public void paint (Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        g.setColor(color);
        int[] xs = {
            xV1*Constants.GRID_SCALE + xc,
            xV2*Constants.GRID_SCALE + xc,
            xV3*Constants.GRID_SCALE + xc
        };
        int[] ys = {
            -yV1*Constants.GRID_SCALE + yc,
            -yV2*Constants.GRID_SCALE + yc,
            -yV3*Constants.GRID_SCALE + yc
        };
        g.drawPolygon(xs, ys, 3);
    }
}
