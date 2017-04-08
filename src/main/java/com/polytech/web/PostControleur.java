package com.polytech.web;

import com.polytech.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.List;

/**
 * Created by ju on 15/03/2017.
 */
@Controller
public class PostControleur {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationServiceLike publicationServiceLike;

    @Autowired
    private PublicationServiceComment publicationServiceComment;

    private Post postLocal;
/*-------- Posts ------------------------------------*/
   /*Récupération données pour l'affichage*/
    @RequestMapping(value= "/feed", method = RequestMethod.GET)
    public String getPost(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<Comment> comments = publicationServiceComment.fetchAll();
        model.addAttribute("comments",comments);
        List<Like> likes = publicationServiceLike.fetchAllLike();
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        model.addAttribute("likes",likes);
        return "feed";
    }

   //Récupére données par formulaires
   @RequestMapping(value ="/share", method = RequestMethod.POST)
    public String post(Post post, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        post.setAuthor(username);
        publicationService.post(post);
        return "redirect:/feed";
    }



/*--------------- Likes -------------------------------------*/

    /*Récupération données pour l'affichage*/
    @RequestMapping(value= "/feedLike", method = RequestMethod.GET)
    public String getLike(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<Like> likes = publicationServiceLike.fetchAllLike();
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        model.addAttribute("likes",likes);
        return "feed";
    }


    //Récupére données par formulaires
    @RequestMapping(value ="/shareLike", method = RequestMethod.POST)
    public String like(Like like, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        like.setidAuthor(username);

        publicationServiceLike.like(like);
        return "redirect:/feedLike";
    }


    /*----- Commentaires ----------------*/
    /*Récupération données pour l'affichage*/
    @RequestMapping(value= "/feedComment", method = RequestMethod.GET)
    public String getComment(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<Comment> comments = publicationServiceComment.fetchAll();
        model.addAttribute("comments",comments);
        List<Like> likes = publicationServiceLike.fetchAllLike();
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        model.addAttribute("likes",likes);
        return "feed";
    }

    //Récupére données par formulaires
    @RequestMapping(value ="/shareComment", method = RequestMethod.POST)
    public String comment(Comment comment, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        comment.setidAuthor(username);
        publicationServiceComment.comment(comment);
        return "redirect:/feedComment";
    }



}
