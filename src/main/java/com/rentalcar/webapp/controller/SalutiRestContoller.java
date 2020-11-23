package com.rentalcar.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.entities.Utente;
import com.rentalcar.services.UtentiService;

@RestController
@RequestMapping("/utenti")
@CrossOrigin(origins="http://localhost:4200")
public class SalutiRestContoller {
	
	
	@Autowired
	private UtentiService utentiService;
	
	
	@GetMapping(value = "/test", produces = "application/json")
	public List<Utente> getUtenti(){
		List <Utente> utenti = utentiService.selTutti();
		if(utenti.size()<=0) {
			return utenti;
		}
		return utenti;
		
	}
	
	@GetMapping(value = "/test/{nome}")
	public String getGreetings2(@PathVariable("nome") String nome){
		if(nome.equals("Davvo")) 
			throw new RuntimeException("Co sto utente ce stamo a fa a muffa");
		
		String msg = String.format("\"%s sta usando sto web service\"", nome);
		return msg;
	}
}
