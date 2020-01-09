package com.codingdojo.dojosurvey;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class DojoSurveyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String survey(@RequestParam(value="username") String username,@RequestParam(value="location") String location, @RequestParam(value="language") String language ,@RequestParam(value="comment") String comment,HttpSession session){
		session.setAttribute("username" , username);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "result.jsp"; 
	}

}
