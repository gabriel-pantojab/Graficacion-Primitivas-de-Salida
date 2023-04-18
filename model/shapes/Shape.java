package model.shapes;
import model.Punto;
import java.util.ArrayList;

public abstract class Shape {
    private ArrayList<Punto> points;
    private ArrayList<Punto> vertex;
    
    public Shape () {
        points = new ArrayList<Punto>();
        vertex = new ArrayList<Punto>();
    }
    
    public abstract void fill ();
    
    protected void cuatro_vecinos(int x, int y) {
        Punto p = new Punto(x, y);
        if (!points.contains(p)) {
            points.add(p);
            cuatro_vecinos(x, y+1);
            cuatro_vecinos(x+1, y);
            cuatro_vecinos(x, y-1);
            cuatro_vecinos(x-1, y);
        }
    }
}
