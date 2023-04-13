package view.shapes;

import java.awt.Point;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import model.algorithms.Algorithm;
import view.Constants;
import view.Pixel;


public abstract class Shape extends JComponent {
    protected ArrayList<Pixel> pixels;
    protected Algorithm algorithm;

    public Shape() {
        pixels = new ArrayList<Pixel>();
    }
    
    public ArrayList<Pixel> getPixels() {
        return pixels;
    }
    
    protected void generatePixels(ArrayList<Point> points) {
        points.forEach((point)->{
            int x = (int) point.getX();
            int y = (int) point.getY();
            int mX = Constants.LX / 2;
            int mY = Constants.LY / 2;
            Pixel pixel = new Pixel(x+mX, -y+mY, Constants.GRID_SCALE);
            pixel.setParentShape(Shape.this);
            pixels.add(pixel);
        });
    }
  
    public void select () {
        pixels.forEach((pixel)->pixel.select());    
    }
}
