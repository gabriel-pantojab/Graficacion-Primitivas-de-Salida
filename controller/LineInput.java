package controller;
import java.awt.Point;
import java.awt.Color;
import view.GraphicLine;
import view.GraphicsShape;
import view.shapes.Shape;
import view.shapes.Line;

/**
 * Write a description of class LineInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LineInput extends InputShape {
    private Point start, end;
    
    public void setInputs () {
        if(complete()) {
            start = inputs.get(0);
            end = inputs.get(1);
        }
    }
    
    public boolean complete () {
        return inputs.size() == 2;
    }
    
    public boolean readyDraw () {
        return inputs.size() >= 1;
    }
    
    public Shape getShape () {
        if(start != null && end != null) return new Line(start, end);
        return null;
    }
    
    public GraphicsShape getGraphicsShape () {
        if(complete()) return new GraphicLine(0, 0, Color.RED, (int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
        return null;
    }
}
