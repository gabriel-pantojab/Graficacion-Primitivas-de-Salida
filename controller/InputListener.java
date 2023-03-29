package controller;
import java.awt.event.*;
import javax.swing.JTextField;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;


/**
 * Write a description of class InputListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputListener implements DocumentListener {
    private ArrayList<JTextField> inputs;
    
    public InputListener (ArrayList<JTextField> inputs) {
        this.inputs = inputs;
        addListener();
    }
    
    public void addListener () {
        inputs.forEach((in)->{
            in.getDocument().addDocumentListener(InputListener.this);
        });
    }
    
    public void setInputs (ArrayList<JTextField> inputs) {
        this.inputs = inputs;
        addListener();
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("changed input");
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        inputs.forEach((i)->System.out.println(i.getText()));
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove input");
    }
}
