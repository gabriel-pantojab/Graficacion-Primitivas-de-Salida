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
    private JButton next, back, run;
    public ControlsAnimation () {
        setPreferredSize(new Dimension(0, 40));
        
        next = new JButton("n");
        back = new JButton("b");
        run = new JButton("r");
        
        add(back);
        add(next);
        add(run);
    }
}
