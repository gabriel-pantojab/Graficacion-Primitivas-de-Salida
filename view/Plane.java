package view;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.ComponentEvent;

public class Plane extends JPanel
{
    final int LY = Constants.LY;
    final int LX = Constants.LX;
    final int GRID_SCALE = Constants.GRID_SCALE;
    private ArrayList<Point> points;
    private Stack<Pixel> pixeles;
    private ArrayList<Pixel> pixelesGrilla;
    private int xI, yI, xF, yF;
    private int index;
    
    public Plane () {
        setLayout(null);
        index = 0;
        pixeles = new Stack<Pixel>();
        pixelesGrilla = new ArrayList<Pixel>();
        crearGrilla();
        setPreferredSize(new Dimension(601, 551));
    }
    
    public void setStartPoint (int x, int y) {
        xI = x;
        yI = y;
    }
    
    public void setEndPoint (int x, int y) {
        xF = x;
        yF = y;
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
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        g.setColor(Color.BLACK);
        g.drawLine(0, centroY, getWidth(), centroY);
        g.drawLine(centroX, 0, centroX, getHeight());
        pixeles.forEach((pixel) -> pixel.paintFill(g));
        paintRealRect(g);
    }
    
    public void paintRealRect(Graphics g) {
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(xI*GRID_SCALE + centroX, -yI*GRID_SCALE + centroY,
                    xF*GRID_SCALE + centroX, -yF*GRID_SCALE + centroY);
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
        int mX = LX / 2;
        int mY = LY / 2;
        Pixel pixel = new Pixel((int)p.getX()+mX, -(int)p.getY()+mY, GRID_SCALE);
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
    
    public void crearGrilla () {
        for (int i = 0; i < LX; i++) {
            for (int j = 0; j < LY; j++) {
                Pixel p = new Pixel(i, j, GRID_SCALE);
                pixelesGrilla.add(p);
            }
        }
    }
    
    public void paintGrilla(Graphics g) {
        g.setColor(new Color(117, 117, 117));
        for (int i = 0; i < LX; i++) {
            for (int j = 0; j < LY; j++) {
                g.drawRect(i*GRID_SCALE, j*GRID_SCALE,GRID_SCALE, GRID_SCALE);
            }
        }
    }

    
    public void showPoints() {
        points.forEach((p) -> {
            System.out.println("("+(int)p.getX()+", "+(int)p.getY()+") ");
        });
    }
}

