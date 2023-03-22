import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.Point;

public class Estadistica {   
    public long getTime (Algorithm algo, int xI, int yI, int xF, int yF) {
        long inicio, fin;
        inicio = System.nanoTime();
        algo.generatePoints(xI, yI, xF, yF);
        fin = System.nanoTime();
        return fin - inicio;
    }
    
    public ArrayList<Double> getErrors (int xI, int yI, int xF, int yF, Algorithm algorithm) {
        ArrayList<Point> pointsAlgorithm = algorithm.generatePoints(xI, yI, xF, yF);
        ArrayList<Point2D.Double> pointsReal = getPointsReal(xI, yI, xF, yF);
        ArrayList<Double> errors = new ArrayList<Double>();
        for (int i = 0; i < pointsReal.size(); i++) {
            Point p = pointsAlgorithm.get(i);
            Point2D.Double pA = new Point2D.Double(p.getX(), p.getY());
            Point2D.Double pR = pointsReal.get(i);
            double distancia = pR.distance(pA);
            errors.add(Math.round(distancia * 1000.0) / 1000.0);
        }
        return errors;
    }
    
    public ArrayList<Point2D.Double> getPointsReal (int xI, int yI, int xF, int yF) {
        ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
        double dy, dx, x, y;
        dy = yF - yI;
        dx = xF - xI;
        x = xI; y = yI;
        points.add(new Point2D.Double(x, y));
        if (dx > dy) { 
            while (x < xF) {
                x = x + 1;
                y = (dy/dx * (x - xI) + yI);
                points.add(new Point2D.Double(x, y));
            }
        } else {
            while (y < yF) {
                y = y + 1;
                x = (dx/dy * (y - yI) + xI);
                points.add(new Point2D.Double(x, y));
            }
        }
        return points;
    }
}
