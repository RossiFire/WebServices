package com.rentalcar.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.entities.Mezzo;
import com.rentalcar.entities.TipoMezzo;
import com.rentalcar.entities.Utente;
import com.rentalcar.services.MezziService;

@RestController
@RequestMapping("/mezzi")
@CrossOrigin(origins="http://localhost:4200")
public class MezziRestController {
	
	@Autowired
	private MezziService mezziService;
	
	private int ModificaId = -1;
	
	
	@GetMapping(value = "/catalogo", produces = "application/json")
	public List<Mezzo> getMezzi(){
		return mezziService.selTutti();
	}
	
	
	@GetMapping(value = "/elimina/{id}")
	public ResponseEntity<String> EliminaMezzo(@PathVariable("id")int id) {
		Optional<Mezzo> tm = mezziService.selById(id);
		Mezzo m = tm.get();
		if(m == null) {
			return ResponseEntity.badRequest().body("\"Errore Nell'eliminazione dell'mezzo\"");
		}
		mezziService.Elimina(m);
		return ResponseEntity.ok("\"Mezzo eliminato correttamente\"");
	}
	
	
	
	@PostMapping(value = "aggiungi")
	public ResponseEntity<String> AggiungiMezzo(@RequestBody Mezzo mezzo) {
		Mezzo m = new Mezzo();
		TipoMezzo tp = new TipoMezzo();
		
		m.setCasaCostr(mezzo.getCasaCostr());
		m.setModello(mezzo.getModello());
		m.setTarga(mezzo.getTarga());
		tp.setId(mezzo.getTipomezzo().getId());
		m.setTipomezzo(tp);
		
		mezziService.Aggiungi(m);
		return ResponseEntity.ok("\" Mezzo aggiunto\"");
	}
	
	@GetMapping(value ="/modifica/{id}")
	public void GetModificaId(@PathVariable("id")int id) {
		Optional<Mezzo> tm = mezziService.selById(id);
		Mezzo m = tm.get();
		if(m == null) {
			throw new RuntimeException("Errore");						
		}else {
			ModificaId= m.getId();
		}
	}
	
	@GetMapping(value="/singolo/{id}")
	public Mezzo getMezzo(@PathVariable("id")int id) {
		return mezziService.selById(id).get();
		
	}
	
	@PostMapping(value="modifica")
	public ResponseEntity<String> Modifica(@RequestBody Mezzo mezzo) {
		Optional<Mezzo> tm = mezziService.selById(ModificaId);
		Mezzo m = tm.get();
		TipoMezzo tp = new TipoMezzo();
		
		m.setCasaCostr(mezzo.getCasaCostr());
		m.setModello(mezzo.getModello());
		m.setTarga(mezzo.getTarga());
		tp.setId(mezzo.getTipomezzo().getId());
		m.setTipomezzo(tp);
		
		mezziService.Aggiorna(m);
		return ResponseEntity.ok("\"Mezzo modificato correttamente \"");
	}	
	
	

}
