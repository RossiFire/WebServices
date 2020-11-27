package com.rentalcar.repositories;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.rentalcar.entities.Utente;

@Repository
public class UtentiDaoImp extends AbstractDao<Utente, Integer> implements UtentiDao{

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Utente> selTutti(){
		String jpql = "SELECT a FROM Utente a";
		List<Utente> utenti = entityManager.createQuery(jpql).getResultList();	
		return utenti;
	}


	@Override
	public void Aggiungi(Utente utente) {
		super.Aggiungi(utente);

	}

	@Override
	public void Aggiorna(Utente utente) {
		super.Aggiorna(utente);
		
	}

	@Override
	public void Elimina(Utente utente) {
		String jqpl = "DELETE FROM Utente a WHERE a.id = :uid";
		entityManager.createQuery(jqpl).setParameter("uid", utente.getId()).executeUpdate();
	}




	@Override
	public Utente selById(int id) {
		String jpql = "SELECT a FROM Utente a WHERE a.id = :uid";
		Utente u = (Utente) entityManager.createQuery(jpql).setParameter("uid", id).getSingleResult();
	return u;
	}


	@Override
	public Utente ControllaUtente(String nome, String password) {
		Utente nonEs = new Utente();
		String jpql = "SELECT a FROM Utente a WHERE a.nome = :name AND a.password = :pwd";
		List<Utente> u =entityManager.createQuery(jpql).setParameter("name", nome)
				.setParameter("pwd", password).getResultList();
		if(u.isEmpty()) {
			nonEs = null;
			return nonEs;
		}else {
			return u.get(0);
		}
		
	}


	@Override
	public int selByCredenziali(String nome, String password) {
		Utente nonEs = new Utente();
		String jpql = "SELECT a FROM Utente a WHERE a.nome = :name AND a.password = :pwd";
		Utente u = (Utente) entityManager.createQuery(jpql).setParameter("name", nome)
				.setParameter("pwd", password).getSingleResult();
		if(u.getNome().equals(null)) {
			return -1;
		}else {
			return u.getId();
		}
	}
	
	
	
	
	
	@Override
	public boolean HaDiritti(String nome, String Password) {
		Utente u = ControllaUtente(nome, Password);
		if(u == null) {
			throw new RuntimeException("Errore");	
		}else {
			if(u.getTipoutente().getTipo().equals("ADMIN")) {
				return true;
			}else {
				return false;
			}			
		}
	}



	

}
