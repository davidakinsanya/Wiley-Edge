package org.example.dto;

import java.math.BigDecimal;

/**
 * This class stores the individual items
 * coupled with their price and stock levels.
 *
 * @author david
 */
public class Item {

  private final int id;
  private String itemName;
  private BigDecimal itemPrice;
  private int inventoryLevel;

  private int quantitySelected;

  public Item(String name, BigDecimal price, int inventory) {
    this.itemName = name;
    this.itemPrice = price;
    this.inventoryLevel = inventory;
    this.id = (int) (Math.random() * 500) + 1;

  }

  /**
   * This method retrieves the id of the item of the object.
   *
   * @return the id of the item
   */
  public int getId() {
    return id;
  }

  /**
   * This method retrieves the item name of the object.
   *
   * @return the item name
   */
  public String getItemName() {
    return itemName;
  }

  /**
   *  This method sets the item name of the object.
   *
   * @param itemName the new item name
   */
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  /**
   * This method gets the item price of the object.
   *
   * @return the item price
   */
  public BigDecimal getItemPrice() {
    return itemPrice;
  }

  /**
   *  This method sets the item price of the object.
   *
   * @param itemPrice the item price.
   */
  public void setItemPrice(BigDecimal itemPrice) {
    this.itemPrice = itemPrice;
  }

  /**
   * This method gets the inventory level of the item object.
   *
   * @return the inventory level
   */
  public int getInventoryLevel() {
    return inventoryLevel;
  }

  /**
   * This method sets the inventory level of the item object.
   *
   * @param inventoryLevel the inventory level
   */
  public void setInventoryLevel(int inventoryLevel) {
    this.inventoryLevel = inventoryLevel;
  }

  /**
   * This method gets the quantity of the item selected.
   *
   * @return the quantity of the item selected
   */
  public int getQuantitySelected() {
    return quantitySelected;
  }


  /**
   * This method sets the quantity of the item selected.
   *
   * @param quantitySelected the number of the item selected
   */
  public void setQuantitySelected(int quantitySelected) {
    this.quantitySelected = quantitySelected;

    if (quantitySelected <= 0) {
      Transaction.transactionItems.remove(this);
    }
  }
}
