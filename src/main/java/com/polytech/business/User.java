package com.polytech.business;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by justine Denis on 08/04/2017.
 * Classe des utilisateur du site (relié à la table USER)
 */
@Entity
@Table(name = "users")
public class User {

    //Déclaration attribut de la classe (relié a la base de donnees)
    @Id
    @Column(name ="ID")
    private Long id;

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="name")
    private String name;

    @Column(name ="lastname")
    private String lastname;

    @Column(name ="adress")
    private String adress;

    @Column(name ="city")
    private String city;

    @Column(name ="mail")
    private String mail;

    @Column(name ="enabled")
    private int enabled;

//Getter et Setter des attributs
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String dbpwd = passwordEncoder.encode(password);                        //Chiffre le password
        while( !passwordEncoder.matches(password,dbpwd)) {                      //Tant que le chiffre ne correpond pas
            dbpwd = passwordEncoder.encode(password);                           //... chiffre a nouveau
        }
        this.password = dbpwd;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
