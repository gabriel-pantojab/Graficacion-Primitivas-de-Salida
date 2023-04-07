package controller;
import java.awt.Point;


/**
 * Write a description of class TriangleInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TriangleInput implements InputShape {
    private Point vertexA, vertexB, vertexC;
    public boolean complete () {
        return true;
    }
}
