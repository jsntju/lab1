package com.polytech.business;

import com.polytech.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by justine Denis on 01/04/2017.
 */
@Service
public class PublicationServiceCommentImpl implements PublicationServiceComment{

    private CommentRepository commentRepository;

    public PublicationServiceCommentImpl(CommentRepository commentRepository)
    {
        this.commentRepository = commentRepository;
    }

    public void comment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> fetchAll() {
        return commentRepository.findAll();
    }

}
