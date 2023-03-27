package model;
import java.util.ArrayList;


/**
 * Write a description of class CircleShape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleShape extends Shape
{
    private ArrayList<CircleAlgorithm> algorithms;
    public CircleShape () {
        super("Algorithms of the Circle");
        algorithms = new ArrayList<CircleAlgorithm>();
        algorithms.add(new CircleBasic());
        algorithms.add(new CircleBresenham());
        algorithms.add(new CircleMidPoint());
    }
    
    public ArrayList<? extends Algorithm> getAlgorithms () {
        return algorithms;
    }
}
