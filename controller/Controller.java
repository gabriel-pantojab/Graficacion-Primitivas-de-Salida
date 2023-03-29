package controller;
import java.util.ArrayList;
import javax.swing.JTextField;


/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller {
    private view.App app;
    private InputListener inputL;
    private OptionListener optionShapeL, optionAlgorithmL;
    public Controller (view.App app) {
        this.app = app;
        ArrayList<JTextField> inputs = this.app.getHeader().getInput().getInputs();
        inputL = new InputListener(inputs);
        optionShapeL = new OptionListener(this.app.getHeader().getOpAlgorithm().getOptionsShape());
    }
}
