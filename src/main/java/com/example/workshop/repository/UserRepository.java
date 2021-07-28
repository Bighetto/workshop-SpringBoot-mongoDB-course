package com.example.workshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
<<<<<<< HEAD

	User findOne(String id);
=======
>>>>>>> da0bc55f1caa6be7ff0939fa4f6fffaea978ba78
}
