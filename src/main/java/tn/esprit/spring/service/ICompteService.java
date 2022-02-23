package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.CompteATitre;
import tn.esprit.spring.entity.CompteCourant;
import tn.esprit.spring.entity.CompteEpargne;




public interface ICompteService {
	List<Compte> retrieveAllCompte();
	List<CompteCourant> retrieveAllCompteCourant();
	List<CompteEpargne> retrieveAllCompteEpargne();
	List<CompteATitre> retrieveAllCompteATitre();
	public Client addClient(Client c);
	public Client consulterClient(Long codeCli);
	public List<Client> consulterClients(String mc);
	public List<Compte> getComptesParClient(Long codeCli);
	
	
	CompteCourant addCompteCourant(CompteCourant cc,Long codeCli);
	CompteEpargne addCompteEpargne(CompteEpargne ce,Long codeCli);
	CompteATitre addCompteAtitre(CompteATitre cat,Long codeCli);
	
	void deleteCompte(String codeCompte);
	CompteCourant updateCompteCourant(CompteCourant  cmpt,Long codeCli);
	CompteEpargne updateCompteEpargne(CompteEpargne  cmpt,Long codeCli);
	CompteATitre updateCompteATitre(CompteATitre  cmpt,Long codeCli);
	public Compte validerCompte(String codeCpte);
	Compte  retrieveCompte (String codeCompte);

	 public void NotificationMail () ;
	 public Compte fetchCompteByIdandPassword (String CodeId,String password) ;

}
