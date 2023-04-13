package model.algorithms;
import java.util.ArrayList;
import java.awt.Point;


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
    
    public abstract ArrayList<Point> generatePoints (int xV1, int yV1, int xV2, int yV2);
}
