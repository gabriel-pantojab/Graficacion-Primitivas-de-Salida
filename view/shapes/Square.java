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
        this.topLeftVertex = topLV;
        this.bottomRightVertex = bottomRV;
        this.algorithm = algorithm;
        pointsBorder = algorithm.generatePoints((int) topLeftVertex.getX(), (int) topLeftVertex.getY(), (int) bottomRightVertex.getX(),
        (int) bottomRightVertex.getY());
        generatePixels();
    }
    
    public Square(Point topLV, Point bottomRV) {
        this(topLV, bottomRV, new SquareMidPoint());
    }
    
    public void fill () {
        int x = (int)topLeftVertex.getX() + (int)(bottomRightVertex.getX() - topLeftVertex.getX()) / 2;
        int y = (int)topLeftVertex.getY() - (int)(topLeftVertex.getY() - bottomRightVertex.getY()) / 2;
        cuatro_vecinos(x, y);
    }
}
