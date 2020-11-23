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

@Entity
@Table(name="TIPOMEZZO")
public class TipoMezzo implements Serializable{
		
		@Id
		@Column(name="idTIPO")
		private int id;
		
		@Column(name = "TIPO")
		private String tipo;
		
		
		@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipomezzo", orphanRemoval = true)
		private List<Mezzo> mezziDelTIpo;


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


		public List<Mezzo> getMezziDelTIpo() {
			return mezziDelTIpo;
		}


		public void setMezziDelTIpo(List<Mezzo> mezziDelTIpo) {
			this.mezziDelTIpo = mezziDelTIpo;
		}	
}
