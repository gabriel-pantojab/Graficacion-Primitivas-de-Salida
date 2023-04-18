package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class SquareMidPunto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareMidPoint extends SquareAlgorithm {
    public SquareMidPoint() {
        super("MidPunto Square");
    }
    public ArrayList<Punto> generatePoints (int xTL, int yTL, int xBR, int yBR) {
        int xTR, yTR, xBL, yBL;
        xTR = xBR;
        yTR = yTL;
        
        xBL = xTL;
        yBL = yBR;
        
        LineMidPoint alg = new LineMidPoint();
        ArrayList<Punto> lado1 = alg.generatePoints(xBL, yBL, xTL, yTL);
        ArrayList<Punto> lado2 = alg.generatePoints(xTL, yTL, xTR, yTR);
        ArrayList<Punto> lado3 = alg.generatePoints(xTR, yTR, xBR, yBR);
        ArrayList<Punto> lado4 = alg.generatePoints(xBR, yBR, xBL, yBL);
        
        ArrayList<Punto> points = new ArrayList<Punto>();
        points.addAll(lado1);
        points.addAll(lado2);
        points.addAll(lado3);
        points.addAll(lado4);
        return points;
    }
}
