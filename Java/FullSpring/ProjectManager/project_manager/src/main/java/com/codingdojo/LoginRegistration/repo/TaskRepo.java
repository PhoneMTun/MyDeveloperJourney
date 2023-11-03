package com.codingdojo.LoginRegistration.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.LoginRegistration.model.Project;
import com.codingdojo.LoginRegistration.model.Task;
import com.codingdojo.LoginRegistration.model.User;

public interface TaskRepo extends CrudRepository<Task, Long>{
	List<Task> findAll();
	Task findByIdIs(Long id);
	List<Task> findAllByProject(Project project);
	
}
