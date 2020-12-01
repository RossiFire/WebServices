package com.rentalcar.services;

import java.util.List;
import java.util.Optional;

import com.rentalcar.entities.Prenotazione;

public interface PrenotazioniService {

	
	List <Prenotazione> selTutti();
	
	void Aggiungi(Prenotazione prenotazione);
	
	void Aggiorna(Prenotazione prenotazione);
	
	void Elimina(Prenotazione prenotazione);
	
	Optional<Prenotazione> selById(int id);
}
