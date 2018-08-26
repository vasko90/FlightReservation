package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.FlightService;
import com.example.demo.services.UserService;

@Controller
public class UserController implements ErrorController{
	
	 private static final String PATH = "/error";
	
	@Autowired
	UserService userService;
	
	@Autowired
	FlightService flightService;

	@RequestMapping(value=PATH)
	public String error() {
		return "loginPage";
	}
	
	public String getErrorPath() {
	    return PATH;
	 }
	
	@RequestMapping("/login")
	public String login() {
		return "loginPage";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("user", new User());
		return "registerPage";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registrateUser(@Valid@ModelAttribute("user")User user,BindingResult result, RedirectAttributes ra){
		
		if(result.hasErrors()) {
			return "registerPage";
		}

		User u = userService.saveUser(user);
		
		if(u == null) {
			ra.addFlashAttribute("message", "User with email: "+user.getEmail()+" already exists.");
			return "redirect:/register";
		}
		
		return "redirect:/login";		
	}
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email")String email, @RequestParam("password") String password, RedirectAttributes ra, HttpSession session) {
		
		User user = userService.findUserByEmail(email);
		if(user == null) {
			ra.addFlashAttribute("message", "Invalid email address or password");
			return "redirect:/login";
		}
	
		if(password.equals(user.getPassword())) {
			session.setAttribute("departure", flightService.getDepartureCities());
			session.setAttribute("arrival", flightService.getArrivalCities());
			return "mainPage";
		}else {
			ra.addFlashAttribute("message", "Invalid email address or password");
			return "redirect:/login";
		}
		
	}
	
	
}
