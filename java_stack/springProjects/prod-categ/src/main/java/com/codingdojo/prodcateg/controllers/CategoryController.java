package com.codingdojo.prodcateg.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.prodcateg.models.Category;
import com.codingdojo.prodcateg.models.CategoryProduct;
import com.codingdojo.prodcateg.models.Product;
import com.codingdojo.prodcateg.services.CategoryService;
import com.codingdojo.prodcateg.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService catService;
	private final ProductService prodService;
	
	public CategoryController(CategoryService catService , ProductService prodService) {
		this.catService = catService ;
		this.prodService = prodService;
	}
	
	@RequestMapping("/categories/new")
	public String newCat(@ModelAttribute("category") Category category) {
		return "/prodcat/category.jsp";
	}
	
	@RequestMapping(value="/categories" , method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category , BindingResult result ) {
		if(result.hasErrors()) {
			return "/categories/new";
		}
		else {
			catService.createCategory(category);
			return "redirect:/products/" + category.getId();
		}
	}
	@RequestMapping(value="/attachproduct")
	public String attachProduct(@ModelAttribute("category") CategoryProduct categoryProduct ) {
		System.out.println(categoryProduct.getCategory().getName());
		System.out.println(categoryProduct.getProduct().getName());
		catService.addProdToCategory(categoryProduct);
		return "redirect:/categories/" + categoryProduct.getCategory().getId();
	}
	@RequestMapping("categories/{catid}")
	public String showCategory(@PathVariable("catid") Long catid , @ModelAttribute("category") CategoryProduct categoryProduct, Model model) {
		Category category = catService.findCat(catid);
		model.addAttribute("category" , category);
		model.addAttribute("products", prodService.availableProductsForCategory(category));
		return "/prodcat/newcategory.jsp";
	}	
}
