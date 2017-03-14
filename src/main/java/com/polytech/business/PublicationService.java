package com.polytech.business;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */

public interface PublicationService {
    void post(Post post);

    List<Post> fetchAll();
}
