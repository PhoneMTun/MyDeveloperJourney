package com.codingdojo.StudentRoster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.repo.DormRepo;

@Service
public class DormService {
	private final DormRepo repo;
	public DormService(DormRepo repo) {
		this.repo=repo;
	}
	public List<Dorm> all(){
		return repo.findAll();
	}
	public Dorm create(Dorm dorm) {
		return repo.save(dorm);
	}
	public Dorm find(Long id) {
		Optional<Dorm> result= repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
			return null;
		}
	}
}
