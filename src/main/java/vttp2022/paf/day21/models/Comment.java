package vttp2022.paf.day21.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {
    private String cId;
    private String user;
    private Integer rating;
    private String cText;
    private Integer gid;

    public String getcId() {
        return cId;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getcText() {
        return cText;
    }
    public void setcText(String cText) {
        this.cText = cText;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setcId(String cId) {
        this.cId = cId;
    }

    public static Comment createComment(SqlRowSet rs) {
        Comment comment = new Comment();
        comment.setGid(rs.getInt("gid"));
        comment.setcId(rs.getString("c_id"));
        comment.setUser(rs.getString("user"));
        comment.setRating(rs.getInt("rating"));
        comment.setcText(rs.getString("c_text"));
        return comment;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("gid", getGid())
        .add("c_id", getcId())
        .add("user", getUser())
        .add("rating", getRating())
        .add("c_text", getcText())
        .build();
    }
    
}
