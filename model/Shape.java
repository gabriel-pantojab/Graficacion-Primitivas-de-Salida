package model;
import java.util.ArrayList;

public abstract class Shape {
    protected String title;
    public Shape (String title) {
        this.title = title;
    }
    
    public abstract ArrayList<? extends Algorithm> getAlgorithms (); 
}
