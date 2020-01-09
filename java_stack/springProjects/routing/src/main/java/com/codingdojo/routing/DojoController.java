package com.codingdojo.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		return "The dojo is awesome:";	
	}
	@RequestMapping("/{burbank-dojo}/m")
	public String burbank(@PathVariable("burbank-dojo") String burbank) {
		return "Burbank Dojo is located in Southern California:";	
	}
	@RequestMapping("/{san-jose}/m")
	public String sanjose(@PathVariable("sano-jose") String sanjose) {
		return "SJ dojo is the headquarters";	
	}
}
