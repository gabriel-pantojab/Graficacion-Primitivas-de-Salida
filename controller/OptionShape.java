package controller;
import java.awt.event.*;
import javax.swing.JComboBox;


/**
 * Write a description of class OptionListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionShape implements ItemListener {
    private JComboBox options;
    private model.ShapeMap optMap;
    public OptionShape (JComboBox combo, model.ShapeMap optMap) {
        options = combo;
        this.optMap = optMap;
        options.addItemListener(this);
    }
    
    public void action (model.Shape shape) {
        
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
        String o = (String)itemEvent.getItem();
        action((model.Shape)optMap.get(o));
    }
}