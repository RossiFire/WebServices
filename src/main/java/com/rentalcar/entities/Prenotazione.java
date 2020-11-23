package com.rentalcar.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rentalcar.entities.Utente;

@Entity
@Table(name = "PRENOTAZIONI")
public class Prenotazione implements Serializable{
	
	@Id
	@Column(name = "idPRENOTAZIONE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "APPROVATA")
	private boolean approvata;
	
	@Column(name = "DATAINIZIO")
	private Date dataInizio;
	
	@Column(name = "DATAIFINE")
	private Date dataFine;
	
	@ManyToOne
	@JoinColumn(name = "UTENTE")
	private Utente utentePrenotato;
	
	@ManyToOne
	@JoinColumn (name = "MEZZO")
	private Mezzo mezzoPrenotato;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtentePrenotato() {
		return utentePrenotato;
	}

	public void setUtentePrenotato(Utente utentePrenotato) {
		this.utentePrenotato = utentePrenotato;
	}

	public Mezzo getMezzoPrenotato() {
		return mezzoPrenotato;
	}

	public void setMezzoPrenotato(Mezzo mezzoPrenotato) {
		this.mezzoPrenotato = mezzoPrenotato;
	}

	public boolean isApprovata() {
		return approvata;
	}

	public void setApprovata(boolean approvata) {
		this.approvata = approvata;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	
	
	public String getDate(Object s) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String data = dateFormat.format(s);
		return data;
	}
	
	public String approvazione(boolean app) {
		if(app) {
			return "Si";
		}else {
			return "No";
		}
	}
	
	
	public List<Prenotazione> getPrenotazioniUtente() {
		List<Prenotazione> prenotazioni = utentePrenotato.getPrenotazioni();
		return prenotazioni;
	}
}