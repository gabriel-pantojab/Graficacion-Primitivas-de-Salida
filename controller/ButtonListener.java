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
    private JButton delete, clear;
    public ButtonListener (view.App app) {
        this.app = app;
        clear = this.app.getCrtAnimation().clear();
        delete = this.app.getCrtAnimation().delete();
        
        delete.addActionListener(this);
        clear.addActionListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        Object s = e.getSource();
        if (s.equals(delete)) {
            app.getPlane().removeCurrentShape();
            app.getPlane().updateUI();
        } else if (s.equals(clear)) {
            app.getPlane().removeAll();
            app.getPlane().updateUI();
        }
    }
}
