package com.example.SMS.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SMS.Entity.Student;
import com.example.SMS.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudents(){		
		return studentRepository.findAll();	
	}
	
	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}
	
	public Student updateStudent(int  id, Student updatedStudent) {
		
		Student existingStudent = studentRepository.findById(id).orElse(null);
		
		if(existingStudent != null) {
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setEmail(updatedStudent.getEmail());
			existingStudent.setCourse(updatedStudent.getCourse());
			existingStudent.setEnrollmentDate(updatedStudent.getEnrollmentDate());
			return studentRepository.save(existingStudent);
		}
		return null;
	}
	
	public boolean deleteStudent(int id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Student> getStudentBycourse(String course){
		return studentRepository.findByCourse(course);
	}
	
	public List<Student> searchStudentsByName(String name){
		return studentRepository.findByName(name);
	}
	
	
}
