package fr.afcepf.ai103.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.service.ServiceCompte;

@ManagedBean
@SessionScoped

public class CompteBean {

	private Long numClient = 1L;

	private ServiceCompte serviCompte = new ServiceCompte();

	private Long numCptDeb = null; // à selectionner dans liste déroulant
	private Long numCptCred = null;
	private Double montant = null; // à saisir dans virement.xhtml

	private List<Compte> comptes; // à afficher sous forme de tableau (h:dataTable)

	// constructeur par défaut :
	public CompteBean() {
		this.comptes = serviCompte.comptesDuClient(numClient);
	}
	
	public String effectuerVirement() {
		String suite = null;
		// effectuer le virement
		serviCompte.transferer(montant, numCptDeb, numCptCred);
		// recharger en mémoire les nouveaux soldes qui ont changées et qui seront ré afficher
		this.comptes=serviCompte.comptesDuClient(numClient);
		// naviguer vers comptes.xhtml
		suite = "comptes";
		return suite;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public ServiceCompte getServiCompte() {
		return serviCompte;
	}

	public void setServiCompte(ServiceCompte serviCompte) {
		this.serviCompte = serviCompte;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

}
