package com.polytech.view;

import com.polytech.business.Post;
import com.polytech.business.PostRepository;
import com.polytech.business.PublicationService;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public class Main {

    public static void main(String[] args) {            //psvm
        //System.out.println("Hello Polytech");
        PostRepository postrepesitory = new PostRepository();
        PublicationService publicationservice  = new PublicationService(postrepesitory);

        Post post = new Post("Il fait chaud!! :) ");
        Post post2 = new Post("Nouvelles infos:  ");
        publicationservice.post(post);
        publicationservice.post(post2);

        List<Post> posts = publicationservice.fetchAll();          //Retourne liste des postes (timeLine)
        System.out.println(posts);

    }
}
