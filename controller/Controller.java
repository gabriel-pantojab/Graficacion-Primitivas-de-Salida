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
    private ButtonListener buttonsL;
    private PlaneListener planeL;
    public Controller (view.App app) {
        this.app = app;
        header = app.getHeader();
        ArrayList<JTextField> inputs = this.app.getHeader().getInput().getInputs();
        inputL = new InputListener(inputs, this.app);
        buttonsL = new ButtonListener(this.app);
        planeL = new PlaneListener(this.app.getPlane());
        optionShapeL = new OptionShape(this.app.getHeader().getOpAlgorithm().getOptionsShape(), new model.ShapeMap()){
            @Override
            public void action (model.Shape shape) {
                updateShape(shape);
                updateAlgorithm(app.getModelShape().getAlgorithms().get(0));
            }
        };
        
        optionAlgorithmL = new OptionAlgorithm(this.app.getHeader().getOpAlgorithm().getOptionsAlgorithm(), new model.AlgorithmMap(app.getModelShape())){
            @Override
            public void action (model.algorithms.Algorithm alg) {
                updateAlgorithm(alg);
            }
        };
    }
    
    public void updateShape (model.Shape shape) {
        app.setShape(shape);
        app.setTitle(app.getModelShape().getTitle());
        header.getOpAlgorithm().setOptionsAlgorithms(header.optionsNameAlgorithms(app.getModelShape().getAlgorithms()));
        header.setShape(app.getModelShape());
        ArrayList<JTextField> inputs = this.app.getHeader().getInput().getInputs();
        inputL.setInputs(inputs);
        optionAlgorithmL.setAlgorithmMap(new model.AlgorithmMap(app.getModelShape()));
        app.getPlane().setGraphic(null);
        app.getPlane().clearPoints();
    }
    
    public void updateAlgorithm (model.algorithms.Algorithm alg) {
        app.setAlgorithm(alg);
        header.setTitleAlgorithm(app.getAlgorithm().getTitle());
        app.getPlane().clearPoints();
        if (!inputL.emptyInputs()) app.runAlgorithm();
    }
}
