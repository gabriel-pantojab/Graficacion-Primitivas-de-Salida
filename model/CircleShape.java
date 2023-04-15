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
    private ArrayList<model.algorithms.CircleAlgorithm> algorithms;
    public CircleShape () {
        super("Algorithms of the Circle");
        algorithms = new ArrayList<model.algorithms.CircleAlgorithm>();
        //algorithms.add(new model.algorithms.CircleBasic());
        //algorithms.add(new model.algorithms.CircleBresenham());
        algorithms.add(new model.algorithms.CircleMidPoint());
    }
    
    public ArrayList<? extends model.algorithms.Algorithm> getAlgorithms () {
        return algorithms;
    }
}
