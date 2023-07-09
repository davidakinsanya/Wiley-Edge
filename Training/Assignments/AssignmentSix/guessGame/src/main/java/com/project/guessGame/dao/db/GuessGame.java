package com.project.guessGame.dao.db;

import com.project.guessGame.dto.Game;

import java.util.List;

/**
 * This class outlines the interaction between the API and
 * the database through specific methods.
 *
 * @author david
 */
public interface GuessGame {

  /**
   * This method gets all the game objects from the database.
   *
   * @return a list of all the game object in the database
   */
  List<Game> getAll();

  /**
   * This method adds a completed game to the database.
   *
   * @param game the completed game
   * @return whether any rows affected after the query
   */
  boolean addCompletedGame(Game game);

  /**
   * This method gets a single game from the database by their id.
   *
   * @param id the id of the desired game
   * @return the game object identified by the id.
   */
  Game getGameById(int id);

  /**
   * This method deletes a single game from the database by their id.
   *
   * @param id the id of the desired game
   * @return whether any rows affected after the query
   */
  boolean deleteGameById(int id);

  /**
   * This method gets all the game IDs from the database.
   *
   * @return a list of all the game IDs.
   */
  List<Integer> getAllGameIds();
}
