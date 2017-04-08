package com.polytech.repository;

import com.polytech.business.Like;
import com.polytech.business.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    /*List<Post> findAll();
    void save(Post post);*/

}
