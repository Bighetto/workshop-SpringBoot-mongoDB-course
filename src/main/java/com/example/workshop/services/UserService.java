package com.example.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.domain.User;
import com.example.workshop.dto.UserDTO;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;

@Service
public class UserService {

	@Autowired
	private UserRepository	repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}return user;
	}
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
