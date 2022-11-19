package com.codingdojo.burgerTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.burgerTracker.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
	List<Burger> findAll();
}
