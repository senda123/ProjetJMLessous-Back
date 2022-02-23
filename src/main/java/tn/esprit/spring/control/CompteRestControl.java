package tn.esprit.spring.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.CompteATitre;
import tn.esprit.spring.entity.CompteCourant;
import tn.esprit.spring.entity.CompteEpargne;
import tn.esprit.spring.service.ICompteService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pi/b")
public class CompteRestControl {
	@Autowired
	ICompteService cmptService;


	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_all_comptes
	@GetMapping("/retrieve_all_comptes")
	public List<Compte> retrieveAllCompte() {
		
		List<Compte> list=cmptService.retrieveAllCompte();

		return list;
	}
	@GetMapping("/retrieve_comptecourant")
	public List<CompteCourant> retrieveAllCompteCourant() {
		List<CompteCourant> list=cmptService.retrieveAllCompteCourant();

		return list;
	}
	@GetMapping("/retrieve_compteepargne")
	public List<CompteEpargne> retrieveAllCompteEpargne() {
		List<CompteEpargne> list=cmptService.retrieveAllCompteEpargne();

		return list;
	}
	@GetMapping("/retrieve_compteatitre")
	public List<CompteATitre> retrieveAllCompteATitre() {
		List<CompteATitre> list=cmptService.retrieveAllCompteATitre();

		return list;
	}

	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_compte/{compte_id}
	@GetMapping("/retrieve_compte/{compte_id}")
	public Compte retrieveCompte(@PathVariable("compte_id") String codeCompte){
		return cmptService.retrieveCompte(codeCompte);
	}


	//demande de compte invalide:client
	@PostMapping("/add/compteCourant/{idClient}")
	public CompteCourant addCompteCourant(@RequestBody CompteCourant cc,@PathVariable("idClient") Long codeCli){
		return cmptService.addCompteCourant(cc,codeCli);
	}
	@PostMapping("/add/compteEpargne/{idClient}")
	public CompteEpargne addCompteEpargne(@RequestBody CompteEpargne ce,@PathVariable("idClient") Long codeCli){
		return cmptService.addCompteEpargne(ce,codeCli);
	}
	@PostMapping("/add/compteAtitre/{idClient}")
	public CompteATitre addCompteAtitre(@RequestBody CompteATitre cat,@PathVariable("idClient") Long codeCli){
		return cmptService.addCompteAtitre(cat,codeCli);
	}
	//validation des comptes:admin
	@PutMapping("/validercompte/{codeCompte}")
	public Compte validerCompte(@PathVariable("codeCompte") String codeCompte){
		return cmptService.validerCompte(codeCompte);
	}
	
	//supprimer des comptes:admin
	//URL :http://localhost:8088/SpringMVC/servlet/remove_compte/{compte_id}
	@DeleteMapping("/{codeCompte}")
	public List<Compte> deleteCompte(@PathVariable("codeCompte") String codeCompte){
		cmptService.deleteCompte(codeCompte);
return cmptService.retrieveAllCompte();

	}
	//update:modifier 
	//URL :http://localhost:8088/SpringMVC/servlet/modify_compte
	@PutMapping("/modify_compteCourant/{id_client}")
	public CompteCourant updateCompteC (@RequestBody CompteCourant cmpt,@PathVariable("id_client")Long codeCli){
		return cmptService.updateCompteCourant(cmpt, codeCli);

	}
	@PutMapping("/modify_compteEpargne/{id_client}")
	public CompteEpargne updateCompteE (@RequestBody CompteEpargne cmpt,@PathVariable("id_client")Long codeCli){
		return cmptService.updateCompteEpargne(cmpt, codeCli);

	}
	@PutMapping("/modify_compteATitre/{id_client}")
	public CompteATitre updateCompteAt (@RequestBody CompteATitre cmpt,@PathVariable("id_client")Long codeCli){
		return cmptService.updateCompteATitre(cmpt, codeCli);

	}
	@GetMapping("/login/{codeCompte}")
	public Compte login(@PathVariable("codeCompte") String codeCompte) throws Exception {
		Compte cmpt=cmptService.retrieveCompte(codeCompte);
		if(cmpt==null){
	throw new Exception("bad credentials");
}
		if(cmpt.getCodeCompte()==codeCompte && cmpt.getPassword()!=null && cmpt.isIsvalide()==true){
			return cmpt;	
		}
		return cmpt;

	}
 
	
	//POUR envoyer un mail de notification
	//URL :http://localhost:8088/SpringMVC/servlet/notificationmail
	/*@GetMapping("/notificationmail")
	public void notificationmail(){
     	cmptService.NotificationMail();

	}*/
}
