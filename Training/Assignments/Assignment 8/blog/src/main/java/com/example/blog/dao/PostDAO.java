package com.example.blog.dao;

import com.example.blog.dto.Post;

import java.util.List;

/**
 * This interface outlines all the interactions between
 * the web application and database involving blog posts.
 *
 * @author david
 */
public interface PostDAO {

  /**
   * This method retrieves a specific blog post.
   *
   * @param id the id of the blog post
   * @return an object representing the blog post
   */
  Post getPostById(int id);

  /**
   * This method gets all the blog posts held in the database.
   *
   * @return a list of blog post objects
   */
  List<Post> getAllPosts();

  /**
   * This method gets all the blog posts IDs held in the database.
   *
   * @return a list of blog post IDs
   */
  List<Integer> getPostIDs();

  /**
   * This method creates a blog post and adds it to the database.
   *
   * @param post a new blog post
   * @return whether the database update was successful
   */
  boolean createPost(Post post);

  /**
   * This method updates an existing blog post.
   *
   * @param post an existing blog post
   * @return whether the database update was successful
   */
  boolean updatePost(Post post);

  /**
   * This method deletes an existing blog post.
   *
   * @param id the id of the existing blog post
   * @return whether the database update was successful
   */
  boolean deletePost(int id);
}
