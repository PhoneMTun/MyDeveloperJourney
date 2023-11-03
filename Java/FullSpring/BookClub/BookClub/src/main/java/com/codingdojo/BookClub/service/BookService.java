package com.codingdojo.BookClub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.BookClub.model.Book;
import com.codingdojo.BookClub.repo.Bookrepo;

@Service
public class BookService {
	@Autowired
	private Bookrepo repo;
	public List<Book> all(){
		return repo.findAll();
	}
	public Book create(Book book) {
		return repo.save(book);
	}
	public Book update(Book book) {
		return repo.save(book);
	}
	public Book findById(Long id) {
		Optional<Book> resultOptional=repo.findById(id);
		if(resultOptional.isPresent()) {
			return resultOptional.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}
