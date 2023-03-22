import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

public class Title extends JPanel
{
    public Title(String text) {
        setPreferredSize(new Dimension(0, 40));
        add(new JLabel(text));
    }
}
