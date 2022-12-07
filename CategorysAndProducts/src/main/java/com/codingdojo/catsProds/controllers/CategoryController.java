package com.codingdojo.catsProds.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;
import com.codingdojo.catsProds.services.CategoryService;
import com.codingdojo.catsProds.services.ProductService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService catServ;
	@Autowired
	private ProductService prodServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", catServ.getAllCat());
		model.addAttribute("products", prodServ.getAllProd());
		return "index.jsp";
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("newCat")Category cat) {
		return "addCategory.jsp";
	}
	@GetMapping("/categories/{id}")
	public String showCat(@PathVariable Long id, Model model, @ModelAttribute("addToCat") Category cat) {
		Category thisCat = catServ.getCatById(id);
		model.addAttribute("category", thisCat);
		model.addAttribute("assignedProd", prodServ.getAssignedCategories(thisCat));
		model.addAttribute("availableProd", prodServ.getNonCategories(thisCat));
		return "showCat.jsp";
	}
	
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("newCat") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "addCategory.jsp";
		}
		catServ.createCategory(cat);
		return "redirect:/";
	}
	
	@PostMapping("/categories/{id}")
	public String addToCat(@PathVariable("id")Long id, @RequestParam(value="productId")Long productId, Model model) {
		Category cat = catServ.getCatById(id);
		Product prod = prodServ.getProdById(productId);
		cat.getProducts().add(prod);
		catServ.updateCat(cat);
		model.addAttribute("category", cat);
		model.addAttribute("assignedProd", prodServ.getAssignedCategories(cat));
		model.addAttribute("availableProd", prodServ.getNonCategories(cat));
		return "redirect:/categories/"+id;
	}
}
