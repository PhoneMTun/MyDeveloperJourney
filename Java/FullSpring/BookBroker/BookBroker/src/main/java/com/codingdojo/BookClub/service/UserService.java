package com.codingdojo.BookClub.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.BookClub.model.LoginUser;
import com.codingdojo.BookClub.model.User;
import com.codingdojo.BookClub.repo.Userrepo;

@Service
public class UserService {
	@Autowired
	private Userrepo repo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser=repo.findByEmail(newUser.getEmail());
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm password match Password");
		}
		if(potentialUser.isPresent()){
			result.rejectValue("email", "Matches", "An account with that email already exists.");
		}
		if(result.hasErrors()) {
			return null;
		}
	String hasedString=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	newUser.setPassword(hasedString);
	return repo.save(newUser);
	}
	public User login(LoginUser newLoginUser, BindingResult result) {
		Optional<User> potentailUser= repo.findByEmail(newLoginUser.getEmailString());
		if(!potentailUser.isPresent()) {
			result.rejectValue("emailString", "Matches", "User not found");
			return null;
		}
		User user=potentailUser.get();
		if(!BCrypt.checkpw(newLoginUser.getPasswordString(), user.getPassword())){
			result.rejectValue("passwordString", "Matches", "Invalid Password!");	
		}
		if(result.hasErrors()) {
			return null;
		}
		return user;
	}
	public User findByid(Long id) {
		Optional <User> potentialUserOptional=repo.findById(id);
		if(potentialUserOptional.isPresent()) {
			return potentialUserOptional.get();
	
		}
		return null;
	}
		
}
