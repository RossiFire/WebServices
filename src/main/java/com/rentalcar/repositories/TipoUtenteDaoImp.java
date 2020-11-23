package com.rentalcar.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentalcar.entities.TipoMezzo;

@Repository
public class TipoUtenteDaoImp extends AbstractDao<TipoMezzo, Integer> implements TipoMezzoDao{

	@Override
	public List<TipoMezzo> selTutti() {
		String jpql = "SELECT a FROM TipoMezzo a";
		List <TipoMezzo> mezzi = entityManager.createQuery(jpql).getResultList();
		return mezzi;
	}

}
