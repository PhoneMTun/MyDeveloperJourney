package com.codingdojo.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.exam.model.Player;
import com.codingdojo.exam.model.Team;
import com.codingdojo.exam.repo.PlayerRepo;

@Service
public class PlayerService {
	@Autowired PlayerRepo repo;
	
	public Player find(Long id) {
		Optional<Player> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	public List<Player> all(){
		return repo.findAll();
	}
	public List<Player> byteams(Team team){
		return repo.findAllByTeam(team);
	}
	public Player createplayer(Player player) {
		return repo.save(player);
	}
	public void deletePlayer(Player player) {
        repo.delete(player);
    }
}
