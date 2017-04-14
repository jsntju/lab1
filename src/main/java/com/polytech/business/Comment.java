package com.polytech.business;

import javax.persistence.*;

/**
 * Created by Justine Denis on 01/04/2017.
 * Classes des commentaires
 */
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Contenu du commentaire
    @Column(name ="CONTENT")
    private String content;

    //Auteur du commentaire
    @Column(name ="IDAuthor")
    private String idAuthor;

    //Numero de post liè au commentaire
   @Column(name ="IDPost")
    private Long idPost;

   /*Constructeur par default*/
    public Comment() {
        this.content = "null";
        this.idAuthor = "null";
    }

    public Comment(String idAuthor, String content, Long idPost) {
        this.content = content;
        this.idAuthor = idAuthor;
        this.idPost = idPost;
    }

    public Comment(String content, String username) {
        this.content = content;
        this.idAuthor = username;
    }

    @Override
    public String toString() {
        return '{' +content +'}';
    }




    /*Accesseurs */
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















