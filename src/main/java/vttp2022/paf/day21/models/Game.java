package vttp2022.paf.day21.models;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer usersRated;
    private String url;
    private String image;
    private List<Comment> comments;


    public Integer getGid() {
        return gid;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUsersRated() {
        return usersRated;
    }

    public void setUsersRated(Integer usersRated) {
        this.usersRated = usersRated;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public static Game create(SqlRowSet rs) {
        Game game = new Game();
        game.setGid(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        game.setYear(rs.getInt("year"));
        game.setRanking(rs.getInt("ranking"));
        game.setUsersRated(rs.getInt("users_rated"));
        game.setUrl(rs.getString("url"));
        game.setImage(rs.getString("image"));

        return game;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("gid", getGid())
        .add("name", getName())
        .add("year", getYear())
        .add("ranking", getRanking())
        .add("users_rated", getUsersRated())
        .add("url", getUrl())
        .add("image", getImage())
        .build();

    }

}
