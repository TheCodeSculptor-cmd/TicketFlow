package com.example.SMS.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SMS.Entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	// 1. Spring generates: SELECT * FROM students WHERE course = ?
	List<Student> findByCourse(String course);
	// 2. Spring generates: SELECT * FROM students WHERE name LIKE %?%
	List<Student> findByName(String partialName);

}
