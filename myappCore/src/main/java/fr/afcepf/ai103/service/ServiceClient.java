package fr.afcepf.ai103.service;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.IDaoClient;
import fr.afcepf.ai103.data.Client;


@Stateless // EJB session sans etat (99% des EJBs de traitement)
@Local // ou @Remote 
public class ServiceClient implements IServiceClient {

		@EJB
		private IDaoClient daoClient;
	
		@Override
		public Client rechercherInfosClient(Long numClient) {
			
			return daoClient.rechercherClientParNumero(numClient);
			
			/*Client cli = new Client();
			//simulation de valeurs récupérées en base :
			cli.setNumClient(numClient);
			cli.setNom("Bon");
			cli.setPrenom("Jour");
			cli.setAdresse("24 rue des foufous");
			cli.setEmail("Bonjour@aurevoir.fr");
			cli.setTelephone("0160252525");
			return cli;*/
		}
}
