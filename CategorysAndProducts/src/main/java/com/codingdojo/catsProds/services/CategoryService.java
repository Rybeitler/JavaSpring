package com.codingdojo.catsProds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;
import com.codingdojo.catsProds.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepo;
	
	public Category createCategory(Category newCat) {
		return catRepo.save(newCat);
	}
	public List<Category> getAllCat(){
		return catRepo.findAll();
	}	
	public Category getCatById(Long id) {
		Optional<Category> cat = catRepo.findById(id);
		return cat.orElseGet(() -> null);
	}
	public Category updateCat(Category cat) {
		return catRepo.save(cat);
	}
	public void deleteCat(Category category) {
		catRepo.delete(category);
	}
	public List<Category> getAddedProducts(Product product){
		return catRepo.findAllByProducts(product);
	}
	public List<Category>getNonProducts(Product product){
		return catRepo.findAllByProductsNotContains(product);
	}
}
