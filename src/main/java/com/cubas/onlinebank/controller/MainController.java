package com.cubas.onlinebank.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cubas.onlinebank.dto.UserDto;
import com.cubas.onlinebank.entity.User;
import com.cubas.onlinebank.service.StatesService;
import com.cubas.onlinebank.service.UserService;
import com.cubas.onlinebank.validation.UserAlreadyExistException;

@Controller
public class MainController {
	
	@Autowired
	StatesService statesService;
	
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
		
		Map<String, String> states = statesService.getAllStates();
		
		model.addAttribute("user", new UserDto());
		model.addAttribute("states", states);
		
		return "authentication/register";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("user") @Valid UserDto userDto,
						   BindingResult result,
						   Model model) {
		
		Map<String, String> states = statesService.getAllStates();
		
		if (result.hasErrors()) {
			model.addAttribute("states", states);
			return "authentication/register";
		}
		
		try {
			
			User registered = userService.registerNewUserAccount(userDto);
			model.addAttribute("user", registered);
			return "redirect:/";
			
		} catch (UserAlreadyExistException uaeEx) {

			result.addError(new ObjectError("emailExists", "An account for that username/email already exists"));
			model.addAttribute("states", states);
			return "authentication/register";
		}
	}
	
	@GetMapping("/aboutUs") 
	public String getAboutUs() {
		
		return "about-us";
	}
	
	@GetMapping("/samplePortal")
	public String getSamplePortal() {
		
		return "sample-portal";
	}
}
