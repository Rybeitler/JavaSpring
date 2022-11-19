package com.codingdojo.burgerTracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.services.BurgerService;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService service;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/burger";
	}
	
	@GetMapping("/burger")
	public String index(Model model,
			@ModelAttribute("newBurger") Burger burger) {
		model.addAttribute("burgers", service.getAllBurgers());
		return "index.jsp";
	}
	@PostMapping("/burger/add")
	public String addBurger(@Valid @ModelAttribute("newBurger")Burger newBurger,
							BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		service.createBurger(newBurger);
		return "redirect:/burger";
	}
}
