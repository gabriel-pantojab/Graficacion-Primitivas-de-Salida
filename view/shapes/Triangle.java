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
        pointsBorder = algorithm.generatePoints((int) vertexA.getX(), (int) vertexA.getY(), (int) vertexB.getX(),
        (int) vertexB.getY(), (int) vertexC.getX(),
        (int) vertexC.getY());
        generatePixels();
    }
    
    public Triangle(Point vertexA, Point vertexB, Point vertexC) {
        this(vertexA, vertexB, vertexC, new TriangleBresenham());
    }
    
    public void fill () {
        int x = (int)vertexB.getX();
        int y = (int)vertexB.getY() - (int)(vertexB.getY() - vertexA.getY()) / 2;
        cuatro_vecinos(x, y);
    }
}
