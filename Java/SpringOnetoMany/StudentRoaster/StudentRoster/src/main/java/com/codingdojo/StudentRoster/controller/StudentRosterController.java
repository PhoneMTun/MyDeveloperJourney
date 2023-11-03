package com.codingdojo.StudentRoster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;
import com.codingdojo.StudentRoster.service.DormService;
import com.codingdojo.StudentRoster.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentRosterController {
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String dorms(Model model) {
		List<Dorm> dorms=dormService.all();
		System.out.print(dorms);
		model.addAttribute("dorms", dorms);
		return "index.jsp";
	}
	@GetMapping("/newdorm")
	public String newdorm(@ModelAttribute("dorm") Dorm dorm) {
		return "NewDorm.jsp";
	}
	@GetMapping("/newstudent")
	public String newstudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.all());
		return "NewStudent.jsp";
	}
	@GetMapping("/dorms/{id}")
	public String diplaydorms(@PathVariable("id")Long id, Model model, @ModelAttribute("student") Student student) {
		model.addAttribute("dorm", dormService.find(id));
		model.addAttribute("students", studentService.allexcept(dormService.find(id)));
		return "display.jsp";
	}
	@PostMapping("/newdormadd")
	public String newdormadd(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDorm.jsp";
		}
		System.out.print(dorm);
		dormService.create(dorm);
		return "redirect:/";
	}
	@PostMapping("/newstudentadd")
	public String newstudentadd(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "NewStudent.jsp";
		}
		System.out.print(student);
		studentService.create(student);
		return "redirect:/";
	}
	@PostMapping("/editstudentindorm/{dormId}")
	public String editstudentindorm(@PathVariable("dormId") Long dormId,@ModelAttribute("student") Student student) {
		Dorm theDorm=dormService.find(dormId);
		Student studentwithisIdStudent= studentService.find(student.getId());
		studentwithisIdStudent.setDorm(theDorm);
		studentService.update(studentwithisIdStudent);
		return "redirect:/";
	}
	
	@PostMapping("/dorms/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		studentService.removeDorm(studentService.find(id));
		return "redirect:/";
	}
}
