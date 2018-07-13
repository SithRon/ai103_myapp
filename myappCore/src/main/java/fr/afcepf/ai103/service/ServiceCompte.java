package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operations;

public class ServiceCompte {
	private Map<Long, Compte> mapComptes = new HashMap<Long, Compte>(); // simulation en mémoire

	public ServiceCompte() {
		Compte cpt1 = new Compte();
		cpt1.setNumero(1234568L);
		cpt1.setLibelle("compte courant");
		cpt1.setSolde(15874.0);
		mapComptes.put(cpt1.getNumero(), cpt1);

		Compte cpt2 = new Compte();
		cpt2.setNumero(5L);
		cpt2.setLibelle("compte de la mort");
		cpt2.setSolde(666.0);
		mapComptes.put(cpt2.getNumero(), cpt2);
	}

	public void transferer(double montant, long numCptDeb, long numCptCred) {
		Compte cptDeb = mapComptes.get(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);

		Compte cptCred = mapComptes.get(numCptCred);
		cptCred.setSolde(cptCred.getSolde() + montant);
	}

	public List<Compte> comptesDuClient(Long numClient) {
		List<Compte> listeComptes = new ArrayList<Compte>();
		// simulation de valeurs récupérées en base
		listeComptes.add(mapComptes.get(1234568L));
		listeComptes.add(mapComptes.get(5L));

		return listeComptes;
	}

	public List<Operations> operationDuCompte(Long numCompte) {
		List<Operations> listeOperations = new ArrayList<Operations>();
		// simulation de valeurs récupérées en base
		if (numCompte!= null && (numCompte % 2) == 0) {
			listeOperations.add(new Operations(1L, new Date(), -30.0, "achat livres"));
			listeOperations.add(new Operations(2L, new Date(), -10.0, "achat dvd"));
		} else {
			listeOperations.add(new Operations(3L, new Date(), -40.0, "achat vêtements"));
			listeOperations.add(new Operations(4L, new Date(), -20.0, "achat crème solaire"));
		}
		return listeOperations;
	}
}
