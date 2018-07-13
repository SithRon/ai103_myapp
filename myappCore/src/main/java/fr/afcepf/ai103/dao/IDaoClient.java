package fr.afcepf.ai103.dao;

import java.util.List;

import fr.afcepf.ai103.data.Client;

/* DAO = Data Access Object avec méthodes CRUD : Create, Retreive, Update, Delete avec throws RuntimeException implicites*/

public interface IDaoClient {

	public Client insererNouveauClient(Client c);
	
	public Client rechercherClientParNumero(Long numero);
	public List<Client> rechercherClients();
	
	public void mettreAjourClient(Client c);
	public void supprimerClient(Long numero);
	
}
