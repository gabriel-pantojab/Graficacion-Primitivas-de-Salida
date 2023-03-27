package view;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.ArrayList;


/**
 * Write a description of class Inputs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Input extends JPanel {
    public Input () {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
    
    public abstract ArrayList<JTextField> getInputs ();
}
