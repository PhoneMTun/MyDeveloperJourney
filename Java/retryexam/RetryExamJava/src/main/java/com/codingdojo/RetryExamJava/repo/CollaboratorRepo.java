package com.codingdojo.RetryExamJava.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.RetryExamJava.model.Collaborator;
import com.codingdojo.RetryExamJava.model.Song;
import com.codingdojo.RetryExamJava.model.User;

public interface CollaboratorRepo extends CrudRepository<Collaborator, Long>{
	List<Collaborator> findAll();
	Collaborator findByIdIs(Long id);
	List<Collaborator> findAllBySong(Song song);
	Optional<Collaborator> findByUserAndSong(User user, Song song);
}
