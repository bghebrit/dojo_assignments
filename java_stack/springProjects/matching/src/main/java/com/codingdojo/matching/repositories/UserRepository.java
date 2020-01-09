package com.codingdojo.matching.repositories;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.matching.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}