package controller;

import java.util.ArrayList;

import view.GraphicsShape;
import view.shapes.Shape;

import java.awt.Point;

/**
 * Write a description of interface InputShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class InputShape {
    protected ArrayList<Point> inputs;
    protected GraphicsShape graphic;
    protected Shape shape;
    public InputShape () {
        inputs = new ArrayList<Point>();
    }
    
    public abstract Shape getShape ();
    
    public abstract void setInputs ();
    
    public abstract GraphicsShape getGraphicsShape ();
    
    public abstract boolean complete ();
    
    public abstract boolean readyDraw ();
    
    public void popInput () {
        int i = inputs.size();
        inputs.remove(i-1);
    }
    
    public Point firtsInput () {
        return inputs.get(0);
    }
    
    public int size() {
        return inputs.size();
    }
    
    public void clearInputs () {
        inputs = new ArrayList<Point>();
    }

    public void addInput(Point point) {
        if(!complete()) inputs.add(point);
    }
}
