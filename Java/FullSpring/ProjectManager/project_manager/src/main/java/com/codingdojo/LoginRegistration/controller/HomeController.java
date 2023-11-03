package com.codingdojo.LoginRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.LoginRegistration.model.LoginUser;
import com.codingdojo.LoginRegistration.model.Project;
import com.codingdojo.LoginRegistration.model.Task;
import com.codingdojo.LoginRegistration.model.User;
import com.codingdojo.LoginRegistration.service.ProjectService;
import com.codingdojo.LoginRegistration.service.TaskService;
import com.codingdojo.LoginRegistration.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class HomeController {
 
	@Autowired
	private ProjectService projectService;
	@Autowired
	private UserService userServ;
	
	@Autowired
	private TaskService taskService;
 
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
 
     return "redirect:/dashboard";
 }
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.setAttribute("userId", null);
	 return "redirect:/";
 }
 
 @GetMapping("/dashboard")
 public String home(Model model, HttpSession session) {
	 Long userId= (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 User user= userServ.findById(userId);
	 model.addAttribute("user", user);
	 model.addAttribute("projects", projectService.all());
	 model.addAttribute("assignedprojects", projectService.byUser(user));
	 model.addAttribute("unassignedProjects", projectService.allexcept(user));
	 
	 return "dashboard.jsp";
 }
 @GetMapping("/projects/{project_id}/tasks")
 public String tasks(@PathVariable("project_id") Long project_id, HttpSession session, Model model,@ModelAttribute("task") Task task) {
	 Long userId= (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 Project thisproject = projectService.find(project_id);
	 User user= userServ.findById(userId);
	 
	 model.addAttribute("projecttasks",taskService.byProjects(thisproject));
	 model.addAttribute("username", user);
	 model.addAttribute("thisproject",thisproject);
	 return "task.jsp";
 }
 @PostMapping("/add/task/{thisproject_id}")
 public String addtasks(@PathVariable("thisproject_id") Long thisproject_id, HttpSession session, @ModelAttribute("task") Task task, BindingResult result) {
	 Long userId= (Long) session.getAttribute("userId");
	 if(userId==null) {
		 return "redirect:/";
	 }
	 Project project= projectService.find(thisproject_id);
	 task.setProject(project);
	 taskService.createtask(task);
	 
	 return "redirect:/projects/"+thisproject_id + "/tasks";
 }
 
 
 
 
 @GetMapping("/dashboard/join/{id}")
 public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.find(id);
		User user = userServ.findById(userId);
		
		user.getProject().add(project);
		userServ.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("unassignedProjects", projectService.allexcept(user));
		model.addAttribute("assignedProjects", projectService.byUser(user));
		
		return "redirect:/dashboard";
	}
 @GetMapping("/dashboard/leave/{id}")
 public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.find(id);
		User user = userServ.findById(userId);
		
		user.getProject().remove(project);
		userServ.updateUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("unassignedProjects", projectService.allexcept(user));
		model.addAttribute("assignedProjects", projectService.byUser(user));
		
		return "redirect:/dashboard";
	}
 @GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("userId", userId);
		return "add.jsp";
	}
 @GetMapping("/projects/{project_id}")
	public String display(@PathVariable("project_id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("project", projectService.find(id));
		return "display.jsp";
	}
 @GetMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Project project = projectService.find(id);
		projectService.deleteProject(project);
		
		return "redirect:/dashboard";
	}
 @GetMapping("/projects/edit/{project_id}")
	public String edithisproject(@PathVariable("project_id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.find(id);
		model.addAttribute("project", project);
		return "edit.jsp";
	}
 
 
 @PostMapping("/edit/{id}")
	public String editProject(@PathVariable("id") Long id,@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			Project thisProject = projectService.find(id);
			
			project.setUsers(thisProject.getUsers());
			project.setLead(user);
			projectService.update(project);
			return "redirect:/dashboard";
		}
	}
 @PostMapping("/add")
	public String addNewProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		if(result.hasErrors()) {
			return "add.jsp";
		}else {
			projectService.create(project);
			
			Long userId = (Long) session.getAttribute("userId");
			User user = userServ.findById(userId);
			user.getProject().add(project);
			userServ.updateUser(user);
			return "redirect:/dashboard";
		}
	}
 
}

