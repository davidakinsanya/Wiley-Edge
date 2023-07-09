package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides the main functionality for the library.
 *
 * @author david
 */
public class LibraryActionsImpl implements LibraryActions {
  private final static List<DVD> libraryList = new ArrayList<>();

  public LibraryActionsImpl() {}

  /**
   * This method gets a copy of the DVD library.
   *
   * @return a list of DVDs in the library
   */
  @Override
  public List<DVD> getLibraryList() {
    return libraryList;
  }

  /**
   * This method runs when the library first starts.
   */
  @Override
  public void startLibrary() {
    try {
      DVDFileIO reader = new DVDFileIO();
      reader.readFile();
    } catch (IOException e) {
      System.out.println("...");
    }
  }

  /**
   * This method runs when the user wants
   * to save the library to file.
   */
  @Override
  public void saveLibrary() {
    try {
      DVDFileIO writer = new DVDFileIO();
      writer.writeFile();
    } catch (IOException e) {
      System.out.println("...");
    }
  }

  /**
   * This method retrieves the size of the library.
   *
   * @return the number of DVDs in the library
   */
  @Override
  public int getSize() {
    return libraryList.size();
  }

  /**
   * This method adds a new DVD to the library.
   *
   * @param newDVD a newly created DVD object
   * @return whether the DVD has been added successfully
   */
  @Override
  public boolean addDVD(DVD newDVD) {
    int size = this.getSize();
    libraryList.add(newDVD);
    int size1 = this.getSize();

    return size1-size == 1;
  }

  /**
   * This method deletes a DVD from the library.
   *
   * @param id  the id of the DVD the user wants to delete
   * @return whether the DVD has been removed successfully
   */
  @Override
  public boolean removeDVD(int id) {
    int size = this.getSize();
    libraryList.removeIf(d -> d.getId() == id);
    int size1 = this.getSize();

    return size1-size == 1;
  }

  /**
   * This method prints out the entire DVD list.
   */
  @Override
  public void printDVDs() {
    System.out.println("DVDs in library: ");
    for (DVD d: libraryList) {
      System.out.println(d.toString());
    }
    System.out.println("\n");
  }

  /**
   * This method prints out a single DVD.
   *
   * @param id the id of the DVD the user wants to print
   */
  @Override
  public void printDVD(int id) {
      System.out.println("\n");
      for (DVD d: libraryList) {
        if (d.getId() == id) {
          System.out.println(d.toString() + "\n");
          return;
        }
      }
      System.out.println("DVD was not found ..\n");
  }

  /**
   * This method searches a DVD by title.
   *
   * @param title the title of the DVD the user wants to search
   * @return the DVD object corresponding to the title
   */
  @Override
  public DVD searchDVDByTitle(String title) {
    for (DVD d: libraryList) {
      if (d.getTitle().equals(title)) {
        System.out.println("\nYour search found (1) DVD.. \n" + d + "\n");
        return d;
      }
    }

    System.out.println("\nYour search found no DVDs.. \n");
    return null;
  }

  /**
   * This method retrieves a DVD by id.
   *
   * @param id the id of the DVD the user wants to retrieve
   * @return the DVD object corresponding to the id
   */
  @Override
  public DVD getDVDById(int id) {
    for (DVD d: libraryList) {
      if (d.getId() == id) {
        return d;
      }
    }
    return null;
  }

  /**
   * This method creates a new DVD object.
   *
   * @return the newly created DVD object
   */
  @Override
  public DVD createDVD() {
    DVD dvd = new DVD( 0, "", "", 0, "", "", "");
    System.out.print("Enter the new title: ");
    dvd.setTitle(scString.nextLine());

    System.out.print("Enter the DVDs new age rating: ");
    dvd.setAge(scInt.nextInt());

    System.out.print("Enter the DVDs release date: ");
    dvd.setDate(scString.nextLine());

    System.out.print("Enter the DVDs director: ");
    dvd.setDirector(scString.nextLine());

    System.out.print("Enter the DVDs studio: ");
    dvd.setStudio(scString.nextLine());

    System.out.print("Enter commentary for the DVD: ");
    dvd.setCommentary(scString.nextLine());
    System.out.println("\n");
    return dvd;
  }

  /**
   * This method edits a portion of a DVD object.
   *
   * @param dvd the DVD object the user wants to edit
   */
  @Override
  public void editDVD(DVD dvd) {
    if (dvd != null) {
      String category = "\n1. Title \n2. Age Rating \n3. Date \n4. Director \n5. Studio \n6. Commentary";
      System.out.println("\nPress numbers 1-6 to pick the part of the DVD you want to change: ");
      System.out.print(category);
      System.out.print("\n: ");
      int num = scInt.nextInt();

      if (num >= 1 && num <= 6) {
        switch (num) {
          case 1:
            System.out.println("The current title for this DVD is + " + dvd.getTitle());
            System.out.print("Enter the new title: ");
            dvd.setTitle(scString.nextLine());
            break;
          case 2:
            System.out.println("The current age rating for this DVD is + " + dvd.getAge());
            System.out.print("Enter the new age rating: ");
            dvd.setAge(scInt.nextInt());
            break;
          case 3:
            System.out.println("The current date for this DVD is + " + dvd.getDate());
            System.out.print("Enter the new date: ");
            dvd.setDate(scString.nextLine());
            break;
          case 4:
            System.out.println("The current director for this DVD is + " + dvd.getDirector());
            System.out.print("Enter the new director: ");
            dvd.setDirector(scString.nextLine());
            break;
          case 5:
            System.out.println("The current studio for this DVD is + " + dvd.getStudio());
            System.out.print("Enter the new studio: ");
            dvd.setStudio(scString.nextLine());
          case 6:
            System.out.println("The current commentary for this DVD is + " + dvd.getCommentary());
            System.out.print("Enter the new commentary: ");
            dvd.setCommentary(scString.nextLine());
            break;
        }
      } else {
        System.out.println("\nChoose a number between 1 and 5 " +
                "to indicate what part of the DVD you want to edit\n");

        editDVD(dvd);

      }
    } else {
      System.out.println("\nYour DVD has not been found..");
    }
  }
}
