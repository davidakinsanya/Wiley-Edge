package org.example;

/**
 * This class runs the DVD library.
 */
public class Controller {
  public static void main(String[] args) {
    System.out.println("Welcome to the DVD Library!");
    LibraryView view = new LibraryView();
    view.run();
  }
}