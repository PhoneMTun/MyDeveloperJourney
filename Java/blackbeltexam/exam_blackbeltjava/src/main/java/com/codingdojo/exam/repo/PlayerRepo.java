package com.codingdojo.exam.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.exam.model.Player;
import com.codingdojo.exam.model.Team;

public interface PlayerRepo extends CrudRepository<Player, Long>{
	List<Player> findAll();
	Player findByIdIs(Long id);
	List<Player> findAllByTeam(Team team);
}
