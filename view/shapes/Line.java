package view.shapes;

import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.LineAlgorithm;
import model.algorithms.LineBresenham;

public class Line extends Shape {
  public Line(Point start, Point end, LineAlgorithm algorithm) {
    this.algorithm = algorithm;
    pointsBorder = algorithm.generatePoints((int) start.getX(), (int) start.getY(), (int) end.getX(),
        (int) end.getY());
    generatePixels();
  }

  public Line(Point start, Point end) {  
    this(start, end, new LineBresenham());
  }
  
  public void fill () {}
}
