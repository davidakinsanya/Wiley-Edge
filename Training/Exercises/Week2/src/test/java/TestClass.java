import org.example.interfaces.Shape;
import org.example.interfaces.shapes.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClass {
  private Shape c;

  @BeforeEach
  public void beforeTestClass() {
    c = new Circle(5);
  }
  @Test
  public void testCase1() {
    double diameter = 5 * Shape.PI * 2;
    assertEquals(diameter, c.getPerimeter());

  }
}
