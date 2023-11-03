package com.codingdojo.StudentRoster.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codingdojo.StudentRoster.model.Course;
import com.codingdojo.StudentRoster.model.Dorm;
import com.codingdojo.StudentRoster.model.Student;

public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
	List<Student> findAllByDorm(Dorm dorm);
	
	@Query("SELECT s FROM Student s WHERE s.dorm != :dorm OR s.dorm IS NULL")
	List<Student> findByDormNotOrDormIsNull(@Param("dorm") Dorm dorm);
	 
	List<Student> findAllByCourses(Course course);
	 List<Student> findByCoursesNotContains(Course course);
}
 