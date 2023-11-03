package com.codingdojo.StudentRoster.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.StudentRoster.model.Course;
import com.codingdojo.StudentRoster.model.Student;

public interface CourseRepo extends CrudRepository<Course, Long>{
	List<Course> findAllByStudents(Student student);
	 List<Course> findByStudentsNotContains(Student student);
	 List<Course> findAll();
}
