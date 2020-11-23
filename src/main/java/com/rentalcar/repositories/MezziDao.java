package com.rentalcar.repositories;

import java.util.List;

import com.rentalcar.entities.Mezzo;

public interface MezziDao {

	
	Mezzo selById(int id);
	
	List<Mezzo> selTutti();
	
	void Aggiungi(Mezzo mezzo);
	
	void Aggiorna(Mezzo mezzo);
	
	void Elimina(Mezzo mezzo);
	
	
}
