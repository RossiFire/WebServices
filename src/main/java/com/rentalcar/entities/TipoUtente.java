package com.rentalcar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="TIPOUTENTE")
public class TipoUtente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idTIPO")
	private int id;
	
	@Column(name = "TIPO")
	private String tipo;
	
	
//	@JsonManagedReference(value = "utente-tipoutente")
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipoutente", orphanRemoval = false)
//	private List<Utente> UtentiDelTipo;



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	
	
//	public List<Utente> getUtentiDelTipo() {
//		return UtentiDelTipo;
//	}
//
//
//	public void setUtentiDelTipo(List<Utente> utentiDelTipo) {
//		UtentiDelTipo = utentiDelTipo;
//	}

}