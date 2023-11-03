package com.codingdojo.LoginRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.LoginRegistration.model.Project;
import com.codingdojo.LoginRegistration.model.Task;
import com.codingdojo.LoginRegistration.model.User;
import com.codingdojo.LoginRegistration.repo.TaskRepo;

@Service
public class TaskService {
	@Autowired TaskRepo repo;
	
	public Task find(Long id) {
		Optional<Task> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	public List<Task> all(){
		return repo.findAll();
	}
	public List<Task> byProjects(Project project){
		return repo.findAllByProject(project);
	}
	public Task createtask(Task task) {
		return repo.save(task);
	}
}
