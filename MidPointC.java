import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class MidPointC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MidPointC {
    private ArrayList<Integer> pValues;
    private ArrayList<Point> o2, o3, o4, o5, o6, o7, o8, o1;
    
    public MidPointC () {
        pValues = new ArrayList();
        o2 = new ArrayList();
        o3 = new ArrayList();
        o4 = new ArrayList();
        o5 = new ArrayList();
        o6 = new ArrayList();
        o7 = new ArrayList();
        o8 = new ArrayList();
        o1 = new ArrayList();
    }
    
    public void simetria (int xc, int yc, int x, int y) {
        o3.add(new Point(xc-x, yc+y));//3
        o7.add(new Point(xc+x, yc-y));//4
        o5.add(new Point(xc-x, yc-y));//5
        o1.add(new Point(xc+y, yc+x));//6
        o4.add(new Point(xc-y, yc+x));//7
        o8.add(new Point(xc+y, yc-x));//8
        o6.add(new Point(xc-y, yc-x));//1
    }
    
    public void generate (int xc, int yc, int r) {
        int x,y,p;
        x = 0;
        y = r;
        p = 1 - r;
        o2.add(new Point(x, y));
        pValues.add(p);
        simetria(xc, yc, x, y);
        while (x < y) {
            x = x + 1;
            if (p < 0) {
                p = p + 2*x + 1;
            }else {
                y = y - 1;
                p = p + 2 * (x - y) + 1;
            }
            o2.add(new Point(x, y));
            pValues.add(p);
            simetria(xc, yc, x, y);
        }
    }
    
    public ArrayList<Point> getO2 () {
        return o2;
    }
    public ArrayList<Point> getO3 () {
        return o3;
    }
    public ArrayList<Point> getO4 () {
        return o4;
    }
    public ArrayList<Point> getO5 () {
        return o5;
    }
    public ArrayList<Point> getO6 () {
        return o6;
    }
    public ArrayList<Point> getO7 () {
        return o7;
    }
    public ArrayList<Point> getO8 () {
        return o8;
    }
    public ArrayList<Point> getO1 () {
        return o1;
    }
    
    public ArrayList<Integer> getV () {return pValues;}
    
    public static void main () {
        JFrame f = new JFrame();
        f.setBounds(0, 0, 100, 100);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MidPointC a = new MidPointC();
        a.generate(0, 0, 4);
        
        Table t2 = new Table(f,"Octacte 2", a.getO2(), a.getV());
        t2.run();
        Table t3 = new Table(f,"Octacte 3", a.getO3(), a.getV());
        t3.run();
        Table t4 = new Table(f,"Octacte 4", a.getO4(), a.getV());
        t4.run();
        Table t5 = new Table(f,"Octacte 5", a.getO5(), a.getV());
        t5.run();
        Table t6 = new Table(f,"Octacte 6", a.getO6(), a.getV());
        t6.run();
        Table t7 = new Table(f,"Octacte 7", a.getO7(), a.getV());
        t7.run();
        Table t8 = new Table(f,"Octacte 8", a.getO8(), a.getV());
        t8.run();
        Table t1 = new Table(f,"Octacte 1", a.getO1(), a.getV());
        t1.run();
        
        f.setVisible(true);
    }
}
