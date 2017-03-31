package com.polytech.web;

import com.polytech.business.Like;
import com.polytech.business.Post;
import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.List;

/**
 * Created by ju on 29/03/2017.
 */
@Controller
@SessionAttributes( value="likes", types={Like.class} )
public class LikeControleur {

    @Autowired
    private PublicationServiceLike publicationServiceLike;
    private PublicationService publicationService;



    /*Récupération données pour l'affichage*/
    @RequestMapping(value= "/feedLike", method = RequestMethod.GET)
    public String getLike(Model model)             //Model = objet q'on remplie (conteneur)
    {
        List<Like> likes = publicationServiceLike.fetchAllLike();
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
        return "redirect:/feedLike";//"redirect:/feedLike";
    }
}
