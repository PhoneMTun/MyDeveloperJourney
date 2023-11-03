package com.codingdojo.DojoOverflow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.model.Answer;
import com.codingdojo.DojoOverflow.repo.AnswerRepo;


@Service
public class AnswerService {
	@Autowired
	private AnswerRepo repo;
	
	public Answer findByQueId(Long questionId){
		return repo.findByQuestionIdIs(questionId);
		
	}
	public Answer create(Answer answer) {
		return repo.save(answer);
	}
}
