package com.project.guessGame.controller;

import com.project.guessGame.dao.db.GuessGameDAO;
import com.project.guessGame.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class accepts all the GET requests within the REST API.
 *
 * @author david
 */
@RestController
@RequestMapping("/")
public class GetMappings {

  private GuessGameDAO dao;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method gets all the game objects from the database.
   *
   * @return a list of all the game object in the database
   */
  @GetMapping("/game")
  public List<Game> getAll() {
    dao = new GuessGameDAO(jdbcTemplate);
    return dao.getAll();
  }

  /**
   * This method gets a single game from the database by their id.
   *
   * @param gameId the id of the desired game
   * @return the game object identified by the id.
   */
  @GetMapping("/game/{gameId}")
  public Game getGameById(@PathVariable int gameId) {
    dao = new GuessGameDAO(jdbcTemplate);
    return dao.getGameById(gameId);
  }

}
