package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.afcepf.ai103.data.Compte;

public class ServiceCompte {
	private Map<Long, Compte> mapComptes = new HashMap<Long, Compte>(); // simulation en mémoire

	public ServiceCompte() {
		Compte cpt1 = new Compte();
		cpt1.setNumero(1234568L);
		cpt1.setLibelle("compte courant");
		cpt1.setSolde(15874.0);
		mapComptes.put(cpt1.getNumero(), cpt1);

		Compte cpt2 = new Compte();
		cpt2.setNumero(66666666L);
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
		listeComptes.add(mapComptes.get(66666666L));

		return listeComptes;
	}

}
