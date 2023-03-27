package view;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class Header here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Header extends JPanel{
    public Header (String title) {
        setLayout(new GridLayout(2, 1));
        setPreferredSize(new Dimension(0, 66));
    }
    
    public void setTitleAlgorithm (String text) {
        
    } 
}
