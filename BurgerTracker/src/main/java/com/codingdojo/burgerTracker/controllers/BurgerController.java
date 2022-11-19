package com.codingdojo.burgerTracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
							BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burgers", service.getAllBurgers());
			return "index.jsp";
		}
		service.createBurger(newBurger);
		return "redirect:/burger";
	}
	
	@GetMapping("/burger/{id}/edit")
	public String editBurgerPage(@PathVariable Long id, Model model) {
		model.addAttribute("thisBurger", service.getById(id));
		return "editBurger.jsp";
	}
	@PutMapping("/burger/{id}/edit")
	public String editBurger(@Valid @ModelAttribute("thisBurger")Burger editedBurger, BindingResult result) {
		if(result.hasErrors()) {
			return "editBurger.jsp";
		}
		service.updateBurger(editedBurger);
		return "redirect:/burger";
	}
	@GetMapping("burger/{id}/delete")
	public String deleteBurger(@PathVariable Long id) {
		service.deleteBurger(id);
		return "redirect:/burger";
	}
}
