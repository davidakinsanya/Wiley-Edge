package com.example.blog.dao;

import com.example.blog.dao.mapper.IDMapper;
import com.example.blog.dao.mapper.PostMapper;
import com.example.blog.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * This interface implements all the interactions between
 * the web application and database involving blog posts.
 *
 * @author david
 */
public class PostDAOImpl implements PostDAO {

  @Autowired
  public JdbcTemplate jdbcTemplate;

  public PostDAOImpl(JdbcTemplate temp) {
    this.jdbcTemplate = temp;
  }

  /**
   * This method retrieves a specific blog post.
   *
   * @param id the id of the blog post
   * @return an object representing the blog post
   */
  @Override
  public Post getPostById(int id) {
    final String sql = "SELECT * FROM Post WHERE postID = ?";
    return jdbcTemplate.queryForObject(sql, new PostMapper(), id);
  }

  /**
   * This method gets all the blog posts held in the database.
   *
   * @return a list of blog post objects
   */
  @Override
  public List<Post> getAllPosts() {
    final String sql = "SELECT * FROM Post";
    return jdbcTemplate.query(sql, new PostMapper());
  }

  /**
   * This method gets all the blog posts IDs held in the database.
   *
   * @return a list of blog post IDs
   */
  @Override
  public List<Integer> getPostIDs() {
    final String sql = "SELECT postID FROM Post";
    return jdbcTemplate.query(sql, new IDMapper());
  }

  /**
   * This method creates a blog post and adds it to the database.
   *
   * @param post a new blog post
   * @return whether the database update was successful
   */
  @Override
  public boolean createPost(Post post) {
    final String sql = "INSERT INTO Post (title, blogPost, blogDate) VALUES (?,?,?)";
    return jdbcTemplate.update(sql, post.getTitle(), post.getPost(), post.getDate()) > 0;
  }

  /**
   * This method updates an existing blog post.
   *
   * @param post an existing blog post
   * @return whether the database update was successful
   */
  @Override
  public boolean updatePost(Post post) {
    final String sql = "UPDATE Post " +
                       "SET title = ? , " +
                       " blogPost = ? , " +
                       "blogDate = ? " +
                       "WHERE postID = ?";

    return jdbcTemplate.update(sql, post.getTitle(),
                                    post.getPost(),
                                    post.getDate(),
                                    post.getId()) > 0;
  }

  /**
   * This method deletes an existing blog post.
   *
   * @param id the id of the existing blog post
   * @return whether the database update was successful
   */
  @Override
  public boolean deletePost(int id) {
    final String sql = "DELETE FROM Post WHERE PostID = ?";
    return jdbcTemplate.update(sql, id) > 0;
  }
}
