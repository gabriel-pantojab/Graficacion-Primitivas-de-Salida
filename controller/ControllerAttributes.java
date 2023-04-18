package controller;
import java.awt.event.*;
import javax.swing.*;


/**
 * Write a description of class ControllerAttributes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControllerAttributes implements ActionListener, ItemListener { 
    private view.Plane plane;
    private view.OptionsAttributes opsAttrib;
    private JCheckBox fill;
    public ControllerAttributes (view.Plane plane, view.OptionsAttributes ops) {
        this.plane = plane;
        opsAttrib = ops;
        fill = ops.getFillCheck();
        
        fill.addItemListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
        Object src = itemEvent.getSource();
        
        if (src.equals(fill)) {
            System.out.println(itemEvent.getStateChange());
        }
    }
}
