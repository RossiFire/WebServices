package com.rentalcar.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentalcar.entities.Prenotazione;

@Repository
public class PrenotazioniDaoImp extends AbstractDao<Prenotazione, Integer> implements PrenotazioniDao{

	@Override
	public List<Prenotazione> selTutti() {
		String jqpl = "SELECT a FROM Prenotazione a";
		return entityManager.createQuery(jqpl).getResultList();
	}
	
	@Override
	public void Aggiungi(Prenotazione prenotazione) {
		super.Aggiungi(prenotazione);
	}
	
	@Override
	public void Aggiorna(Prenotazione prenotazione) {
		super.Aggiorna(prenotazione);
	}
	
	@Override
	public void Elimina(Prenotazione prenotazione) {
		String jqpl = "DELETE FROM Prenotazione a WHERE a.id = :uid";
		entityManager.createQuery(jqpl).setParameter("uid", prenotazione.getId()).executeUpdate();
	}

	@Override
	public List<Prenotazione> selByUserId(int id) {
		String jqpl = "SELECT a FROM Prenotazione a WHERE a.utentePrenotato.id = :uid";
		return entityManager.createQuery(jqpl).setParameter("uid", id).getResultList();
	}

	@Override
	public Prenotazione selById(int id) {
		String jqpl = "SELECT a FROM Prenotazione a WHERE a.id = :uid";
		return (Prenotazione) entityManager.createQuery(jqpl).setParameter("uid", id).getSingleResult();
	}

}
