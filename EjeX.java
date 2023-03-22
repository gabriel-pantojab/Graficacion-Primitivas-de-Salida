import javax.swing.*;
import java.awt.*;

public class EjeX extends JPanel{
    private int tam;
    public EjeX(int tam) {
        setPreferredSize(new Dimension(0, 40));
        this.tam = tam;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        for(int i=0; i<tam; i++) {
            g.drawString(i + "", i*Constants.GRID_SCALE + 45, 20);
        }
    }
}
