import java.awt.Graphics;
import java.awt.Color;

public class Pixel {
    private int width;
    private int x, y;
    private Color color;
    public Pixel(int x, int y, int width){
        this.width = width;
        this.x = x;
        this.y = y;
        color = Color.BLACK;
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
