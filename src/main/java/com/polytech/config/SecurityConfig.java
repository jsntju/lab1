package com.polytech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by ju on 17/03/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passEncoder());
    }


    /*Déchiffre mdp => faut entrer mdp deja chiffrer*/
    @Bean
    public PasswordEncoder passEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /*Demande authentification avant acces au site */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .authorizeRequests()
                .antMatchers("/").permitAll()               //Pages accessible = lien publique par default c'est l'index
                .antMatchers("/**.css").permitAll()         //Pages accessible = lien publique
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .logout()
                .and()
                    .httpBasic()
                .and()
                    .csrf().disable();                          //Ajoute faille ds systeme
    }

    /*Enregistre une authentification*/
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("ju")
                .password("ju")
                .roles("USER");
    }*/
}
