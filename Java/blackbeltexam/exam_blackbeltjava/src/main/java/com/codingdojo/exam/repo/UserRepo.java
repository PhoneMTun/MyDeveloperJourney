package com.codingdojo.exam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.model.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
 
 Optional<User> findByEmail(String email);
 List<User> findAll();
 User findByIdIs(Long id);
 
}
