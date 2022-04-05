package vttp2022.paf.day21.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.paf.day21.models.Game;
import vttp2022.paf.day21.repositories.GameRepo;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepo;

    public Optional<Game> getComments(Integer gid) {
        Optional<Game> opt = gameRepo.getGameById(gid);
        if (opt.isEmpty())
            return Optional.empty();

        Game game = opt.get();
        game.setComments(gameRepo.getCommentsByGid(gid));
        return Optional.of(game);
    }
}
