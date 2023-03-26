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
    protected ArrayList<Double> pValues;
    
    public abstract ArrayList<Point> generatePoints (int xI, int yI, int xF, int yF);
}
