package com.rentalcar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rentalcar.entities.Prenotazione;

public interface PrenotazioniDao extends JpaRepository<Prenotazione, Integer>{

	@Modifying
	@Query("DELETE FROM Prenotazione t WHERE t.id = ?1")
	void delete(int entityId);
}
