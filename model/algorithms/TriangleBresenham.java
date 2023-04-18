package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class TriangleBresenham here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TriangleBresenham extends TriangleAlgorithm {
    public TriangleBresenham() {
        super("Triangle Bresenham");
    }
    
    public ArrayList<Punto> generatePoints (int xV1, int yV1, int xV2, int yV2, int xV3, int yV3){
        ArrayList<Punto> points = new ArrayList<Punto>();
        LineBresenham alg = new LineBresenham();
        ArrayList<Punto> lado1, lado2, lado3;
        lado1 = alg.generatePoints(xV1, yV1, xV2, yV2);
        lado2 = alg.generatePoints(xV2, yV2, xV3, yV3);
        lado3 = alg.generatePoints(xV3, yV3, xV1, yV1);
        points.addAll(lado1);
        points.addAll(lado2);
        points.addAll(lado3);
        return points;
    }
}
