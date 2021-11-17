package com.students.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.entity.Student;
import com.students.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		try {
			return new ResponseEntity<>(repo.save(student),HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents()
	{
		try {
			List<Student> list = (List<Student>) repo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
			} 
		catch (Exception e) {
			return new ResponseEntity<List<Student>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id)
	{
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Student>(student.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
			
	}
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		try {
			return new ResponseEntity<Student>(repo.save(student),HttpStatus.OK);
			
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
		try {
			Optional<Student> student = repo.findById(id);
			if (student.isPresent()) {
				repo.delete(student.get());
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
