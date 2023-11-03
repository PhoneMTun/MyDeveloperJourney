package com.codingdojo.HelloHuman;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String index1(@RequestParam(value="name", required=false) String searchQuery, 
			@RequestParam(value="last_name", required=false) String searchQuery2,
		@RequestParam(value="times", required=false) int times){
	if(searchQuery==null) {
		return "Hello World";
	}
	String output="";
	for (int i = 0;i<times;i++) {
		output+="Hello "+ searchQuery+ " "+ searchQuery2+ " ";
		 
	}
	return output;
}
}

