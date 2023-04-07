package controller;
import java.awt.Point;


/**
 * Write a description of class CircleInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CircleInput extends InputShape {
    private Point center;
    private int radio;
    public boolean complete () {
        return inputs.size() == 2;
    }
}
