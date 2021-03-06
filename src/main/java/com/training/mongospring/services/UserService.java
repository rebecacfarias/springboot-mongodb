package com.training.mongospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.mongospring.domain.User;
import com.training.mongospring.dto.UserDTO;
import com.training.mongospring.repository.UserRepository;
import com.training.mongospring.services.exception.ObjectNotFoundException;

@Service
public class UserService {

		@Autowired
		private UserRepository repo;
	
		public List<User> findAll(){
			return repo.findAll();
		}
		
		public User findById(String id) {
			User user;
			try {
				user = repo.findById(id).get();
			}catch(Exception e){
				throw new ObjectNotFoundException("Usuario nao encontrado");
			}
				
			return user;
		}
		
		public User insert(User user) {
			return repo.insert(user);
		}
		
		
		public void delete(String id) {
			findById(id);
			repo.deleteById(id);
		}
		
		
		public User update(User userAtt) {
			User currentUser;
			try {
				currentUser = repo.findById(userAtt.getId()).get();
			}catch(Exception e) {
				throw new ObjectNotFoundException("Usuario nao encontrado");
			}
			
			updateData(currentUser, userAtt);
			return repo.save(currentUser);
		}
		
		public void updateData(User currentUser, User userAtt) {
			currentUser.setName(userAtt.getName());
			currentUser.setEmail(userAtt.getEmail());
		}
		
		
		public User fromDTO(UserDTO userDto) {
			
			return new User(userDto.getId(),userDto.getName(), userDto.getEmail());
		}
} 
