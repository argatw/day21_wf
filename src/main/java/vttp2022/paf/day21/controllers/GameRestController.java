package vttp2022.paf.day21.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.paf.day21.Services.GameService;
import vttp2022.paf.day21.models.Comment;
import vttp2022.paf.day21.models.Game;

@RestController
@RequestMapping("/game")
public class GameRestController {
    
    @Autowired
    private GameService gameSvc;

    @GetMapping(path="/{gid}")
    public ResponseEntity<String> getGameAndCommentsById(@PathVariable Integer gid) {
        Optional<Game> opt = gameSvc.getComments(gid);
        JsonObjectBuilder builder = Json.createObjectBuilder();
        if (opt.isEmpty())
            return ResponseEntity.status(404)
                .body(builder.add("error", "not found: %s".formatted(gid))
                    .build().toString());

        Game game = opt.get();
        builder.add("gid", game.getGid());
        builder.add("name", game.getName());
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for (Comment c: game.getComments())
            arrBuilder.add("/comment/%s".formatted(c.getGid()));
        builder.add("comments", arrBuilder.build());

        return ResponseEntity.ok(builder.build().toString());
    }
}
