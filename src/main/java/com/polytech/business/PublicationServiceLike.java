package com.polytech.business;

import java.util.List;

/**
 * Created by ju on 29/03/2017.
 */
public interface PublicationServiceLike {
    //Pour les likes
    void like(Like like);
    List<Like> fetchAllLike();
}
