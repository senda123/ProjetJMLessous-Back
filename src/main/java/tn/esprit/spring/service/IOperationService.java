package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.Operation;




public interface IOperationService {
	List<Operation> retrieveAllOperationsbyType(String type,String codeCpt);
	List<Operation> retrieveAllOperations();
	List<Operation> retrieveAllOperationsByCodeCompte(String codeCpt);
	void retraitOperationCompte(String codeCpt, double montant);
	void versementOperationCompte(String codeCpt, double montant);
	void virmentOperationCompte(String codeCpt1,String codeCpt2, double montant);
}
