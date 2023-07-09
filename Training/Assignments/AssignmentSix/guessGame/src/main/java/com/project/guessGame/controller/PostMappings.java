package com.project.guessGame.controller;

import com.project.guessGame.dao.db.GuessGameDAO;
import com.project.guessGame.dao.logic.Difficulty;
import com.project.guessGame.dao.logic.GameSetup;
import com.project.guessGame.dao.logic.Service;
import com.project.guessGame.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.HttpConstraint;
import java.util.Arrays;

/**
 * This class accepts all the POST requests within the REST API.
 *
 * @author david
 */
@RestController
@RequestMapping("/")
public class PostMappings {

  private Service service;
  private GuessGameDAO dao;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // http://localhost:8080/begin?difficulty=easy
  // http://localhost:8080/guess?guess1=1&guess2=2&guess3=3&guess4=4&gameId=42


  /**
   * This method initiates the start of the game.
   *
   * @param difficulty the difficulty the user wants to play at
   * @return the game id of the new game
   */
  @PostMapping("/begin")
  public String startGame(String difficulty) {
    dao = new GuessGameDAO(jdbcTemplate);
    service = new Service(dao);


    if (difficulty.toLowerCase().equals("hard")) {
      GameSetup.gameDiff = Difficulty.HARD;
    }
    service.getCPUNumbers();
    GameSetup.gameId = service.generateId();
    return "201: GameId: " + GameSetup.gameId;

  }

  /**
   *  This method processes the users guess.
   *
   * @param guess1 the users first guess
   * @param guess2 the users second guess
   * @param guess3 the users third guess
   * @param guess4 the users fourth guess
   * @param gameId the game id
   * @return a string representing the accuracy of the guess
   */
  @PostMapping("/guess")
  public String initiateGuess(int guess1, int guess2,
                              int guess3, int guess4,
                              int gameId) {
    if (service != null) {
      if (GameSetup.noOfGuesses <= 10) {
        int[] compareArr = {guess1, guess2, guess3, guess4};
        GameSetup.noOfGuesses++;
        return service.guessLogic(compareArr, gameId);
      }
      dao.addCompletedGame(new Game(gameId, Arrays.toString(GameSetup.cpuNumbers), GameSetup.noOfGuesses, GameSetup.gameDiff.name(), true));
      service = null;
      return "You ran out of guesses and lost, the results of your game have been saved!";
    }
    return "Please enter the POST request http://localhost:8080/begin?difficulty=easy To start the game on easy mode.";
  }
}
