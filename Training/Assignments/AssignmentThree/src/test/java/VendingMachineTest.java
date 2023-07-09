import org.example.dao.VendingActionsImpl;
import org.example.dto.Change;
import org.example.dto.Item;
import org.example.exception.InsufficientFundsException;
import org.example.io.InventoryIO;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

  VendingActionsImpl v = new VendingActionsImpl();
  Item one = InventoryIO.inventory.get(0);
  Item two = InventoryIO.inventory.get(1);

  public VendingMachineTest() {}

  @Test
  public void startingVendingMachine() {
    assertDoesNotThrow(() -> new InventoryIO().readFile());
  }

  @Test
  public void successfulAddToTransaction() throws IOException {
    assertEquals(v.addToTransaction(one, 2), 1);
  }

  @Test
  public void insufficientFundsException() {
   InsufficientFundsException thrown;
    thrown = assertThrows(
            InsufficientFundsException.class,
             () -> Change.getChange(BigDecimal.valueOf(7.87), BigDecimal.valueOf(9.08)),
             "Expected to getChange() throw, but it didn't"
     );
  }

  @Test
  public void insufficientFundsNoException() {
    assertDoesNotThrow(() -> Change.getChange(BigDecimal.valueOf(9.08), BigDecimal.valueOf(7.87)));
    System.out.println("\n");
    assertDoesNotThrow(() -> Change.getChange(BigDecimal.valueOf(4.13), BigDecimal.valueOf(1.26)));
    System.out.println("\n");
    assertDoesNotThrow(() -> Change.getChange(BigDecimal.valueOf(6.71), BigDecimal.valueOf(2.97)));
  }

  @Test
  public void updateStockTest() {
    v.addToTransaction(one, 2);
    v.addToTransaction(two, 2);

    assertDoesNotThrow(() -> new InventoryIO().writeFile("inventory_test.txt"));
  }
}
