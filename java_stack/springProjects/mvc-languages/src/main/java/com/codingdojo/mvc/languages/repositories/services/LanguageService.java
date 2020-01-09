package com.codingdojo.mvc.languages.repositories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.languages.models.Language;
import com.codingdojo.mvc.languages.repositories.LanguageRepository;



@Service
public class LanguageService {
	// adding the Language repository as a dependency
    private final LanguageRepository langRepo;
    
    public LanguageService(LanguageRepository langRepo) {
    	this.langRepo = langRepo;
    }
    
    // returns all the languages
    public List<Language> allLanguages() {
        return langRepo.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return langRepo.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLang = langRepo.findById(id);
        if(optionalLang.isPresent()) {
            return optionalLang.get();
        } else {
            return null;
        }
    }
}
