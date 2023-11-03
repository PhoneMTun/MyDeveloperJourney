package com.example.NinjaGoldGame.controllers;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaGoldGameController {
	Random random= new Random();
	@RequestMapping("/activities")
	public String activitie() {
		return "activity.jsp";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public String index(HttpSession session,
			@RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest,
			@RequestParam(value = "spa", required = false) String spa,
			@RequestParam(value = "reset", required = false) String reset){
		int count=0;
		ArrayList<String> activities= new ArrayList<String>();
		SimpleDateFormat dateFormat= new SimpleDateFormat("MMMM d Y h:mm a");
		Date curretDate=new Date();
		
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", count);
			session.setAttribute("activities", activities);
		}else {
			count=(int) session.getAttribute("count");
			activities=(ArrayList<String>)session.getAttribute("activities");
		}
		
		if(farm!=null) {
				int randomnum= random.nextInt(11)+10;
				count+=randomnum;
				activities.add(0,"You entered a farm and earned"+randomnum+" gold. ("+dateFormat.format(curretDate)+")");
					session.setAttribute("activities",activities);
					session.setAttribute("count", count);
					return "redirect:/";
				}
		if(cave!=null) {
			int randomnum= random.nextInt(6)+5;
			count+=randomnum;
			activities.add(0,"You entered a cave and earned"+randomnum+" gold. ("+dateFormat.format(curretDate)+")");
				session.setAttribute("activities",activities);
				session.setAttribute("count", count);
				return "redirect:/";
			}
		if(house!=null) {
			int randomnum= random.nextInt(3)+2;
			count+=randomnum;
			activities.add(0,"You entered a house and earned"+randomnum+" gold. ("+dateFormat.format(curretDate)+")");
				session.setAttribute("activities",activities);
				session.setAttribute("count", count);
				return "redirect:/";
			}
		if(quest!=null) {
			int randomnum= random.nextInt(51);
			count+=randomnum;
			activities.add(0,"You filed a quest and lost "+randomnum+" gold. ("+dateFormat.format(curretDate
					)+")");
				session.setAttribute("activities",activities);
				session.setAttribute("count", count);
				return "redirect:/";
			}
		if(spa!=null) {
			int randomnum= random.nextInt(16)+5;
			count+=randomnum;
			activities.add(0,"You filed a spa and lost "+randomnum+" gold. ("+dateFormat.format(curretDate
					)+")");
				session.setAttribute("activities",activities);
				session.setAttribute("count", count);
				return "redirect:/";
			}
		if(count>0) {
			session.setAttribute("count", 0);
			return "prison.jsp";
		}
		if(reset!=null) {
			session.setAttribute("count", 0);
				return "redirect:/";
			}
		return "index.jsp";
	}


}
