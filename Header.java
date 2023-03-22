import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class Header here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Header extends JPanel{
    public Header (Controls controls, String title) {
        setLayout(new GridLayout(2, 1));
        add(new Title(title));
        add(controls);
        setPreferredSize(new Dimension(0, 70));
    }
}
