package com.codingdojo.savetravels.controllers;

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

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService service;
	
	@GetMapping ("/")
	public String home() {
		return "redirect:/expenses";
	}
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("newExpense") Expense expense) {
		model.addAttribute("expenses", service.allExpenses());
		return "index.jsp";
	}
	@PostMapping("/expenses/new")
	public String addExpense(@Valid @ModelAttribute("newExpense")Expense newExpense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expenses", service.allExpenses());
			return "index.jsp";
		}
		service.createExpense(newExpense);
		return "redirect:/expenses";
	}
	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable Long id, Model model) {
		model.addAttribute("expense", service.findExpense(id));
		return "show.jsp";
	}
	@GetMapping("/expenses/edit/{id}")
	public String editExpensePage(@PathVariable Long id, Model model) {
		model.addAttribute("expense", service.findExpense(id));
		return "edit.jsp";
	}
	@PutMapping("/expenses/edit/{id}")
	public String editExpense(
			@Valid @ModelAttribute("expense")Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		service.updateExpense(expense);
		return "redirect:/expenses";
	}
	@GetMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable Long id) {
		service.deleteExpense(id);
		return "redirect:/expenses";
	}
}
