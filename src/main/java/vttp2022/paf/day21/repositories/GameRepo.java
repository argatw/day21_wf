package vttp2022.paf.day21.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day21.models.Comment;
import vttp2022.paf.day21.models.Game;

@Repository
public class GameRepo {
    
    @Autowired
    private JdbcTemplate template;

    public List<Comment> getCommentsByGid(Integer gid) {
        return getCommentsByGid(gid, Integer.MAX_VALUE, 0);
    }

    // public List<Comment> getCommentsByGid(Integer gid, Integer limit) {
    //     return getCommentsByGid(gid, limit, 0);
    // }

    // SLIDE 23 OF DAY21
    public List<Comment> getCommentsByGid(Integer gid, Integer limit, Integer offset) {
        final List<Comment> comments = new LinkedList<>();
        
        final SqlRowSet resultSet = template.queryForRowSet(
            "select * from comment where gid = ? limit ? offset ?"
            , gid, limit, offset
        );

        while (resultSet.next()) {
            Comment comment = Comment.createComment(resultSet);
            comments.add(comment);
        }

        return comments;
    }

    public Optional<Game> getGameById(Integer gid) {
        final SqlRowSet result = template.queryForRowSet(
            // select * from game where gid = <gid>
            // SQL_SELECT_GAME_BY_GID ***** cant concatenate
            "select * from game where gid=?", gid
            );

        if (!result.next()) 
            // GameRepo game = new GameRepo();
            return Optional.empty();

        return Optional.of(Game.create(result));
        // Integer gid = rs.getInt("gid");
        
    }

}



