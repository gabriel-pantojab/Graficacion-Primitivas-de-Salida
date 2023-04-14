package view.shapes;
import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.SquareMidPoint;
import model.algorithms.SquareAlgorithm;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Shape{
    private Point topLeftVertex, bottomRightVertex;
    public Square(Point topLV, Point bottomRV, SquareAlgorithm algorithm) {
        topLeftVertex = topLV;
        bottomRV = bottomRV;
        this.algorithm = algorithm;
        ArrayList<Point> points = algorithm.generatePoints((int) topLeftVertex.getX(), (int) topLeftVertex.getY(), (int) bottomRightVertex.getX(),
        (int) bottomRightVertex.getY());
        generatePixels(points);
    }
    
    public Square(Point topLV, Point bottomRV) {
        this(topLV, bottomRV, new SquareMidPoint());
    }
}
