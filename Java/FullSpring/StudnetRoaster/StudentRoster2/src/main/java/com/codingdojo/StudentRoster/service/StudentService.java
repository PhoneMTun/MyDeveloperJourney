package com.codingdojo.StudentRoster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.StudentRoster.model.Course;
import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;
import com.codingdojo.StudentRoster.repo.StudentRepo;

@Service
public class StudentService {
	private final StudentRepo repo;
	public StudentService(StudentRepo repo) {
		this.repo =repo;
	}
	public List<Student> all(){
		return repo.findAll();
	}
	public List<Student> allexcept(Dorm dorm){
		return repo.findByDormNotOrDormIsNull(dorm);
	}
	public Student create(Student student) {
		return repo.save(student);
	}
	public Student update(Student student) {
		return repo.save(student);
	}
	public Student find(Long id) {
		Optional<Student> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	public List<Student> byDorm(Dorm dorm){
		return repo.findAllByDorm(dorm);
	}
	public List<Student> byCourse(Course course){
		return repo.findAllByCourses(course);
	}
	
	public void removeDorm(Student student) {
		student.setDorm(null);
		repo.save(student);
	}
	public void removeCourse(Student student){
		student.setCourses(null);
		repo.save(student);
	}
}

