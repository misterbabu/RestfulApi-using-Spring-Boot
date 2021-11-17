package com.students.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("home")
	/*public String home(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("Hi "+name);
		session.setAttribute("name", name);
		return "home";
	}*/
	/*public String home(String name,HttpSession session)
	{
		session.setAttribute("name",name);
		return "home";
	}*/
	public String home(@RequestParam("name") String myName,HttpSession session)
	{
		session.setAttribute("name", myName);
		return "home";
	}
}
