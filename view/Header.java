package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class Header here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Header extends JPanel{
    private Title title;
    private OptionsAlgorithm oA;
    private Input input;
    public Header (String textTitle,model.Shape shape) {
        setLayout(new GridLayout(2, 1));
        JPanel containerO = new JPanel(new GridLayout(1, 2));
        String[] s = {"Line", "Circle"};
        
        oA = new OptionsAlgorithm(s, optionsA(shape.getAlgorithms()));
        input = getInput(shape);
        
        containerO.add(oA);
        containerO.add(input);
        
        title = new Title(textTitle);
        
        add(title);
        add(containerO);
        
        setPreferredSize(new Dimension(0, 66));
    }
    
    private Input getInput (model.Shape s) {
        Input inp;
        if (s instanceof model.LineShape) {
            inp = new LineInput();
        }else {
            inp = new CircleInput();
        }
        return inp;
    }
    
    private String[] optionsA (ArrayList<? extends model.Algorithm> list) {
        String[] o = new String[list.size()];
        for (int i=0; i < list.size(); i++) {
            String n = list.get(i).getTitle();
            o[i] = n;
        }
        return o;
    }
    
    public OptionsAlgorithm getOpAlgorithm () {
        return oA;
    }
    
    public Input getInput () {
        return input;
    }
    
    public void setTitleAlgorithm (String text) {
        title.setTitle(text);
    } 
}
