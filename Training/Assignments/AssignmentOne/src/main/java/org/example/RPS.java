package org.example;

import java.util.Scanner;

public class RPS {
  public static void compareRock(String option, int[] score) {
    // Method assesses the instance of the user selecting rock
    // And the CPU has entered a unique option

    if (option.equals("scissors")) {
      System.out.println("User wins round...");
      score[0]++;
    } else {
      System.out.println("CPU wins round...");
      score[1]++;
    }
  } // End of method
  public static void comparePaper(String option, int[] score) {
    // Method assesses the instance of the user selecting paper
    // And the CPU has entered a unique option

    if (option.equals("rock")) {
      System.out.println("User wins round...");
      score[0]++;
    } else {
      System.out.println("CPU wins round...");
      score[1]++;
    }
  } // End of method
  public static void compareScissors(String option, int[] score) {
    // Method assesses the instance of the user selecting scissors
    // And the CPU has entered a unique option

    if (option.equals("paper")) {
      System.out.println("User wins round...");
      score[0]++;
    } else {
      System.out.println("CPU wins round...");
      score[1]++;
    }
  } // End of method
  public static void gameLogic(String user, String cpu, int[] score) {
    // Method to control the games decision-making
    // as well as managing the score.

    switch (user) {
      case "rock":
        compareRock(cpu, score);
        break;
      case "paper":
        comparePaper(cpu, score);
        break;
      case "scissors":
        compareScissors(cpu, score);
        break;
    }
  } // End of method

  public static void getWinner(int[] score) {
    // Decision-making logic to reveal the winner

    if (score[0] > score[1]) {
      System.out.println("User wins.");
    } else if (score[0] < score[1]) {
      System.out.println("CPU wins.");
    } else {
      System.out.println("Draw.");
    }
    System.out.println("\n");
  } // End of method

  public static boolean endSequence(int[] score) {
    // Asking the user if they want to play another round

    Scanner scanner = new Scanner(System.in);
    String yesOrNo;
    System.out.println("Final Score:\nUser: " + score[0] + " CPU: " + score[1] + " Tie: " + score[2]);
    getWinner(score);
    System.out.print("Thanks for playing! Press 'y' to play again or any other key to exit the game: ");
    yesOrNo = scanner.next();
    if (yesOrNo.equals("y")) {
      System.out.println("\n");
      return true;
    }
    return false;
  } // End of method

  public static void main(String[] args) {
    String[] options = {"rock", "paper", "scissors"};
    int[] score = {0, 0, 0};
    int rounds = 3;
    int roundCount = 1;

    String optionsString = "rock paper scissors";
    String userOption;
    Scanner getUserOption = new Scanner(System.in);


    while (rounds != 0) {
      System.out.println("Round: " + roundCount);
      System.out.print("Rock, Paper or Scissors?: ");
      userOption = getUserOption.next().toLowerCase();
      String computerOption = options[(int) (Math.random() * 2)]; // generating a random selection for CPU.

      if (optionsString.contains(userOption)) { // check for correct input

        if (!userOption.equals(computerOption)) { // check for a draw
          gameLogic(userOption, computerOption, score);
        } else {
          System.out.println("Round ended in a draw..");
          score[2]++;
        }

        System.out.println("User: " + score[0] + " CPU: " + score[1] + " Tie: " + score[2] + "\n");

      } else {
        System.out.println("You must pick from 'Rock', 'Paper' or 'Scissors'!\n"); // Error statement
        rounds++; // increment resets the round because of error
      }

      rounds--;
      roundCount++;

      if (rounds == 0) { // resetting the game at the end of the last round if the user wants to play again
        if(endSequence(score)) {
          rounds = 3; roundCount = 1;
          score[0] = 0; score[1] = 0; score[2] = 0;
        }
      }
    } // End of loop

  } // End of main
} // End of class
