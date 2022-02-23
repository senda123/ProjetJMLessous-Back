package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.CompteCourant;
@Repository
public interface CompteCourantRepository  extends CrudRepository<CompteCourant,String>{

}
