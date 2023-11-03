package com.codingdojo.JavaExam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.JavaExam.model.Baby;
import com.codingdojo.JavaExam.model.User;
import com.codingdojo.JavaExam.model.Vote;
import com.codingdojo.JavaExam.repo.VoteRepo;

@Service
public class VoteService {
	@Autowired VoteRepo repo;
	public Vote find(Long id) {
		Optional<Vote> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	public List<Vote> all(){
		return repo.findAll();
	}
	public List<Vote> byBabies(Baby baby){
		return repo.findAllByBaby(baby);
	}
	public Vote createvote(Vote vote) {
		return repo.save(vote);
	}
	public void deletevote(Vote vote) {
        repo.delete(vote);
    }
	public String castVote(User user, Baby baby) {
	    Optional<Vote> existingVote = repo.findByUserAndBaby(user, baby);
	    if (existingVote.isPresent()) {
	        return "You have already voted for this baby!";
	    }
	    
	    Vote vote = new Vote();
	    vote.setUser(user);
	    vote.setBaby(baby);
	    repo.save(vote);
	    
	    return "Your vote has been successfully cast!";
	}
	public Vote findByBabyAndUser(Long babyId, Long userId) {
	    Baby baby = new Baby();
	    baby.setId(babyId);
	    
	    User user = new User();
	    user.setId(userId);
	    
	    Optional<Vote> result = repo.findByUserAndBaby(user, baby);
	    if(result.isPresent()) {
	        return result.get();
	    } else {
	        return null;
	    }
	}

	   
	}





	

