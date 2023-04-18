package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class LineBasic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineBasic extends LineAlgorithm
{
    public LineBasic () {
        super("Basic Algorithm");
    }
    
    public ArrayList<Punto> generatePoints(int xI, int yI, int xF, int yF) {
        ArrayList<Punto> points = new ArrayList<Punto>();
        double dy, dx;
        int x, y;
        dy = yF - yI;
        dx = xF - xI;
        x = xI; y = yI;
        points.add(new Punto(x, y));
        pValues.add(0);
        if (dx > dy) { 
            while (x < xF) {
                x = x + 1;
                y = (int)(dy/dx * (x - xI) + yI);
                points.add(new Punto(x, y));
                pValues.add(0);
            }
        } else {
            while (y < yF) {
                y = y + 1;
                x = (int)(dx/dy * (y - yI) + xI);
                points.add(new Punto(x, y));
                pValues.add(0);
            }
        }
        return points;
    }
}
