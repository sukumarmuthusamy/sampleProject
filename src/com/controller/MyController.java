package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.service.UserServiceimpl;


@Controller
public class MyController 
{
	@RequestMapping("/displayForm")
	public ModelAndView recieveRequest()
	{
		ModelAndView mv = new ModelAndView("myform");
		User user = new User();
		mv.addObject("user", user);
		return mv;
		
	}
	@RequestMapping("/processForm")
	public ModelAndView processRequest1(@ModelAttribute("user")User user)
	{
		
		ModelAndView mv = new ModelAndView("HelloPage");
		UserServiceimpl us= new UserServiceimpl();
		User u =us.getUser(user);
		mv.addObject("data", u.getUser());
		return mv;
	}


}
