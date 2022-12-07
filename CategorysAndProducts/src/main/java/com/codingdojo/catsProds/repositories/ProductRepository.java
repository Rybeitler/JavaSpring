package com.codingdojo.catsProds.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	List<Product>findAllByCategories(Category category);
	
	List<Product>findAllByCategoriesNotContains(Category category);
}
