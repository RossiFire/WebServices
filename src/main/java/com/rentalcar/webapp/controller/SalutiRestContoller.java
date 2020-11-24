package com.rentalcar.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.entities.Utente;
import com.rentalcar.services.UtentiService;

@RestController
@RequestMapping("/utenti")
@CrossOrigin(origins="http://localhost:4200")
public class SalutiRestContoller {
	
	
	@Autowired
	private UtentiService utentiService;
	
	
	@GetMapping(value = "/customer", produces = "application/json")
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
			throw new RuntimeException("Errore");
		
		String msg = String.format("\"%s sta usando sto web service\"", nome);
		return msg;
	}
	
	@PostMapping(value = "/aggiungi")
	public void AggiungiUtente(@RequestBody Utente utente) {
		System.out.println("CIAO CIAO CIAO");
		System.out.println("CIAO CIAO CIAO");
		if(utente != null) {
			utentiService.Aggiungi(utente);
		}else {
			throw new RuntimeException("Errore");
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/saluti")
	public String saluti(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== get greeting ====");
		return name;
	}

	
	
}
