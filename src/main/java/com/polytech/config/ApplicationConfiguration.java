package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.JdbcPostRepository;
import com.polytech.repository.PostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by norabbit on 13/03/17.
 * Configuration de l'application
 */
@Configuration
public class ApplicationConfiguration {

    /*Création de la BDD */
    @Bean
    public DataSource dataSource()
    {
        //Créer BDD de type H2
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
        //Pour se co, faut utiliser driver (cf fichier pom)
        //create-schema.sql => c'est le fichier sql de la BDD

    }


    @Bean                               //Pour spring => permet de gérer la f(x) ds un conteneur
    public PostRepository postRepository()
    {
        //return new PostRepositoryImpl();
        return new JdbcPostRepository(dataSource());
    }

    /**/
    @Bean
    public PublicationService publicationService(PostRepository postRepository)
    {
        return new PublicationServiceImpl(postRepository);
    }


}
