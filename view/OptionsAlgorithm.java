package view;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.FlowLayout;


/**
 * Write a description of class OptionsAlgorithm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionsAlgorithm extends JPanel {
    private JComboBox optionsShape, optionsAlgorithm;
    
    public OptionsAlgorithm (String[] shapes, String[] algorithms) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));
        optionsShape = new JComboBox();
        optionsAlgorithm = new JComboBox();
        
        createItems(shapes, algorithms);
        
        add(optionsShape);
        add(optionsAlgorithm);
    }
    
    private void createItems (String[] shapes, String[] algorithms) {
        for (String s : shapes) {
            optionsShape.addItem(s);
        }
        
        for (String a : algorithms) {
            optionsAlgorithm.addItem(a);
        }
    }
    
    private void createItemsAlgorithms (String[] algorithms) {
        for (String a : algorithms) {
            optionsAlgorithm.addItem(a);
        }
    }
    
    public JComboBox getOptionsShape () {
        return optionsShape;
    }
    
    public JComboBox getOptionsAlgorithm () {
        return optionsAlgorithm;
    }
    
    public void setOptionsAlgorithms (String[] algorithms) {
        optionsAlgorithm.removeAllItems();
        createItemsAlgorithms(algorithms);
    }
}
