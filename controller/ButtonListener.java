package controller;
import java.awt.event.*;
import javax.swing.JButton;


/**
 * Write a description of class ButtonListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonListener implements ActionListener {
    private view.App app;
    private JButton next, back, run;
    public ButtonListener (view.App app) {
        this.app = app;
        next = this.app.getCrtAnimation().next();
        back = this.app.getCrtAnimation().back();
        run = this.app.getCrtAnimation().run();
        
        next.addActionListener(this);
        back.addActionListener(this);
        run.addActionListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        Object s = e.getSource();
        if (s.equals(next)) {
            app.getPlane().pushPixel();
        } else if (s.equals(back)) {
            app.getPlane().removePixel();
        } else if (s.equals(run)) {
            app.getPlane().run();
        }
    }
}
