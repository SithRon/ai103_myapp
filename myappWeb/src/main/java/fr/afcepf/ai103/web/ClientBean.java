package fr.afcepf.ai103.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.IServiceClient;
import fr.afcepf.ai103.service.ServiceClient;

@ManagedBean
@SessionScoped

public class ClientBean {

	private Long numClient; // à saisir
	private String password; // à saisir et vérifier 
	private String message; // à afficher
	private Client client; // infos "client" à récupérer
	
	//private IServiceClient servClient = new ServiceClient(); ancienne version sans EJB
	
	@EJB // pour demander au serveur JEE de mettre à jour automatiquement la référence serviceClient en pointant vers 
	// un ejb existant de l'application qui implémente l'interface précisée (injection de dépendance)
	private IServiceClient serviceClient;
	
	public ClientBean() {
		System.out.println("dans construceur par défaut, serviceClient =" + serviceClient);
	}

	@PostConstruct
	public void initialisationApresInjectionDeDependance(){
		System.out.println("dans une méthode préfixée par @PostConstruct, serviceClient =" + serviceClient);		
	}
	public String verifLogin() {
		String suite = null;
		// simuler vérification du MDP
		if (password != null && password.equals("pwd" + numClient)) {
			// MDP considéré comme ok si "pwd" + numClient (ex: "pwd1")
			// on demande à naviguer vers la page client
			suite = "client"; // .jsf (ou .jsp ou .xhtml)
			this.client = serviceClient.rechercherInfosClient(numClient);
		} else {
			message = "Mauvais logs";
		}
		return suite;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public IServiceClient getServClient() {
		return serviceClient;
	}

	public void setServClient(IServiceClient servClient) {
		this.serviceClient = servClient;
	}
	
}
