package model.algorithms;
import java.util.ArrayList;
import model.Punto;


/**
 * Write a description of class SquareAlgorithm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class SquareAlgorithm extends Algorithm {
    public SquareAlgorithm(String title) {
        super(title);
    }
    
    public abstract ArrayList<Punto> generatePoints (int xTL, int yTL, int xBR, int yBR);
}
