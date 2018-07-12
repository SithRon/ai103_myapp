package fr.afcepf.ai103.data;

import java.util.Date;

public class Operations {
	private Long numero;
	private Date date;
	private Double montant;
	private String libelle;
	
	

	public Operations(Long numero, Date date, Double montant, String libelle) {
		super();
		this.numero = numero;
		this.date = date;
		this.montant = montant;
		this.libelle = libelle;
	}

	public Operations() {
		super();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLabel(String libelle) {
		this.libelle = libelle;
	}

}
