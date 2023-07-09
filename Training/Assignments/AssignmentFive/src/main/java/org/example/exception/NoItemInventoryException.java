package org.example.exception;

/**
 * This method terminates the program when the user
 * selects an item not in stock.
 *
 * @author david
 */
public class NoItemInventoryException extends RuntimeException {
  public NoItemInventoryException(String msg) {
    super(msg);
  }
}
