package com.polytech.web;

import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Request;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ju on 15/03/2017.
 */
@Controller
public class helloControleur {

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
        model.addAttribute("postes",posts);
        return "feed";
    }

    //Difference path et param => meme chose mais ecriture deifférente
    //Recupére élément par path ici (pas par param)
   /*@RequestMapping(value= "/share/{id}", method = RequestMethod.GET)
    public Post fetchPost(@PathVariable("id") Long id)
    {
        return feedService.fetchFeed(id);
    }*/

   //Récupére données par formulaire
   @RequestMapping(value ="/share", method = RequestMethod.POST)
    public String post(Post post)
    {
        publicationService.post(post);
        return "redirect:/feed";
    }


}
