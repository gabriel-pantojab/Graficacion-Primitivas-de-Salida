package controller;

import java.util.ArrayList;

import view.GraphicsShape;
import view.shapes.Shape;

import model.Punto;

/**
 * Write a description of interface InputShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class InputShape {
    protected ArrayList<Punto> inputs;
    protected GraphicsShape graphic;
    protected Shape shape;
    protected int minCantPoints;
    public InputShape () {
        minCantPoints = 1;
        inputs = new ArrayList<Punto>();
    }
    
    public abstract Shape getShape ();
    
    public abstract void setInputs ();
    
    public abstract GraphicsShape getGraphicsShape ();
    
    public abstract boolean complete ();
    
    public abstract boolean readyDraw ();
    
    public int minCantPoints () {
        return minCantPoints;
    }
    
    public void popInput () {
        int i = inputs.size();
        inputs.remove(i-1);
    }
    
    public Punto firtsInput () {
        return inputs.get(0);
    }
    
    public int size() {
        return inputs.size();
    }
    
    public void clearInputs () {
        inputs = new ArrayList<Punto>();
    }

    public void addInput(Punto point) {
        if(!complete()) inputs.add(point);
    }
}
