import javax.swing.*;
import java.awt.*;

public class PlanoCartesiano extends JFrame {
    
    public PlanoCartesiano() {
        super("Plano Cartesiano");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        int centroX = getWidth() / 2;
        int centroY = getHeight() / 2;
        // Dibujar eje X
        g.drawLine(0, centroY, getWidth(), centroY);
        // Dibujar eje Y
        g.drawLine(centroX, 0, centroX, getHeight());
        // Dibujar cuadrícula
        int intervalo = 20;
        for (int i = intervalo; i < getWidth(); i += intervalo) {
            g.drawLine(i, centroY - 5, i, centroY + 5);
            g.drawLine(centroX - 5, i, centroX + 5, i);
        }
        
        int x = -5;
        int y = -3;
        x = x*intervalo + centroX; // la coordenada x del punto
        y = -y*intervalo + centroY; // la coordenada y del punto
        g.fillOval(x - 3, y - 3, 6, 6);
    }
    
    public static void main(String[] args) {
        new PlanoCartesiano();
    }
}
