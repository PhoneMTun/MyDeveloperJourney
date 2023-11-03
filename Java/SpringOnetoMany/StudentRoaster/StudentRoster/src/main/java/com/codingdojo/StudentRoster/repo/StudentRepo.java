package com.codingdojo.StudentRoster.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
	List<Student> findAllByDorm(Dorm dorm);
	 List<Student> findByDormNot(Dorm dorm);
}
