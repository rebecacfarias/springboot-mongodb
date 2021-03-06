package com.training.mongospring.services;

import java.util.Date;
import java.util.List;

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
		
		public List<Post> findByTitle(String text){
			return repo.findByTitleContainingIgnoreCase(text);
		}
		
		public List<Post> fullSearch(String text, Date minDate, Date maxDate){
			maxDate = new Date(maxDate.getTime()+ 24*60*60*1000);
			
			return repo.fullSearch(text, minDate, maxDate);
		}

} 
