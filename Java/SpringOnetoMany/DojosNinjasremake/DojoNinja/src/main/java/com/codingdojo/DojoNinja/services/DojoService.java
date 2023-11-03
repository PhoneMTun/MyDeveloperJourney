package com.codingdojo.DojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoNinja.models.Dojo;
import com.codingdojo.DojoNinja.repo.DojoRepo;



@Service
public class DojoService {
	private final DojoRepo repo;
	public DojoService(DojoRepo repo) {
		this.repo=repo;
	}
	public List<Dojo> all(){
		return repo.findAll();
	}
	public Dojo create(Dojo dojo) {
		return repo.save(dojo);
	}
	public Dojo find(Long id) {
		Optional<Dojo> result= repo.findById(id);
		if(result.isPresent()) {
			return result.get();
			
		}else {
			return null;
		}
	}
}
