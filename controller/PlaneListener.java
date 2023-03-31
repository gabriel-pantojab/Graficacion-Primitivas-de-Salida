package controller;
import java.awt.event.*;


/**
 * Write a description of class PlaneListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaneListener extends MouseAdapter {
    private view.Plane plane;
    public PlaneListener (view.Plane plane) {
        this.plane = plane;
        this.plane.addMouseListener(this);
    }
    
    public void mouseClicked(MouseEvent e) {
        int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;
        int x = e.getX()/view.Constants.GRID_SCALE-view.Constants.LX/2+1;
        int y = -(e.getY()/view.Constants.GRID_SCALE-view.Constants.LY/2+1);
        System.out.println(x+" "+y);
    }
}
