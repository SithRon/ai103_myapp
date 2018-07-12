package fr.afcepf.ai103.data;

public class Compte {
	private Long numero;
	private String libelle;
	private Double solde;

	
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", libelle=" + libelle + ", solde=" + solde + "]";
	}

	public Compte() {
		super();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

}
