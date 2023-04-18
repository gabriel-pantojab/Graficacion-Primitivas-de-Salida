package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class CircleMidPunto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleMidPoint extends CircleAlgorithm
{
    public CircleMidPoint () {
        super("Middle Punto");
    }
    
    public void simetria (int xc, int yc, int x, int y, ArrayList<Punto> points) {
        points.add(new Punto(xc-x, yc+y));//3
        points.add(new Punto(xc+x, yc-y));//7
        points.add(new Punto(xc-x, yc-y));//5
        points.add(new Punto(xc+y, yc+x));//1
        points.add(new Punto(xc-y, yc+x));//4
        points.add(new Punto(xc+y, yc-x));//8
        points.add(new Punto(xc-y, yc-x));//6
    }
    
    public ArrayList<Punto> generatePoints (int xC, int yC, int radio) {
        ArrayList<Punto> points = new ArrayList<Punto>();
        int x,y,p;
        x = 0;
        y = radio;
        p = 1 - radio;
        points.add(new Punto(x+xC, y+yC));
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
            points.add(new Punto(x+xC, y+yC));
            pValues.add(p);
            simetria(xC, yC, x, y, points);
        }
        return points;
    }
}
