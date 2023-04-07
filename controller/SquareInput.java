package controller;
import java.awt.Point;


/**
 * Write a description of class SquareInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareInput extends InputShape {
    private Point topLeft, bottomRight;
    public boolean complete () {
        return inputs.size() == 2;
    }
}
