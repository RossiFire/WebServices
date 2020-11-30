package com.rentalcar.repositories;

import java.util.List;

import com.rentalcar.entities.Utente;

public interface UtentiDao {

		Utente selById(int id);
		
		List<Utente> selTutti();
		
		void Aggiungi(Utente utente);
		
		void Aggiorna(Utente utente);
		
		void Elimina(Utente utente);
		
		Utente ControllaUtente(String nome, String password);
		
		int selByCredenziali(String nome,String password);
		
		boolean HaDiritti(String nome, String password);
		
		List<Utente> selCustomer();
}
