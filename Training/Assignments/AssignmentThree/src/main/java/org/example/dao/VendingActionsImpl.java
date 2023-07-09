package org.example.dao;

import org.example.dto.Cart;
import org.example.dto.Item;
import org.example.dto.Transaction;
import org.example.io.InventoryIO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

/**
 * This method provides the implementation to the vending machine actions.
 *
 * @author david
 */
public class VendingActionsImpl implements VendingActions {

  InventoryIO io;
  List<Item> inventory;


  public VendingActionsImpl() {
    this.startVendingMachine();
    inventory = InventoryIO.inventory;
  }

  /**
   * This method starts the vending machine.
   */
  @Override
  public void startVendingMachine() {
    try {
      io = new InventoryIO();
      io.readFile();

    } catch (IOException e) {
      System.out.println("File does not exist.");
    }
  }

  /**
   * This method displays the items of the vending machine.
   */
  @Override
  public void showItems() {
    Stream<Item> filteredInventory
            = inventory.stream().filter(i -> i.getInventoryLevel() > 0);

    filteredInventory.forEach(x -> System.out.println(x.getId() + ": " +
            x.getItemName() + " £" +
            x.getItemPrice()));

    System.out.println("\n");
    }

  /**
   * This method adds an item to the transaction.
   *
   * @param item the added item
   * @param amt the amount of the item add
   * @return the state of whether the transaction was successful.
   */
  @Override
  public int addToTransaction(Item item, int amt) {
    Transaction.transactionItems.add(item);

    Transaction.total.add(item.getItemPrice().multiply(BigDecimal.valueOf((double)amt) ));

    int currentStock = item.getInventoryLevel();
    int currentQuantityBought  = item.getQuantitySelected();

    currentStock -= amt;
    currentQuantityBought += amt;
    item.setInventoryLevel(currentStock);
    item.setQuantitySelected(currentQuantityBought);
    return 1;
  }

  /**
   * This method forwards the vending machine to the cart.
   */
  @Override
  public void presentCart() {
    Cart cart = new Cart();
    cart.cartFlow();
  }

  /**
   * This method initiates process of updating the stock level.
   *
   * @throws IOException where the file writer has issues
   */
  @Override
  public void updateStock() throws IOException {
    io.writeFile("inventory.txt");
  }
}
