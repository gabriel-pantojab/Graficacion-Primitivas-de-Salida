package controller;


/**
 * Write a description of class TriangleInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Point;
import java.awt.Color;
import view.GraphicSquare;
import view.GraphicTriangle;
import view.GraphicsShape;
import view.shapes.Shape;
import view.shapes.Triangle;

public class TriangleInput extends InputShape {
    private Point vertexA, vertexB, vertexC;
    
    public TriangleInput () {
        minCantPoints = 2;
    }
    
    public boolean complete () {
        return inputs.size() == 3;
    }
    
    public boolean readyDraw () {
        return inputs.size() >= 2;
    }
    
    public Shape getShape () {
        return new Triangle(vertexA, vertexB, vertexC);
    }
    
    public void setInputs () {
        if (complete()) {
            vertexA = inputs.get(0);
            vertexB = inputs.get(1);
            vertexC = inputs.get(2);
        }
    }
    
    public GraphicsShape getGraphicsShape () {
        if(complete()) {
            return new GraphicTriangle(0, 0, Color.RED, (int)vertexA.getX(),(int)vertexA.getY(),
                                        (int)vertexB.getX(), (int)vertexB.getY(),
                                        (int)vertexC.getX(), (int)vertexC.getY());
        }
        return null;
    }
}
