package com.example.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshop.domain.Post;
import com.example.workshop.domain.User;
import com.example.workshop.dto.AuthorDTO;
import com.example.workshop.dto.CommentDTO;
import com.example.workshop.repository.PostRepository;
import com.example.workshop.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para SP. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/03/2020"), "Champions League Europa", "Estou indo assistir o maior campeonato de futebol do mundo!", new AuthorDTO(alex));
		
		CommentDTO c1 = new CommentDTO("Boa viagem Maria!", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c2 = new CommentDTO("Vai com Deus!", sdf.parse("22/03/2018"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("Show de bola! literalmente rs", sdf.parse("26/04/2020"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1));
		alex.getPosts().addAll(Arrays.asList(post2));
		
		userRepository.save(maria);
		userRepository.save(alex);
	}
}
