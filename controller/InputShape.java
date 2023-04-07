package controller;

import java.util.ArrayList;

import view.Input;

import java.awt.Point;

/**
 * Write a description of interface InputShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class InputShape {
    protected ArrayList<Point> inputs;

    public InputShape () {
        inputs = new ArrayList<Point>();
    }

    public void addInput(Point point) {
        inputs.add(point);
    }

    public abstract boolean complete ();
}
