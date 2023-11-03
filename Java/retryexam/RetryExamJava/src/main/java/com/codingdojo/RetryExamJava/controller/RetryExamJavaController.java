package com.codingdojo.RetryExamJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.RetryExamJava.model.Collaborator;
import com.codingdojo.RetryExamJava.model.LoginUser;
import com.codingdojo.RetryExamJava.model.Song;
import com.codingdojo.RetryExamJava.model.User;
import com.codingdojo.RetryExamJava.service.CollaboratorService;
import com.codingdojo.RetryExamJava.service.SongService;
import com.codingdojo.RetryExamJava.service.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RetryExamJavaController{
	@Autowired 
	private SongService songService;
	
	@Autowired 
	private CollaboratorService collaboratorService;

	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
	
		 String successMessage = (String) session.getAttribute("successMessage");
		    
		    if(successMessage != null){
		        model.addAttribute("successMessage", successMessage);
		        session.removeAttribute("successMessage");
		    }
	   model.addAttribute("newUser", new User());
	   model.addAttribute("newLogin", new LoginUser());
	   return "welcome.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
	       BindingResult result, Model model, HttpSession session) {
	
		 userServ.register(newUser, result);
		 
	   
	   if(result.hasErrors()) {
	       model.addAttribute("newLogin", new LoginUser());
	       return "welcome.jsp";
	   }
	   
	
	   session.setAttribute("userId", newUser.getId());
	   session.setAttribute("successMessage", "Registration successful!");
	
	   return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	       BindingResult result, Model model, HttpSession session) {
	   
	    User user = userServ.login(newLogin, result);
	
	   if(result.hasErrors()) {
	       model.addAttribute("newUser", new User());
	       return "welcome.jsp";
	   }
	
	   session.setAttribute("userId", user.getId());
	
	   return "redirect:/home";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		 session.setAttribute("userId", null);
		 return "redirect:/";
	}
	
	//dashboard
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		 Long userId= (Long) session.getAttribute("userId");
		 if(userId==null) {
			 return "redirect:/";
		 }
		 User user= userServ.findById(userId);
		 model.addAttribute("user", user);
		 model.addAttribute("songs",songService.all());
	
		 return "dashboard.jsp";
	}
	
	//add
	@GetMapping("/songs/new")
	public String createsongpage(@ModelAttribute("song") Song song,HttpSession session, Model model ) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		return "add.jsp";	
	}
	@PostMapping("/add/song")
	public String addsong(@Valid @ModelAttribute("song") Song song, BindingResult result, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
	        return "redirect:/logout";
	    }
	    if(result.hasErrors()) {
	        return "add.jsp";
	    }
	    if (song.getAdditionalLyric() != null && song.getAdditionalLyric().isEmpty()) {
	        song.setAdditionalLyric(null);
	    }
	    Song savedSong=songService.create(song, result);
	    if (savedSong == null || result.hasErrors()) {
	        return "add.jsp"; 
	    }
	    Long userId = (Long) session.getAttribute("userId");
	    User user = userServ.findById(userId);
	    user.getSong().add(song);
	    userServ.updateUser(user);
	    return "redirect:/home";
	}
	@GetMapping("/songs/{song_id}")
	public String editsongid(@PathVariable("song_id")Long song_id,  HttpSession session, Model model) {
	
	if(session.getAttribute("userId") == null) {
		return "redirect:/logout";
	}
	Long userId = (Long) session.getAttribute("userId");
	model.addAttribute("userId", userId);
	model.addAttribute("song", songService.find(song_id));
	model.addAttribute("collaborators", collaboratorService.bySong(songService.find(song_id)));
	return "display.jsp";
	}
//	edit
	@GetMapping("/songs/{song_id}/edit")
	public String editsongpage(@PathVariable("song_id") Long song_id, HttpSession session, Model model) {
	    
	    if (session.getAttribute("userId") == null) {
	        return "redirect:/logout";
	    }
	   
	    Long userId = (Long) session.getAttribute("userId");

	    model.addAttribute("userId", userId);

	    Song existingSong = songService.find(song_id);

	    model.addAttribute("song", existingSong);

	    return "update.jsp";
	}

	@PostMapping("/edit/{song_id}")
	public String editsong(
	        @Valid @ModelAttribute("song") Song song, BindingResult result, HttpSession session, Model model, @PathVariable("song_id") Long song_id) {

	    if (session.getAttribute("userId") == null) {
	        return "redirect:/logout";
	    }

	    Long userId = (Long) session.getAttribute("userId");
	    
	    User user = userServ.findById(userId);

	    if (result.hasErrors()) {
	        

	        return "update.jsp";
	    }

	    Song thisSong = songService.find(song_id);

	    thisSong.setName(song.getName());
	    thisSong.setGenre(song.getGenre());
	    thisSong.setLyric(song.getLyric());
	    thisSong.setAdditionalLyric(song.getAdditionalLyric());

	    songService.update(thisSong);

	    if (!user.equals(thisSong.getCreator())) {
	        Collaborator existingCollaborator = collaboratorService.findBySongAndUser(song_id, userId);

	        if (existingCollaborator == null) {
	            Collaborator collaborator = new Collaborator();
	            collaborator.setUser(user);
	            collaborator.setSong(thisSong);
	            collaboratorService.save(collaborator);
	        }
	    }

	    return "redirect:/home";
	}

	
	@GetMapping("/songs/delete/{song_id}")
 	public String deleteTeam(@PathVariable("song_id") Long song_id, HttpSession session) {

	 if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	 Song song = songService.find(song_id);
	 for(Collaborator collaborator : song.getCollaborators()) {
	        collaboratorService.deletecollaborator(collaborator);
	    }
	 songService.deleteSong(song);
	 return "redirect:/home";
	}

	


}

