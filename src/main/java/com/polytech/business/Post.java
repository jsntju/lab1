package com.polytech.business;


import javax.persistence.*;

/**
 * Created by Justine Denis on 13/03/17.
 * Classes des postes
 */
@Entity
@Table(name = "Post")
public class Post {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Contenu du post
    @Column(name ="CONTENT")
    private String content;

    //Auteur du post
    @Column(name ="AUTHOR")
    private String author;


    @Override
    public String toString() {
        return '{' + id +' '+content +
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

    public void setId(Long id){this.id = id;}
    public Long getId(){return this.id;}


}
