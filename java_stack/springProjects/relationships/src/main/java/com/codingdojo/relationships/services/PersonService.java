package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> allPersons(){
		return personRepo.findAll();
	}
	
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = personRepo.findById(id);
		if(person.isPresent()) {
			return person.get();
		}
		else {
			return null;
		}
	}

}
