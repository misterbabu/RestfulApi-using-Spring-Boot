package com.students.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam int sid)
	{
		ModelAndView mv = new ModelAndView("showStudent.jsp");
		Student student = repo.findById(sid).orElse(new Student());
		
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findBySidGreaterThan(102));
		System.out.println(repo.findByTechSorted("Java"));
		
		mv.addObject(student);
		return mv;
		
	}

}
