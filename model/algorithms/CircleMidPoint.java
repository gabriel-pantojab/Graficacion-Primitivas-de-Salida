package model.algorithms;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Write a description of class CircleMidPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleMidPoint extends CircleAlgorithm
{
    public CircleMidPoint () {
        super("Middle Point");
    }
    
    public void simetria (int xc, int yc, int x, int y, ArrayList<Point> points) {
        points.add(new Point(xc-x, yc+y));//3
        points.add(new Point(xc+x, yc-y));//7
        points.add(new Point(xc-x, yc-y));//5
        points.add(new Point(xc+y, yc+x));//1
        points.add(new Point(xc-y, yc+x));//4
        points.add(new Point(xc+y, yc-x));//8
        points.add(new Point(xc-y, yc-x));//6
    }
    
    public ArrayList<Point> generatePoints (int xC, int yC, int radio) {
        ArrayList<Point> points = new ArrayList<Point>();
        int x,y,p;
        x = 0;
        y = radio;
        p = 1 - radio;
        points.add(new Point(x+xC, y+yC));
        pValues.add(p);
        simetria(xC, yC, x, y, points);
        while (x < y) {
            x = x + 1;
            if (p < 0) {
                p = p + 2*x + 1;
            }else {
                y = y - 1;
                p = p + 2 * (x - y) + 1;
            }
            points.add(new Point(x+xC, y+yC));
            pValues.add(p);
            simetria(xC, yC, x, y, points);
        }
        return points;
    }
}
