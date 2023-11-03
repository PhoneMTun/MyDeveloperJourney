package com.example.bookschema.controllers;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookschema.models.Book;
import com.example.bookschema.services.BookService;


@Controller
public class BookController {
	@Autowired
	BookService bookService;
	@GetMapping("/")
	public String home() {
		return "redirect:/books";
	}
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books= bookService.allBooks();
		model.addAttribute("books",books);
		return "index.jsp";
	}
	
	@GetMapping("/books/{BooksId}")
	public String view(Model model,@PathVariable("BooksId") Long BooksId ) {
		System.out.println(BooksId);
		Book book= bookService.findBook(BooksId);
		System.out.println(book);
		model.addAttribute("book", bookService.findBook(BooksId));
		return "show.jsp";
	}
}
