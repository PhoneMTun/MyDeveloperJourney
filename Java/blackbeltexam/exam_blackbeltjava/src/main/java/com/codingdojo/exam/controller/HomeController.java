package com.codingdojo.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.exam.model.LoginUser;
import com.codingdojo.exam.model.Player;
import com.codingdojo.exam.model.Team;
import com.codingdojo.exam.model.User;
import com.codingdojo.exam.service.PlayerService;
import com.codingdojo.exam.service.TeamService;
import com.codingdojo.exam.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class HomeController {
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PlayerService playerService;


  @Autowired
  private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model, HttpSession session) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
	 String successMessage = (String) session.getAttribute("successMessage");
	    
	    if(successMessage != null){
	        model.addAttribute("successMessage", successMessage);
	        session.removeAttribute("successMessage"); // remove it so it doesn't persist across requests
	    }
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
     session.setAttribute("successMessage", "Registration successful!");
 
     return "redirect:/";
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
 
// dashboard
 @GetMapping("/home")
 public String home(Model model, HttpSession session) {
	 Long userId= (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 User user= userServ.findById(userId);
	 model.addAttribute("user", user);
	 model.addAttribute("player", playerService.all());
	 model.addAttribute("teams",teamService.all());
	 return "dashboard.jsp";
 }
 
// updating
 @GetMapping("teams/{team_id}/edit")
 public String editteampage(@PathVariable("team_id")Long team_id, @ModelAttribute("team") Team team, HttpSession session, Model model) {
	 if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		model.addAttribute("team", teamService.find(team_id));
		return "edit.jsp";
 }
 
 @PostMapping("/edit/{team_id}")
 public String editTeam(@PathVariable("team_id") Long team_id, @Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
     if(session.getAttribute("userId") == null) {
         return "redirect:/logout";
     }

     Long userId = (Long) session.getAttribute("userId");
     User user = userServ.findById(userId);

     if(result.hasErrors()) {
         return "edit.jsp";
     }
     Team thisTeam = teamService.find(team_id);
     thisTeam.setName(team.getName()); 
     thisTeam.setCreator(user);
     teamService.update(thisTeam);
     return "redirect:/home";
 }

// add
 @GetMapping("teams/new")
 public String createteampage(@ModelAttribute("team") Team team, HttpSession session, Model model) {
	 if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		return "add.jsp";
}
 @PostMapping("/add")
	public String addteam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			teamService.create(team);
			
			Long userId = (Long) session.getAttribute("userId");
			User user = userServ.findById(userId);
			user.getTeam().add(team);
			userServ.updateUser(user);
			return "redirect:/home";
		}
	}


// delete
 @GetMapping("/teams/delete/{team_id}")
 	public String deleteTeam(@PathVariable("team_id") Long team_id, HttpSession session) {

	 if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	 Team team = teamService.find(team_id);
	 for(Player player : team.getPlayers()) {
	        playerService.deletePlayer(player);
	    }
	 teamService.deleteTeam(team);
	 return "redirect:/home";
 }
 
 
// addplayers
 @GetMapping("/teams/{team_id}")
	 public String teampage(@PathVariable("team_id") Long team_id,HttpSession session, Model model, @ModelAttribute("player") Player player  ) { 
	 if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	 Long userId = (Long) session.getAttribute("userId");
	 Team team=teamService.find(team_id);
	 model.addAttribute("team", teamService.find(team_id));
	 model.addAttribute("players", playerService.byteams(team));
	 model.addAttribute("userId", userId);
	 return "display.jsp";
	 
 }
 @PostMapping("/add/player/{team_id}")
 public String addplayer(@Valid@ModelAttribute("player") Player player, BindingResult result,@PathVariable("team_id") Long team_id, HttpSession session, Model model ) {
     Long userId = (Long) session.getAttribute("userId");
     model.addAttribute("userId",userId);
     if (userId == null) {
         return "redirect:/";
     }

     Team team = teamService.find(team_id);
     if (teamService.countPlayersInTeam(team) >= 9) {
         result.rejectValue("team", "Full", "The team already has 9 players!");
     }

     if (result.hasErrors()) {
    	 model.addAttribute("team", team); 
    	 model.addAttribute("players", team.getPlayers());
         return "display.jsp";
     }

     player.setTeam(team);
     playerService.createplayer(player);
     return "redirect:/teams/" + team_id;
 }

}
