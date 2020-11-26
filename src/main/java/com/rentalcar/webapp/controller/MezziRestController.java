package com.rentalcar.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void EliminaMezzo(@PathVariable("id")int id) {
		mezziService.Elimina(mezziService.selById(id));
	}
	
	@PostMapping(value = "aggiungi")
	public void AggiungiMezzo(@RequestBody Mezzo mezzo) {
		Mezzo m = new Mezzo();
		TipoMezzo tp = new TipoMezzo();
		
		m.setCasaCostr(mezzo.getCasaCostr());
		m.setModello(mezzo.getModello());
		m.setTarga(mezzo.getTarga());
		tp.setId(mezzo.getTipomezzo().getId());
		m.setTipomezzo(tp);
		
		mezziService.Aggiungi(m);
	}
	
	@GetMapping(value ="/modifica/{id}")
	public void GetModificaId(@PathVariable("id")int id) {
		Mezzo m = mezziService.selById(id);
		if(m == null) {
			throw new RuntimeException("Errore");						
		}else {
			ModificaId= m.getId();
		}
	}
	
	@PostMapping(value="modifica")
	public void Modifica(@RequestBody Mezzo mezzo) {
		Mezzo m = mezziService.selById(ModificaId);
		TipoMezzo tp = new TipoMezzo();
		
		m.setCasaCostr(mezzo.getCasaCostr());
		m.setModello(mezzo.getModello());
		m.setTarga(mezzo.getTarga());
		tp.setId(mezzo.getTipomezzo().getId());
		m.setTipomezzo(tp);
		
		mezziService.Aggiorna(m);
	}	
	
	

}
