package com.sb.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sb.school.domain.User;
import com.sb.school.service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("LIST", userService.getList());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(User user) {
		userService.join(user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String username) {
		userService.deleteUser(username);
		return "redirect:/";
	}
}
