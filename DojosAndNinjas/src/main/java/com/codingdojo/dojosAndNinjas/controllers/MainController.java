package com.codingdojo.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosAndNinjas.models.Dojo;
import com.codingdojo.dojosAndNinjas.models.Ninja;
import com.codingdojo.dojosAndNinjas.services.DojoService;
import com.codingdojo.dojosAndNinjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/dojos";
	}
	@GetMapping("/dojos")
	public String dojos(Model model, @ModelAttribute("newDojo")Dojo dojo){
		model.addAttribute("dojos", dojoService.allDojos());
		return "dojos.jsp";
	}
	@GetMapping("/ninjas")
	public String ninjas(Model model, @ModelAttribute("newNinja")Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninjas.jsp";
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("newDojo")Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "dojos.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos";
	}
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("newNinja")Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "ninjas.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/dojos";
	}
}
