package view;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;

public class Pixel extends JComponent implements MouseListener{
    private int width;
    private int x, y;
    private Color color;
    private boolean isSelected;
    public Pixel(int x, int y, int width, Color color){
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
        isSelected = false;
        setBounds(x*width, y*width, width, width);
        addMouseListener(this);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public Pixel(int x, int y, int width){
        this(x, y, width, Color.BLACK);
    }
    
    public int getXPlane () {
        return x;
    }
    
    public int getYPlane () {
        return y;
    }
    
    public void setColor (Color color) {
        this.color = color;
    }
    
    public void paintFill(Graphics g) {
        g.setColor(color);
        g.fillRect(x*width, y*width, width, width);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(isSelected) color = new Color(42, 42, 42);
        else color = Color.BLACK;
        g.setColor(color);
        g.fillRect(0, 0, width, width);
    }
    
    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(getParent());
        isSelected = !isSelected;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
