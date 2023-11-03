package com.codingdojo.RetryExamJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.RetryExamJava.model.Collaborator;
import com.codingdojo.RetryExamJava.model.Song;
import com.codingdojo.RetryExamJava.model.User;
import com.codingdojo.RetryExamJava.repo.CollaboratorRepo;

@Service
public class CollaboratorService {
	@Autowired CollaboratorRepo repo;
	public Collaborator find(Long id) {
		Optional<Collaborator> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	public List<Collaborator> all(){
		return repo.findAll();
	}
	public List<Collaborator> bySong(Song song){
		return repo.findAllBySong(song);
	}
	public Collaborator save(Collaborator collaborator) {
		return repo.save(collaborator);
	}
	public void deletecollaborator(Collaborator collaborator) {
	    repo.delete(collaborator);
	}
	public Collaborator findBySongAndUser(Long songId, Long userId) {
	    Song song = new Song();
	    song.setId(songId);
	    
	    User user = new User();
	    user.setId(userId);
	    
	    Optional<Collaborator> result = repo.findByUserAndSong(user, song);
	    if(result.isPresent()) {
	        return result.get();
	    } else {
	        return null;
	    }
	}
}
