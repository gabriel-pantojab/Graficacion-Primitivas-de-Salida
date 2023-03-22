import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;

/**
 * Write a description of class MAIN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TablaEstadisticas
{
    public static void main (String args[]) {
        Algorithm mp = new MiddlePoint();
        Algorithm ba = new BasicAlgorithm();
        Algorithm br = new Bresenham();
        Estadistica et = new Estadistica();
        Data data = new Data();
        
        int xI, yI, xF, yF;
        int tamMuestra = 50;
        String[] labels = {"cantidad puntos", "tiempo basico", "tiempo bresenham", "tiempo punto medio"};
        String[][] datos = new String[tamMuestra][4];
        
        for (int i = 0; i < tamMuestra; i++) {
            xI = (int)data.getPointsIniciales()[i].getX();
            yI = (int)data.getPointsIniciales()[i].getY();
            
            xF = (int)data.getPointsFinales()[i].getX();
            yF = (int)data.getPointsFinales()[i].getY();
            
            long tba = et.getTime(ba, xI, yI, xF, yF);
            long tmp = et.getTime(mp, xI, yI, xF, yF);
            long tbr = et.getTime(br, xI, yI, xF, yF);
            
            datos[i][0] = Math.max(xF-xI, yF-yI) +"";
            datos[i][1] = tba + "";
            datos[i][2] = tbr + "";
            datos[i][3] = tmp + "";
        }
        
        JFrame f = new JFrame();
        
        f.setBounds(0, 0, 400, 400);
        
        JTable tabla = new JTable(datos, labels);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabla.setDefaultRenderer(Object.class, centerRenderer);
        f.add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    public static void presicion () {
        Algorithm mp = new MiddlePoint();
        Algorithm ba = new BasicAlgorithm();
        Algorithm br = new Bresenham();
        Estadistica et = new Estadistica();
        JFrame f = new JFrame();
        
        int xI, yI, xF, yF;
        xI = 1;
        yI = 2;
        xF = 13;
        yF = 7;
        int dx = xF - xI;
        int dy = yF - yI;
        int tamMuestra = Math.max(dx, dy);
        String[] labels = {"x", "desviacion basico", "desviacion bresenham", "desviacion punto medio"};
        String[][] datos = new String[tamMuestra][4];
        ArrayList<Double> errors1 = et.getErrors(xI, yI, xF, yF, ba);
        ArrayList<Double> errors2 = et.getErrors(xI, yI, xF, yF, br);
        ArrayList<Double> errors3 = et.getErrors(xI, yI, xF, yF, mp);
        
        for (int i=0; i<tamMuestra; i++) {
            datos[i] = new String[]{(i+1)+"", errors1.get(i) + "", errors2.get(i) + "", errors3.get(i) + ""};
        }
        
        f.setBounds(0, 0, 400, 400);
        
        JTable tabla = new JTable(datos, labels);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabla.setDefaultRenderer(Object.class, centerRenderer);
        f.add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    static void precisionPromedio () {
        Algorithm mp = new MiddlePoint();
        Algorithm ba = new BasicAlgorithm();
        Algorithm br = new Bresenham();
        Estadistica et = new Estadistica();
        Data data = new Data();
        
        int xI, yI, xF, yF;
        int tamMuestra = 50;
        String[] labels = {"cantidad puntos", "basico", "bresenham", "punto medio"};
        String[][] datos = new String[tamMuestra][4];
        
        for (int i = 0; i < tamMuestra; i++) {
            xI = (int)data.getPointsIniciales()[i].getX();
            yI = (int)data.getPointsIniciales()[i].getY();
            
            xF = (int)data.getPointsFinales()[i].getX();
            yF = (int)data.getPointsFinales()[i].getY();
            
            ArrayList<Double> errors1 = et.getErrors(xI, yI, xF, yF, ba);
            ArrayList<Double> errors2 = et.getErrors(xI, yI, xF, yF, br);
            ArrayList<Double> errors3 = et.getErrors(xI, yI, xF, yF, mp);
            
            double pBA = promedio(errors1, errors1.size());
            double pBR = promedio(errors2, errors2.size());
            double pMP = promedio(errors3, errors3.size());
            
            datos[i][0] = Math.max(xF-xI, yF-yI) +"";
            datos[i][1] = pBA + "";
            datos[i][2] = pBR + "";
            datos[i][3] = pMP + "";
        }
        
        JFrame f = new JFrame();
        
        f.setBounds(0, 0, 400, 400);
        
        JTable tabla = new JTable(datos, labels);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tabla.setDefaultRenderer(Object.class, centerRenderer);
        f.add(new JScrollPane(tabla));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private static double promedio (ArrayList<Double> errors, int size) {
        double r = 0;
        for (Double e : errors) {
            r += e;
        }
        r /= size;
        return Math.round(r * 1000.0) / 1000.0;
    }
}
