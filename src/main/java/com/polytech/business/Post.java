package com.polytech.business;


import javax.persistence.*;

/**
 * Created by norabbit on 13/03/17.
 */
@Entity
@Table(name = "Post")
public class Post {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="CONTENT")
    private String content;

    @Override
    public String toString() {
        return '{' + content +
                '}';
    }


    private String username;


    public Post(String content/*, String username*/) {
        this.content = content;
        //this.username = username;
    }
    public Post() {
        this.content ="Commentaire par default";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
