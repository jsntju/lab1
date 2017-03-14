package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.JdbcPostRepository;
import com.polytech.repository.PostRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by norabbit on 13/03/17.
 * Configuration de l'application
 */
@Configuration
@PropertySource("classpath:/application.properties")                    //Fichier contenant infos de co
public class ApplicationConfiguration {

    /*Connexion à la BDD => Ancienne version (local) */
    /*@Bean
    public DataSource dataSource()
    {
        //Créer BDD de type H2
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
        //Pour se co, faut utiliser driver (cf fichier pom)
        //create-schema.sql => c'est le fichier sql de la BDD
    }*/


    /*------ Pour fichier properties:*/
    /*@Value("${datasource.driverName}")                      //recupere informations du fichier
    private String driverClassName;                            //Cherche dans le fichier

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;*/

    @Autowired
    private org.springframework.core.env.Environment environment;                       //Resume tout pour la connexion


    /*Connexion à la BDD sur serveur*/
    //Datasource créer plein de co au début et après les récupère
    @Bean
    public DataSource dataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
       /* dataSource.setUsername("root");                           //ancienne veriosn, en brut
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/BDDPolytech");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");*/

        /*dataSource.setDriverClassName(driverClassName);             //Version connexion à chaque fois
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);*/

        String driverClassName = environment.getProperty("datasource.driverName");      //Version connexion avec le resumé
        String url = environment.getProperty("datasource.url");
        String password = environment.getProperty("datasource.password");
        String username = environment.getProperty("datasource.username");
        dataSource.setDriverClassName(driverClassName);             //Version connexion à chaque fois
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
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
