package org.example.io;

import org.example.dto.Item;
import org.example.dto.Transaction;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all the inventory reading and writing operations.
 *
 * @author david
 */
public class InventoryIO {
  private BufferedReader buffer;
  private BufferedWriter writer;

  public static List<Item> inventory = new ArrayList<>();

  public InventoryIO() {
    try {
      File file1 = new File("inventory.txt");
      FileReader reader = new FileReader(file1);
      this.buffer = new BufferedReader(reader);
    } catch (FileNotFoundException f) {
      System.out.println("inventory.txt" + " Does not exist...");
    }
  }

  /**
   * This method reads a text file with inventory inside.
   *
   * @throws IOException thrown when the reader can't read the file
   */
  public void readFile() throws IOException {
    String itemStr;

    try {
      while ((itemStr = buffer.readLine()) != null) {
        String[] itemArray;
        Item item = new Item("", BigDecimal.valueOf(0), 0);

        itemArray = itemStr.split(",");
        itemArray[1] = itemArray[1].replace("£", "");
        BigDecimal price = new BigDecimal(itemArray[1]);

        item.setItemName(itemArray[0]);
        item.setItemPrice(price);
        item.setInventoryLevel(Integer.parseInt(itemArray[2]));
        addItem(item);
      }
    } catch (IOException e) {
      System.out.println("No line was read..");
    } finally {
      buffer.close();
    }
  }

  /**
   * This method writes a text file with the inventory in string format.
   *
   *  @param filename the filename of the inventory storage
   * @throws IOException thrown when the writer can't write to file
   */
  public void writeFile(String filename) throws IOException {
    String fileContent = fileString();
    try {
      writer = new BufferedWriter(new FileWriter(filename));
      writer.write(fileContent);
      System.out.println("Inventory saved as: " + filename);
    } catch (IOException e) {
      System.out.println("Empty file ..");
    } finally {
      writer.flush();
      writer.close();
    }
  }

  /**
   * This method reconstructs the inventory text file, so they can be written to file.
   *
   * @return a string containing all the inventory items separated by comma
   */
  public String fileString() {
    String str = "";
    for (Item i : InventoryIO.inventory) {
      str += i.getItemName() + ",£" +
              i.getItemPrice() + "," +
              i.getInventoryLevel() + "\n";
    }

    return str;
  }

  /**
   * This method adds an item to the inventory from a line in the text file.
   *
   * @param item an item object.
   */
  public void addItem(Item item) {
    inventory.add(item);
  }
}
