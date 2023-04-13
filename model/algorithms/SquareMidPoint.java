package model.algorithms;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Write a description of class SquareMidPoint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareMidPoint extends SquareAlgorithm {
    public SquareMidPoint() {
        super("MidPoint");
    }
    public ArrayList<Point> generatePoints (int xTL, int yTL, int xBR, int yBR) {
        int xTR, yTR, xBL, yBL;
        xTR = xBR;
        yTR = yTL;
        
        xBL = xTL;
        yBL = yBR;
        
        LineMidPoint alg = new LineMidPoint();
        ArrayList<Point> lado1 = alg.generatePoints(xBL, yBL, xTL, yTL);
        ArrayList<Point> lado2 = alg.generatePoints(xTL, yTL, xTR, yTR);
        ArrayList<Point> lado3 = alg.generatePoints(xTR, yTR, xBR, yBR);
        ArrayList<Point> lado4 = alg.generatePoints(xBR, yBR, xBL, yBL);
        
        ArrayList<Point> points = new ArrayList<Point>();
        points.addAll(lado1);
        points.addAll(lado2);
        points.addAll(lado3);
        points.addAll(lado4);
        return points;
    }
}
