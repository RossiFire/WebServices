package com.rentalcar.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao <I extends Serializable, Id extends Serializable>
implements GenericRepository<I,Id>{
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected final Class<I> entityClass;
	
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.entityClass = (Class<I>)((ParameterizedType)
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
				
	}
	
	
	@Override
	public void Aggiungi(I entity) {
		this.entityManager.persist(entity);
		flushAndClear();
		
	}
	
	@Override
	public void Aggiorna(I entity) {
		this.entityManager.merge(entity);
		flushAndClear();
	}
	
	
	@Override
	public void Elimina(I entity) {
		this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));
		flushAndClear();
	}
	
	
	
	private void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}
	
}
