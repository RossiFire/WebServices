package com.rentalcar.services;

import java.util.List;
import java.util.Optional;

import com.rentalcar.entities.Utente;

public interface UtentiService {

	
	Optional<Utente> selById(int id);
	
	List<Utente> selTutti();
	
	void Aggiungi(Utente utente);
	
	void Aggiorna(Utente utente);
	
	void Elimina(Utente utente);
	
	String ControllaUtente(String nome, String password);
	
	int selByCredenziali(String nome,String password);
	
	public boolean HaDiritti(String nome, String password);
	
	List<Utente> selCustomer();
}
