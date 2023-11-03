package com.codingdojo.DojoOverflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.model.Question;
import com.codingdojo.DojoOverflow.repo.QuestionRepo;



@Service
public class QuestionService {
	@Autowired 
	private QuestionRepo repo;
	
	public List<Question> allQuestions(){
		return repo.findAll();
	}
	public Question create(Question question ) {
		return repo.save(question);
	}
	public Question findById(Long id) {
		Optional<Question> resultOptional=repo.findById(id);
		if(resultOptional.isPresent()) {
			return resultOptional.get();
		}
		return null;
	}
}
