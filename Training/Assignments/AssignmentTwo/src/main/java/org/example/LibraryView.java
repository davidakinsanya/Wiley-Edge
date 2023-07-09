package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * This class controls the user interaction within the DVD library.
 *
 * @author david
 */
public class LibraryView implements LibraryActions {
  private final LibraryActionsImpl libraryImpl = new LibraryActionsImpl();
  private final Scanner menuSelector = new Scanner(System.in);

  public LibraryView() {
    this.startLibrary();
  }

  /**
   * This method runs the library view.
   */
  public void run () {
    int num = menu();
    while (options(num) == 1) { // if the user wants to use the library again.
      System.out.println("\n");
      num = menu(); // The user uses the library and asked to enter '1' if the user wants to continue.
      System.out.println("\n");
    }
    this.saveLibrary();
  }

  /**
   * This method acts as the main menu prompting
   * the user to access the library functionality.
   *
   * @return the number representing what function the user wants the library to perform
   */
  public int menu() {
    System.out.println("How can we help? Choose 1-6: ");
    System.out.println("1. Add a DVD. \n" +
                       "2. Remove a DVD. \n" +
                       "3. View a DVD. \n" +
                       "4. Edit a DVD. \n" +
                       "5. View DVD Collection. \n" +
                       "6. Search DVD by Title. \n" +
                       "7. Exit. ");

    System.out.print("\n: ");
    return menuSelector.nextInt();

  }


  /**
   *  This method holds the logic to navigate what
   *  specific function the user wants to perform
   *  within the library.
   *
   * @param menu the number representing what function the user wants the library to perform
   * @return the number representing whether the user wants to continue
   */
  public int options (int menu) {
    System.out.println("\n");
    switch (menu) {
      case 1:
        this.addDVD(this.createDVD());
        break;
      case 2:
        System.out.println("Select the ID of the DVD you want to delete. The IDs are: ");
        for (DVD d : libraryImpl.getLibraryList()) {
          System.out.println(d.getId() + ": " + d.getTitle() );
        }
        System.out.print("\n: ");
        this.removeDVD(scInt.nextInt());
        break;
      case 3:
        System.out.println("Select the ID of the DVD you want to view. The IDs are: ");
        IdWithTitle();
        this.printDVD(scInt.nextInt());
        break;
      case 4:
        System.out.println("Select the ID of the DVD you want to edit. The IDs are: ");
        IdWithTitle();
        this.editDVD(this.getDVDById(scInt.nextInt()));
        break;
      case 5:
        this.printDVDs();
        break;
      case 6:
        System.out.println("Enter the title of the DVD you want to view. Here are the list of titles: ");
        IdWithTitle();
        this.searchDVDByTitle(scString.nextLine());
        break;
      case 7:
        return -1;
      default:
        System.out.println("Choose a number between 1 and 7 as prompted..");
        return 1;
    }

    System.out.print("Press '1' to continue using the DVD Library or any other key to save and quit: ");
    return scInt.nextInt();
  }

  /**
   * This method provides the options' menu with the DVD titles alongside their IDs.
   */
  public void IdWithTitle() {
    for (DVD d : libraryImpl.getLibraryList()) {
      System.out.println(d.getId() + ": " + d.getTitle());
    }
    System.out.print("\n: ");
  }


  /**
   * This method gets a copy of the DVD library.
   *
   * @return a list of DVDs in the library
   */
  @Override
  public List<DVD> getLibraryList() { return libraryImpl.getLibraryList(); }

  /**
   * This method runs when the library first starts.
   */
  @Override
  public void startLibrary() { libraryImpl.startLibrary(); }

  /**
   * This method runs when the user wants
   * to save the library to file.
   */
  @Override
  public void saveLibrary() { libraryImpl.saveLibrary(); }

  /**
   * This method retrieves the size of the library.
   *
   * @return the number of DVDs in the library
   */
  @Override
  public int getSize() { return libraryImpl.getSize(); }

  /**
   * This method adds a new DVD to the library.
   *
   * @param newDVD a newly created DVD object
   * @return whether the DVD has been added successfully
   */
  @Override
  public boolean addDVD(DVD newDVD) {  return libraryImpl.addDVD(this.createDVD()); }

  /**
   * This method deletes a DVD from the library.
   *
   * @param id  the id of the DVD the user wants to delete
   * @return whether the DVD has been removed successfully
   */
  @Override
  public boolean removeDVD(int id) { return libraryImpl.removeDVD(id); }

  /**
   * This method prints out the entire DVD list.
   */
  @Override
  public void printDVDs() { libraryImpl.printDVDs(); }

  /**
   * This method prints out a single DVD.
   *
   * @param id the id of the DVD the user wants to print
   */
  @Override
  public void printDVD(int id) { libraryImpl.printDVD(id); }

  /**
   * This method searches a DVD by title.
   *
   * @param title the title of the DVD the user wants to search
   * @return the DVD object corresponding to the title
   */
  @Override
  public DVD searchDVDByTitle(String title) { return libraryImpl.searchDVDByTitle(title); }

  /**
   * This method retrieves a DVD by id.
   *
   * @param id the id of the DVD the user wants to retrieve
   * @return the DVD object corresponding to the id
   */
  @Override
  public DVD getDVDById(int id) { return libraryImpl.getDVDById(id); }

  /**
   * This method creates a new DVD object.
   *
   * @return the newly created DVD object
   */
  @Override
  public DVD createDVD() { return libraryImpl.createDVD(); }

  /**
   * This method edits a portion of a DVD object.
   *
   * @param dvd the DVD object the user wants to edit
   */
  @Override
  public void editDVD(DVD dvd) { libraryImpl.editDVD(dvd); }
}
