package com.students.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
	public ModelAndView home(Student stud)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",stud);
		mv.setViewName("home");
		return mv;
	}
}
