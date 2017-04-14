package com.polytech.repository;

import com.polytech.business.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ju on 08/04/2017.
 */
@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,Long> {
}
