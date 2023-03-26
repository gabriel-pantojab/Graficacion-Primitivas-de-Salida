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
    private int xI, yI, xF, yF;
    private Algorithm algorithm;
    private Table tabla;
    private Plano plano;
    private Header header;
    public App (int xI, int yI, int xF, int yF) {
        super("Algoritmos de la Recta");
        setLayout(new BorderLayout());
        this.xI = xI;
        this.yI = yI;
        this.xF = xF;
        this.yF = yF;
        
        algorithm = new BasicAlgorithm();

        add(new ControlsAlgorithm(this), BorderLayout.SOUTH);
        
        ArrayList<Point> points = algorithm.generatePoints(xI, yI, xF, yF);
        plano = new Plano(xI, yI, xF, yF, points);
        tabla = new Table(this, "Datos " + algorithm.getTitle(), points, algorithm.getPValues());
        Controls controls = new Controls(plano, tabla);
        header = new Header(controls, algorithm.getTitle());
        add(header, BorderLayout.NORTH);
        add(plano, BorderLayout.CENTER);
        add(new Border(), BorderLayout.WEST);
        add(new Border(), BorderLayout.EAST);
        
        setBounds(0, 0, 707, 696);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void graficar () {
        ArrayList<Point> points = algorithm.generatePoints(xI, yI, xF, yF);
        plano.setPoints(points);
        tabla.setPoints(points);
        tabla.setPValues(algorithm.getPValues());
        tabla.clear();
    }
    
    public void cambiarAlgoritmo (int op) {
        switch (op) {
            case 1: algorithm = new BasicAlgorithm();
            break;
            case 2: algorithm = new Bresenham();
            break;
            case 3: algorithm = new MiddlePoint();
            break;
        }
        tabla.setTitleAlgorithm(algorithm.getTitle());
        header.setTitleAlgorithm(algorithm.getTitle());
        graficar();
        plano.updateUI();
    }
    
    public static void main(String[] args) {
        Algorithm mp = new MiddlePoint();
        Algorithm b = new BasicAlgorithm();
        Algorithm br = new Bresenham();
        new App(-3, -3, 8, 2);
    }
}
