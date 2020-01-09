package com.codingdojo.prodcateg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodcateg.models.Category;
import com.codingdojo.prodcateg.models.CategoryProduct;
import com.codingdojo.prodcateg.models.Product;
import com.codingdojo.prodcateg.repositories.CategoryProductRepository;
import com.codingdojo.prodcateg.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository prodRepo;
	private final CategoryProductRepository catProdRepo;
	
	public ProductService(ProductRepository prodRepo , CategoryProductRepository catProdRepo) {
		this.prodRepo = prodRepo;
		this.catProdRepo = catProdRepo;
	}
	
	public List<Product> allProducts(){
		return prodRepo.findAll();
		
	}
	public Product createProduct(Product p) {
		return prodRepo.save(p);
	}
	public void addCatToProduct(CategoryProduct categoryProduct) {
		catProdRepo.save(categoryProduct);
	}
	public Product getProduct(Long id) {
		Optional <Product> prod = prodRepo.findById(id);
		if (prod.isPresent()) {
			return prod.get();
		}else {
			return null;
		}
		
	}
	public Iterable<Product> availableProductsForCategory(Category category){
		return prodRepo.findByCategoriesNotContains(category);
	}

}
