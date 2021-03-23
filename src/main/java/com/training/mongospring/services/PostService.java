package com.training.mongospring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mongospring.domain.Post;
import com.training.mongospring.repository.PostRepository;
import com.training.mongospring.services.exception.ObjectNotFoundException;

@Service
public class PostService {

		@Autowired
		private PostRepository repo;

		public Post findById(String id) {
			Post post;
			try {
				post = repo.findById(id).get();
			}catch(Exception e){
				throw new ObjectNotFoundException("Post nao encontrado");
			}
				
			return post;
		}

} 
