package tn.esprit.spring.service;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.CompteATitre;
import tn.esprit.spring.entity.CompteCourant;
import tn.esprit.spring.entity.CompteEpargne;
import tn.esprit.spring.entity.Mail;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.CompteAtitreRepository;
import tn.esprit.spring.repository.CompteCourantRepository;
import tn.esprit.spring.repository.CompteEpargneRepository;
import tn.esprit.spring.repository.CompteRepository;

@Service
public  class CompteServiceImpl implements ICompteService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	CompteRepository cmptRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompteAtitreRepository cmptAtRepository;
	@Autowired
	CompteCourantRepository cmptCRepository;
	@Autowired
	CompteEpargneRepository cmptERepository;
	@Autowired
	MailServiceImpl sendmail;
	private static final Logger L=LogManager.getLogger(CompteServiceImpl.class);
	@Override
	public List<Compte> retrieveAllCompte() {
		
		List<Compte> comptes=(List<Compte>) cmptRepository.findAll();
		
		for(Compte compte :comptes ){
			L.info("compte::::::::::::::" + compte);
		}
		return comptes;

	}



	@Override
	public void deleteCompte(String codeCompte) {
		cmptRepository.deleteById(codeCompte);
		L.info("compte::::::::::::::" );
		
	}



	@Override
	public Compte retrieveCompte(String codeCompte) {
		L.info(("au niveau de retrievecompte le code de compte = " +codeCompte));
		Compte compte = cmptRepository.findById(codeCompte).orElse(null);
		L.info("le compte  returned : "+compte);
		return compte;
	}

	@Override
	public void NotificationMail() {
		/*Iterable<Compte> comptes=cmptRepository.findAll();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		String now =sdformat.format(new Date());
		comptes.forEach(fact ->{
			java.util.logging.Logger.getGlobal().info("notification"+ sdformat.format(fact.getDate_fin()).equals(now));
			java.util.logging.Logger.getGlobal().info("notification"+ now);
			if((sdformat.format(fact.getDate_fin()).equals(now))||(fact.getisPaiement()!=true)){
		
				Mail mail=new Mail();
				mail.setFrom("khouloudabd512@gmail.com");
				mail.setSendTo(fact.getEmail());
				mail.setSubject("Facture");
				mail.setMessage("hello "+fact.getNomclient()+"\n try to create new bill if date is expired"+fact.getDate_fin()+ " OR payment if not payment "+fact.getisPaiement());
				sendmail.sendEmail(mail);
				
			}
			
			});*/
		
		
	}

	@Override
	public Compte validerCompte(String codeCpte) {
		
		Compte cp = cmptRepository.findById(codeCpte).get();
		if (cp==null) {
			throw new RuntimeException("Compte introuvable");
		}
		cp.setIsvalide(true);
		L.info("compte::::::::::::::" + cp);
		Mail mail=new Mail();
		
		mail.setFrom("khouloudabd512@gmail.com");
		mail.setSendTo(cp.getEmail());
	
		mail.setSubject("hello ,new account");
		mail.setMessage("hi " + ",\n you have a new account is valid" );
		
		sendmail.sendEmail(mail);
		
		return cmptRepository.save(cp);
		
	}

	@Override
	public Client consulterClient(Long codeCli) {
		Client c = em.find(Client.class,codeCli);
		if (c==null) {
			throw new RuntimeException("Client introuvable");
		}
		return c;
	}

	@Override
	public List<Client> consulterClients(String mc) {
		Query req = em.createQuery("select c from CLIENTS c where c.nomClient like :x");
		req.setParameter("x", "%" + mc + "%");
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesParClient(Long codeCli) {
		Query req = em.createQuery("select c from Compte c where c.client.codeClient = :x");
		req.setParameter("x", codeCli);
		return req.getResultList();
	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<CompteCourant> retrieveAllCompteCourant() {
List<CompteCourant> comptes=(List<CompteCourant>) cmptCRepository.findAll();
		
		for(Compte compte :comptes ){
			L.info("compte::::::::::::::" + compte);
		}
		return comptes;
	}

	@Override
	public List<CompteEpargne> retrieveAllCompteEpargne() {
List<CompteEpargne> comptes=(List<CompteEpargne>) cmptERepository.findAll();
		
		for(Compte compte :comptes ){
			L.info("compte::::::::::::::" + compte);
		}
		return comptes;
	}

	@Override
	public List<CompteATitre> retrieveAllCompteATitre() {
List<CompteATitre> comptes=(List<CompteATitre>) cmptAtRepository.findAll();
		
		for(Compte compte :comptes ){
			L.info("compte::::::::::::::" + compte);
		}
		return comptes;
	}

	@Override
	public CompteCourant addCompteCourant(CompteCourant cc,Long codeCli) { 
		L.info("compte::::::::::::::" + cc);
		Mail mail=new Mail();
		
		mail.setFrom("khouloudabd512@gmail.com");
		mail.setSendTo(cc.getEmail());
	
		mail.setSubject("hello ,new account");
		mail.setMessage("hi " + ",\n you have a new account created" );
		
		sendmail.sendEmail(mail);
		Client cli = em.find(Client.class, codeCli);
		cc.setClient(cli);
		cc.setIsvalide(false);
		cc.setType_Compte("compteCourant");
		 return cmptCRepository.save(cc);
	}

	@Override
	public CompteEpargne addCompteEpargne(CompteEpargne ce,Long codeCli) {
		L.info("compte::::::::::::::" + ce);
		Mail mail=new Mail();
		
		mail.setFrom("khouloudabd512@gmail.com");
		mail.setSendTo(ce.getEmail());
	
		mail.setSubject("hello ,new account");
		mail.setMessage("hi " + ",\n you have a new account created" );
		
		sendmail.sendEmail(mail);
		Client cli = em.find(Client.class, codeCli);
		ce.setClient(cli);
		ce.setIsvalide(false);
		ce.setType_Compte("compteEpargne");
		return cmptERepository.save(ce);
	}

	@Override
	public CompteATitre addCompteAtitre(CompteATitre cat,Long codeCli) {
		L.info("compte::::::::::::::" + cat);
		Mail mail=new Mail();
		
		mail.setFrom("khouloudabd512@gmail.com");
		mail.setSendTo(cat.getEmail());
	
		mail.setSubject("hello ,new account");
		mail.setMessage("hi " + ",\n you have a new account created" );
		
		sendmail.sendEmail(mail);
		Client cli = em.find(Client.class, codeCli);
		cat.setClient(cli);
		cat.setIsvalide(false);
		cat.setType_Compte("compteATitre");
		cat.setType_valeur_mobil(cat.getType_valeur_mobil());
		 return cmptAtRepository.save(cat);
		 }
	



	@Override
	public CompteCourant updateCompteCourant(CompteCourant cmpt, Long codeCli) {
		CompteCourant cmpte=cmptCRepository.findById(cmpt.getCodeCompte()).orElse(null);
		cmpt.setCodeCompte(cmpte.getCodeCompte());
		cmpt.setClient(cmpte.getClient());
		return cmptCRepository.save(cmpt);
	}
	
	


	@Override
	public CompteEpargne updateCompteEpargne(CompteEpargne cmpt, Long codeCli) {
		CompteEpargne cmpte=cmptERepository.findById(cmpt.getCodeCompte()).orElse(null);
		cmpt.setCodeCompte(cmpte.getCodeCompte());
		cmpt.setClient(cmpte.getClient());
		return cmptERepository.save(cmpt);
	}



	@Override
	public CompteATitre updateCompteATitre(CompteATitre cmpt, Long codeCli) {
		CompteATitre cmpte=cmptAtRepository.findById(cmpt.getCodeCompte()).orElse(null);
		cmpt.setCodeCompte(cmpte.getCodeCompte());
		cmpt.setClient(cmpte.getClient());
		return cmptAtRepository.save(cmpt);
	}



	@Override
	public Compte fetchCompteByIdandPassword(String CodeID, String password) {
		return cmptRepository.getUserByEmailAndPassword(CodeID, password);
	}







}
