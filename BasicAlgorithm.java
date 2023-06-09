import java.util.ArrayList;
import java.awt.Point;

public class BasicAlgorithm extends Algorithm {
    public BasicAlgorithm () {
        super("Basic Algorithm");
    }
    public ArrayList<Point> generatePoints(int xI, int yI, int xF, int yF) {
        ArrayList<Point> points = new ArrayList<Point>();
        double dy, dx;
        int x, y;
        dy = yF - yI;
        dx = xF - xI;
        x = xI; y = yI;
        points.add(new Point(x, y));
        pValues.add(0);
        if (dx > dy) { 
            while (x < xF) {
                x = x + 1;
                y = (int)(dy/dx * (x - xI) + yI);
                points.add(new Point(x, y));
                pValues.add(0);
            }
        } else {
            while (y < yF) {
                y = y + 1;
                x = (int)(dx/dy * (y - yI) + xI);
                points.add(new Point(x, y));
                pValues.add(0);
            }
        }
        return points;
    }
}
