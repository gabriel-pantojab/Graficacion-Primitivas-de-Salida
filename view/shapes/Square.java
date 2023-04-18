package view.shapes;
import model.Punto;
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
    private Punto topLeftVertex, bottomRightVertex;
    public Square(Punto topLV, Punto bottomRV, SquareAlgorithm algorithm) {
        this.topLeftVertex = topLV;
        this.bottomRightVertex = bottomRV;
        this.algorithm = algorithm;
        pointsBorder = algorithm.generatePoints((int) topLeftVertex.getX(), (int) topLeftVertex.getY(), (int) bottomRightVertex.getX(),
        (int) bottomRightVertex.getY());
        generatePixels();
    }
    
    public Square(Punto topLV, Punto bottomRV) {
        this(topLV, bottomRV, new SquareMidPoint());
    }
    
    public void fill () {
        int x = (int)topLeftVertex.getX() + (int)(bottomRightVertex.getX() - topLeftVertex.getX()) / 2;
        int y = (int)topLeftVertex.getY() - (int)(topLeftVertex.getY() - bottomRightVertex.getY()) / 2;
        cuatro_vecinos(x, y);
    }
}
