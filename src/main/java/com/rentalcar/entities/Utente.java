package com.rentalcar.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rentalcar.entities.Prenotazione;

@Entity
@Table(name = "UTENTE")
public class Utente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUTENTE")
	private int id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "COGNOME")
	private String cognome;

	@Column(name = "NASCITA")
	private Date nascita;

	@Column(name = "PASSW")
	private String password;

	@ManyToOne
	@JoinColumn(name = "TIPOUTENTE")
	private TipoUtente tipoutente;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "utentePrenotato", orphanRemoval = true)
	private List<Prenotazione> prenotazioni;
	



	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}


	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Date getNascita() {
		return nascita;
	}


	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TipoUtente getTipoutente() {
		return tipoutente;
	}


	public void setTipoutente(TipoUtente tipoutente) {
		this.tipoutente = tipoutente;
	}

}