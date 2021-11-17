package com.students.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.students.main.model.Student;
import com.students.main.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository repo;
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/addStudent")
	public String addStudent(Student student)
	{
		repo.save(student);
		return "home.jsp";
	}
	@RequestMapping("/students")
	@ResponseBody
	public List<Student> getStudents()
	{
		return repo.findAll();
		
	}
	@RequestMapping("/student/{id}")
	@ResponseBody
	public Optional<Student> getStudent(@PathVariable int id)
	{
		return repo.findById(id);
		
	}

}
