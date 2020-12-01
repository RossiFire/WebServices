package com.rentalcar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.repositories.PrenotazioniDao;
import com.rentalcar.entities.Prenotazione;

@Service
@Transactional
public class PrenotazioniServiceImp implements PrenotazioniService{

	@Autowired
	private PrenotazioniDao prenotazioniDao;
	
	@Override
	public List<Prenotazione> selTutti() {
		return prenotazioniDao.findAll();
	}

	@Override
	public void Aggiungi(Prenotazione prenotazione) {
		prenotazioniDao.save(prenotazione);
		
	}

	@Override
	public void Aggiorna(Prenotazione prenotazione) {
		Aggiungi(prenotazione);
		
	}

	@Override
	public void Elimina(Prenotazione prenotazione) {
		prenotazioniDao.delete(prenotazione);	
	}
	

	@Override
	public Optional<Prenotazione> selById(int id) {
		return prenotazioniDao.findById(id);
	}

}
