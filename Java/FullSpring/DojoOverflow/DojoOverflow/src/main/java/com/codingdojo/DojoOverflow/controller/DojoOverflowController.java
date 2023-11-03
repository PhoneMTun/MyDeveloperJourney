package com.codingdojo.DojoOverflow.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.DojoOverflow.model.Answer;
import com.codingdojo.DojoOverflow.model.Question;
import com.codingdojo.DojoOverflow.model.Tag;
import com.codingdojo.DojoOverflow.service.AnswerService;
import com.codingdojo.DojoOverflow.service.QuestionService;
import com.codingdojo.DojoOverflow.service.TagService;

import jakarta.validation.Valid;

@Controller
public class DojoOverflowController {
	@Autowired
	TagService tagService;
	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions",questionService.allQuestions());
		return "index.jsp";
	}
	@GetMapping("/questions/new")
	public String index(@ModelAttribute("question") Question question) {
		return "new.jsp";
	}
	@GetMapping("/questions/{question_id}")
	public String questionpage(@PathVariable("question_id") Long question_id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", questionService.findById(question_id));
		return "question.jsp";
	}
	@PostMapping("/questions/new/add")
	public String addQuestion(
			@Valid @ModelAttribute("question") Question question, 
			BindingResult result,
			@RequestParam("listOfTags") String listOfTags,
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			return "new.jsp";
		}
		
		List<Tag> questionTags = checkTags(listOfTags);
		
		if(questionTags==null||questionTags.size()>3) {
			redirectAttributes.addFlashAttribute("error", "The number of tags must be between 1 and 3");
			return "redirect:/questions/new";
		}
		
		question.setTags(questionTags);
		questionService.create(question);
		
		return "redirect:/";
	}
	private List<Tag> checkTags(String tags){
		if(tags.length()>0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for(String tagString:tagList) {
				Tag tag = tagService.findBySubject(tagString.toLowerCase().strip());
				if(tag==null) {
					tag = new Tag(tagString.toLowerCase().strip());
					tagService.create(tag);
				}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}

	@PostMapping("/questions/addanswer/{question_id}")
	public String addanswer(@Valid@ModelAttribute("answer") Answer answer, BindingResult result, @PathVariable("question_id") Long question_id) {
		if(result.hasErrors()) {
			return "question.jsp";
		}
		answer.setQuestion(questionService.findById(question_id));
		answerService.create(answer);
		
		return "redirect:/questions/"+question_id;
		
		
			
		
}
}
