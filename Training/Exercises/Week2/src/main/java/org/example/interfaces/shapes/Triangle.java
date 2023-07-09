package org.example.interfaces.shapes;

import org.example.interfaces.Shape;

public class Triangle implements Shape {
  private final int base;
  private final int height;
  private final int[] vertices;

  public Triangle(int base, int height, int[] verticesBC) {
    this.base = base;
    this.height = height;
    this.vertices = new int[3];
    this.vertices[0] = base;
  }
  @Override
  public double getArea() {
    return 0.5 * base * height;
  }

  @Override
  public double getPerimeter() {
    int perimeter = 0;
    for (int i : vertices) perimeter  += i;
    return perimeter;
  }

  public String getVertices() {
    return "Vertices A = " + this.vertices[0]
            + "\nVertices B = " + this.vertices[1]
            + "\nVertices C = " + this.vertices[2];
  }

  public int getHeight() {
    return height;
  }

  public int getBase() {
    return base;
  }

  @Override
  public String getShape() {
    return "Triangle";
  }
}
