package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * This interface outlines the main action of the library.
 *
 * @author david
 */
public interface LibraryActions {

  Scanner scInt = new Scanner(System.in);
  Scanner scString = new Scanner(System.in);

  /**
   * This method gets a copy of the DVD library.
   *
   * @return a list of DVDs in the library
   */
  List<DVD> getLibraryList();

  /**
   * This method runs when the library first starts.
   */
  void startLibrary();

  /**
   * This method runs when the user wants
   * to save the library to file.
   */
  void saveLibrary();

  /**
   * This method retrieves the size of the library.
   *
   * @return the number of DVDs in the library
   */
  int getSize();

  /**
   * This method adds a new DVD to the library.
   *
   * @param newDVD a newly created DVD object
   * @return whether the DVD has been added successfully
   */
  boolean addDVD(DVD newDVD);

  /**
   * This method deletes a DVD from the library.
   *
   * @param id  the id of the DVD the user wants to delete
   * @return whether the DVD has been removed successfully
   */
  boolean removeDVD(int id);

  /**
   * This method prints out the entire DVD list.
   */
  void printDVDs();

  /**
   * This method prints out a single DVD.
   *
   * @param id the id of the DVD the user wants to print
   */
  void printDVD(int id);

  /**
   * This method searches a DVD by title.
   *
   * @param title the title of the DVD the user wants to search
   * @return the DVD object corresponding to the title
   */
  DVD searchDVDByTitle(String title);

  /**
   * This method retrieves a DVD by id.
   *
   * @param id the id of the DVD the user wants to retrieve
   * @return the DVD object corresponding to the id
   */
  DVD getDVDById(int id);

  /**
   * This method creates a new DVD object.
   *
   * @return the newly created DVD object
   */
  DVD createDVD();

  /**
   * This method edits a portion of a DVD object.
   *
   * @param dvd the DVD object the user wants to edit
   */
  void editDVD(DVD dvd);
}
