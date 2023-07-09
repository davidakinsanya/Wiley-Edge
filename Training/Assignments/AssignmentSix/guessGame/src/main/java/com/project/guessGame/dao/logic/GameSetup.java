package com.project.guessGame.dao.logic;

import com.project.guessGame.dao.db.GuessGameDAO;
import com.project.guessGame.dto.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This method sets up shared variables for each game.
 *
 * @author david
 */
public class GameSetup {

  public static int[] cpuNumbers = new int[4];
  public static int gameId;


  public static int noOfGuesses = 0;

  public static List<Game> completedGames = new ArrayList<>();
  public static Difficulty gameDiff = Difficulty.EASY;

  /**
   * This method generate the games ID.
   *
   * @param db an object establishing a database connection to check the IDs.
   * @return the id of the game
   */
  public int generateId(GuessGameDAO db) {
    int id = (int)(Math.random() * 50) + 1;
    if (db.getAllGameIds().contains(id)) return generateId(db);
    return id;
  }

  /**
   * This method generates the CPU unique numbers at the beginning of the game.
   */
  public void getCPUNumbers() {
    cpuNumbers = new int[] {1,2,3,4};
    for (int i = 0; i < cpuNumbers.length; i++) {
     int num = (int)(Math.random() * 9) + 1;
     if (uniqueCheck(num, cpuNumbers)) {
       cpuNumbers[i] = num;
     } else {
       i--;
     }
    }
  }

  /**
   * This method checks whether each value in the CPU guess is unique.
   *
   * @param num a randomly generated number
   * @param numArr the cpu guess
   * @return whether the number is contained within the cpu guess array
   */
  public boolean uniqueCheck(int num, int[] numArr) {
    return !Arrays.toString(numArr).contains(Integer.toString(num));
  }
}
