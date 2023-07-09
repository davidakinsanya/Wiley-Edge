package com.example.blog.dao.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IDMapper implements RowMapper<Integer> {
  @Override
  public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
    return rs.getInt("PostID");
  }
}
