package com.example.blog;

import com.example.blog.dao.PostDAOImpl;
import com.example.blog.dto.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private PostDAOImpl dao;

	@BeforeEach
	public void BeforeEach() { dao = new PostDAOImpl(jdbcTemplate); }

	@Test
	public void TestGetAllPosts() { assertDoesNotThrow(() -> dao.getAllPosts()); }

	@Test
	public void TestCreateNewPost() {
		Post post = new Post("second", "third", "2023/01/02");
		assertDoesNotThrow(() -> dao.createPost(post));
	}

	@Test
	public void TestPostID() {
		assertDoesNotThrow(() -> dao.getPostIDs());
	}

	@Test
	public void TestUpdatePost() {
		Post post = dao.getPostById(dao.getPostIDs().get(0));
		post.setTitle("New Title");

		assertTrue(dao.updatePost(post));
	}

	@Test
	public void DeletePost() { assertDoesNotThrow(() -> dao.deletePost(dao.getPostIDs().get(0)));}

}
