package com.codingdojo.DojoOverflow.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.model.Tag;

public interface TagRepo extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Tag findBySubject(String subject);
}
