package com.polytech.business;

import java.util.List;

/**
 * Created by ju on 01/04/2017.
 */
public interface PublicationServiceComment {
    void comment(Comment comment);
    List<Comment> fetchAll();
}
