package model;
import java.util.ArrayList;
import java.awt.Point;


/**
 * Write a description of class Algorithm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Algorithm
{
    protected ArrayList<Integer> pValues;
    protected String title;
    public Algorithm (String title) {
        pValues = new ArrayList<Integer>();
        this.title = title;
    }
    
    public ArrayList<Integer> getPValues () {
        return pValues;
    }
    
    public String getTitle () {
        return title;
    }
    
    public abstract ArrayList<Point> generatePoints (int xI, int yI, int xF, int yF);
}
