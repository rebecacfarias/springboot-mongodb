package com.training.mongospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mongospring.domain.User;
import com.training.mongospring.repository.UserRepository;

@Service
public class UserService {

		@Autowired
		private UserRepository repo;
	
		public List<User> findAll(){
			return repo.findAll();
		}
} 
