package view;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class ControlsAnimation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlsAnimation extends JPanel {
    private JButton clear, delete;
    public ControlsAnimation () {
        setPreferredSize(new Dimension(0, 40));
        
        delete = new JButton("Delete Current Shape");
        clear = new JButton("Clear");

        add(delete);
        add(clear);
    }
    
    public JButton clear () {
        return clear;
    }
    
    public JButton delete () {
        return delete;
    }
}
