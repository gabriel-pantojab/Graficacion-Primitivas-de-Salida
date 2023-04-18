package controller;
import java.awt.event.*;
import java.awt.*;
import view.GraphicsShape;
import model.Punto;

/**
 * Write a description of class PlaneListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaneListener extends MouseAdapter {
    private view.Plane plane;
    private view.App app;
    private InputShape inputShape;
    public PlaneListener (view.App app, view.Plane plane) {
        this.app = app;
        this.plane = plane;
        this.plane.addMouseListener(this);
        this.plane.addMouseMotionListener(this);
    }
    
    public void mouseMoved(MouseEvent e) {
        int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;
        int x = e.getX()/view.Constants.GRID_SCALE-view.Constants.LX/2;
        int y = -(e.getY()/view.Constants.GRID_SCALE-view.Constants.LY/2);
        
        if (inputShape != null && inputShape.readyDraw()) {
            view.Pixel topPixel = plane.peekPixelOrigen();
            if (plane.sizePixelesOrigen() > inputShape.minCantPoints() &&
                (topPixel.getX() != x || topPixel.getY() != y)) {
                plane.popPixelOrigen();
            }
            plane.pushPixelOrigen(x, y);
            if(inputShape.size() > inputShape.minCantPoints()) inputShape.popInput();
            inputShape.addInput(new Punto(x, y));
            inputShape.setInputs();
            updateGraphicShape();
            plane.repaint();
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;
        int x = (e.getX()/view.Constants.GRID_SCALE) - (view.Constants.LX/2);
        int y = -(e.getY()/view.Constants.GRID_SCALE-view.Constants.LY/2);
        System.out.println(x+" "+y);
        if (app.getPlane().getCurrentShape() != null) {
            app.getPlane().getCurrentShape().unselect();
            app.getPlane().setCurrentShape(null); 
        }
        
        if(inputShape == null) {
            plane.setCursor(new Cursor(Cursor.HAND_CURSOR));
            if (app.getModelShape() instanceof model.LineShape) {
                inputShape = new LineInput();
            } else if (app.getModelShape() instanceof model.CircleShape) {
                inputShape = new CircleInput();
            } else if (app.getModelShape() instanceof model.SquareShape) {
                inputShape = new SquareInput();
            } else if (app.getModelShape() instanceof model.TriangleShape) {
                inputShape = new TriangleInput();
            }
        }
        
        Punto p = new Punto(x, y);
        inputShape.addInput(p);
        plane.pushPixelOrigen((int)p.getX(), (int)p.getY());
        
        if (inputShape.complete()) {
            inputShape.setInputs();
            updateGraphicShape();
            updateUIShape();
            plane.clearPixelesOrigen();
            inputShape.clearInputs();
            app.runAlgorithm();
            plane.repaint();
            inputShape = null;
            plane.setGraphic(null);
            plane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    
    private void updateUIShape () {
        plane.add(inputShape.getShape());
        plane.updateUI();
    }
    
    private void updateGraphicShape () {
        int xc = plane.getWidth() / 2;
        int yc = plane.getHeight() / 2;
        
        GraphicsShape g = inputShape.getGraphicsShape();
        if (g!=null) {
            g.setCenter(xc, yc);
            plane.setGraphic(g);
        }
    }
}
