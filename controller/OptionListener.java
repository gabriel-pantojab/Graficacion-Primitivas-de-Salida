package controller;
import java.awt.event.*;
import javax.swing.JComboBox;


/**
 * Write a description of class OptionListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionListener implements ItemListener {
    private JComboBox options;
    
    public OptionListener (JComboBox combo) {
        options = combo;
        options.addItemListener(this);
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
    }
}