package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte,String>{
	
	public Compte getUserByEmailAndPassword(String login, String password);
}
