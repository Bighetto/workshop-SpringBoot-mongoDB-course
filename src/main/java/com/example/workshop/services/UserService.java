package com.example.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.domain.User;
import com.example.workshop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository	repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
