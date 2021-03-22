package com.training.mongospring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.mongospring.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
