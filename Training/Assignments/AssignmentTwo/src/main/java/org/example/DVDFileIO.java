package org.example;

import java.io.*;

/**
 * This class stores all the DVD reading and writing operations.
 *
 * @author david
 */
public class DVDFileIO {

  private BufferedReader buffer;

  private BufferedWriter writer;

  private final LibraryActionsImpl library = new LibraryActionsImpl();

  public DVDFileIO() throws FileNotFoundException {
    try {
      File file1 = new File("dvd.txt");
      FileReader reader = new FileReader(file1);
      this.buffer = new BufferedReader(reader);
    } catch (FileNotFoundException f) {
      System.out.println("dvd.txt" + " Does not exist...");
    }
  }

  /**
   * This method reads a text file with DVD information inside.
   *
   * @throws IOException thrown when the reader can't read the file
   */
  public void readFile() throws IOException {
    String dvd;
    String[] dvdArray;
    try {
      while ((dvd = buffer.readLine()) != null) {
        dvdArray = dvd.split(",");
        library.addDVD(getDVDObject(dvdArray));
      }
    } catch (IOException e) {
      System.out.println("No line was read..");
    } finally {
      buffer.close();
    }
  }

  /**
   * This method writes a text file with DVD information in string format.
   *
   * @throws IOException thrown when the writer can't write to file
   */
  public void writeFile() throws IOException {
    String fileContent = fileString();
    String fileName = "dvd.txt";
    try {
      writer = new BufferedWriter(new FileWriter(fileName));
      writer.write(fileContent);
      System.out.println("Library saved as: " + fileName);
    } catch (IOException e) {
      System.out.println("Empty file ..");
    } finally {
      writer.flush();
      writer.close();
    }
  }

  /**
   * This method reconstructs the DVD object, so they can be written to file.
   *
   * @return a string containing all the DVDs separated by comma
   */
  public String fileString() {
    String str = "";

    for (DVD d: library.getLibraryList()) {
      str += d.getTitle() + "," + d.getDate() + "," +
              d.getAge() + "," + d.getDirector() + "," +
              d.getStudio() + "," + d.getCommentary() + "\n";
    }
    return str;
  }

  /**
   * This method creates a DVD object from a line in the text file.
   *
   * @param arr DVD information in array format
   * @return a DVD object
   */
  public DVD getDVDObject(String[] arr) {
    int id = (int) (Math.random()*1000) + 1;
   return new DVD(id, arr[0],arr[1],
            Integer.parseInt(arr[2]),
            arr[3], arr[4], arr[5]);
  }
}
