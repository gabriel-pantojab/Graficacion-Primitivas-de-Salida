package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class Ventana here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class App extends JFrame {
    private final int LY = Constants.LY;
    private final int LX = Constants.LX;
    
    private model.Shape shape;
    private model.algorithms.Algorithm algorithm;
    
    private Plane plane;
    private Header header;
    private ControlsAnimation crtAnimation;

    public App () {
        super("Algoritmos de la Recta");
        setLayout(new BorderLayout(10,10));
        
        shape = new model.LineShape();
        algorithm = shape.getAlgorithms().get(0);
        
        header = new Header(algorithm.getTitle(), shape);
        plane = new Plane();
        crtAnimation = new ControlsAnimation();
        
        add(header, BorderLayout.NORTH);
        add(plane, BorderLayout.CENTER);
        add(crtAnimation, BorderLayout.SOUTH);
        add(new Border(), BorderLayout.EAST);
        add(new OptionsAttributes(), BorderLayout.WEST);
        
        int w = (Constants.LX*Constants.GRID_SCALE+1) + 40+200 + 10+10 + (16);
        int h = (Constants.LY*Constants.GRID_SCALE+1) + 66 + (10+10) + 40 + 39;
        //1267x696
        setBounds(0, 0, w, h);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void runAlgorithm () {
        if (plane.getGraphicShape() instanceof GraphicLine) {
            model.algorithms.LineAlgorithm a = (model.algorithms.LineAlgorithm)algorithm;
            GraphicLine gL = (GraphicLine)plane.getGraphicShape();
            Point start = gL.startPoint();
            Point end = gL.endPoint();
            int xI = (int)start.getX();
            int yI = (int)start.getY();
            int xF = (int)end.getX();
            int yF = (int)end.getY();
            plane.setPoints(a.generatePoints(xI, yI, xF, yF));
        } else if (plane.getGraphicShape() instanceof GraphicCircle) {
            model.algorithms.CircleAlgorithm a = (model.algorithms.CircleAlgorithm)algorithm;
            GraphicCircle gC = (GraphicCircle)plane.getGraphicShape();
            Point center = gC.center();
            int xC = (int)center.getX();
            int yC = (int)center.getY();
            int radio = gC.radio();
            plane.setPoints(a.generatePoints(xC, yC, radio));
        } 
    }
    
    public void setShape (model.Shape shape) {
        this.shape = shape;
    }
    
    public void setAlgorithm (model.algorithms.Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public Plane getPlane () {
        return plane;
    }
    
    public Header getHeader () {
        return header;
    }
    
    public model.Shape getModelShape () {
        return shape;
    }
    
    public ControlsAnimation getCrtAnimation () {
        return crtAnimation;
    }
    
    public model.algorithms.Algorithm getAlgorithm () {
        return algorithm;
    }
    
    public static void main(String[] args) {
        new App();
    }
}
