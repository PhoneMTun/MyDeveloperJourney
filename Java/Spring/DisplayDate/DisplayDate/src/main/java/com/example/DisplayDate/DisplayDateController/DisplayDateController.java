package com.example.DisplayDate.DisplayDateController;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "TimeDishboard.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM d, yyyy");
		Date date= new Date();
		model.addAttribute("date", sdf.format(date));
		return "Date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		Date date= new Date();
		model.addAttribute("time", sdf.format(date));
		return "Time.jsp";
	}
	
	
}
