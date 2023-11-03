package com.codingdojo.BookClub.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.BookClub.model.Book;

@Repository
public interface Bookrepo extends CrudRepository<Book, Long>{
	List<Book> findAll();
	
}
