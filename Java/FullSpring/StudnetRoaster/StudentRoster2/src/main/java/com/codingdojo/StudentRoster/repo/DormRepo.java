package com.codingdojo.StudentRoster.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.StudentRoster.model.Dorm;

public interface DormRepo extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();
}



