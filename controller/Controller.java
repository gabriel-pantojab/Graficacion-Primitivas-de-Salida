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
    private view.Header header;
    private InputListener inputL;
    private OptionShape optionShapeL;
    private OptionAlgorithm optionAlgorithmL;
    public Controller (view.App app) {
        this.app = app;
        header = app.getHeader();
        ArrayList<JTextField> inputs = this.app.getHeader().getInput().getInputs();
        inputL = new InputListener(inputs);
        optionShapeL = new OptionShape(this.app.getHeader().getOpAlgorithm().getOptionsShape(), new model.ShapeMap()){
            @Override
            public void action (model.Shape shape) {
                Controller.this.app.setShape(shape);
                updateShape();
            }
        };
        
        optionAlgorithmL = new OptionAlgorithm(this.app.getHeader().getOpAlgorithm().getOptionsAlgorithm(), new model.AlgorithmMap(app.getModelShape())){
            @Override
            public void action (model.Algorithm alg) {
                Controller.this.app.setAlgorithm(alg);
                updateAlgorithm();
            }
        };
    }
    
    public void updateShape () {
        app.setTitle(app.getModelShape().getTitle());
        header.getOpAlgorithm().setOptionsAlgorithms(header.optionsNameAlgorithms(app.getModelShape().getAlgorithms()));
        header.setShape(app.getModelShape());
        ArrayList<JTextField> inputs = this.app.getHeader().getInput().getInputs();
        inputL.setInputs(inputs);
    }
    
    public void updateAlgorithm () {
        header.setTitleAlgorithm(app.getAlgorithm().getTitle());
    }
}
