package com.rentalcar.repositories;

import java.util.List;

import com.rentalcar.entities.Prenotazione;

public interface PrenotazioniDao {

	
	List <Prenotazione> selTutti();
	
	void Aggiungi(Prenotazione prenotazione);
	
	void Aggiorna(Prenotazione prenotazione);
	
	void Elimina(Prenotazione prenotazione);
	
	List <Prenotazione> selByUserId(int id);
	
	Prenotazione selById(int id);
	
	
}
