import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class Header here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Header extends JPanel{
    private Title title;
    public Header (Controls controls, String title) {
        setLayout(new GridLayout(2, 1));
        this.title = new Title(title);
        add(this.title);
        add(controls);
        setPreferredSize(new Dimension(0, 70));
    }
    
    public void setTitleAlgorithm (String text) {
        title.setTitle(text);
    } 
}
