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

import com.rentalcar.entities.TipoUtente;
import com.rentalcar.entities.Utente;
import com.rentalcar.services.UtentiService;

@RestController
@RequestMapping("/utenti")
@CrossOrigin(origins="http://localhost:4200")
public class SalutiRestContoller {
	
	
	@Autowired
	private UtentiService utentiService;
	
	private int ModificaId = -1;
	
	@GetMapping(value = "/customer", produces = "application/json")
	public List<Utente> getUtenti(){
		 return utentiService.selTutti();
		
	}
	
	@PostMapping(value = "/aggiungi")
	public void AggiungiUtente(@RequestBody Utente utente) {
		Utente u = Normalizzazione(utente);
		utentiService.Aggiungi(u);
	}
	
	
	@GetMapping("/elimina/{id}")
	public void Elimina(@PathVariable("id") int id) {
		Utente u = utentiService.selById(id);
		if(u == null) {
			throw new RuntimeException("Errore");						
		}else {
			utentiService.Elimina(u);
		}
	}
	
	
	@GetMapping("/modifica/{id}")
	public void GetModId(@PathVariable("id") int id) {
		Utente u = utentiService.selById(id);
		if(u == null) {
			throw new RuntimeException("Errore");						
		}else {
			ModificaId= u.getId();
		}
	}

	
	@PostMapping("/modifica")
	public void Modifica(@RequestBody Utente utente) {
		
		Utente u = utentiService.selById(ModificaId);
		TipoUtente tp = new TipoUtente();
		u.setNome(utente.getNome());
		u.setCognome(utente.getCognome());
		u.setNascita(utente.getNascita());
		u.setPassword(utente.getPassword());
		tp.setId(utente.getTipoutente().getId());
		u.setTipoutente(tp);
		utentiService.Aggiorna(u);
	}
	
	
	
	public Utente Normalizzazione(Utente utente) {
		Utente u = new Utente();
		TipoUtente tp = new TipoUtente();
		if(utente != null) {
			u.setNome(utente.getNome());
			u.setCognome(utente.getCognome());
			u.setNascita(utente.getNascita());
			u.setPassword(utente.getPassword());
			tp.setId(utente.getTipoutente().getId());
			u.setTipoutente(tp);
		}else {
			throw new RuntimeException("Errore");
		}
		return u;
	}
	
	
}
