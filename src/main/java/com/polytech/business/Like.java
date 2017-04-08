package com.polytech.business;

import javax.persistence.*;

/**
 * Created by ju on 28/03/2017.
 */
@Entity
@Table(name = "liketable")
public class Like {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name ="IDPost")
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn (name="IDPost")
    private Post idPost;

    //@ManyToOne
    //@JoinColumn (name="IDAuthor")
    @Column(name ="IDAuthor")
    private String iDAuthor;

    @Override
    public String toString() {
        return (iDAuthor+' '+idPost+' '+id);
    }


    public void setidPost (Post idPost ) { this.idPost = idPost;}
    public Post getidPost () { return(idPost);}

    public void setidAuthor (String iDAuthor ) {
        this.iDAuthor = iDAuthor;
    }
    public String getidAuthor () { return(iDAuthor);}

}
