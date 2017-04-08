package com.polytech.business;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ju on 01/04/2017.
 */
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="CONTENT")
    private String content;

    @Column(name ="IDAuthor")
    private String idAuthor;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn (name="IDPost")
    private Post idPost;

    public Comment() {
        this.content = "null";
        this.idAuthor = "null";
    }

    @Override
    public String toString() {
        return '{' +content +'}';
    }

    public Comment(String content, String username) {
        this.content = content;
        this.idAuthor = username;
    }


    public String getContent() {
        return content;
    }
    public String getidAuthor()
    {
        return idAuthor;
    }

    public void setidAuthor(String username)
    {
        this.idAuthor = username;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void setidPost (Post idPost ) { this.idPost = idPost;}
    public Post getidPost () { return(idPost);}
}















