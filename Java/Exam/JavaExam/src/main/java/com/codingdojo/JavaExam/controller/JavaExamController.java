package com.codingdojo.JavaExam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.JavaExam.model.Baby;
import com.codingdojo.JavaExam.model.LoginUser;
import com.codingdojo.JavaExam.model.User;
import com.codingdojo.JavaExam.model.Vote;
import com.codingdojo.JavaExam.service.BabyService;
import com.codingdojo.JavaExam.service.UserService;
import com.codingdojo.JavaExam.service.VoteService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class JavaExamController{
	
	@Autowired
	private BabyService babyService;
	@Autowired 
	private VoteService voteService;
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
	 model.addAttribute("babies",babyService.all());
	 return "dashboard.jsp";
}
//add
@GetMapping("/names/new")
public String createbabypage(@ModelAttribute("baby") Baby baby, HttpSession session, Model model) {
	if(session.getAttribute("userId") == null) {
		return "redirect:/logout";
	}
	Long userId = (Long) session.getAttribute("userId");
	model.addAttribute("userId", userId);
	return "add.jsp";
}
@PostMapping("/add/baby")
public String addbaby(@Valid @ModelAttribute("baby") Baby baby, BindingResult result, HttpSession session, Model model) {
    if(session.getAttribute("userId") == null) {
        return "redirect:/logout";
    }

    if(result.hasErrors()) {
        return "add.jsp";
    }

   
    Baby savedBaby = babyService.create(baby, result);
    if (savedBaby == null || result.hasErrors()) {
        return "add.jsp"; 
    }

    Long userId = (Long) session.getAttribute("userId");
    User user = userServ.findById(userId);
    user.getBaby().add(baby);
    userServ.updateUser(user);
    return "redirect:/home";
}


//display
@GetMapping("/names/{baby_id}")
public String editteampage(@PathVariable("baby_id")Long baby_id,  HttpSession session, Model model) {
	if(session.getAttribute("userId") == null) {
		return "redirect:/logout";
	}
	Long userId = (Long) session.getAttribute("userId");
	Vote vote = voteService.findByBabyAndUser(baby_id, userId);

	model.addAttribute("baby",babyService.find(baby_id));
	model.addAttribute("vote",vote);
	model.addAttribute("userId", userId);
	return "display.jsp";
}
//edit
@GetMapping("/names/{baby_id}/edit")
public String editbabypage(@PathVariable("baby_id")Long baby_id, @ModelAttribute("baby") Baby baby, HttpSession session, Model model) {
	if(session.getAttribute("userId") == null) {
        return "redirect:/logout";
    }
    Long userId = (Long) session.getAttribute("userId");
    model.addAttribute("userId", userId);
	model.addAttribute("baby", babyService.find(baby_id));
	return "update.jsp";
    
}
@PostMapping("/edit/{baby_id}")
public String editbaby(@Valid @ModelAttribute("baby") Baby baby, BindingResult result,@PathVariable("baby_id")Long baby_id, HttpSession session, Model model) {
	if(session.getAttribute("userId") == null) {
        return "redirect:/logout";
    }
    Long userId = (Long) session.getAttribute("userId");
    User user = userServ.findById(userId);

    if(result.hasErrors()) {
        return "edit.jsp";
    }
    if(result.hasErrors()) {
        return "edit.jsp";
    }
    Baby thisBaby = babyService.find(baby_id);
    thisBaby.setName(baby.getName()); 
    thisBaby.setCreator(user);
    babyService.update(thisBaby);
    return "redirect:/home";
}
//delete
@GetMapping ("/teams/delete/{baby_id}")
public String deleteTeam(@PathVariable("baby_id") Long baby_id, HttpSession session) {
	if(session.getAttribute("userId") == null) {
		return "redirect:/logout";
	}
	babyService.deleteBaby(babyService.find(baby_id));
	return "redirect:/home";
}
//countvote
@GetMapping("/count/{babyId}")
public String upvote(@PathVariable("babyId") Long babyId, HttpSession session, Model model, RedirectAttributes redirectAttributes) {
    Long userId = (Long) session.getAttribute("userId");
    if(userId == null) {
        return "redirect:/logout"; 
    }
    User user = userServ.findById(userId);
    Baby baby = babyService.find(babyId);
    
    String voteMessage = voteService.castVote(user, baby);
    redirectAttributes.addFlashAttribute("voteMessage", voteMessage);
    
    return "redirect:/home";
}



}
