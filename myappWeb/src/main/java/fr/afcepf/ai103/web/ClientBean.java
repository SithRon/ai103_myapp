package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.ServiceClient;

@ManagedBean
@SessionScoped

public class ClientBean {

	private Long numClient; // à saisir
	private String password; // à saisir et vérifier 
	private String message; // à afficher
	private Client client; // infos "client" à récupérer
	private ServiceClient servClient = new ServiceClient();
	

	public String verifLogin() {
		String suite = null;
		// simuler vérification du MDP
		if (password != null && password.equals("pwd" + numClient)) {
			// MDP considéré comme ok si "pwd" + numClient (ex: "pwd1")
			// on demande à naviguer vers la page client
			suite = "client"; // .jsf (ou .jsp ou .xhtml)
			this.client = servClient.rechercherInfosClient(numClient);
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

	public ServiceClient getServClient() {
		return servClient;
	}

	public void setServClient(ServiceClient servClient) {
		this.servClient = servClient;
	}
	
}
