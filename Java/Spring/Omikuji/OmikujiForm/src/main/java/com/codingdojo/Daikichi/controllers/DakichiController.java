package com.codingdojo.Daikichi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class DakichiController {
	@RequestMapping("/daikichi")
	public String index() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "Today you will find all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	@RequestMapping("/omikuji")
	public String home() {
		return "send.jsp";
	}

	@PostMapping("/send")
	public String send(
			@RequestParam("num") int number,
			@RequestParam("cityname") String cityname,
			@RequestParam("personname") String personname,
			@RequestParam("hobby") String hobby,
			@RequestParam("livingthing") String livingthing,
			@RequestParam("nicething") String nicething,
			HttpSession session) {
		
		String resultOmikuji=String.format("In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
				number, cityname, personname, hobby, livingthing, nicething);
		session.setAttribute("resultOmikuji", resultOmikuji);
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		String result= (String) session.getAttribute("resultOmikuji");
		model.addAttribute("result", result);
		return "show.jsp";
	}
	

}
