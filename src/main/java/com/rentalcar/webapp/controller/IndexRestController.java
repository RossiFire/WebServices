package com.rentalcar.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200")
public class IndexRestController {
	
	@GetMapping
	public String home() {
		return "ciao";
	}
}
