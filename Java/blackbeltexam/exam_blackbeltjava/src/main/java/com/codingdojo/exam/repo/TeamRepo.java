package com.codingdojo.exam.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.exam.model.Team;
import com.codingdojo.exam.model.User;

public interface TeamRepo extends CrudRepository<Team, Long>{
	List<Team> findAll();
	Team findByIdIs(Long id);
	List<Team> findAllByUsers(User user);
	List<Team> findByUsersNotContains(User user);
}
