package com.codingdojo.ProjectandCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.ProjectandCategories.model.Category;
import com.codingdojo.ProjectandCategories.model.Product;
import com.codingdojo.ProjectandCategories.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public List<Product> allProducts(){
		return repo.findAll();
	}
	public List<Product> getAssignedProducts(Category category){
		return repo.findAllByCategories(category);
	}
	public List<Product> getUnassignedProducts(Category category){
		return repo.findByCategoriesNotContains(category);
	}
	public Product findById(Long id) {
		Optional<Product> resultOptional=repo.findById(id);
		if(resultOptional.isPresent()) {
			return resultOptional.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public Product create(Product product) {
		return repo.save(product);
	}
	public Product update(Product product) {
		return repo.save(product);
	}
}
