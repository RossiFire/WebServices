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
	public ResponseEntity<String> AggiungiPrenotazione(@RequestBody Prenotazione p) {
		
		Optional<Utente> tu = utentiService.selById(p.getUtentePrenotato().getId());
		if(tu.isEmpty()) {
			return ResponseEntity.badRequest().body("\" Utente non trovato \"");
		}
		Optional<Mezzo> tm = mezziService.selById(p.getMezzoPrenotato().getId());
		if(tu.isEmpty()) {
			return ResponseEntity.badRequest().body("\" Mezzo non trovato \"");
		}
		Utente u = tu.get();
		Mezzo m = tm.get();
		Prenotazione Pr = new Prenotazione();
		Pr.setId(p.getId());
		Pr.setDataInizio(p.getDataInizio());
		Pr.setDataFine(p.getDataInizio());
		Pr.setApprovata(p.isApprovata());
		Pr.setUtentePrenotato(u);
		Pr.setMezzoPrenotato(m);
		PrenotazioniService.Aggiungi(Pr);
		return ResponseEntity.ok("\" Prenotazione Aggiunta \"");
			
	}
	
	
	@GetMapping(value ="elimina/{id}")
	public ResponseEntity<String> Elimina(@PathVariable("id")int id) {
		Optional<Prenotazione> tp = PrenotazioniService.selById(id);
		if(tp.isEmpty()) {
			return ResponseEntity.badRequest().body("\" Prenotazione da eliminare non trovata \"");
		}
		Prenotazione p = tp.get();
		PrenotazioniService.Elimina(p);
		return ResponseEntity.ok("\"Prenotazione eliminata \"");
	}
	
	
	
	
	@GetMapping(value = "modifica/{id}")
	public void Precompila(@PathVariable("id")int id) {
		Optional<Prenotazione> tp = PrenotazioniService.selById(id);
		IdInMemoria = tp.get().getId();
	}
	
	
	
	@PostMapping(value="/modifica")
	public ResponseEntity<String> Modifica(@RequestBody Prenotazione p) {
		Optional<Prenotazione> tp =  PrenotazioniService.selById(IdInMemoria);
		if(tp.isEmpty()) {
			return ResponseEntity.badRequest().body("\" Prenotazione da modificare non trovata \"");
		}
		Prenotazione Pr = tp.get();
		
		Optional<Utente> tm = utentiService.selById(p.getUtentePrenotato().getId());
		Utente NewUtente = tm.get();
		
		Optional<Mezzo> tmm = mezziService.selById(p.getMezzoPrenotato().getId());
		Mezzo newMezzo = tmm.get();

		
		Pr.setApprovata(p.isApprovata());
		Pr.setDataInizio(p.getDataInizio());
		Pr.setDataFine(p.getDataFine());
		Pr.setUtentePrenotato(NewUtente);
		Pr.setMezzoPrenotato(newMezzo);
		PrenotazioniService.Aggiorna(Pr);
		return ResponseEntity.ok("\"Prenotazione Modificata \"");
	}

	
	
	

}
