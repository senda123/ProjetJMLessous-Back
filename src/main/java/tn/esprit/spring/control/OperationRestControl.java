package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.CompteATitre;
import tn.esprit.spring.entity.Operation;
import tn.esprit.spring.service.IOperationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pi/o")
public class OperationRestControl {
	@Autowired
	IOperationService optService;
	//admin
	//URL :http://localhost:8088/SpringMVC/servlet/retrieve_all_comptes
		@GetMapping("/retrieve_all_optsbycode/{codeCompte}")
		public List<Operation> retrieveAllOperationBycode(@PathVariable("codeCompte") String codeCpt) {
			
			List<Operation> list=optService.retrieveAllOperationsByCodeCompte(codeCpt);

			return list;
		}
		@GetMapping("/filter/{codeCompte}/{type}")
		public List<Operation> filterBytype(@PathVariable("codeCompte") String codeCpt,@PathVariable("type") String type) {
			
			List<Operation> list=optService.retrieveAllOperationsbyType(type, codeCpt);

			return list;
		}
		//URL :http://localhost:8088/SpringMVC/servlet/retrieve_all_comptes
				@GetMapping("/retrieve_all_opts")
				public List<Operation> retrieveAllOperation() {
					
					List<Operation> list=optService.retrieveAllOperations();

					return list;
				}
		@PostMapping("/add/opt_retrait/{codeCompte}/{montant}")
		public  void retrait_opt(@PathVariable("montant")  double montant,@PathVariable("codeCompte") String codeCpt){
			System.out.println(montant+codeCpt);
			optService.retraitOperationCompte(codeCpt, montant);
		}
		@PostMapping("/add/opt_versement/{codeCompte}/{montant}")
		public  void versement_opt(@PathVariable("montant")  double montant,@PathVariable("codeCompte") String codeCpt){
			System.out.println(montant+codeCpt);
			optService.versementOperationCompte(codeCpt, montant);
		}
		@PostMapping("/add/opt_virement/{codeCompte1}/{codeCompte2}/{montant}")
		public  void virement_opt(@PathVariable("montant")  double montant,@PathVariable("codeCompte1") String codeCpt1,@PathVariable("codeCompte2") String codeCpt2){
		
			optService.virmentOperationCompte(codeCpt1, codeCpt2, montant);
		}
}
