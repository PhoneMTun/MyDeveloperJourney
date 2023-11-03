package com.codingdojo.RetryExamJava.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.RetryExamJava.model.Song;
import com.codingdojo.RetryExamJava.model.User;

public interface SongRepo extends CrudRepository<Song, Long>{
	List<Song> findAll();
	Song findByIdIs(Long id);
	List<Song> findAllByUsers(User user);
	List<Song> findByUsersNotContains(User user);
	Optional<Song>  findByName(String name);
}
