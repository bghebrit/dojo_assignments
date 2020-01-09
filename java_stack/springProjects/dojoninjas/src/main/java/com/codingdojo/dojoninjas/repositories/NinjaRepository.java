package com.codingdojo.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja , Long>{
	
	List<Ninja> findAll();

}
