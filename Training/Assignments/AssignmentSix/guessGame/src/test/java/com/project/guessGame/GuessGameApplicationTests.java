package com.project.guessGame;

import com.project.guessGame.dao.db.GuessGameDAO;
import com.project.guessGame.dto.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class tests the methods in the guessGameDao class.
 *
 * @author david
 */
@Repository
@SpringBootTest
class GuessGameApplicationTests {

	private GuessGameDAO dao;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final Game game1 = new Game(99, "[4,5,6,7]", 4, "EASY", true);
	private final Game game2 = new Game(98, "[9,8,4,3]", 6, "EASY", true);
	private final Game game3 = new Game(97, "[1,4,3,8]", 7, "EASY", true);

	@BeforeEach
	public void beforeEach() {
		dao = new GuessGameDAO(jdbcTemplate);
		for (Game game: dao.getAll()) {
			dao.deleteGameById(game.getGameId());
		}
	}

	/**
	 * This test checks whether the program can add a number to the database.
	 */
	@Test
	public void addGame() {
		dao.addCompletedGame(game1);
		assertEquals(dao.getGameById(99).getGameId(), 99);
	}

	/**
	 * This test checks whether the program can delete a number to the database.
	 */
	@Test
	public void deleteGame() {
		dao.deleteGameById(99);
		assertFalse(dao.getAll().contains(game1));
	}

	/**
	 * This test checks whether the program can retrieve all the games
	 * and their IDs from the database.
	 */
	@Test
	public void getAllGames() {
		dao.addCompletedGame(game1);
		dao.addCompletedGame(game2);
		dao.addCompletedGame(game3);
		assertEquals(dao.getAll().size(), 3);
		assertEquals(dao.getAllGameIds().size(),3);
	}
}
