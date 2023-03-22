import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

/**
 * Write a description of class Controls here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controls extends JPanel implements ActionListener{
    private JButton stepMas, stepMenos, run;
    private Plano plano;
    private Table tabla;
    public Controls (Plano plano, Table tabla) {
        this.plano = plano;
        this.tabla = tabla;
        stepMas = new JButton("\u27A1");
        stepMenos = new JButton("\u2B05");
        run = new JButton("\u25B6");
        
        stepMas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stepMenos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        run.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stepMas.addActionListener(this);
        stepMenos.addActionListener(this);
        run.addActionListener(this);
        add(stepMenos);
        add(stepMas);
        add(run);
    }
    
    public void actionPerformed (ActionEvent e) {
        if (e.getSource().equals(stepMas)) {
            plano.pushPixel();
            tabla.pushRow();
        } else if (e.getSource().equals(stepMenos)) {
            plano.removePixel();
            tabla.removeRow();
        } else {
            plano.run();
            tabla.run();
        }  
    }
}
