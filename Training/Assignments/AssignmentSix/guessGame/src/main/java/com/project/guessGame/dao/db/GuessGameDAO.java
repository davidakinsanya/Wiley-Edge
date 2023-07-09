package com.project.guessGame.dao.db;

import com.project.guessGame.dao.mapper.GameMapper;
import com.project.guessGame.dao.mapper.IDMapper;
import com.project.guessGame.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GuessGameDAO implements GuessGame {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public GuessGameDAO(JdbcTemplate temp) {
    this.jdbcTemplate = temp;
  }

  /**
   * This method gets all the game objects from the database.
   *
   * @return a list of all the game object in the database
   */
  @Override
  public List<Game> getAll() {
    final String sql = "SELECT * FROM Game";

    return jdbcTemplate.query(sql, new GameMapper());
  }

  /**
   * This method adds a completed game to the database.
   *
   * @param game the completed game
   * @return whether any rows affected after the query
   */
  @Override
  @Transactional
  public boolean addCompletedGame(Game game) {

    final String sql = "INSERT INTO Game VALUES" +
            "(?, ?, ?, ?, ?)";

    return jdbcTemplate.update(sql, game.getGameId(),
            game.getAnswer(),
            game.getGuessesUsed(),
            game.getDifficulty(),
            game.isGameWon()) > 0;
  }

  /**
   * This method gets a single game from the database by their id.
   *
   * @param id the id of the desired game
   * @return the game object identified by the id.
   */
  @Override
  public Game getGameById(int id) {
    final String sql = "SELECT * FROM Game WHERE gameId = " + id;
    return jdbcTemplate.queryForObject(sql, new GameMapper());
  }

  /**
   * This method deletes a single game from the database by their id.
   *
   * @param id the id of the desired game
   * @return whether any rows affected after the query
   */
  @Override
  public boolean deleteGameById(int id) {
    final String sql = "DELETE FROM Game WHERE gameId = " + id;
    return jdbcTemplate.update(sql) > 0;
  }

  /**
   * This method gets all the game IDs from the database.
   *
   * @return a list of all the game IDs.
   */
  @Override
  public List<Integer> getAllGameIds() {
    final String sql = "SELECT gameId FROM Game";
    return jdbcTemplate.query(sql, new IDMapper());
  }
}
