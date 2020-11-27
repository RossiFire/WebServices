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
import com.rentalcar.entities.Prenotazione;
import com.rentalcar.entities.Utente;
import com.rentalcar.services.MezziService;
import com.rentalcar.services.PrenotazioniService;
import com.rentalcar.services.UtentiService;

@RestController
@RequestMapping("/prenotazioni")
@CrossOrigin(origins="http://localhost:4200")
public class PrenotazioniRestController {
	
		
	@Autowired
	private PrenotazioniService PrenotazioniService;
	
	@Autowired
	private UtentiService utentiService;
	
	@Autowired
	private MezziService mezziService;
	
	private int IdInMemoria = -1;
	
	
	@GetMapping(produces ="application/json")
	public List<Prenotazione> GetPrenotazioni(){
		return PrenotazioniService.selTutti();
	}
	
	
	@PostMapping(value = "/aggiungi")
	public void AggiungiPrenotazione(@RequestBody Prenotazione p) {
		
		Utente u = utentiService.selById(p.getUtentePrenotato().getId());
		Mezzo m = mezziService.selById(p.getMezzoPrenotato().getId());
		Prenotazione Pr = new Prenotazione();
		Pr.setId(p.getId());
		Pr.setDataInizio(p.getDataInizio());
		Pr.setDataFine(p.getDataInizio());
		Pr.setApprovata(p.isApprovata());
		Pr.setUtentePrenotato(u);
		Pr.setMezzoPrenotato(m);
		PrenotazioniService.Aggiungi(Pr);
			
	}
	
	@GetMapping(value ="elimina/{id}")
	public void Elimina(@PathVariable("id")int id) {
		PrenotazioniService.Elimina(PrenotazioniService.selById(id));
	}
	
	
	@GetMapping(value = "modifica/{id}")
	public void Precompila(@PathVariable("id")int id) {
		IdInMemoria = PrenotazioniService.selById(id).getId();
	}
	
	@PostMapping(value="/modifica")
	public void Modifica(@RequestBody Prenotazione p) {
		Prenotazione Pr =  PrenotazioniService.selById(IdInMemoria);
		Utente NewUtente = utentiService.selById(p.getUtentePrenotato().getId());
		Mezzo newMezzo = mezziService.selById(p.getMezzoPrenotato().getId());
		
		
		Pr.setApprovata(p.isApprovata());
		Pr.setDataInizio(p.getDataInizio());
		Pr.setDataFine(p.getDataFine());
		Pr.setUtentePrenotato(NewUtente);
		Pr.setMezzoPrenotato(newMezzo);
		PrenotazioniService.Aggiorna(Pr);
	}

	
	
	

}
