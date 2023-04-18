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
    private JPanel directionsPanel, rotatePanel, lineStylePanel, fillPanel, colorPanel, grosorPanel
            ,escalaPanel;
    
    private JLabel rotate;
    private JComboBox grados;
    
    private JLabel tagLineStyle;
    private JComboBox lineStyle;
    
    private JLabel fillLabel;
    private JCheckBox fill;
    
    private JLabel colorLabel;
    
    private JLabel grosorLabel;
    private JComboBox grosor;
    
    private JLabel escalaLabel;
    private JComboBox escala;
    public OptionsAttributes () {
        setPreferredSize(new Dimension(200, 0));
        setLayout(new BorderLayout(5, 5));
        setBackground(new Color(41, 50, 65));
        Box mainBox = Box.createVerticalBox();
        //
        createDirectionsPanel();
        //
        createRotatePanel();
        //
        createStyleLinePanel();
        //
        createFillPanel();
        //
        createColorPanel ();
        //
        createGrosorPanel ();
        //
        createEscalaPanel ();
        
        
        mainBox.add(Box.createVerticalGlue());
        mainBox.add(directionsPanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(rotatePanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(lineStylePanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(fillPanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(colorPanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(grosorPanel);
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(escalaPanel);
        mainBox.add(Box.createVerticalGlue());

        add(mainBox, BorderLayout.CENTER);
        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.EAST);
    }
    
    private void createEscalaPanel () {
        escalaPanel = new JPanel();
        escalaLabel = new JLabel("Escala: ");
        escala = new JComboBox();
        for (int i=1; i<=10; i++) {
            escala.addItem(i);
        }
        createHorizontalPanel(escalaPanel, new JComponent[]{escalaLabel, escala});
    }
    
    private void createGrosorPanel () {
        grosorPanel = new JPanel();
        grosorLabel = new JLabel("Grosor: ");
        grosor = new JComboBox();
        for (int i=1; i<=5; i++) {
            grosor.addItem(i);
        }
        createHorizontalPanel(grosorPanel, new JComponent[]{grosorLabel, grosor});
    }
    
    private void createColorPanel () {
        colorPanel = new JPanel();
        colorLabel = new JLabel("Color: ");
        createHorizontalPanel(colorPanel, new JComponent[]{colorLabel});
    }
    
    private void createFillPanel () {
        fillPanel = new JPanel();
        fillLabel = new JLabel("Fill: ");
        fill = new JCheckBox();
        createHorizontalPanel(fillPanel, new JComponent[]{fillLabel, fill});
    }
    
    private void createStyleLinePanel () {
        lineStylePanel = new JPanel();
        tagLineStyle = new JLabel("Trazado: ");
        lineStyle = new JComboBox();
        lineStyle.addItem("Continua");
        lineStyle.addItem("Segmentada");
        lineStyle.addItem("Punteada");
        createHorizontalPanel(lineStylePanel, new JComponent[]{tagLineStyle, lineStyle});
    }
    
    private void createHorizontalPanel (JPanel panel, JComponent[] components) {
        Box b = Box.createHorizontalBox();
        Box B = Box.createVerticalBox();

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (JComponent c : components) {
            b.add(c);
        }
        B.add(Box.createVerticalGlue());
        B.add(b);
        B.add(Box.createVerticalGlue());
        
        panel.add(B);
    }
    
    private void createRotatePanel () {
        rotatePanel = new JPanel();
        
        rotate = new JLabel("Rotar: ");
        grados = new JComboBox();
        for(int i = 0; i<=360; i++) {
            grados.addItem(i);
        }
        createHorizontalPanel(rotatePanel, new JComponent[]{rotate, grados});
    }
    
    private void createDirectionsPanel () {
        directionsPanel = new JPanel();
        directionsPanel.setBackground(new Color(224, 251, 252));
        Box boxDP = Box.createHorizontalBox();
        
        Box box1 = Box.createVerticalBox();
        Box box2 = Box.createVerticalBox();
        Box box3 = Box.createVerticalBox();
        JPanel d1, d2, d3;
        d2 = new JPanel();
        d1 = new JPanel();
        d3 = new JPanel();
        
        //-------------------------
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
        //--------------------------------------------------------
        
        box1.add(Box.createVerticalGlue());
        box1.add(left);
        box1.add(Box.createVerticalGlue());
        box2.add(up);
        box2.add(Box.createVerticalStrut(5));
        box2.add(down);
        box3.add(Box.createVerticalGlue());
        box3.add(right);
        box3.add(Box.createVerticalGlue());
        
        boxDP.add(box1);
        boxDP.add(Box.createHorizontalStrut(5));
        boxDP.add(box2);
        boxDP.add(Box.createHorizontalStrut(5));
        boxDP.add(box3);
        
        directionsPanel.add(boxDP);
    }
    
    //**************************************************************
    public JCheckBox getFillCheck () {
        return fill;
    }
}
