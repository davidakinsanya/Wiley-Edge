package com.example.blog.dao.mapper;

import com.example.blog.dto.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
  @Override
  public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Post(
            rs.getInt("postID"),
            rs.getString("title"),
            rs.getString("blogPost"),
            rs.getString("blogDate")
    );
  }
}
