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
    private ArrayList<LineAlgorithm> algorithms;
    public LineShape () {
        super("Algorithms of the Line");
        algorithms = new ArrayList<LineAlgorithm>();
        algorithms.add(new LineBasic());
        algorithms.add(new LineBresenham());
        algorithms.add(new LineMidPoint());
    }
    
    public ArrayList<? extends Algorithm> getAlgorithms () {
        return algorithms;
    }
}
