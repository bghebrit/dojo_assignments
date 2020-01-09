package com.codingdojo.matching.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.matching.models.Discussion;

public interface DiscussionRepository extends CrudRepository<Discussion, Long> {
    Iterable<Discussion> findAll();
}