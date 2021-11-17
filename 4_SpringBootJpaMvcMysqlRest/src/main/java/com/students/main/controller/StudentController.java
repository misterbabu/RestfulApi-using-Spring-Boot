package com.students.main.controller;

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
	public String getStudents()
	{
		return repo.findAll().toString();
		
	}
	@RequestMapping("/student/{id}")
	@ResponseBody
	public String getStudent(@PathVariable int id)
	{
		return repo.findById(id).toString();
		
	}

}
