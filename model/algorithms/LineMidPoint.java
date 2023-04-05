package model.algorithms;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Write a description of class LineMidPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineMidPoint extends LineAlgorithm
{
    public LineMidPoint () {
        super("Middle Point");
    }
    
    public ArrayList<Point> generatePoints(int xI, int yI, int xF, int yF) {
        ArrayList<Point> points = new ArrayList<Point>();
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

        points.add(new Point(x, y));
        pValues.add(p);
        if (dx > dy) {
            while (x != xF) {
                x = x + 2;
                if (p <= 0) {
                    p = p + incInf;
                } else {
                    p = p + incSup;
                    y = y + 1;
                }
                points.add(new Point(x, y));
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
                points.add(new Point(x, y));
                pValues.add(p);
            }
        }
        return points;
    }
}
