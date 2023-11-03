package com.example.Counter.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;


@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count=0;
		if(session.getAttribute("count")==null) {
			session.setAttribute("count",0);
		}else {
			count=(Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter() {
		return "welcome.jsp";
	}
	@RequestMapping("/upby2")
	public String counter2(HttpSession session) {
		Integer count=0;
		if(session.getAttribute("count")==null) {
			session.setAttribute("count",0);
		}else {
			count=(Integer) session.getAttribute("count");
			count+=2;
			session.setAttribute("count", count);
		}
		return "upby2.jsp";
	}
	@RequestMapping("/reset")
	public String resetCounter(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}
}
