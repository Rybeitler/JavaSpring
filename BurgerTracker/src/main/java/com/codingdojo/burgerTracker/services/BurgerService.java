package com.codingdojo.burgerTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository burgerRepo;
	
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	public List<Burger> getAllBurgers(){
		return burgerRepo.findAll();
	}
	
	public Burger getById(Long id) {
		Optional<Burger> burger = burgerRepo.findById(id);
		return burger.orElseGet(() -> null);
	}
	
	public Burger updateBurger(Burger burgerEdit) {
		return burgerRepo.save(burgerEdit);
	}
	
	public void deleteBurger(Long id) {
		burgerRepo.deleteById(id);
	}
}
