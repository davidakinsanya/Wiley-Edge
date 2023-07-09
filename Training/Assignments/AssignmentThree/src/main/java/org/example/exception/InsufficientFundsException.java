package org.example.exception;

/**
 * This method terminates the program when the user
 * doesn't have enough funds to complete the transaction.
 *
 * @author david
 */
public class InsufficientFundsException extends RuntimeException {
  public InsufficientFundsException(String msg) {
    super(msg);
  }
}
