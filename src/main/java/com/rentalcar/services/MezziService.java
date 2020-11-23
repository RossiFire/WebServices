package com.rentalcar.services;

import java.util.List;

import com.rentalcar.entities.Mezzo;

public interface MezziService {

	
	Mezzo selById(int id);
	
	List<Mezzo> selTutti();
	
	void Aggiungi(Mezzo mezzo);
	
	void Aggiorna(Mezzo mezzo);
	
	void Elimina(Mezzo mezzo);
}
