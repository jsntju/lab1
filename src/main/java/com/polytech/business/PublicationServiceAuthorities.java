package com.polytech.business;

import java.util.List;

/**
 * Created by justine Denis on 08/04/2017.
 * Interface de service pour les authorités
 */
public interface PublicationServiceAuthorities {
   void authorities(Authorities authorities);
    List<Authorities> fetchAll();
}
