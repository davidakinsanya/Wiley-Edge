package com.example.blog.dto;

/**
 * This class models the data held with an individual blog post.
 *
 * @author david
 */
public class Post {
  private String date;
  private String post;

  private String title;
  private int id;

  public Post(int id, String title, String post, String date) {
    this.id = id;
    this.title = title;
    this.post = post;
    this.date = date;
  }

  public Post(String title, String post, String date) {
    this.title = title;
    this.date = date;
    this.post = post;
  }

  /**
   * This method gets the id of a blog post.
   *
   * @return the numeric id of the blog post
   */
  public int getId() {
    return id;
  }

  /**
   *  This method gets the date of a blog post
   *
   * @return the blog post date
   */
  public String getDate() {
    return date;
  }

  /**
   * This method sets the date of a blog post.
   *
   * @param date the blog post date
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * This method gets the content of a blog post.
   *
   * @return the blog post content
   */
  public String getPost() {
    return post;
  }

  /**
   * This method sets the content of a blog post.
   *
   * @param post the blog post content
   */
  public void setPost(String post) {
    this.post = post;
  }

  /**
   * This method gets the title of a blog post.
   *
   * @return the blog post title
   */
  public String getTitle() {
    return title;
  }

  /**
   * This method sets the title of a blog post.
   *
   * @param title the blog post title
   */
  public void setTitle(String title) {
    this.title = title;
  }
}
