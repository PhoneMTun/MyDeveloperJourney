package com.codingdojo.DojoNinja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.DojoNinja.models.Dojo;
import com.codingdojo.DojoNinja.models.Ninja;
import com.codingdojo.DojoNinja.services.DojoService;
import com.codingdojo.DojoNinja.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoNinjaController {
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	//Gets
	@GetMapping("/")
	public String index(@ModelAttribute("dojo")Dojo dojo) {
		
		return "redirect:/dojos/new";
	}
	@GetMapping("/dojos/new")
	public String newdojo(@ModelAttribute("dojo")Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "NewDojo.jsp";
	}
	@GetMapping("/ninjas/new")
	public String newninja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "NewNinja.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo=dojoService.find(id);
		model.addAttribute("dojo", dojo);
		return "DojoPage.jsp";
	}
	
	
	//Posts
	@PostMapping("/dojos")
	public String addDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return"NewDojo.jsp";
		}
		System.out.print(dojo);
		Dojo newDojo=dojoService.create(dojo);
		System.out.print(newDojo.getId());
		return String.format("redirect:/dojos/%s",newDojo.getId());
	}
	
	@PostMapping("/ninjas")
	public String addNinjas(		@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result){
	if (result.hasErrors()) {
		return "NewNinja.jsp";
	}
	ninja=ninjaService.create(ninja);
	return "redirect:/dojos/"+ninja.getDojo().getId(); 
	}
}

