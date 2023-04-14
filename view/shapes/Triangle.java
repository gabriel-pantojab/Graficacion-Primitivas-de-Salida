package view.shapes;
import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.TriangleBresenham;
import model.algorithms.TriangleAlgorithm;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangle extends Shape{
    private Point vertexA, vertexB, vertexC;
    public Triangle(Point vertexA, Point vertexB, Point vertexC, TriangleAlgorithm algorithm) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.algorithm = algorithm;
        ArrayList<Point> points = algorithm.generatePoints((int) vertexA.getX(), (int) vertexA.getY(), (int) vertexB.getX(),
        (int) vertexB.getY());
        generatePixels(points);
    }
    
    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this(vertexA, vertexB, vertexC, new TriangleBresenham());
    }
}
