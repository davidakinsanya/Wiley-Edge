package com.project.guessGame.dao.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class IDMapper implements RowMapper<Integer> {
  @Override
  public Integer mapRow(ResultSet rs, int index) throws SQLException {
    return rs.getInt("gameId");
  }
}


