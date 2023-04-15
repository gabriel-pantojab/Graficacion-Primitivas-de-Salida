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
    private view.Plane plane;
    
    private InputListener inputL;
    private OptionShape optionShapeL;
    private OptionAlgorithm optionAlgorithmL;
    private ButtonListener buttonsL;
    private PlaneListener planeL;
    public Controller (view.App app) {
        this.app = app;
        header = this.app.getHeader();
        plane = this.app.getPlane();
        ArrayList<JTextField> inputs = header.getInput().getInputs();
        inputL = new InputListener(inputs, this.app);
        buttonsL = new ButtonListener(this.app);
        planeL = new PlaneListener(this.app, plane);
        optionShapeL = new OptionShape(header.getOpAlgorithm().getOptionsShape(), new model.ShapeMap()){
            @Override
            public void action (model.Shape shape) {
                updateShape(shape);
                updateAlgorithm(app.getModelShape().getAlgorithms().get(0));
            }
        };
        
        optionAlgorithmL = new OptionAlgorithm(header.getOpAlgorithm().getOptionsAlgorithm(), new model.AlgorithmMap(app.getModelShape())){
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
        //ArrayList<JTextField> inputs = header.getInput().getInputs();
        //inputL.setInputs(inputs);
        optionAlgorithmL.setAlgorithmMap(new model.AlgorithmMap(app.getModelShape()));
        plane.setGraphic(null);
        plane.clearPoints();
    }
    
    public void updateAlgorithm (model.algorithms.Algorithm alg) {
        app.setAlgorithm(alg);
        //header.setTitleAlgorithm(app.getAlgorithm().getTitle());
        plane.clearPoints();
        //TODO: volver a revisar
        //if (!inputL.emptyInputs()) app.runAlgorithm();
        app.runAlgorithm();
    }
}
