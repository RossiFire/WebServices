package com.rentalcar.services;

import java.util.List;

import com.rentalcar.entities.Prenotazione;

public interface PrenotazioniService {

	
	List <Prenotazione> selTutti();
	
	void Aggiungi(Prenotazione prenotazione);
	
	void Aggiorna(Prenotazione prenotazione);
	
	void Elimina(Prenotazione prenotazione);
	
	List <Prenotazione> selByUserId(int id);
	
	Prenotazione selById(int id);
}
