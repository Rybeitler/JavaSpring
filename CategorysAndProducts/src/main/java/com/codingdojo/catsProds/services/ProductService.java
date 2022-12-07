package com.codingdojo.catsProds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;
import com.codingdojo.catsProds.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository prodRepo;
	
	public Product createProduct(Product product) {
		return prodRepo.save(product);
	}
	public List<Product> getAllProd(){
		return prodRepo.findAll();
	}	
	public Product getProdById(Long id) {
		Optional<Product> prod = prodRepo.findById(id);
		return prod.orElseGet(() -> null);
	}
	public Product updateProd(Product product) {
		return prodRepo.save(product);
	}
	public void deleteProd(Product product) {
		prodRepo.delete(product);
	}
	public List<Product> getAssignedCategories(Category category){
		return prodRepo.findAllByCategories(category);
	}
	public List<Product>getNonCategories(Category category){
		return prodRepo.findAllByCategoriesNotContains(category);
	}
}
