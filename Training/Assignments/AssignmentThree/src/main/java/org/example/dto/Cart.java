package org.example.dto;

import org.example.dao.VendingView;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.example.dto.Change.getChange;

/**
 * This class controls the logic involving the cart of the vending machine.
 *
 * @author david
 */
public class Cart {

  Scanner scString = new Scanner(System.in);
  Scanner scInt = new Scanner(System.in);

  /**
   * This method controls all the logic in the cart.
   */
  public void cartFlow() {
    Stream<Item> cart = Transaction.transactionItems.stream();
    System.out.println("Here is your current cart: \n");

    for (Item i: Transaction.transactionItems) {
      Transaction.total = Transaction.total.add( i.getItemPrice().multiply( BigDecimal.valueOf(i.getQuantitySelected())));
    }

    cart.forEach(x -> System.out.println(x.getId() + ": " +
            x.getItemName() + " £" +
            x.getItemPrice().multiply( BigDecimal.valueOf(x.getQuantitySelected()))));

    System.out.println("\nTotal: £" + Transaction.total);

    forwardToPayment();
  }

  /**
   * This method controls the process of paying in the cart.
   */
  public void forwardToPayment() {
    getChange(VendingView.funds, Transaction.total);
  }
}


