package com.project.guessGame.dao.logic;

import java.util.Arrays;

/**
 * This class sets up the guess logic to process each guess.
 *
 * @author david
 */
public class GuessLogic {

  public String[] exactPartial;

  /**
   * This method checks whether the users guess and the CPU guess are equal.
   *
   * @param userNumbers the users guess
   * @return whether the users guess is equal to the CPU guess
   */
  public boolean arrayEquals(int[] userNumbers) {
    return Arrays.toString(GameSetup.cpuNumbers).equals(Arrays.toString(userNumbers));
  }

  /**
   * This method checks if a number is contained within the CPU guess.
   * @param number the number in the users guess
   * @return whether the number is contained within the users guess
   */
  public boolean numberIsInclusive(int number) {
    return Arrays.stream(GameSetup.cpuNumbers).anyMatch(n -> n == number);
  }

  /**
   * This method controls parts of the guess logic in comparing the user guess with the CPU.
   *
   * @param userNumbers the users guess
   * @return a string representing the accuracy of the guess
   */
  public String compareGuess(int[] userNumbers) {
    this.exactPartial = new String[]{" x ", " x ", " x ", " x "};
    int exact = 0;
    int partial = 0;
    int correct = 0;
    for (int i = 0; i < userNumbers.length; i++) {
      if (numberIsInclusive(userNumbers[i])) {
        correct = 1;
        if (userNumbers[i] == GameSetup.cpuNumbers[i]) {
         exactPartial[i] = " E " ;
         exact++;
        } else {
          partial++;
          exactPartial[i] = " P ";
        }
      }
    }
    if (GameSetup.gameDiff == Difficulty.EASY) {
      return Arrays.toString(exactPartial);
    }
    return "Exact: " + exact + " Partial: " + partial;
  }
}
