package com.codingdojo.ProjectandCategories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ProjectandCategories.model.Category;
import com.codingdojo.ProjectandCategories.model.Product;
import com.codingdojo.ProjectandCategories.service.CategoryService;
import com.codingdojo.ProjectandCategories.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProjectandCategoriesController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products=productService.allProducts();
		List<Category> categories=categoryService.allCategories();
		model.addAttribute("products",products);
		model.addAttribute("categories",categories);
		return "index.jsp";
	}
	@GetMapping("/products/new")
	public String addproductpage(@ModelAttribute("product")Product product) {
		return "newproduct.jsp";
	}
	@GetMapping("/categories/new")
	public String addcategorypage(@ModelAttribute("category")Category category) {
		return "newcategory.jsp";
	}
	@GetMapping("/products/{product_id}")
	public String viewProduct(@PathVariable("product_id")Long product_id,Model model) {
		Product finding_product= productService.findById(product_id);
		model.addAttribute("product",finding_product);
		model.addAttribute("belongs", categoryService.getAssignedCategories(finding_product));
		model.addAttribute("notbelongs", categoryService.getUnassignedCategories(finding_product));
		return "ProductPage.jsp";
	}
	@PostMapping("/products/{product_id}/update")
	public String updateProduct(@PathVariable("product_id")Long product_id, @RequestParam(value = "categoryId") Long categoryId, Model model,@ModelAttribute("product")Product product) {
		Product finding_product= productService.findById(product_id);
		Category findCategory=categoryService.findById(categoryId);
		finding_product.getCategories().add(findCategory);
		productService.update(finding_product);
		return "redirect:/products/"+ product_id;
	}
	@GetMapping("/categories/{category_id}")
	public String viewCategory(@PathVariable("category_id")Long category_id,Model model) {
		Category finding_category= categoryService.findById(category_id);
		model.addAttribute("category",finding_category);
		model.addAttribute("belongs", productService.getAssignedProducts(finding_category));
		model.addAttribute("notbelongs", productService.getUnassignedProducts(finding_category));
		return "CategoryPage.jsp";
	}
	@PostMapping("/categories/{category_id}/update")
	public String updateCategory(@PathVariable("category_id")Long category_id, @RequestParam(value = "productId") Long productId, Model model,@ModelAttribute("category")Product Category) {
		Category finding_category= categoryService.findById(category_id);
		Product findproduct=productService.findById(productId);
		finding_category.getProducts().add(findproduct);
		categoryService.update(finding_category);
		return "redirect:/categories/"+ category_id;
	}
	
	
	
	
	
	
	
	@PostMapping("/add")
	public String addproduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}
		productService.create(product);
		return "redirect:/";
	}
	@PostMapping("/addcategory")
	public String addcategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newproduct.jsp";
		}
		categoryService.create(category);
		return "redirect:/";
	}
	
		
}
