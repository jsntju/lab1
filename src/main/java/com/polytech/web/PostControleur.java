package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by ju on 15/03/2017.
 */
@Controller
public class PostControleur {

    @Autowired
    private PublicationService publicationService;

    //Affichage juste hello => test
   /*@RequestMapping(value= "/share", method = RequestMethod.POST)
    public String home()
    {
        return "feed";
    }*/

   /*Récupération données pour l'affichage*/
    @RequestMapping(value= "/feed", method = RequestMethod.GET)
    public String getPost(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts",posts);
        return "feed";
    }

    //Difference path et param => meme chose mais ecriture deifférente
    //Recupére élément par path ici (pas par param)
   /*@RequestMapping(value= "/share/{id}", method = RequestMethod.GET)
    public Post fetchPost(@PathVariable("id") Long id)
    {
        return feedService.fetchFeed(id);
    }*/

   //Récupére données par formulaires
   @RequestMapping(value ="/share", method = RequestMethod.POST)
    public String post(Post post, Principal principal)
    {
        String username = principal.getName();              //Nom de la personne
        post.setAuthor(username);
        publicationService.post(post);
        return "redirect:/feed";
    }


}
