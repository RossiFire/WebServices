package com.rentalcar.services;

import java.util.List;
import java.util.Optional;

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
	public Optional<Mezzo> selById(int id) {
		return mezziDao.findById(id);
	}

	@Override
	public List<Mezzo> selTutti() {
		return mezziDao.findAll();
	}

	@Override
	public void Aggiungi(Mezzo mezzo) {
		mezziDao.save(mezzo);
	}

	@Override
	public void Aggiorna(Mezzo mezzo) {
		Aggiungi(mezzo);
	}

	@Override
	public void Elimina(Mezzo mezzo) {
		mezziDao.delete(mezzo);
	}
	


}
