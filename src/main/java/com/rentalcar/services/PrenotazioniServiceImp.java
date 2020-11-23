package com.rentalcar.services;

import java.util.List;

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
		return prenotazioniDao.selTutti();
	}

	@Override
	public void Aggiungi(Prenotazione prenotazione) {
		prenotazioniDao.Aggiungi(prenotazione);
		
	}

	@Override
	public void Aggiorna(Prenotazione prenotazione) {
		prenotazioniDao.Aggiorna(prenotazione);
		
	}

	@Override
	public void Elimina(Prenotazione prenotazione) {
		prenotazioniDao.Elimina(prenotazione);
		
	}

	@Override
	public List<Prenotazione> selByUserId(int id) {
		return prenotazioniDao.selByUserId(id);
	}

	@Override
	public Prenotazione selById(int id) {
		return prenotazioniDao.selById(id);
	}

}
