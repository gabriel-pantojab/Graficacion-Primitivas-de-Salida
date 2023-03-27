package view;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.ArrayList;


/**
 * Write a description of class CircleInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CircleInput extends Input {
    private JTextField xC, yC, radio;
    private JLabel labelXC, labelYC, labelRadio;
    
    public CircleInput () {
        labelXC = new JLabel("xC");
        xC = new JTextField(2);
        
        labelYC = new JLabel("yC");
        yC = new JTextField(2);
        
        labelRadio = new JLabel("radio");
        radio = new JTextField(4);
        
        add(labelXC);
        add(xC);
        
        add(labelYC);
        add(yC);
        
        add(labelRadio);
        add(radio);
    }
    
    public ArrayList<JTextField> getInputs () {
        ArrayList<JTextField> inputs = new ArrayList<JTextField>();
        inputs.add(xC);
        inputs.add(yC);
        inputs.add(radio);
        
        return inputs;
    }
}
