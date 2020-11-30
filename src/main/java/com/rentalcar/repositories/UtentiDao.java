package com.rentalcar.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rentalcar.entities.Utente;

@Repository
public interface UtentiDao extends JpaRepository<Utente, Integer>{

		@Query("SELECT a FROM Utente a WHERE a.nome =?1 AND a.password =?2")
		public Utente ControlloEsisteUtente(String nome, String password);
		
		
		@Query("SELECT a FROM Utente a, TipoUtente b WHERE a.tipoutente=b.id AND b.tipo= 'CUSTOMER'")
		public List<Utente> SelCustomer();
		
}










































//Utente selById(int id);
//
//List<Utente> selTutti();
//
//void Aggiungi(Utente utente);
//
//void Aggiorna(Utente utente);
//
//void Elimina(Utente utente);
//
//Utente ControllaUtente(String nome, String password);
//
//int selByCredenziali(String nome,String password);
//
//boolean HaDiritti(String nome, String password);
//
//List<Utente> selCustomer();