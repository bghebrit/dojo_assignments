package com.codingdojo.matching.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.matching.models.User;
import com.codingdojo.matching.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
}
