package model;

import java.util.ArrayList;

public class TriangleShape extends Shape {
    private ArrayList<model.algorithms.TriangleAlgorithm> algorithms;
    
    public TriangleShape() {
        super("Algorithms of the Triangle");
        algorithms = new ArrayList<model.algorithms.TriangleAlgorithm>();
        algorithms.add(new model.algorithms.TriangleBresenham());
    }
    
    public ArrayList<? extends model.algorithms.Algorithm> getAlgorithms () {
        return algorithms;
    }
}
