package com.polytech.business;

import com.polytech.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by justine Denis on 29/03/2017.
 */
@Service
public class PublicationServiceImplLike implements PublicationServiceLike{

    private LikeRepository likeRepository;

    public PublicationServiceImplLike(LikeRepository likeRepository)
    {
        this.likeRepository = likeRepository;
    }

    /*----- Pour les likes -----*/
    public void like(Like like) {
        likeRepository.save(like);
    }

    public List<Like> fetchAllLike() {
        return likeRepository.findAll();
    }

}
