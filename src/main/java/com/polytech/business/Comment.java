package com.polytech.business;

import javax.persistence.*;

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

   // @ManyToOne(targetEntity = Post.class)
    //@JoinColumn (name="IDPost")
   @Column(name ="IDPost")
    private Long idPost;

    public Comment() {
        this.content = "null";
        this.idAuthor = "null";
    }

    public Comment(String idAuthor, String content, Long idPost) {
        this.content = content;
        this.idAuthor = idAuthor;
        this.idPost = idPost;
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

    public void setidPost (Long idPost ) { this.idPost = idPost;}
    public Long getidPost () { return(idPost);}
}















