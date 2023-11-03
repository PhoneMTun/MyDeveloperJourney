package com.codingdojo.DojoOverflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.model.Tag;
import com.codingdojo.DojoOverflow.repo.TagRepo;



@Service
public class TagService {
	@Autowired
	private TagRepo repo;
	
	public List<Tag> allTags(){
		return repo.findAll();
	}
	public Tag findById(Long id) {
		Optional<Tag> resultOptional=repo.findById(id);
		if(resultOptional.isPresent()) {
			return resultOptional.get();
		}
		return null;
	}
	public Tag findBySubject(String subject) {
		return repo.findBySubject(subject);
	}
	
	public Tag create(Tag tag) {
		return repo.save(tag);
	}
}
