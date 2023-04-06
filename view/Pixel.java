package view;

import java.awt.Graphics;
import java.awt.Color;

public class Pixel {
    private int width;
    private int x, y;
    private Color color;
    public Pixel(int x, int y, int width, Color color){
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public Pixel(int x, int y, int width){
        this(x, y, width, Color.BLACK);
    }
    
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
    
    public void setColor (Color color) {
        this.color = color;
    }
    
    public void paintFill(Graphics g) {
        g.setColor(color);
        g.fillRect(x*width, y*width, width, width);
    }
    
    public void paint (Graphics g) {
        g.setColor(color);
        g.drawRect(x*width, y*width, width, width);
    }
}
