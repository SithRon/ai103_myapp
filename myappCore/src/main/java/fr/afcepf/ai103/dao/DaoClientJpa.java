package fr.afcepf.ai103.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.afcepf.ai103.data.Client;

public class DaoClientJpa implements IDaoClient {

	private EntityManager entityManager;

	private void initEntityManagerSansEjb() {
		//1. Créer l'objet technique EntityManagerFactory de JPA en analysant le fichier META-INF/persistence.xml
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myappCore");
		//myappCore est un nom logique d'une partie de la configuration de la META-INF/persistence.xml
		
		//2. Créer le ENtityManager via la factory
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	public DaoClientJpa() {
		initEntityManagerSansEjb();
	}

	@Override
	public Client insererNouveauClient(Client c) {
		try {
			entityManager.getTransaction().begin();
			// en entrée la partie c.numClient vaut null
			entityManager.persist(c); // INSERT INTO SQL avec auto_increment
			entityManager.getTransaction().commit();
			return c; // en retour c.numClient ne sera plus null
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Client rechercherClientParNumero(Long numero) {
		// SELECT FROM... WHERE numero=?
		return entityManager.find(Client.class, numero);
	}

	@Override
	public List<Client> rechercherClients() {

		return entityManager.createQuery("SELECT C FROM Client", Client.class).getResultList();
	}

	@Override
	public void mettreAjourClient(Client c) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(c);// update SQL
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void supprimerClient(Long numero) {
		try {
			entityManager.getTransaction().begin();
				Client c = entityManager.find(Client.class, numero);
				entityManager.remove(c);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

}
