package model;
import java.util.ArrayList;


/**
 * Write a description of class LineShape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineShape extends Shape
{
    private ArrayList<model.algorithms.LineAlgorithm> algorithms;
    public LineShape () {
        super("Algorithms of the Line");
        algorithms = new ArrayList<model.algorithms.LineAlgorithm>();
        algorithms.add(new model.algorithms.LineBasic());
        algorithms.add(new model.algorithms.LineBresenham());
        algorithms.add(new model.algorithms.LineMidPoint());
        //algorithms.add(new model.algorithms.DDA());
    }
    
    public ArrayList<? extends model.algorithms.Algorithm> getAlgorithms () {
        return algorithms;
    }
}
