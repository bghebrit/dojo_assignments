package com.codingdojo.matching.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
