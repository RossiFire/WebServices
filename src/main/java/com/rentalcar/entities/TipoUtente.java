package com.rentalcar.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TIPOUTENTE")
public class TipoUtente implements Serializable{
	
	@Id
	@Column(name="idTIPO")
	private int id;
	
	@Column(name = "TIPO")
	private String tipo;
	
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipoutente", orphanRemoval = true)
	private List<Utente> UtentiDelTipo;



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