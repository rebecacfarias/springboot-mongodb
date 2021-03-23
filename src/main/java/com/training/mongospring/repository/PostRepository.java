package com.training.mongospring.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.training.mongospring.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	
	//mesma coisa com query
	@Query("{ 'title' : { $regex: ?0, $options: 'i'}}")
	List<Post>searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
