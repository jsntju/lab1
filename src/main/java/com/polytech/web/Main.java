package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class Main {

    public static void main(String[] args) {            //psvm

        //System.out.println("Hello Polytech");
        /*PostRepository postrepesitory = new PostRepositoryImpl();
        PublicationService publicationservice  = new PublicationServiceImpl(postrepesitory);*/

       //Déclaration contexte:
        System.setProperty("spring.profiles.active","DEV");                 //active profile
        ApplicationContext ApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);     //Recupere les bean
        PublicationService publicationservice = ApplicationContext.getBean(PublicationService.class);       //Nom de la fontion du bean ou de la classe

        Post post = new Post("Il fait chaud!! ");
        Post post2 = new Post("Manger une glace ;) Cool  ");
        publicationservice.post(post);
        publicationservice.post(post2);

        List<Post> posts = publicationservice.fetchAll();          //Retourne liste des postes (timeLine)
        System.out.println(posts);

    }
}
