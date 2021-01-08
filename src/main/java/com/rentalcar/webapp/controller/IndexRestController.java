package com.rentalcar.webapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class IndexRestController {
	
	@GetMapping("/")
	public String home() {
		return "autenticato";
	}
		
	@GetMapping("/utente")
	public String getUtente() {
		return "Bho ci dovrebbe essere un'utente in formato json";
	}
}
