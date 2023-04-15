package controller;
import java.awt.Point;
import java.awt.Color;
import view.GraphicSquare;
import view.GraphicLine;
import view.GraphicsShape;
import view.shapes.Shape;
import view.shapes.Square;


/**
 * Write a description of class SquareInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareInput extends InputShape {
    private Point topLeftVertex, bottomRightVertex;
    
    public void setInputs () {
        if(complete()) {
            topLeftVertex = inputs.get(0);
            bottomRightVertex = inputs.get(1);
        }
    }
    
    public boolean complete () {
        return inputs.size() == 2;
    }
    
    public boolean readyDraw () {
        return inputs.size() >= 1;
    }
    
    public Shape getShape () {
        if(topLeftVertex != null && bottomRightVertex != null) return new Square(topLeftVertex, bottomRightVertex);
        return null;
    }
    
    public GraphicsShape getGraphicsShape () {
        if(complete()) {
            int width = (int)bottomRightVertex.getX() - (int)topLeftVertex.getX();
            int height = (int)topLeftVertex.getY() - (int)bottomRightVertex.getY();
            return new GraphicSquare(0, 0, Color.RED, (int)topLeftVertex.getX(), (int)topLeftVertex.getY(), width, height);
            //return new GraphicLine(0, 0, Color.RED, (int)topLeftVertex.getX(), (int)topLeftVertex.getY(), (int)bottomRightVertex.getX(), (int)bottomRightVertex.getY());
        }
        return null;
    }
}
