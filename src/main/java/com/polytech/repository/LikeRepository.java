package com.polytech.repository;

import com.polytech.business.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ju on 29/03/2017.
 */
@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {
}
