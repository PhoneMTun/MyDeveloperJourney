package com.codingdojo.JavaExam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.JavaExam.model.Baby;
import com.codingdojo.JavaExam.model.User;
import com.codingdojo.JavaExam.model.Vote;

public interface VoteRepo extends CrudRepository<Vote, Long>{
	List<Vote> findAll();
	Vote findByIdIs(Long id);
	List<Vote> findAllByBaby(Baby baby);
	Optional<Vote> findByUserAndBaby(User user, Baby baby);
}
