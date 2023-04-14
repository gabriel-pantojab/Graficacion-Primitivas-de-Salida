package view.shapes;

import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.CircleAlgorithm;
import model.algorithms.CircleMidPoint;

public class Circle extends Shape {
    private Point center;
    public Circle(Point center, int radio, CircleAlgorithm algorithm) {
        this.center = center;
        this.algorithm = algorithm;
        pointsBorder = algorithm.generatePoints((int) center.getX(), (int) center.getY(), radio);
        generatePixels();
    }
    
    public Circle(Point center, int radio) {  
        this(center, radio, new CircleMidPoint());
    }
    
    public void fill () {
        cuatro_vecinos((int)center.getX(), (int)center.getY());
    }
}
