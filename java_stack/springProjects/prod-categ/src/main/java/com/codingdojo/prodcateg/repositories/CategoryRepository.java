package com.codingdojo.prodcateg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.prodcateg.models.Category;
import com.codingdojo.prodcateg.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category , Long> {
	
	List<Category> findAll();	
	List<Category> findByProductsNotContains(Product product);

}
