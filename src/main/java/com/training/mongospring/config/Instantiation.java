package com.training.mongospring.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.training.mongospring.domain.Post;
import com.training.mongospring.domain.User;
import com.training.mongospring.dto.AuthorDTO;
import com.training.mongospring.dto.CommentDTO;
import com.training.mongospring.repository.PostRepository;
import com.training.mongospring.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.save(maria);
		userRepository.save(alex);
		userRepository.save(bob);

		Post post1 = new Post(null, sdf.parse("21/12/2012"), "Partiu viagem", "Vou viajar pra Marte!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/12/2012"), "To na nave", "O wi fi chega aqui na nave gente!",new AuthorDTO(maria));

		CommentDTO comment1 = new CommentDTO("Boa viagem amiga!", sdf.parse("21/12/2012"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Chocado!", sdf.parse("21/12/2012"), new AuthorDTO(bob));
		
		post1.getComments().add(comment1);
		post2.getComments().add(comment2);
		
		postRepository.save(post1);
		postRepository.save(post2);
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);

	}
}
