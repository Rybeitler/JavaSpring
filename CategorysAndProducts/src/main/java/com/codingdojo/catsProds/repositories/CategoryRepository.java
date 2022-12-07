package com.codingdojo.catsProds.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.catsProds.models.Category;
import com.codingdojo.catsProds.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category>findAll();
	
	List<Category>findAllByProducts(Product product);
	
	List<Category>findAllByProductsNotContains(Product product);
}
