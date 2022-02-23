package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Compte;
import tn.esprit.spring.entity.Operation;
import tn.esprit.spring.entity.OperationType;
import tn.esprit.spring.repository.CompteRepository;
import tn.esprit.spring.repository.OperationRepository;
@Service
public class OperationServiceImpl implements IOperationService {
	@Autowired
	OperationRepository operationRepository;
	@Autowired
    CompteRepository compteRepository;
	private static final Logger L=LogManager.getLogger(OperationServiceImpl.class);
	@Override
	public List<Operation> retrieveAllOperations() {
List<Operation> operations=(List<Operation>) operationRepository.findAll();
		
		for(Operation operation :operations ){
			L.info("operation::::::::::::::" + operation);
		}
		return operations;

	}

	@Override
	public List<Operation> retrieveAllOperationsByCodeCompte(String codeCpt) {
		L.info(("au niveau de retrieveAllOperationsByCodeCompte le code de compte = " +codeCpt));
		
		List<Operation> op = new ArrayList<Operation>();;
		List<Operation> operations=(List<Operation>) operationRepository.findAll();
		for(Operation operation :operations ){
			if (operation.getComptes().getCodeCompte().equals(codeCpt))
			{
				op.add(operation);
			}
		}
		return op;
	}

	@Override
	public void retraitOperationCompte(String codeCpt, double montant) {
		L.info(("au niveau de retrieveAllOperationsByCodeCompte le code de compte = " +codeCpt));
		Compte compte = compteRepository.findById(codeCpt).orElse(null);
		L.info(("au niveau de retrieveAllOperationsByCodeCompte le code de compte = " +compte.getNom()));
		Operation o = new Operation();
		o.setComptes(compte);
		
		
		double s = compte.getSolde();
		System.out.println(s);
		
		s-=montant;
		o.setMontant(-montant);
		o.setDateOperation(new Date());
		o.setOperationType(OperationType.RETRAIT);
		compte.setSolde(s);
		System.out.println(compte.getSolde());
	compteRepository.save(compte);
	
		operationRepository.save(o);
		
		System.out.println(s);
	}

	@Override
	public void versementOperationCompte(String codeCpt, double montant) {
		L.info(("au niveau de retrieveAllOperationsByCodeCompte le code de compte = " +codeCpt));
		Compte compte = compteRepository.findById(codeCpt).orElse(null);
		L.info(("au niveau de retrieveAllOperationsByCodeCompte le code de compte = " +compte.getNom()));
		Operation o = new Operation();
		o.setComptes(compte);
		
		
		double s = compte.getSolde();
		System.out.println(s);
		
		s+=montant;
		o.setMontant(+montant);
		o.setDateOperation(new Date());
		o.setOperationType(OperationType.VERSEMENT);
		compte.setSolde(s);
		System.out.println(compte.getSolde());
	compteRepository.save(compte);
	
		operationRepository.save(o);
		
		System.out.println(s);
		
	}

	@Override
	public void virmentOperationCompte(String codeCpt1, String codeCpt2, double montant) {
			retraitOperationCompte(codeCpt1, montant);
			versementOperationCompte(codeCpt2, montant);
	}

	@Override
	public List<Operation> retrieveAllOperationsbyType(String type, String codeCpt) {
		List<Operation> op = new ArrayList<Operation>();
		List<Operation> operations=(List<Operation>) operationRepository.findAll();

		for(Operation operation :operations ){
	
			if (( operation.getComptes().getCodeCompte().equals(codeCpt) || codeCpt.toString().equals("-1")) && operation.getOperationType().toString().toLowerCase().equals(type.toLowerCase()) )
			{
				op.add(operation);
			}
		}
		return op;
	}



}
