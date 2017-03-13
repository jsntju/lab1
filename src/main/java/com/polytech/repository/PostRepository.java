package com.polytech.repository;

import com.polytech.business.Post;
import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
public interface PostRepository {

    List<Post> findAll();
    void save(Post post);
}
