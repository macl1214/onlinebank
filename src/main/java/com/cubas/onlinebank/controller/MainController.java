package com.cubas.onlinebank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cubas.onlinebank.entity.User;
import com.cubas.onlinebank.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<User> users = userService.getUsers();
		
		users.forEach(user -> System.out.println(user));
		
		return "home";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "authentication/login";
	}
	
	@GetMapping("/register")
	public String getRegistration(Model model) {
		
		model.addAttribute("user", new User());
		
		return "authentication/register";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") User user) {
		
		return "redirect:/";
	}
	
	@GetMapping("/aboutUs") 
	public String getAboutUs() {
		
		return "about-us";
	}
}
