package com.codingdojo.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class TheCodeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping ("/code") 
		public String code() {
		return "code.jsp";
	}
	
	
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public String login(@RequestParam(value="code") String code , RedirectAttributes redirectAttributes) {
		if(code.equals("Bushido")) {
			return "/code.jsp";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You have the wrong code , please enter the correct code!");
			return "redirect:/";
		}
		
	}
	
}
