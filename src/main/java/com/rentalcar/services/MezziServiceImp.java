package com.rentalcar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentalcar.repositories.MezziDao;
import com.rentalcar.entities.Mezzo;

@Service
@Transactional
public class MezziServiceImp implements MezziService{

	@Autowired
	private MezziDao mezziDao;
	
	@Override
	public Mezzo selById(int id) {
		return mezziDao.selById(id);
	}

	@Override
	public List<Mezzo> selTutti() {
		return mezziDao.selTutti();
	}

	@Override
	public void Aggiungi(Mezzo mezzo) {
		mezziDao.Aggiungi(mezzo);	
	}

	@Override
	public void Aggiorna(Mezzo mezzo) {
		mezziDao.Aggiorna(mezzo);
	}

	@Override
	public void Elimina(Mezzo mezzo) {
		mezziDao.Elimina(mezzo);
	}
	


}
