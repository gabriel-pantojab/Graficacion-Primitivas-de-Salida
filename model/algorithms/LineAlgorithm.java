package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class LineAlgorithm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class LineAlgorithm extends Algorithm
{
    public LineAlgorithm (String title) {
        super(title);
    }
    
    public abstract ArrayList<Punto> generatePoints (int xI, int yI, int xF, int yF);
}
