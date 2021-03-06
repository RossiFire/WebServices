package com.rentalcar.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentalcar.entities.TipoUtente;
import com.rentalcar.entities.Utente;
import com.rentalcar.services.UtentiService;

@RestController
@RequestMapping("/utenti")
@CrossOrigin(origins={"http://localhost:4200","http://localhost:3000"})

public class SalutiRestContoller {
	
	
	@Autowired
	private UtentiService utentiService;
	
	private int ModificaId = -1;
	
	
	@PostMapping(value = "/aggiungi")
	public ResponseEntity<String> AggiungiUtente(@RequestBody Utente utente) {
		Utente u = Normalizzazione(utente);
		utentiService.Aggiungi(u);
		return new ResponseEntity<String>("\"Utente Inserito nel server\"", HttpStatus.OK);
	}
	
	@GetMapping(value = "/customer", produces = "application/json")
	public List<Utente> GetCustomer() {
		return utentiService.selCustomer();
	}
	
	
	@GetMapping("/elimina/{id}")
	public ResponseEntity<String> Elimina(@PathVariable("id") int id) {
		Optional <Utente> tm = utentiService.selById(id);
		Utente u = tm.get();
		if(u == null) {
			return ResponseEntity.badRequest().body("\"Errore Nell'eliminazione dell'utente\"");
		}else {
			utentiService.Elimina(u);
			return ResponseEntity.ok("\"Eliminazione avvenuta con successo\"");
		}
	}
	
	
	@GetMapping("/modifica/{id}")
	public ResponseEntity<String> GetModId(@PathVariable("id") int id) {
		Optional<Utente> tm = utentiService.selById(id);
		Utente u = tm.get();
		if(u == null) {
			return new ResponseEntity<String>("\"Errore Nell'eliminazione dell'utente\"", HttpStatus.BAD_REQUEST);					
		}else {
			ModificaId= u.getId();
			return new ResponseEntity<String>("\"Id memorizzato e pronto alla modifica\"", HttpStatus.OK);
		}
	}

	
	@PostMapping("/modifica")
	public ResponseEntity<String> Modifica(@RequestBody Utente utente) {	
		Optional<Utente> tm = utentiService.selById(ModificaId);
		Utente u = tm.get();
		TipoUtente tp = new TipoUtente();
		u.setNome(utente.getNome());
		u.setCognome(utente.getCognome());
		u.setNascita(utente.getNascita());
		u.setPassword(utente.getPassword());
		tp.setId(utente.getTipoutente().getId());
		u.setTipoutente(tp);
		utentiService.Aggiorna(u);
		System.out.println(u.getId());
		return new ResponseEntity<String>("\"Utente Modificato\"", HttpStatus.OK);
	}
	
	
	@PostMapping(value= "/controlla")
	public boolean ControllaPrivilegi(@RequestBody String Dati) {
		JSONObject obj = new JSONObject(Dati);
        String Nome = obj.getString("nome");
        String Psw = obj.getString("password");
		return utentiService.HaDiritti(Nome, Psw);
	}
	
	
	
	@PostMapping(value="/id")
	public int getId(@RequestBody String Dati) {
		JSONObject obj = new JSONObject(Dati);
        String Nome = obj.getString("nome");
        String Psw = obj.getString("password");
		return utentiService.selByCredenziali(Nome, Psw);
	}
	
	
	@GetMapping(value="/singolo/{id}")
	public Optional<Utente> getUtente(@PathVariable("id") int id) {
		return utentiService.selById(id);
	}
	
	
	@PostMapping(value="/modificaProfilo")
	public ResponseEntity<String> ModificaProfilo(@RequestBody Utente utente){
		Optional<Utente> Ut = utentiService.selById(utente.getId());
		Utente u = Ut.get();
		if(u == null) {
			return ResponseEntity.badRequest().body("\" Non siamo riusciti a prelevare l'utente \"");
		}
		TipoUtente tp = new TipoUtente();
		u.setNome(utente.getNome());
		u.setCognome(utente.getCognome());
		u.setNascita(utente.getNascita());
		u.setPassword(utente.getPassword());
		tp.setId(utente.getTipoutente().getId());
		u.setTipoutente(tp);
		utentiService.Aggiorna(u);
		return ResponseEntity.ok("\" Profilo modificato \"");
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
