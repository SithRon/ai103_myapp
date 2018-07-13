package fr.afcepf.ai103.data;

import javax.persistence.Column;
// javaxx.persistence = package de JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //entité persistante(qui va être stocké en BDD) prise en charge par JPA/Hibernate

//@Table(name="Client")
public class Client {

	//@ID et @GeneratedValue va prendre en compte "numClient" car déclaré juste au-dessus
	@Id // ientifiant (PK)
	@GeneratedValue(strategy=GenerationType.IDENTITY) //IDENTITY convient le mieux pour les BDD récentes
	//@Column(name="numClient")
	private Long numClient;
	
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	@Column(length=15) //VARCHAR de 15
	private String telephone;
	private String password;

	// +get/set, +toString(), + default constructeur

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [numClient=" + numClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", telephone=" + telephone + ", password=" + password + "]";
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
