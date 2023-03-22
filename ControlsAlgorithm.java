import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 * Write a description of class Controls here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControlsAlgorithm extends JPanel implements ActionListener{
    private JButton basic, bresenham, middle;
    private App app;
    public ControlsAlgorithm (App app) {
        this.app = app;
        basic = new JButton("Basic");
        bresenham = new JButton("Bresenham");
        middle = new JButton("MiddlePoint");
        
        basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bresenham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        middle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        basic.addActionListener(this);
        bresenham.addActionListener(this);
        middle.addActionListener(this);
        add(basic);
        add(bresenham);
        add(middle);
    }
    
    public void actionPerformed (ActionEvent e) {
        if (e.getSource().equals(basic)) {
            app.cambiarAlgoritmo(1);
        } else if (e.getSource().equals(bresenham)) {
            app.cambiarAlgoritmo(2);
        } else {
            app.cambiarAlgoritmo(3);
        }  
    }
}
