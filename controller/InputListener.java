package controller;
import java.awt.Color;
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
    private view.App app;
    public InputListener (ArrayList<JTextField> inputs, view.App app) {
        this.app = app;
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
        actionInputs();
    }
    
    public boolean emptyInputs () {
        boolean campos_vacios = false;
        for (JTextField i : inputs) {
            if (i.getText().equals("")) campos_vacios = true;
        }
        return campos_vacios;
    }
    
    private void actionInputs () {
        if (!emptyInputs()) {
            view.Plane p = app.getPlane();
            if (app.getModelShape() instanceof model.LineShape) {
                int xI = Integer.parseInt(inputs.get(0).getText());
                int yI = Integer.parseInt(inputs.get(1).getText());
                int xF = Integer.parseInt(inputs.get(2).getText());
                int yF = Integer.parseInt(inputs.get(3).getText());

                p.setGraphic(new view.GraphicLine(p.getWidth() / 2, p.getHeight()/2, Color.RED, xI, yI, xF, yF));
            } else if (app.getModelShape() instanceof model.CircleShape) {
                int xC = Integer.parseInt(inputs.get(0).getText());
                int yC = Integer.parseInt(inputs.get(1).getText());
                int radio = Integer.parseInt(inputs.get(2).getText());
                
                p.setGraphic(new view.GraphicCircle(p.getWidth() / 2, p.getHeight()/2, Color.RED, xC, yC, radio));
            }
            app.runAlgorithm();
            p.repaint();
        }
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        actionInputs();
    }
}
