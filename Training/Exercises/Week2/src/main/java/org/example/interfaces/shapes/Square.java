package org.example.interfaces.shapes;

public class Square extends Rectangle {
  private final int length;

  public Square(int length) {
    super(length, length);
    this.length = length;
  }
  @Override
  public double getArea() {
    return Math.pow(this.length, 2);
  }

  @Override
  public String getShape() {
    return "Square";
  }
}
