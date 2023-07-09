package org.example.dto;

import org.example.dao.VendingView;
import org.example.exception.InsufficientFundsException;

import java.math.BigDecimal;
import java.math.MathContext;


/**
 * This class holds the logic involving administering change to the user.
 *
 * @author david
 */
public class Change {

  /**
   * This method calculates and prints the amount of change administered.
   * @param funds the amount the user wants to spend
   * @param total the total worth of the transaction
   */
  public static void getChange(BigDecimal funds, BigDecimal total)  {
    int comparison = funds.compareTo(total);
    BigDecimal change;

    if (comparison >= 0) {
      BigDecimal amount = VendingView.funds.multiply(BigDecimal.valueOf((double)100));
      change = funds.subtract(total);
      System.out.println("Change: £" + change);
      System.out.println("\nYou were given..\n");

      BigDecimal changeLeft = change;
      BigDecimal coinsGiven;

      for (Coin c : Coin.values()) {
        coinsGiven = changeLeft.multiply(BigDecimal.valueOf((double) 100))
                .divideAndRemainder(c.getValue())[0];

        if (coinsGiven.compareTo(BigDecimal.ZERO) > 0) {
          System.out.println(c.toString()+ "(s): " + coinsGiven.round(new MathContext(1))); // 2mars 1fanta 5.89
          changeLeft = changeLeft.subtract((
                  c.getValue().divide(BigDecimal.valueOf((double) 100)).multiply(coinsGiven)  ));
        }
      }
      System.out.println("\nEnjoy!");

    } else {
      throw new InsufficientFundsException("You are £ " +  total.subtract(funds).toString() + " short of this purchase...");
    }
  }

}
