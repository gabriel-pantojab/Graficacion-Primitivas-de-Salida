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
        
        next = new JButton("\u27A1");
        back = new JButton("\u2B05");
        run = new JButton("\u25B6");
        
        add(back);
        add(next);
        add(run);
    }
    
    public JButton next () {
        return next;
    }
    
    public JButton back () {
        return back;
    }
    
    public JButton run () {
        return run;
    }
}
