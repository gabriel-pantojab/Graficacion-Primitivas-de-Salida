package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class TriangleAlgorithm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class TriangleAlgorithm extends Algorithm {
    public TriangleAlgorithm(String title) {
        super(title);
    }
    
    public abstract ArrayList<Punto> generatePoints (int xV1, int yV1, int xV2, int yV2, int xV3, int yV3);
}
