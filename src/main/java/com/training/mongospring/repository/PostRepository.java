package com.training.mongospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.mongospring.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
