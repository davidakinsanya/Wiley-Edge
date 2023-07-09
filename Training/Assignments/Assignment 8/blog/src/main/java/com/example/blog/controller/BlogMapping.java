package com.example.blog.controller;

import com.example.blog.dao.PostDAOImpl;
import com.example.blog.dto.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

/**
 * This method defines all HTTP requests used by the user to interact with the web application.
 *
 * @author david
 */
@Controller
public class BlogMapping {
  private JdbcTemplate jdbcTemplate;
  private PostDAOImpl dao;

  private BlogMapping(JdbcTemplate temp) {
    this.jdbcTemplate = temp;
  }

  /**
   * This method allows the user to create a new post.
   *
   * @param model a Model object allowing for data to be collect from the HTML form
   * @return a redirection to a new HTML page
   */
  @GetMapping("/new_post")
  public String createPost(Model model) {
    Post post = new Post("", "", "");
    model.addAttribute("post", post);
    return "createPost";
  }

  /**
   * This method allows for a new blog entry to be added to the database
   * @param request an object allowing for data to be collect from the HTML form
   * @return a redirection to a new HTML page
   */
  @PostMapping("createNewPost")
  public String createNewPost(HttpServletRequest request) {
    Post post = new Post(request.getParameter("title"),
                        request.getParameter("post"),
                        request.getParameter("date"));

    dao = new PostDAOImpl(jdbcTemplate);
    dao.createPost(post);
    return "redirect:/";
  }

  /**
   * This method allows the user to display blog posts stored in the web application.
   *
   * @param request  an object allowing for data to be collect from a search bar
   * @return a redirection to a new HTML page
   */
  @PostMapping("/blog")
  public String showPost(HttpServletRequest request) {
    return request.getParameter("search");
  }
}
