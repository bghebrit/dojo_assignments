package com.codingdojo.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.services.DojoService;
import com.codingdojo.dojoninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninjas/new")
		public String index(@ModelAttribute("ninja") Ninja ninja, Model model) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "/dojoninja/ninja.jsp";
	}
	
	@RequestMapping(value="/addninja", method=RequestMethod.POST)
		public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja , BindingResult result) {
			if(result.hasErrors()) {
				return "/dojoninja/ninja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+ninja.getDojo().getId();
			
		}
	}

}
