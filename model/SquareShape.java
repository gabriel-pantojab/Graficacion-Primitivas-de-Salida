package model;
import java.util.ArrayList;


/**
 * Write a description of class SquareShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareShape extends Shape {
    private ArrayList<model.algorithms.SquareAlgorithm> algorithms;
    public SquareShape() {
        super("Algorithms of the Square");
        algorithms = new ArrayList<model.algorithms.SquareAlgorithm>();
        algorithms.add(new model.algorithms.SquareMidPoint());
    }
    public ArrayList<? extends model.algorithms.Algorithm> getAlgorithms () {
        return algorithms;
    }
}
