package org.example.dao;

import org.example.dto.Item;
import org.example.dto.Transaction;
import org.example.exception.NoItemInventoryException;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This method controls displaying the vending machine functionality to the user.
 *
 * @author david
 */
public class VendingView implements VendingActions {

  private final VendingActionsImpl vendingImpl;
  public static BigDecimal funds = BigDecimal.ZERO;

  public VendingView(VendingActionsImpl impl) {
    vendingImpl = new VendingActionsImpl();
    this.startVendingMachine();
  }

  /**
   * This method runs the vending view.
   *
   * @throws IOException where the file writer has issues
   */
  public void run() throws IOException {
    insertFunds();
    menu();
  }

  /**
   * This method displays the vending machine menu.
   *
   * @throws IOException where the file writer has issues
   */
  public void menu() throws IOException {
    String selection = "y";
    System.out.println("Welcome to The Vending Machine.");
    System.out.println("Here is what we have on display..\n");
    showItems();
    while (selection.equals("y")) {
      System.out.print("Select the number of the item you would like to buy: ");
      int id = scInt.nextInt();
      selection = selectItem(id);
      System.out.println("\n");
    }
    if (Transaction.transactionItems.size() >= 1) {
      presentCart();
      this.updateStock();
    } else {
      System.out.println("Thank you for using the Vending Machine.");
    }
  }

  /**
   * This method controls the process of selecting an item from the vending machine.
   *
   * @param id the id of the desired item
   * @return a String representing whether the user wants to select another item
   */
  public String selectItem(int id) {

    for (Item i : vendingImpl.inventory) {
      if (i.getId() == id && i.getInventoryLevel() > 0) {

        System.out.print("How many would you like to buy: ");
        this.addToTransaction(i, scInt.nextInt());
        System.out.print("\nPress 'y' to continue purchasing or 'n' to go the cart: ");
        return scString.next();

      } else if (i.getId() == id && i.getInventoryLevel() == 0) {

        throw new NoItemInventoryException("Sorry, " + i.getItemName() + " is out of stock now..");
      }
    }

    System.out.println("Sorry, we don't have the item ..");
    System.out.print("\nPress 'y' to continue purchasing or 'n' to go the cart: ");
    return scString.next();
  }

  /**
   * This method prompts the user to insert money they want to spend on the vending machine.
   */
  public void insertFunds() {
    System.out.print("Please insert how much money you would like to use in the Vending machine: ");
    funds = BigDecimal.valueOf(scDouble.nextDouble()).round(new MathContext(3));
  }

  /**
   * This method starts the vending machine.
   */
  @Override
  public void startVendingMachine() { vendingImpl.startVendingMachine(); }

  /**
   * This method displays the items of the vending machine.
   */
  @Override
  public void showItems() { vendingImpl.showItems(); }

  /**
   * This method adds an item to the transaction.
   *
   * @param item the added item
   * @param amt the amount of the item add
   * @return the state of whether the transaction was successful.
   */
  @Override
  public int addToTransaction(Item item, int amt) {
    if (item.getInventoryLevel() >= amt) {
      vendingImpl.addToTransaction(item, amt);
      System.out.println("(" + amt + ")" + " " + item.getItemName() + " added to the cart ..");
      return 1;
    }
    System.out.println("We only have " + item.getInventoryLevel() + " left in stock ...");
    return -1;
  }

  /**
   * This method forwards the vending machine to the cart.
   */
  @Override
  public void presentCart() {
    vendingImpl.presentCart();
  }

  /**
   * This method initiates process of updating the stock level.
   */
  @Override
  public void updateStock() throws IOException {
    vendingImpl.updateStock();
  }
}
