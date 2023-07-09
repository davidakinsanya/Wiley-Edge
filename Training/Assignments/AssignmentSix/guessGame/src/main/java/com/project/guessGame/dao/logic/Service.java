package com.project.guessGame.dao.logic;

import com.project.guessGame.dao.db.GuessGameDAO;
import com.project.guessGame.dto.Game;

import java.util.Arrays;

/**
 * This method is used to connect the API to the rest of
 * the programs' logic at different points.
 *
 * @author david
 */
public class Service {
  private GameSetup game;
  private GuessLogic logic;

  private GuessGameDAO dao;

  public Service(GuessGameDAO db) {
    game = new GameSetup();
    logic = new GuessLogic();
    dao = db;
  }

  /**
   * This method generates the CPU unique numbers at the beginning of the game.
   */
  public void getCPUNumbers() {
    game.getCPUNumbers();
  }

  /**
   * This method generate the games ID.
   *
   * @return the id of the game
   */
  public int generateId() {
    return game.generateId(dao);
  }

  /**
   * This method controls parts of the guess logic in comparing the user guess with the CPU.
   *
   * @param arr the users guess
   * @param id the game ID
   * @return a string representing the accuracy of the guess
   */
  public String guessLogic(int[] arr, int id) {
    if (!logic.arrayEquals(arr)) {
      return logic.compareGuess(arr);
    } else {
      System.out.println("\n");
      GameSetup.completedGames.add(new Game(id, Arrays.toString(GameSetup.cpuNumbers), GameSetup.noOfGuesses, GameSetup.gameDiff.name(), false));
      return "You won, congrats!, the results of your game have been saved!";
    }
  }
}