package com.codingdojo.prodcateg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodcateg.models.Category;
import com.codingdojo.prodcateg.models.CategoryProduct;
import com.codingdojo.prodcateg.models.Product;
import com.codingdojo.prodcateg.repositories.CategoryProductRepository;
import com.codingdojo.prodcateg.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository catRepo;
	private final CategoryProductRepository catProdRepo;
	
	public CategoryService(CategoryRepository catRepo ,CategoryProductRepository catProdRepo ) {
		this.catRepo = catRepo;
		this.catProdRepo = catProdRepo;
	}
	public List<Category> allCategories(){
		return catRepo.findAll();
	}
	public Category createCategory(Category c) {
		return catRepo.save(c);
	}
	public List<Category> availableCategoriesForProduct(Product product){
		return catRepo.findByProductsNotContains(product);
	}
	public void addProdToCategory(CategoryProduct categoryProduct) {
		catProdRepo.save(categoryProduct);
	}
	public Category findCat(Long id) {
		Optional<Category> category = catRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}

}
