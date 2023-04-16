package view;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class OptionsAttributes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OptionsAttributes extends JPanel{
    private JButton up, down, left, right;
    private JPanel directionsPanel, rotatePanel, lineStylePanel;
    
    private JLabel rotate;
    private JComboBox grados;
    
    private JLabel tagLineStyle;
    private JComboBox lineStyle;
    public OptionsAttributes () {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        directionsPanel = new JPanel();
        directionsPanel.setPreferredSize(new Dimension(0, 100));
        directionsPanel.setLayout(new BorderLayout(5, 5));
        
        JPanel panelUp = new JPanel();
        JPanel panelDown = new JPanel();
        
        up = new JButton("\u2191");
        down = new JButton("\u2193");
        left = new JButton("\u2190");
        right = new JButton("\u2192");
        
        
        Font customFont = new Font("Arial", Font.BOLD, 16);
        up.setFont(customFont);
        down.setFont(customFont);
        left.setFont(customFont);
        right.setFont(customFont);
        
        up.setCursor(new Cursor(Cursor.HAND_CURSOR));
        down.setCursor(new Cursor(Cursor.HAND_CURSOR));
        left.setCursor(new Cursor(Cursor.HAND_CURSOR));
        right.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panelUp.add(up);
        panelDown.add(down);
        
        directionsPanel.add(panelUp, BorderLayout.NORTH);
        directionsPanel.add(panelDown, BorderLayout.SOUTH);
        directionsPanel.add(left, BorderLayout.WEST);
        directionsPanel.add(right, BorderLayout.EAST);
        
        rotatePanel = new JPanel();
        
        rotate = new JLabel("Rotar: ");
        grados = new JComboBox();
        for(int i = 0; i<=360; i++) {
            grados.addItem(i);
        }
        rotatePanel.add(rotate);
        rotatePanel.add(grados);
        
        lineStylePanel = new JPanel();
        
        tagLineStyle = new JLabel("Trazado: ");
        lineStyle = new JComboBox();
        lineStyle.addItem("Continua");
        lineStyle.addItem("Segmentada");
        lineStyle.addItem("Punteada");
        lineStylePanel.add(tagLineStyle);
        lineStylePanel.add(lineStyle);
        
        add(directionsPanel);
        add(rotatePanel);
        add(lineStylePanel);
    }
}
