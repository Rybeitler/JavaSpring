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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;
import com.codingdojo.catsProds.services.CategoryService;
import com.codingdojo.catsProds.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private CategoryService catServ;
	@Autowired
	private ProductService prodServ;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("newProd")Product prod) {
		return "addProduct.jsp";
	}
	@GetMapping("products/{id}")
	public String showCat(@PathVariable Long id, Model model, @ModelAttribute("addToProd")Product prod) {
		Product thisProd = prodServ.getProdById(id);
		model.addAttribute("product", thisProd);
		model.addAttribute("assignedCat", catServ.getAddedProducts(thisProd));
		model.addAttribute("availableCat", catServ.getNonProducts(thisProd));
		return "showProd.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("newProd")Product prod, BindingResult result) {
		if(result.hasErrors()) {
			return "addProduct.jsp";
		}
		prodServ.createProduct(prod);
		return "redirect:/";
	}
	@PostMapping("products/{id}")
	public String addToProd(@PathVariable("id")Long id, @RequestParam("categoryId")Long catId, Model model) {
		Product prod = prodServ.getProdById(id);
		Category cat = catServ.getCatById(catId);
		prod.getCategories().add(cat);
		prodServ.updateProd(prod);
		model.addAttribute("product", prod);
		model.addAttribute("assignedCat", catServ.getAddedProducts(prod));
		model.addAttribute("assignedCat", catServ.getNonProducts(prod));
		return "redirect:/products/"+id;
	}
}
