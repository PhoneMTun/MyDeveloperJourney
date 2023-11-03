package com.codingdojo.RetryExamJava.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.RetryExamJava.model.User;

public interface UserRepo extends CrudRepository<User, Long>{
	 Optional<User> findByEmail(String email);
	 List<User> findAll();
	 User findByIdIs(Long id);
}
