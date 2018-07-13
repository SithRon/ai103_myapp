package fr.afcepf.ai103.test;

import fr.afcepf.ai103.dao.DaoClientJpa;
import fr.afcepf.ai103.dao.IDaoClient;
import fr.afcepf.ai103.data.Client;

public class TestApp {

	public static void main(String[] args) {

		IDaoClient daoClient = new DaoClientJpa();
		for (Client c : daoClient.rechercherClients()) {
			System.out.println(c.toString());
		}
		
		Client cc = new Client();
		cc.setNom("BIPBIP");
		daoClient.insererNouveauClient(cc);
		System.out.println("nouveau numClient " + cc.getNumClient());
		System.exit(0);// forcer l'arrêt (pour compenser entityManager.close()
	}

}
