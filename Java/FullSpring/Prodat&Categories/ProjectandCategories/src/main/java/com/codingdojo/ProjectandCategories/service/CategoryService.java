package com.codingdojo.ProjectandCategories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.ProjectandCategories.model.Category;
import com.codingdojo.ProjectandCategories.model.Product;
import com.codingdojo.ProjectandCategories.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo repo;
	
	public List<Category> allCategories(){
		return repo.findAll();
	}
	public List<Category> getAssignedCategories(Product product){
		return repo.findAllByProducts(product);
	}
	public List<Category> getUnassignedCategories(Product product){
		return repo.findByProductsNotContains(product);
	}
	public Category findById(Long id) {
		Optional<Category> resultOptional=repo.findById(id);
		if(resultOptional.isPresent()) {
			return resultOptional.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	public Category create(Category category) {
		return repo.save(category);
	}
	public Category update(Category category) {
		return repo.save(category);
	}
}
