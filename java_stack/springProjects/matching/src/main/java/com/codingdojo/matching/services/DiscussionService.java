package com.codingdojo.matching.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.matching.models.Discussion;
import com.codingdojo.matching.repositories.DiscussionRepository;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public Iterable<Discussion> findall(){
        return discussionRepository.findAll();
    }

    public Discussion save(Discussion discussion){
        return discussionRepository.save(discussion);
    }
}