package com.polytech.business;

import java.util.List;

/**
 * Created by justine Denis on 08/04/2017.
 * Interface de service pour les utilisateurs
 */
public interface PublicationServiceUser {
   void user(User user);
    List<User> fetchAll();
}
