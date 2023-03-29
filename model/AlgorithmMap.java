package model;
import java.util.HashMap;


/**
 * Write a description of class AlgorithmMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlgorithmMap {
    private HashMap<String, Algorithm> options;
    private Shape shape;
    public AlgorithmMap (Shape shape) {
        this.shape = shape;
        options = new HashMap<String, Algorithm>();
        create();
    }
    
    public void create () {
        shape.getAlgorithms().forEach(
            (a) -> {
                options.put(a.getTitle(), a);
            }
        );
    }
    
    public Object get (String name) {
        return options.get(name);
    }
}
