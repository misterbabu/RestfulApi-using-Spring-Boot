package com.students.takemeout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
	@Autowired
	StudentRepository repo;
	@GetMapping("student")
	public List<Student> getStudents()
	{
		List<Student> students = (List<Student>)repo.findAll();
		
		
		return students;
	}

}
