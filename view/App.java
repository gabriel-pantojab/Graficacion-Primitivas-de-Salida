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
    private model.Algorithm algorithm;
    
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
        add(new Border(), BorderLayout.WEST);
        
        setBounds(0, 0, 707, 696);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void setShape (model.Shape shape) {
        this.shape = shape;
        setTitle(shape.getTitle());
        header.getOpAlgorithm().setOptionsAlgorithms(header.optionsNameAlgorithms(shape.getAlgorithms()));
        header.setShape(shape);
    }
    
    public void setAlgorithm (model.Algorithm algorithm) {
        this.algorithm = algorithm;
        header.setTitleAlgorithm(algorithm.getTitle());
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
    
    public static void main(String[] args) {
        new App();
    }
}
