package com.codingdojo.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.LoginRegistration.model.LoginUser;
import com.codingdojo.LoginRegistration.model.User;
import com.codingdojo.LoginRegistration.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class HomeController {
 

  @Autowired
  private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "welcome.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
     // to do some extra validations and create a new user!
	 userServ.register(newUser, result);
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "welcome.jsp";
     }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", newUser.getId());
 
     return "redirect:/home";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
      User user = userServ.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "welcome.jsp";
     }
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", user.getId());
 
     return "redirect:/home";
 }
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.setAttribute("userId", null);
	 return "redirect:/";
 }
 
 @GetMapping("/home")
 public String home(Model model, HttpSession session) {
	 Long userId= (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 User user= userServ.findById(userId);
	 model.addAttribute("user", user);
	 return "dashboard.jsp";
 }
 
}

