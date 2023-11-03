package com.codingdojo.DojoOverflow.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.model.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
	Question findByIdIs(Long id);
}
