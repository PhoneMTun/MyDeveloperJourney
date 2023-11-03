package com.codingdojo.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.exam.model.Team;
import com.codingdojo.exam.model.User;
import com.codingdojo.exam.repo.TeamRepo;

@Service
public class TeamService {
	@Autowired TeamRepo repo;
	public List<Team> all(){
		return repo.findAll();
	}
	public Team create(Team team) {
		return repo.save(team);
	}
	public Team update(Team team) {
		return repo.save(team);
	}
	
	public List<Team> byUser(User user){
		return repo.findAllByUsers(user);
	}
	
	public List<Team> allexcept(User user){
		return repo.findByUsersNotContains(user);
	}
	public void deleteTeam(Team team) {
		repo.delete(team);
		
	}
	public Team find(Long id) {
		Optional<Team> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	
	public int countPlayersInTeam(Team team) {
	    return team.getPlayers().size();
	}
}

