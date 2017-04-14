package com.polytech.business;

import java.util.List;

/**
 * Created by Justine Denis on 13/03/17.
 * Interface de service pour les postes
 */

public interface PublicationService {
    void post(Post post);
    List<Post> fetchAll();

}
