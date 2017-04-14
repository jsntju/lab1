package com.polytech.business;

import java.util.List;

/**
 * Created by Justine Denis on 01/04/2017.
 * Interface de service pour les commentaires
 */
public interface PublicationServiceComment {
    void comment(Comment comment);
    List<Comment> fetchAll();
}
