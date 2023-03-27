package controller;
import java.awt.event.*;
import javax.swing.JComboBox;


/**
 * Write a description of class OptionListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionListener implements ActionListener {
    private JComboBox options;
    
    public OptionListener (JComboBox combo) {
        options = combo;
        options.addActionListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {}
}