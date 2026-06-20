package com.example.SMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SMS.Entity.Student;
import com.example.SMS.Service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentService.addStudent(student));
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Student student = studentService.getStudentById(id).orElse(null);
		return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		Student updated = studentService.updateStudent(id, student);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		boolean deleted = studentService.deleteStudent(id);
		return deleted ? ResponseEntity.ok("Deleted Successfully") : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/course/{courseName}")
	public ResponseEntity<List<Student>> getStudentByCourse(@PathVariable String courseName){
		return ResponseEntity.ok(studentService.getStudentBycourse(courseName));
	}
	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudentsByName(@RequestParam String name){
		return ResponseEntity.ok(studentService.searchStudentsByName(name));
	}
	
	
}


