package it.domenico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "colore", nullable = false)
	private String colore;
	
	@Column(name = "cilindrata", nullable = false)
	private int cilindrata;

	
}
