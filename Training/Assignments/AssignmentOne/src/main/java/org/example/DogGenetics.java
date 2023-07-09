package org.example;

import java.util.Scanner;

public class DogGenetics {

  public static void dogRecursion(String[] list,
                                  int dogCounter,
                                  int totalPercentage,
                                  int percentageAssigned) {
    
    if (dogCounter != list.length-1) {
      // Base Case for the first four dogs
      int randomPercentage = (int) (Math.random() * totalPercentage) + 1;
      totalPercentage -= randomPercentage;
      percentageAssigned += randomPercentage;
      System.out.println(list[dogCounter] + ": " + randomPercentage + "%");
      dogCounter++;
      // Recursive step including updated parameters
      dogRecursion(list, dogCounter, totalPercentage, percentageAssigned);
    } else {
      // Special case for the last (or first) dog
      // Ensuring percentages reach 100% by the last (or first) dog
      System.out.println(list[dogCounter] + ": " + (100-percentageAssigned) + "%");
    }

  } // End of method

  public static void main(String[] args) {
    int totalPercentage = 100;
    int percentageCount = 0;
    int dogCounter = 0;

    Scanner enterDog = new Scanner(System.in);
    String dogName;

    String[] dogBreeds = {"St. Bernard",
            "Chihuahua",
            "Dramatic RedNosed Asian Pug",
            "Common Cur",
            "King Doberman"};

    System.out.print("Please start the program by entering your dogs name: ");
    dogName = enterDog.nextLine();
    System.out.println("\nWell, I'm pleased to say that " + dogName + " is an incredible... \n");
    dogRecursion(dogBreeds, dogCounter, totalPercentage, percentageCount);
  } // End of main

} // End of class