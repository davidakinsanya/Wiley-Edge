package com.project.guessGame.dto;

/**
 * This class captures each of the completed game.
 *
 * @author david
 */
public class Game {
  private int gameId;
  private String answer;
  private int guessesUsed;
  private String difficulty;
  private boolean gameWon;

  public Game(int id, String ans, int guess, String diff, boolean won) {
    this.gameId = id;
    this.answer = ans;
    this.guessesUsed = guess;
    this.difficulty = diff;
    this.gameWon = won;
  }

  /**
   * This method gets the answer of the game.
   *
   * @return the answer of the game
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * This method sets the answer of the game.
   *
   * @param answer the answer of the game
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  /**
   * This method retrieves the status of whether the game has been won.
   *
   * @return whether the game has been won
   */
  public boolean isGameWon() {
    return gameWon;
  }

  /**
   * This method sets the status of whether the game has been won.
   *
   * @param gameWon the status of whether the game has been won
   */
  public void setGameWon(boolean gameWon) {
    this.gameWon = gameWon;
  }

  /**
   * This method gets the games ID number.
   *
   * @return the games ID number
   */
  public int getGameId() {
    return gameId;
  }

  /**
   * This method sets the games ID number.
   *
   * @param gameId the games ID number
   */
  public void setGameId(int gameId) {
    this.gameId = gameId;
  }

  /**
   * This method gets the games' difficulty level.
   *
   * @return the games' difficulty level
   */
  public String getDifficulty() { return difficulty; }

  /**
   * This method sets the games' difficulty level.
   *
   * @param difficulty the games' difficulty level
   */
  public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

  /**
   * This method gets the number of guesses used.
   * @return the number of guesses used
   */
  public int getGuessesUsed() { return guessesUsed; }

  /**
   * This method sets the number of guesses used.
   *
   * @param guessesUsed the number of guesses used
   */
  public void setGuessesUsed(int guessesUsed) { this.guessesUsed = guessesUsed; }
}
