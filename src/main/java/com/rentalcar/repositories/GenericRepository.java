package com.rentalcar.repositories;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public interface GenericRepository <I extends Serializable, E extends Serializable>{

	
		@NotNull
		List<I> selTutti();
		

		
		void Aggiungi(@NotNull I entity);
		
		void Aggiorna(@NotNull I entity);
		
		void Elimina(@NotNull I entity);
		
		
}
