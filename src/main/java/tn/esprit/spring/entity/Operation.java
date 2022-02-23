package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)


public  class Operation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private Date dateOperation;
	private double montant;
	private OperationType OperationType;
	@ManyToOne
	@JoinColumn(name = "codeCompte")
	private Compte comptes;

	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public OperationType getOperationType() {
		return OperationType;
	}

	public void setOperationType(OperationType operationType) {
		OperationType = operationType;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public Compte getComptes() {
		return comptes;
	}

	public void setComptes(Compte comptes) {
		this.comptes = comptes;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Operation(Date dateOperation, double montant, Compte comptes) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.comptes = comptes;
	}





   
}
