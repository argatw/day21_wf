package vttp2022.paf.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp2022.paf.day21.models.Comment;
import vttp2022.paf.day21.models.Game;
import vttp2022.paf.day21.repositories.GameRepo;

@SpringBootTest
class Day21ApplicationTests {

	@Autowired
	private GameRepo gameRepo;

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt = gameRepo.getGameById(10);

		assertTrue(opt.isPresent());
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt = gameRepo.getGameById(10000);

		assertFalse(opt.isPresent(), "gid-10000");
	}

	@Test
	void shouldReturn42Comments() {
		// List<Comment> results = GameRepo.getCommentsByGid();
		List<Comment> results = gameRepo.getCommentsByGid(10);

		assertEquals(42, results.size(), "number of comments for gid=10 is 42");
	}

}
