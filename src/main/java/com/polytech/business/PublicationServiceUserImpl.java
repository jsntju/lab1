package com.polytech.business;

import com.polytech.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by justine Denis on 08/04/2017.
 */
@Service
public class PublicationServiceUserImpl implements PublicationServiceUser {

    private UserRepository userRepository;

    public PublicationServiceUserImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void user(User user) {
        userRepository.save(user);
    }

    public List<User> fetchAll() {
        return userRepository.findAll();
    }


}
