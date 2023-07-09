package org.example.other;

import org.example.interfaces.Shape;
import org.example.interfaces.shapes.Circle;
import org.example.interfaces.shapes.Rectangle;
import org.example.interfaces.shapes.Square;
import org.example.interfaces.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static void main(String[] args) {
    int[] verticesBC = {9,6};

    Shape square = new Square(8);
    Shape rectangle = new Rectangle(8,4);
    Shape circle = new Circle(6);
    Shape triangle = new Triangle(4,8, verticesBC);

    List<Shape> list = new ArrayList<>();
    list.add(square);
    list.add(rectangle);
    list.add(circle);
    list.add(triangle);

    for (Shape x: list) {
      System.out.println("Shape x is a: " + x.getShape() + "\n"
                        + "Its perimeter is: " + x.getPerimeter() + "cm\n"
                        + "Its area is: " + x.getArea() + "cm2\n\n");
    }

  }
}
