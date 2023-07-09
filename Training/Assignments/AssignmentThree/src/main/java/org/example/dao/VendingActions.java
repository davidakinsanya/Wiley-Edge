package org.example.dao;


import org.example.dto.Item;

import java.io.IOException;
import java.util.Scanner;

/**
 * This interface defines the actions of the Vending Machine.
 *
 * @author david
 */
public interface VendingActions {

  Scanner scInt = new Scanner(System.in);
  Scanner scDouble = new Scanner(System.in);

  Scanner scString = new Scanner(System.in);

  /**
   * This method starts the vending machine.
   */
  void startVendingMachine();

  /**
   * This method displays the items of the vending machine.
   */
  void showItems();

  /**
   * This method adds an item to the transaction.
   *
   * @param item the added item
   * @param amt the amount of the item add
   * @return the state of whether the transaction was successful.
   */
  int addToTransaction(Item item, int amt);

  /**
   * This method forwards the vending machine to the cart.
   */
  void presentCart();

  /**
   * This method initiates process of updating the stock level.
   *
   * @throws IOException where the file writer has issues
   */
  void updateStock() throws IOException;


  // TODO: Finalise Transaction
}
