package com.rentalcar.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalcar.repositories.UtentiDao;
import com.rentalcar.entities.Utente;

@Service("utentiService")
@Transactional
public class UtentiServiceImp implements UtentiService{

	@Autowired
	private UtentiDao utentiRepo;

	@Override
	public Optional<Utente> selById(int id) {
		return utentiRepo.findById(id);
	}
	
	@Override
	public List<Utente> selTutti() {
		return utentiRepo.findAll();
	}

	@Override
	public void Aggiungi(Utente utente) {
		utentiRepo.save(utente);
		utentiRepo.flush();
	}

	@Override
	public void Aggiorna(Utente utente) {
		Aggiungi(utente);
		
	}

	@Override
	public void Elimina(Utente utente) {
		utentiRepo.delete(utente);
		utentiRepo.flush();
	}

	@Override
	public String ControllaUtente(String nome, String password) {
		Utente u = utentiRepo.ControlloEsisteUtente(nome, password);

		if (u.getNome().equals("-1")) {
			return "NO";
		} else {
			if (u.getTipoutente().getTipo().equals("ADMIN")) {
				return "ADMIN";
			} else {
				return "CUSTOMER";
			}
		}
	}

	@Override
	public int selByCredenziali(String nome, String password) {
		Utente u = utentiRepo.ControlloEsisteUtente(nome, password);
		return u.getId();
	}
	
	@Override
	public boolean HaDiritti(String nome, String password) {
		Utente u = utentiRepo.ControlloEsisteUtente(nome, password);
		if(u.getTipoutente().getTipo().equals("ADMIN")) {
			return true;
		}else {
			return false;
		}
	}

	
	@Override
	public List<Utente> selCustomer(){
		return utentiRepo.SelCustomer();
	}
}
