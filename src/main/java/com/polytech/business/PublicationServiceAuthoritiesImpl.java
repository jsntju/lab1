package com.polytech.business;

import com.polytech.repository.AuthoritiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ju on 08/04/2017.
 */
@Service
public class PublicationServiceAuthoritiesImpl implements PublicationServiceAuthorities {

    private AuthoritiesRepository authoritiesRepository;

    public PublicationServiceAuthoritiesImpl(AuthoritiesRepository authoritiesRepository)
    {
        this.authoritiesRepository = authoritiesRepository;
    }

    public void authorities(Authorities authorities) {
        authoritiesRepository.save(authorities);
    }

    public List<Authorities> fetchAll() {
        return authoritiesRepository.findAll();
    }


}
