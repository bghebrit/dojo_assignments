package com.codingdojo.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.services.DojoService;

@Controller
public class DojoController {
	private DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojoninja/dojo.jsp";
	}
	
	@RequestMapping(value="/adddojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo , BindingResult result) {
		if(result.hasErrors()) {
			return "/dojoninja/dojo.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{dojoid}")
	public String show(@PathVariable("dojoid") Long id , Model model) {
		Dojo dojo = dojoService.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojoninja/dojopage.jsp";
	}
	

}
