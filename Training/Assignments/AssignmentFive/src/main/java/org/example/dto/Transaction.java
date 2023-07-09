package org.example.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores the items the user was selected from the vending machine.
 *
 * @author david
 */
public class Transaction {

  public static List<Item> transactionItems = new ArrayList<>();
  public static BigDecimal total = BigDecimal.valueOf((double) 0);

  public Transaction() {}

  /**
   * This method gets a specific item inside the transaction.
   *
   * @param id the id of the desired transaction
   * @return the item object if found
   */
  public static Item getItem(int id) {
    for (Item i: Transaction.transactionItems) {
      if (i.getId() == id) {
        return i;
      }
    }
    return null;
  }
}
