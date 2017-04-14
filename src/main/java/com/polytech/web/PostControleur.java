package com.polytech.web;

import com.polytech.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

/**
 * Created by ju on 15/03/2017.
 */
@Controller
public class PostControleur {

    private long i=3;


    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationServiceLike publicationServiceLike;

    @Autowired
    private PublicationServiceComment publicationServiceComment;

    @Autowired
    private PublicationServiceUser publicationServiceUser;

    @Autowired
    private PublicationServiceAuthorities publicationServiceAuthorities;

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
        List<Comment> comments = publicationServiceComment.fetchAll();
        model.addAttribute("comments",comments);
        return "feed";
    }

    //Récupére données par formulaires
    /*@RequestMapping(value ="/shareLike", method = RequestMethod.POST)
    public String like(Like like, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        like.setidAuthor(username);

        publicationServiceLike.like(like);
        return "redirect:/feedLike";
    }*/

    @RequestMapping(value ="/shareLike", method = RequestMethod.POST)
    //PostMapping
    public String like(@RequestParam(value="id") Long idPost, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        Like like = new Like(username,idPost);
        publicationServiceLike.like(like);                  //ajoute Like au model
        return "redirect:/feedLike";
    }



    /*--------------------- Commentaires ----------------*/
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
    /*@RequestMapping(value ="/shareComment", method = RequestMethod.POST)
    public String comment(Comment comment, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        comment.setidAuthor(username);
        publicationServiceComment.comment(comment);
        return "redirect:/feedComment";
    }*/


    @RequestMapping(value ="/shareComment", method = RequestMethod.POST)
    public String comment(@RequestParam(value="id") Long idPost, Comment comment, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        comment.setidAuthor(username);
        comment.setidPost(idPost);
        //Comment comment1 = new Comment(username, comment, idPost);
        publicationServiceComment.comment(comment);
        return "redirect:/feedComment";
    }


/*------------------ Inscription ----------------------------------*/
   //Récupére données par formulaires
    @RequestMapping(value ="/subscribe", method = RequestMethod.POST)
    public String user(User user, Principal principal)
    {
        Authorities authorities = new Authorities();
        authorities.setUsername(user.getUsername());
        authorities.setAuthority("USER");
        authorities.setId(i);
        user.setId(i);
        user.setEnabled(1);
        i++;
        publicationServiceUser.user(user);
        publicationServiceAuthorities.authorities(authorities);
        return "redirect:/lectureInscription";
    }

    /*Récupération données pour l'affichage*/
   @RequestMapping(value= "/lectureInscription", method = RequestMethod.GET)
    public String getUser(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<User> users = publicationServiceUser.fetchAll();
        model.addAttribute("users",users);
        List<Authorities> authorities = publicationServiceAuthorities.fetchAll();
        model.addAttribute("authorities",authorities);
        return "feed";
    }

}
