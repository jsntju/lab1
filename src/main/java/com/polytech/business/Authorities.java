package com.polytech.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Justine Denis on 08/04/2017.
 * Objet indiquant le niveau de qualification de l'user pour acceder au site
 */
@Entity
@Table(name = "authorities")
public class Authorities {


    @Id
    private long id;

   @Column(name ="username")
    private String username;

    @Column(name ="authority")
    private String authority;

    public Authorities (String username, String authority)
    {
        this.username = username;
        this.authority = authority;
    }

    public Authorities() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}