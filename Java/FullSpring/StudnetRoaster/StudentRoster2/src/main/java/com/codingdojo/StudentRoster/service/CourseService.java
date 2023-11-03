package com.codingdojo.StudentRoster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.StudentRoster.model.Course;
import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;
import com.codingdojo.StudentRoster.repo.CourseRepo;

@Service
public class CourseService {
	@Autowired
	CourseRepo repo;
	
	public List<Course> all(){
		return repo.findAll();
	}
	public List<Course> allexcept(Student student){
		return repo.findByStudentsNotContains(student);
	}
	public Course create(Course course) {
		return repo.save(course);
	}
	public Course update(Course course) {
		return repo.save(course);
	}
	public Course find(Long id) {
		Optional<Course> result=repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}else {
				return null;
			}
		}
	
	

}
