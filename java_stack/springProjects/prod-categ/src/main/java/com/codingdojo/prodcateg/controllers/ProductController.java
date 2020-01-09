package com.codingdojo.prodcateg.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.prodcateg.models.CategoryProduct;
import com.codingdojo.prodcateg.models.Product;
import com.codingdojo.prodcateg.services.CategoryService;
import com.codingdojo.prodcateg.services.ProductService;

@Controller
public class ProductController {
	private final ProductService prodService;
	private final CategoryService catService;
	
	public ProductController(ProductService prodService , CategoryService catService) {
		this.prodService = prodService;
		this.catService = catService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/prodcat/product.jsp";
	}
	@RequestMapping(value="/addproduct" , method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/prodcat/product.jsp";
		}
		else {
			prodService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	@RequestMapping("/products/{productid}")
	public String product(@PathVariable("productid") Long prodid , @ModelAttribute("categoryProduct") CategoryProduct categoryProduct,Model model) {
		Product prod = prodService.getProduct(prodid);
		model.addAttribute("product" , prod);
		model.addAttribute("categories" , catService.availableCategoriesForProduct(prod));
		return "/prodcat/newproducts.jsp";
		
	}
	@RequestMapping("/attachcategory")
	public String attachCategory(@ModelAttribute("category") CategoryProduct categoryProduct) {
		System.out.println(categoryProduct.getCategory().getName());
		System.out.println(categoryProduct.getProduct().getName());
		prodService.addCatToProduct(categoryProduct);
		return "redirect:/products/" + categoryProduct.getProduct().getId();
	}
	
	
	
	
}
