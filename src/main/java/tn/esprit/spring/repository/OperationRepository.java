package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import tn.esprit.spring.entity.Operation;
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
