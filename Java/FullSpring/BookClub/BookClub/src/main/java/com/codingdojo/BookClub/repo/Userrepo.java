package com.codingdojo.BookClub.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.BookClub.model.User;

public interface Userrepo extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
