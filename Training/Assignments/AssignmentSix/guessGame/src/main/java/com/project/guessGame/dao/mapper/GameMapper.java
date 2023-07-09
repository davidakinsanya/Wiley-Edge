package com.project.guessGame.dao.mapper;

import com.project.guessGame.dto.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class GameMapper implements RowMapper<Game> {

  @Override
  public Game mapRow(ResultSet rs, int index) throws SQLException {
    return new Game(
            rs.getInt("gameId"),
            rs.getString("answer"),
            rs.getInt("guessesUsed"),
            rs.getString("difficulty"),
            rs.getBoolean("gameWon")
    );
  }

}
