package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CompteATitre;
@Repository
public interface CompteAtitreRepository  extends CrudRepository<CompteATitre,String>{

}
