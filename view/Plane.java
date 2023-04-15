package view;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.ComponentEvent;

public class Plane extends JPanel implements LayoutManager
{
    final int LY = Constants.LY;
    final int LX = Constants.LX;
    int GRID_SCALE = Constants.GRID_SCALE;
    private ArrayList<Point> points;
    private Stack<Pixel> pixeles, pixelesOrigen;
    private ArrayList<Pixel> pixelesGrilla;
    private GraphicsShape graphic;
    private int indexPixel;
    
    private view.shapes.Shape currentShape;
    
    public Plane () {
        setLayout(this);
        indexPixel = 0;
        pixeles = new Stack<Pixel>();
        pixelesOrigen = new Stack<Pixel>();
        pixelesGrilla = new ArrayList<Pixel>();
        crearGrilla();
        setPreferredSize(new Dimension(GRID_SCALE*LX+1, GRID_SCALE*LY+1));
        setBackground(new Color(250, 250, 250));
    }
    
    public void setCurrentShape (view.shapes.Shape s) {
        if (currentShape != null) currentShape.unselect(); 
        currentShape = s;
    }
    
    public view.shapes.Shape getCurrentShape () {
        return currentShape;
    }
    
    public void removeCurrentShape () {
        if (currentShape != null) {
            remove(currentShape);
        }
    }
    
    public void clearPoints () {
        points = new ArrayList<Point>();
        pixeles = new Stack<Pixel>();
        indexPixel = 0;
        repaint();
    }
    
    public void setGraphic (GraphicsShape g) {
        this.graphic = g;
    }
    
    public GraphicsShape getGraphicShape() {
        return graphic;
    }
    
    public void setPoints (ArrayList<Point> points) {
        indexPixel = 0;
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
        //pixeles.forEach((pixel) -> pixel.paintFill(g));
        pixelesOrigen.forEach((pixel) -> pixel.paintFill(g));
        if (graphic != null) graphic.paint((Graphics2D)g);
    }
    
    public void run () {
        Thread h = new Thread() {
            public void run () {
                while (indexPixel < points.size()) {
                    pushPixel();
                    try {
                        Thread.sleep(0);
                    } catch (Exception e) {}
                }
            }  
        };
        h.start();
    }
    
    public void pushPixel () {
        if (indexPixel == points.size()) return; 
        Point p = points.get(indexPixel);
        int mX = LX / 2;
        int mY = LY / 2;
        Pixel pixel = new Pixel((int)p.getX()+mX, -(int)p.getY()+mY, GRID_SCALE);
        pixeles.push(pixel);
        indexPixel++;
        repaint();
    }
    
    public void removePixel () {
        if (indexPixel == 0) return;
        pixeles.pop();
        indexPixel--;
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
    
    public void paintPixel (int x, int y) {
        Graphics g = getGraphics();
        int mX = LX / 2;
        int mY = LY / 2;
        g.setColor(Color.GREEN);
        g.drawRect(x+mX-1, -y+mY-1, GRID_SCALE, GRID_SCALE);
    }
    
    public void pushPixelOrigen (int x, int y) {
        int mX = LX / 2;
        int mY = LY / 2;
        pixelesOrigen.push(new Pixel(x+mX, -y+mY, GRID_SCALE, Color.RED));
        repaint();
    }
    
    public void popPixelOrigen () {
        pixelesOrigen.pop();
        repaint();
    }
    
    public Pixel peekPixelOrigen () {
        return pixelesOrigen.peek();
    }
    
    public void clearPixelesOrigen () {
        pixelesOrigen = new Stack<Pixel>();
    }
    
    public int sizePixelesOrigen () {
        return pixelesOrigen.size();
    }
    
    public void showPoints() {
        points.forEach((p) -> {
            System.out.println("("+(int)p.getX()+", "+(int)p.getY()+") ");
        });
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLayoutComponent'");
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        Container parent = comp.getParent();
        if (comp instanceof view.shapes.Shape) {
            view.shapes.Shape cS = (view.shapes.Shape)comp;
            cS.getPixelsBorder().forEach((pixel)->{
                parent.remove(pixel);
            });
            cS.getPixelsFill().forEach((pixel)->{
                parent.remove(pixel);
            });
            System.out.println(parent.getComponentCount());
        }
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int n = parent.getComponentCount();
        for (int i = 0; i < n; i++) {
            Component c = parent.getComponent(i);
            if (c instanceof view.shapes.Shape) {
                view.shapes.Shape cS = (view.shapes.Shape)c;
                cS.getPixelsBorder().forEach((p)->{
                    parent.add(p);
                });
                cS.getPixelsFill().forEach((p)->{
                    parent.add(p);
                });
            }
        }
    }
}

