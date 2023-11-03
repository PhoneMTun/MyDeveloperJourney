package com.codingdojo.DojoOverflow.repo;


import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.model.Answer;

public interface AnswerRepo extends CrudRepository<Answer, Long>{
	Answer findByQuestionIdIs(Long id);
}
