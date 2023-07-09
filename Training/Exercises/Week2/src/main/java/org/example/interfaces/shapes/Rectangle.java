package org.example.interfaces.shapes;

import org.example.interfaces.Shape;

public class Rectangle implements Shape {

  private final int length;
  private final int width;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double getArea() {
    return this.length * this.width;
  }

  @Override
  public double getPerimeter() {
    return this.getArea() * 2;
  }

  @Override
  public String getShape() {
    return "Rectangle";
  }
}
