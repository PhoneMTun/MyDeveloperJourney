package com.codingdojo.ProjectandCategories.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.ProjectandCategories.model.Category;
import com.codingdojo.ProjectandCategories.model.Product;

public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();
	Category findByIdIs(Long id);
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
