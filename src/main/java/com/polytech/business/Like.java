package com.polytech.business;

import javax.persistence.*;

/**
 * Created by Justine Denis on 28/03/2017.
 * Classes des likes des postes
 */
@Entity
@Table(name = "liketable")
public class Like {

    @Id
    @Column(name ="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Numéro de post liké
    @Column(name ="IDPost")
    private Long idPost;

    //Autheur du like
    @Column(name ="IDAuthor")
    private String iDAuthor;

    @Override
    public String toString() {
        return (iDAuthor+' '+idPost+' '+id);
    }

    public Like()
    {
        this.iDAuthor = "null";
    }
    public Like(String iDAuthor, Long idPost)
    {
        this.iDAuthor = iDAuthor;
        this.idPost = idPost;
    }

    /*Accesseurs*/
    public void setidPost (Long idPost ) { this.idPost = idPost;}
    public Long getidPost () { return(idPost);}

    public void setidAuthor (String iDAuthor ) {
        this.iDAuthor = iDAuthor;
    }
    public String getidAuthor () { return(iDAuthor);}

    public boolean equalsId(Long id)
    {
        return(this.id==id);
    }

}
