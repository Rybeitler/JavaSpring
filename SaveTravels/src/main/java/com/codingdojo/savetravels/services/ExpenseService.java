package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository repo;
	
	public ExpenseService(ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public List<Expense> allExpenses(){
		return repo.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		return repo.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = repo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense editExpense) {
		return repo.save(editExpense);
	}
	
	public void deleteExpense(Long id) {
		repo.deleteById(id);
	}
}
