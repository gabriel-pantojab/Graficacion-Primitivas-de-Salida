import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;
import java.awt.Point;

public class Table extends JDialog {
    private ArrayList<Point> points;
    private ArrayList<Integer> pValues;
    private JTable tabla;
    private int index;
    public Table (JFrame frame, String title, ArrayList<Point> points, ArrayList<Integer> pValues) {
        super(frame, title);
        this.points = points;
        this.pValues = pValues;
        index = 0;
        setBounds(100, 100, 300, 300);
        crearTabla();
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public void setTitleAlgorithm (String title) {
        setTitle(title);
    }
    
    public void pushRow () {
        if (index == points.size()) return;
        Point p = points.get(index);
        String punto = "("+(int)p.getX()+", "+(int)p.getY()+")";
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        if (model.getRowCount() > 0)  {
            model.addRow(new Object[]{index - 1, pValues.get(index - 1), punto});
        }
        else model.addRow(new Object[]{"-", "-", punto});
        index++;
        
        tabla.repaint();
    }
    
    public void clear () {
        while (index > 0) {
            removeRow();
        }
    }
    
    public void setPoints (ArrayList<Point> points) {
        this.points = points;
    }
    
    public void setPValues (ArrayList<Integer> pValues) {
        this.pValues = pValues;
    }
    
    public void removeRow () {
        if (index == 0) return; 
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int rowCount = model.getRowCount();
        model.removeRow(rowCount - 1);
        index--;
    }
    
    public void run () {
        Thread h = new Thread() {
            public void run () {
                while (index < points.size()) {
                    pushRow();
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {}
                }
            }  
        };
        h.start();
    }
    
    private void crearTabla () {
        String titulos[] = {"k", "p", "(x, y)"};
        Object datos[][] = {};
        DefaultTableModel modeloTabla = new DefaultTableModel(datos, titulos);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabla = new JTable(modeloTabla);
        tabla.setDefaultRenderer(Object.class, centerRenderer);
        tabla.setRowSelectionAllowed(false);
        tabla.setColumnSelectionAllowed(false);
        tabla.setEnabled(false);
        add(new JScrollPane(tabla));
    }
}
