package model.algorithms;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Write a description of class CircleAlgorithm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CircleAlgorithm extends Algorithm
{
    public CircleAlgorithm (String title) {
        super(title);
    }
    
    public abstract ArrayList<Point> generatePoints (int xC, int yC, int radio);
}
