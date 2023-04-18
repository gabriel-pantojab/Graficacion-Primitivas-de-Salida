package view.shapes;

import model.Punto;
import java.util.ArrayList;

import model.algorithms.CircleAlgorithm;
import model.algorithms.CircleMidPunto;

public class Circle extends Shape {
    private Punto center;
    public Circle(Punto center, int radio, CircleAlgorithm algorithm) {
        this.center = center;
        this.algorithm = algorithm;
        pointsBorder = algorithm.generatePoints((int) center.getX(), (int) center.getY(), radio);
        generatePixels();
    }
    
    public Circle(Punto center, int radio) {  
        this(center, radio, new CircleMidPunto());
    }
    
    public void fill () {
        cuatro_vecinos((int)center.getX(), (int)center.getY());
    }
}
