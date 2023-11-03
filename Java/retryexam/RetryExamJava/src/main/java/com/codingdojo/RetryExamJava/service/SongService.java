package com.codingdojo.RetryExamJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


import com.codingdojo.RetryExamJava.model.Song;
import com.codingdojo.RetryExamJava.model.User;
import com.codingdojo.RetryExamJava.repo.SongRepo;

@Service
public class SongService {
	@Autowired SongRepo repo;

public List<Song> all(){
	return repo.findAll();
}
public Song create(Song song, BindingResult result) {
    Optional<Song> potentialSong = repo.findByName(song.getName());
    
    if (potentialSong.isPresent()) {
        result.rejectValue("name", "Duplicate", "A song with this name already exists!");
        return null;
    } else {
    	System.out.println("Saving new song: " + song.getName());
        return repo.save(song);
    }
}
public Song update(Song song) {
	
	String combinedLyric = song.getLyric() + " " + song.getAdditionalLyric();
    song.setLyric(combinedLyric);


	return repo.save(song);
}
public List<Song> byUser(User user){
	return repo.findAllByUsers(user);
}

public List<Song> allexcept(User user){
	return repo.findByUsersNotContains(user);
}
public void deleteSong(Song song) {
	repo.delete(song);
	
}
public Song find(Long id) {
	Optional<Song> result=repo.findById(id);
	if(result.isPresent()) {
		return result.get();
	}else {
			return null;
		}
	}

}
