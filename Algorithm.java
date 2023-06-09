import java.util.ArrayList;
import java.awt.Point;

public abstract class Algorithm {
    protected ArrayList<Integer> pValues;
    protected String title;
    public Algorithm (String title) {
        pValues = new ArrayList<Integer>();
        this.title = title;
    }
    
    protected ArrayList<Integer> getPValues () {
        return pValues;
    }
    
    protected String getTitle () {
        return title;
    }
    
    public abstract ArrayList<Point> generatePoints(int xI, int yI, int xF, int yF);
}
