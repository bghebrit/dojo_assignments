package com.codingdojo.mvc.repositories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // updates a book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    public Book updateBook(Long id , String title , String desc , String lang , Integer numOfPages) {
    	Optional<Book> random = bookRepository.findById(id);
    	if(random != null) {
    		random.get().setTitle(title);
    		random.get().setDescription(desc);
    		random.get().setLanguage(lang);
    		random.get().setNumberOfPages(numOfPages);
    		return random.get();
    	}
    	else {
    		return null;
    	}
    }
    
    
    // retrieves a book

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }

}
