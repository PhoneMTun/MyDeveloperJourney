package com.codingdojo.ProjectandCategories.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.ProjectandCategories.model.Category;
import com.codingdojo.ProjectandCategories.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Product findByIdIs(Long id);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
