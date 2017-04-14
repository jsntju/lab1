package com.polytech.business;

import java.util.List;

/**
 * Created by justine Denis on 29/03/2017.
 * Interface de service pour les likes
 */
public interface PublicationServiceLike {
    //Pour les likes
    void like(Like like);
    List<Like> fetchAllLike();

}
