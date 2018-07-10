package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean // de JSF2, nom logique par défaut = "calculBean" = nom de la classe avec
				// minuscule au début
@RequestScoped
public class CalculBean {
	private Double x; // à saisir
	private Double resultat; // à afficher
	// +get/set

	public String CalculerRacine() {
		this.resultat=Math.sqrt(this.x);
		return null; // rester sur la même page
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getResultat() {
		return resultat;
	}

	public void setResultat(Double resultat) {
		this.resultat = resultat;
	}
}
