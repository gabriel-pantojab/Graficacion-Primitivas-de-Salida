package controller;
import java.awt.event.*;
import javax.swing.*;

public class OptionAlgorithm implements ItemListener {
    private JComboBox options;
    private model.AlgorithmMap optMap;
    public OptionAlgorithm (JComboBox combo, model.AlgorithmMap optMap) {
        options = combo;
        this.optMap = optMap;
        options.addItemListener(this);
    }
    
    public void action (model.Algorithm shape) {
        
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
        String o = (String)itemEvent.getItem();
        action((model.Algorithm)optMap.get(o));
    }
}