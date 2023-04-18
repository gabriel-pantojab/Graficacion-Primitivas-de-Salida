package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class LineMidPunto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineMidPoint extends LineAlgorithm {
    public LineMidPoint () {
        super("Middle Punto");
    }
    
    public ArrayList<Punto> generatePoints(int xI, int yI, int xF, int yF) {
        if(xI > xF) {
            int temp = xF;
            xF = xI;
            xI = temp;
        }
        if(yI > yF) {
            int temp = yF;
            yF = yI;
            yI = temp;
        }
        ArrayList<Punto> points = new ArrayList<Punto>();
        int dx, dy, p, incInf, incSup;
        dx = xF - xI;
        dy = yF - yI;
        p = dy - 2*dx;
        incSup = 2 * (dy - dx);
        int x = xI, y = yI;
        
        if (dx > dy) {
            incInf = 2 * dy;
            p = 2 * dy - dx;
        } else {
            incInf = -2 * dx;
            p = dy - 2 * dx;
        }

        points.add(new Punto(x, y));
        pValues.add(p);
        if (dx > dy) {
            while (x != xF) {
                x = x + 1;
                if (p <= 0) {
                    p = p + incInf;
                } else {
                    p = p + incSup;
                    y = y + 1;
                }
                points.add(new Punto(x, y));
                pValues.add(p);
            }
        } else {
            while (y != yF) {
                y = y + 1;
                if (p <= 0) {
                    p = p + incSup;
                    x = x + 1;
                } else {
                    p = p + incInf;
                }
                points.add(new Punto(x, y));
                pValues.add(p);
            }
        }
        return points;
    }
}
