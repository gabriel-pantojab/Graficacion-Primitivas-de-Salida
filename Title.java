import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

public class Title extends JPanel
{
    private JLabel title;
    public Title(String text) {
        setPreferredSize(new Dimension(0, 40));
        title = new JLabel(text);
        add(title);
    }
    
    public void setTitle (String text) {
        title.setText(text);
    }
}
