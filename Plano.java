import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class Plano extends JPanel
{
    final int LY = 20;
    final int LX = 20;
    final int GRID_SCALE = 20;
    private ArrayList<Point> points;
    private Stack<Pixel> pixeles;
    private int xI, yI, xF, yF;
    private int index;
    
    public Plano(int xI, int yI, int xF, int yF, ArrayList<Point> points) {
        index = 0;
        this.points = points;//algoritmo
        this.xI = xI;
        this.yI = yI;
        this.xF = xF;
        this.yF = yF;
        pixeles = new Stack<Pixel>();
    }
    
    public void setPoints (ArrayList<Point> points) {
        index = 0;
        this.points = points;
        pixeles.clear();
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrilla(g);
        pixeles.forEach((pixel) -> pixel.paint(g));
        paintRealRect(g);
    }
    
    public void paintRealRect(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine((xI*GRID_SCALE)+GRID_SCALE/2, 
                    ((LY - yI - 1)*GRID_SCALE) + GRID_SCALE/2, 
                    (xF*GRID_SCALE)+GRID_SCALE/2 ,
                    ((LY - yF - 1)*GRID_SCALE)+GRID_SCALE/2);
    }
    
    public void run () {
        Thread h = new Thread() {
            public void run () {
                while (index < points.size()) {
                    pushPixel();
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {}
                }
            }  
        };
        h.start();
    }
    
    public void pushPixel () {
        if (index == points.size()) return; 
        Point p = points.get(index);
        Pixel pixel = new Pixel((int)p.getX(), LY - ((int)p.getY() + 1), GRID_SCALE);
        pixeles.push(pixel);
        index++;
        repaint();
    }
    
    public void removePixel () {
        if (index == 0) return;
        pixeles.pop();
        index--;
        repaint();
    }
    
    public void paintGrilla(Graphics g) {
        for (int i = 0; i < LY; i++) {
            for (int j = 0; j < LX; j++) {
                g.drawRect(i * GRID_SCALE, j * GRID_SCALE, GRID_SCALE, GRID_SCALE);
            }
        }
    }
    
    public void showPoints() {
        points.forEach((p) -> {
            System.out.println("("+(int)p.getX()+", "+(int)p.getY()+") ");
        });
    }
}
