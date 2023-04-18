package view.shapes;

import model.Punto;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import model.algorithms.Algorithm;
import view.Constants;
import view.Pixel;


public abstract class Shape extends JComponent {
    protected ArrayList<Pixel> pixelsBorder, pixelsFill;
    protected ArrayList<Punto> pointsBorder, pointsFill;
    protected Algorithm algorithm;

    public Shape() {
        pointsBorder = new ArrayList<Punto>();
        pointsFill = new ArrayList<Punto>();
        pixelsBorder = new ArrayList<Pixel>();
        pixelsFill = new ArrayList<Pixel>();
    }
    
    public ArrayList<Pixel> getPixelsBorder() {
        return pixelsBorder;
    }
    
    public ArrayList<Pixel> getPixelsFill() {
        return pixelsFill;
    }
    
    public abstract void fill ();
    
    protected void cuatro_vecinos(int x, int y) {
        Punto p = new Punto(x, y);
        if (!pointsBorder.contains(p) && !pointsFill.contains(p)) {
            pointsFill.add(p);
            int mX = Constants.LX / 2;
            int mY = Constants.LY / 2;
            Pixel pixel = new Pixel(x+mX, -y+mY, Constants.GRID_SCALE);
            pixelsFill.add(pixel);
            pixel.setParentShape(Shape.this);
            
            cuatro_vecinos(x, y+1);
            cuatro_vecinos(x+1, y);
            cuatro_vecinos(x, y-1);
            cuatro_vecinos(x-1, y);
        }
    }
    
    protected void generatePixels() {
        pointsBorder.forEach((point)->{
            int x = (int) point.getX();
            int y = (int) point.getY();
            int mX = Constants.LX / 2;
            int mY = Constants.LY / 2;
            Pixel pixel = new Pixel(x+mX, -y+mY, Constants.GRID_SCALE);
            pixel.setParentShape(Shape.this);
            pixelsBorder.add(pixel);
        });
    }
  
    public void select () {
        pixelsBorder.forEach((pixel)->pixel.select());    
    }
    
    public void unselect () {
        pixelsBorder.forEach((pixel)->pixel.unselect());
    }
}
