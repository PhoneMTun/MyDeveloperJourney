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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.StudentRoster.model.Course;
import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;
import com.codingdojo.StudentRoster.service.CourseService;
import com.codingdojo.StudentRoster.service.DormService;
import com.codingdojo.StudentRoster.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentRosterController {
	@Autowired
	private DormService dormService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	@GetMapping("/classes")
	public String allclasspage(Model model) {
		model.addAttribute("courses", courseService.all());
		return "classes.jsp";
	}
	@GetMapping("/classes/{course_id}")
	public String allclasspage(Model model, @PathVariable("course_id")Long course_id) {
		model.addAttribute("course", courseService.find(course_id));
		return "EachClass.jsp";
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
	@GetMapping("/newclass")
	public String newclass(@ModelAttribute("course") Course course) {
		return "NewClass.jsp";
	}
	@GetMapping("/newstudent")
	public String newstudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.all());
		return "NewStudent.jsp";
	}
	@GetMapping("/dorms/{id}")
	public String diplaydorms(@PathVariable("id")Long id, Model model, @ModelAttribute("student") Student student) {
		model.addAttribute("dorm", dormService.find(id));
		model.addAttribute("studentsexcept", studentService.allexcept(dormService.find(id)));
		return "display.jsp";
	}
	@GetMapping("/students/{id}")
	public String diplaystudnets(@PathVariable("id")Long id, Model model) {
		model.addAttribute("student", studentService.find(id));
		model.addAttribute("coursesexcept", courseService.allexcept(studentService.find(id)));
		return "displayClass.jsp";
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
	@PostMapping("/newclassadd")
	public String newdormadd(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "NewClass.jsp";
		}
		System.out.print(course);
		courseService.create(course);
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
	public String editstudentindorm(@PathVariable("dormId") Long dormId,@ModelAttribute("student") Student student, @RequestParam("studentId") Long studentId) {
		Dorm theDorm=dormService.find(dormId);
		Student studentwithisIdStudent= studentService.find(studentId);
		studentwithisIdStudent.setDorm(theDorm);
		studentService.update(studentwithisIdStudent);
		return "redirect:/";
	}
	@PostMapping("/editstudentincourse/{student_Id}")
	public String editstudentindorm(@PathVariable("student_Id") Long student_Id,@ModelAttribute("course") Course course, @RequestParam("courseId") Long courseId) {
		Student thesStudent=studentService.find(student_Id);
		Course coursewithisIdcourse= courseService.find(courseId);
		coursewithisIdcourse.getStudents().add(thesStudent);
		courseService.update(coursewithisIdcourse);
		return "redirect:/students/"+student_Id;
	} 
	
	@GetMapping("/dorms/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		studentService.removeDorm(studentService.find(id));
		return "redirect:/";
	}
	@GetMapping("/course/{student_id}/drop/{selectcourse_id}")
	public String drop(@PathVariable("student_id") Long student_id, @PathVariable("selectcourse_id") Long selectcourse_id) {
		Student student=studentService.find(student_id);
		Course courseToDrop = courseService.find(selectcourse_id);
		student.getCourses().remove(courseToDrop);
		studentService.update(student);

		return "redirect:/students/"+student_id;
	}
}
