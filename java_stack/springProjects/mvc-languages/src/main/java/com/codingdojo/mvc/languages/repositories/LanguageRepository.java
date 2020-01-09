package com.codingdojo.mvc.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository <Language, Long>{
	
	List<Language> findAll();
    // this method finds languages with descriptions containing the search string
    List<Language> findByDescriptionContaining(String search);
    // this method counts how many languages contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a language that starts with a specific title
    Long deleteByTitleStartingWith(String search);
    Optional<Language> findById(Long id);
    void deleteById(Long id);

}
