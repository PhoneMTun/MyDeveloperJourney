package com.codingdojo.JavaExam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.JavaExam.model.Baby;
import com.codingdojo.JavaExam.model.User;


public interface BabyRepo extends CrudRepository<Baby, Long>  {
	List<Baby> findAll();
	Baby findByIdIs(Long id);
	List<Baby> findAllByUsers(User user);
	List<Baby> findByUsersNotContains(User user);
	Optional<Baby>  findByName(String name);
}
