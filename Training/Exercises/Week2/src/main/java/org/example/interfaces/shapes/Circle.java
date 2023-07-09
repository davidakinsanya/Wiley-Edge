package org.example.interfaces.shapes;

import org.example.interfaces.Shape;

public class Circle implements Shape {
  private final int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.pow(Shape.PI * radius, 2);
  }

  @Override
  public double getPerimeter() {
    return 2 * radius * Shape.PI;
  }

  @Override
  public String getShape() {
    return "Circle";
  }

  public int getRadius() {
    return radius;
  }
}
