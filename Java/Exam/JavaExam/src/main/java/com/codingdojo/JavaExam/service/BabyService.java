package com.codingdojo.JavaExam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.JavaExam.model.Baby;
import com.codingdojo.JavaExam.model.User;
import com.codingdojo.JavaExam.repo.BabyRepo;

@Service
public class BabyService {
	@Autowired BabyRepo repo;
	public List<Baby> all(){
		return repo.findAll();
	}
	public Baby create(Baby baby, BindingResult result) {
        Optional<Baby> potentialBaby = repo.findByName(baby.getName());
        
        if (potentialBaby.isPresent()) {
            result.rejectValue("name", "Duplicate", "A baby with this name already exists!");
            return null;
        } else {
            return repo.save(baby);
        }
    }

	public Baby update(Baby baby) {
		return repo.save(baby);
	}
	public List<Baby> byUser(User user){
		return repo.findAllByUsers(user);
	}
	
	public List<Baby> allexcept(User user){
		return repo.findByUsersNotContains(user);
	}
	public void deleteBaby(Baby team) {
		repo.delete(team);
		
	}
	public Baby find(Long id) {
		Optional<Baby> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	
	public int countVotesForBaby(Baby baby) {
	    return baby.getVotes().size();
	}
	
}
	

