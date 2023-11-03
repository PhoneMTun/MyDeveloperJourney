package com.codingdojo.LoginRegistration.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.LoginRegistration.model.Project;
import com.codingdojo.LoginRegistration.model.User;


public interface ProjectRepo extends CrudRepository<Project, Long>{
	List<Project> findAll();
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);
	List<Project> findByUsersNotContains(User user);
	
}
