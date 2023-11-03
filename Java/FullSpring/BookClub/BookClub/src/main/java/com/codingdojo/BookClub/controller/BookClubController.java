package com.codingdojo.BookClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.BookClub.model.Book;
import com.codingdojo.BookClub.model.LoginUser;
import com.codingdojo.BookClub.model.User;
import com.codingdojo.BookClub.service.BookService;
import com.codingdojo.BookClub.service.UserService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class BookClubController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		return "redirect:/";
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user= userService.login(newLogin, result);
	if(result.hasErrors()) {
		model.addAttribute("newUser", new User());
		return "index.jsp";
	}
	session.setAttribute("userId", user.getId());
	return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String dashboard(Model model, HttpSession session) {
		Long userId=(Long) session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/";
		}
		User user=userService.findByid(userId);
		model.addAttribute("user",user);
		List<Book> books=bookService.all();
		model.addAttribute("books", books);
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String addbookpage( @ModelAttribute("book")Book book, Model model, HttpSession session ) {
		User user=userService.findByid((Long) session.getAttribute("userId"));
		model.addAttribute("user",user);
		return "add.jsp";
	}
	@GetMapping("/books/{book_id}")
	public String display( @PathVariable("book_id") Long book_id,Model model, HttpSession session ) {
		if((Long) session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book=bookService.findById(book_id);
		model.addAttribute("user",userService.findByid((Long) session.getAttribute("userId")));
		model.addAttribute("book",book);
		return "display.jsp";
	}
	@GetMapping("/books/{book_id}/edit")
	public String updatepage( @PathVariable("book_id") Long book_id, Model model, HttpSession session ) {
		User user=userService.findByid((Long) session.getAttribute("userId"));
		model.addAttribute("user",user);
		model.addAttribute("book",bookService.findById(book_id));
		return "update.jsp";
	}
	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("book")Book book, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "update.jsp";
		}
		User user=userService.findByid((Long) session.getAttribute("userId"));
		model.addAttribute("user",user);
		bookService.update(book);
		return "redirect:/books";
	}
	
	@PostMapping("/add")
	public String addbook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		}
		bookService.create(book);
		return "redirect:/books";
	}
	@PostMapping("/books/{book_id}/delete")
	public String delete(@PathVariable("book_id")Long book_id) {
	bookService.delete(book_id);
	return "redirect:/books";
	}
	}


