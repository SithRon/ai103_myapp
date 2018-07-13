package fr.afcepf.ai103.service;

import fr.afcepf.ai103.data.Client;

public class ServiceClient {

		public Client rechercherInfosClient(Long numClient) {
			Client cli = new Client();
			//simulation de valeurs récupérées en base :
			cli.setNumClient(numClient);
			cli.setNom("Bon");
			cli.setPrenom("Jour");
			cli.setAdresse("24 rue des foufous");
			cli.setEmail("Bonjour@aurevoir.fr");
			cli.setTelephone("0160252525");
			return cli;
		}
}
