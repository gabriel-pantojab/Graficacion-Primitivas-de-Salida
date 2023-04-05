package controller;
import java.awt.event.*;
import java.awt.*;


/**
 * Write a description of class PlaneListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaneListener extends MouseAdapter {
    private view.Plane plane;
    private view.App app;
    private Point start, end;
    private boolean pS;
    public PlaneListener (view.App app, view.Plane plane) {
        this.app = app;
        this.plane = plane;
        pS = true;
        this.plane.addMouseListener(this);
        this.plane.addMouseMotionListener(this);
    }
    
    public void mouseMoved(MouseEvent e) {
        /*int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;*/
        int xc = (view.Constants.GRID_SCALE*view.Constants.LX) / 2;
        int yc = (view.Constants.GRID_SCALE*view.Constants.LY) / 2;
        int x = e.getX()/view.Constants.GRID_SCALE-view.Constants.LX/2;
        int y = -(e.getY()/view.Constants.GRID_SCALE-view.Constants.LY/2);
        if (start != null) {
            view.Pixel topPixel = plane.peekPixelOrigen();
            end = new Point(x, y);
            if (plane.sizePixelesOrigen() > 1 &&
                (topPixel.getX() != x || topPixel.getY() != y)) {
                plane.popPixelOrigen();
                plane.pushPixelOrigen(x, y);
            } else  plane.pushPixelOrigen(x, y);
            if (app.getModelShape() instanceof model.LineShape) {
                int xI = (int)start.getX();
                int yI = (int)start.getY();
                int xF = (int)end.getX();
                int yF = (int)end.getY();
                plane.setGraphic(new view.GraphicLine(xc, yc, Color.RED, xI, yI, xF, yF));
            } else if (app.getModelShape() instanceof model.CircleShape) {
                int xC = (int)start.getX();
                int yC = (int)start.getY();
                int radio = (int)start.distance(end);
                plane.setGraphic(new view.GraphicCircle(xc, yc, Color.RED, xC, yC, radio));
            }
            plane.repaint();
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        /*int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;*/
        int xc = (view.Constants.GRID_SCALE*view.Constants.LX) / 2;
        int yc = (view.Constants.GRID_SCALE*view.Constants.LY) / 2;
        int x = e.getX()/view.Constants.GRID_SCALE-view.Constants.LX/2;
        int y = -(e.getY()/view.Constants.GRID_SCALE-view.Constants.LY/2);
        System.out.println(x+" "+y);
        if (pS) {
            start = new Point(x, y);
            plane.pushPixelOrigen(x, y);
            plane.setCursor(new Cursor(Cursor.HAND_CURSOR));
            pS = false;
        }else {
            end = new Point(x, y);
            plane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            pS = true;
        }
        if (start != null && end != null) { 
            if (app.getModelShape() instanceof model.LineShape) {
                int xI = (int)start.getX();
                int yI = (int)start.getY();
                int xF = (int)end.getX();
                int yF = (int)end.getY();
                plane.setGraphic(new view.GraphicLine(xc, yc, Color.RED, xI, yI, xF, yF));
            } else if (app.getModelShape() instanceof model.CircleShape) {
                int xC = (int)start.getX();
                int yC = (int)start.getY();
                int radio = (int)start.distance(end);
                plane.setGraphic(new view.GraphicCircle(xc, yc, Color.RED, xC, yC, radio));
            }
            start = end = null;
            plane.clearPixelesOrigen();
            app.runAlgorithm();
            plane.repaint();
        }
    }
}
