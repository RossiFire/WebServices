package com.rentalcar.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEZZO")
public class Mezzo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idMEZZO")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "TIPOMEZZO")
	private TipoMezzo tipomezzo;
	
	@Column(name = "CASACOSTR")
	private String casaCostr;
	
	@Column(name = "MODELLO")
	private String modello;
	
	@Column(name = "TARGA")
	private String targa;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "mezzoPrenotato", orphanRemoval = true)
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

	public TipoMezzo getTipomezzo() {
		return tipomezzo;
	}

	public void setTipomezzo(TipoMezzo tipomezzo) {
		this.tipomezzo = tipomezzo;
	}

	public String getCasaCostr() {
		return casaCostr;
	}

	public void setCasaCostr(String casaCostr) {
		this.casaCostr = casaCostr;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}


	
}
