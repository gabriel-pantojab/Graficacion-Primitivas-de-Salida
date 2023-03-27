package view;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.ArrayList;


/**
 * Write a description of class LineInput here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineInput extends Input {
    private JTextField xI, yI, xF, yF;
    private JLabel labelXI, labelYI, labelXF, labelYF;
    
    public LineInput () {
        labelXI = new JLabel("xI");
        labelYI = new JLabel("yI");
        labelXF = new JLabel("xF");
        labelYF = new JLabel("yF");
        xI = new JTextField(2);
        yI = new JTextField(2);
        xF = new JTextField(2);
        yF = new JTextField(2);
        
        add(labelXI);
        add(xI);
        
        add(labelYI);
        add(yI);
        
        add(labelXF);
        add(xF);
        
        add(labelYF);
        add(yF);
    }
    
    public ArrayList<JTextField> getInputs () {
        ArrayList<JTextField> inputs = new ArrayList<JTextField>();
        inputs.add(xI);
        inputs.add(yI);
        inputs.add(xF);
        inputs.add(yF);
        return inputs;
    }
}
