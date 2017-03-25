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

    @Column(name ="AUTHOR")
    private String author;

    @Override
    public String toString() {
        return '{' + content +
                '}';
    }


    public Post(String content, String username) {
        this.content = content;
        this.author = username;
    }
    public Post() {
        this.content ="Commentaire par default";
    }

    public String getContent() {
        return content;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String username)
    {
        this.author = username;
    }
    public void setContent(String content) {
        this.content = content;
    }


}
