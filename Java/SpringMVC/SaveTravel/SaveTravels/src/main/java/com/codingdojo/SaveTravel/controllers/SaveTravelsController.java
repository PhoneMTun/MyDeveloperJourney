package com.codingdojo.SaveTravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.SaveTravel.models.SaveTravel;
import com.codingdojo.SaveTravel.services.SaveTravelService;

import jakarta.validation.Valid;

@Controller
public class SaveTravelsController {
	@Autowired
	SaveTravelService saveTravelService;
	@GetMapping("/")
	public String index(@ModelAttribute("saveTravel") SaveTravel saveTravel, Model model) {
		List<SaveTravel> saveTravels= saveTravelService.allSaveTravels();
		model.addAttribute("saveTravels", saveTravels);
		return "index.jsp";
	}
	@PostMapping("/add")
	public String newSaveTravel(@Valid @ModelAttribute("saveTravel") SaveTravel saveTravel, BindingResult result) {
		if(result.hasErrors()) {
			return"index.jsp";
		}
		saveTravelService.createSaveTravels(saveTravel);
		return "redirect:/";
	}
	@GetMapping("/expenses/{saveTravelId}")
	public String show(Model model,@PathVariable("saveTravelId")Long saveTravelId) {
		System.out.print(saveTravelId);
		model.addAttribute("saveTravel", saveTravelService.findSaveTravels(saveTravelId));
		return "show.jsp";
	}
	
	@GetMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id")Long id, Model model) {
		SaveTravel saveTravel= saveTravelService.findSaveTravels(id);
		model.addAttribute("saveTravel", saveTravel);
		return "update.jsp";
	}
	
	@PostMapping("/saveTravel/{id}")
	public String update(@Valid @ModelAttribute("saveTravel")SaveTravel saveTravel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "update.jsp";
		}
		saveTravelService.updateSaveTravels(saveTravel);
		return "redirect:/";
	}
	
	@PostMapping("/saveTravel/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		saveTravelService.deleteSaveTravelService(id);
		return "redirect:/";
		
	}
	}
	

	

