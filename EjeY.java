import javax.swing.*;
import java.awt.*;

public class EjeY extends JPanel{
    private int tam;
    public EjeY(int tam) {
        setPreferredSize(new Dimension(40, 0));
        this.tam = tam;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        for(int i=1; i<=tam; i++) {
            String tag = (tam - i) + "";
            g.drawString(tag, 20, (i)*Constants.GRID_SCALE);
        }
    }
}
