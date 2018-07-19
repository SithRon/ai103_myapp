package fr.afcepf.ai103.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai103.data.Client;

public class DaoClientJpa implements IDaoClient {

	// myappCore est un nom logique d'une partie de la
	// configuration de META-INF/persistence.xml
	// @PersistenceContext initialise entityManager en fonction de persistence.xml
	// dans un projet EJB (ou Spring)
	@PersistenceContext(unitName = "myappCore")
	private EntityManager entityManager;

	public DaoClientJpa() {

	}

	// commit/rollback déclenché automatiquement par container EJB selon exception
	public Client insererNouveauClient(Client c) {
		entityManager.persist(c); // INSERT INTO SQL avec auto_increment
		return c; // en retour c.numClient ne sera plus null
	}

	public Client rechercherClientParNumero(Long numero) {
		// SELECT FROM ... WHERE numero=?
		return entityManager.find(Client.class, numero);
	}

	public List<Client> rechercherClients() {
		return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
	}

	public void mettreAjourClient(Client p) {

		entityManager.merge(p); // UDPATE SQL

	}

	public void supprimerClient(Long numero) {
		Client c = entityManager.find(Client.class, numero);
		entityManager.remove(c); // DELETE SQL
	}

}