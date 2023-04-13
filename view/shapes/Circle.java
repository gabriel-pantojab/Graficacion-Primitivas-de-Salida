package view.shapes;

import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.CircleAlgorithm;
import model.algorithms.CircleMidPoint;

public class Circle extends Shape
{
    public Circle(Point center, int radio, CircleAlgorithm algorithm) {
    this.algorithm = algorithm;
    ArrayList<Point> points = algorithm.generatePoints((int) center.getX(), (int) center.getY(), radio);
    generatePixels(points);
  }

  public Circle(Point center, int radio) {  
    this(center, radio, new CircleMidPoint());
  }
}
