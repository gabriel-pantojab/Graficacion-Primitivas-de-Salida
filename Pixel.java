import java.awt.Graphics;
import java.awt.Color;

public class Pixel {
    private int width;
    private int x, y;
    public Pixel(int x, int y, int width){
        this.width = width;
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x*width, y*width, width, width);
    }
}
