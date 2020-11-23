package com.rentalcar.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentalcar.entities.Mezzo;

@Repository
public class MezziDaoImp extends AbstractDao<Mezzo, Integer> implements MezziDao{


	@Override
	public List<Mezzo> selTutti() {
			String jpql = "SELECT a FROM Mezzo a";
			List<Mezzo> mezzi = entityManager.createQuery(jpql).getResultList();	
			return mezzi;
	}
	
	@Override
	public Mezzo selById(int id) {
		String jpql = "SELECT a FROM Mezzo a WHERE a.id = :uid";
		Mezzo mezzo = (Mezzo) entityManager.createQuery(jpql).setParameter("uid", id).getSingleResult();
	return mezzo;
	}
	
	@Override
	public void Aggiungi(Mezzo mezzo) {
		super.Aggiungi(mezzo);
	}
	
	@Override
	public void Aggiorna(Mezzo mezzo) {
		super.Aggiorna(mezzo);
	}
	
	@Override
	public void Elimina(Mezzo mezzo) {
		String jqpl = "DELETE FROM Mezzo a WHERE a.id = :uid";
		entityManager.createQuery(jqpl).setParameter("uid", mezzo.getId()).executeUpdate();
	}

}
