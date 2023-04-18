package model.algorithms;
import java.util.ArrayList;
import model.Punto;


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
    
    public abstract ArrayList<Punto> generatePoints (int xC, int yC, int radio);
}
