package com.polytech.business;

import com.polytech.repository.LikeRepository;
import com.polytech.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by norabbit on 13/03/17.
 */
@Service       //ou @component
public class PublicationServiceImpl implements PublicationService {

    //private List<Post> db = new ArrayList<Post>();
    private PostRepository postRepository;

    public PublicationServiceImpl(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }


    /*---- Pour les Posts -----*/
    public void post(Post post) {
        postRepository.save(post);
    }

    public List<Post> fetchAll() {
        return postRepository.findAll();
    }


}
