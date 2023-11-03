package com.codingdojo.LoginRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.LoginRegistration.model.Project;
import com.codingdojo.LoginRegistration.model.User;
import com.codingdojo.LoginRegistration.repo.ProjectRepo;

@Service
public class ProjectService {
	@Autowired ProjectRepo repo;

	public List<Project> all(){
		return repo.findAll();
	}
	public Project create(Project project) {
		return repo.save(project);
	}
	public Project update(Project project) {
		return repo.save(project);
	}
	public List<Project> byUser(User user){
		return repo.findAllByUsers(user);
	}
	public List<Project> allexcept(User user){
		return repo.findByUsersNotContains(user);
	}
	public void deleteProject(Project project) {
		repo.delete(project);
		
	}
	public Project find(Long id) {
		Optional<Project> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
}

