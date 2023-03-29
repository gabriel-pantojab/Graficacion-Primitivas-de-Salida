package model;
import java.util.HashMap;


/**
 * Write a description of interface ShapeMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ShapeMap {
    private HashMap<String, Shape> shapes;
    
    public ShapeMap () {
        shapes = new HashMap<String, Shape>();
    }
    
    private void create () {
        shapes.put("Line", new LineShape());
        shapes.put("Circle", new CircleShape());
    }
    
    public Shape shape (String name) {
        return shapes.get(name);
    }
}
