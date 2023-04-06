package model;
import java.util.ArrayList;

public abstract class Shape {
    protected String title;
    public Shape (String title) {
        this.title = title;
    }
    
    public String getTitle () {
        return title;
    }
    
    public abstract ArrayList<? extends model.algorithms.Algorithm> getAlgorithms (); 
}
