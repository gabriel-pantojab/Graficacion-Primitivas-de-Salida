package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class LineBresenham here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineBresenham extends LineAlgorithm
{
    public LineBresenham () {
        super("Bresenham");
    }
    
    public ArrayList<Punto> generatePoints(int xI, int yI, int xF, int yF) {
        ArrayList<Punto> points = new ArrayList<Punto>();
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (xF - xI);
        dy = (yF - yI);
        if (dy < 0) {
            dy = -dy; stepy = -1;
        }
        else
            stepy = 1;
        if (dx < 0) {
            dx = -dx; stepx = -1;
        }
        else
            stepx = 1;
        x = xI;
        y = yI;
        points.add(new Punto(x, y));
        
        if(dx>dy){
            p = 2*dy - dx;
            pValues.add(p);
            incE = 2*dy;
            incNE = 2*(dy-dx);
            while (x != xF){
                x = x + stepx;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    y = y + stepy;
                    p = p + incNE;
                }
                points.add(new Punto(x, y));
                pValues.add(p);
            }
        }
        else{
            p = 2*dx - dy;
            pValues.add(p);
            incE = 2*dx;
            incNE = 2*(dx-dy);
            while (y != yF){
                y = y + stepy;
                if (p < 0){
                    p = p + incE;
                }
                else {
                    x = x + stepx;
                    p = p + incNE;
                }
                points.add(new Punto(x, y));
                pValues.add(p);
            }
        }
        return points;
    }
}
