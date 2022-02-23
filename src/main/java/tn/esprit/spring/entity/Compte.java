package tn.esprit.spring.entity;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Collection;

//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//pour l heritage et chacun a de compte
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="Type_Compte",discriminatorType=DiscriminatorType.STRING,length=2)

@Entity
@Table
public class Compte  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="codeCompte")
	private String codeCompte;
	private String password;
	private  String nom;
	private String prenom;
	private String email;
	private String Type_Compte;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private double solde;
	private boolean isvalide;
	//private double DepotMin;
	@ManyToOne
	@JoinColumn(name="idClient", referencedColumnName ="idClient")
	private Client client;
	@OneToMany(mappedBy = "comptes", fetch = FetchType.LAZY)
	private Collection <Operation> operations;


	/**
	 * @return the idClient
	 */

	/**
	 * @return the nombreCompte
	 */

	//private Collection<Operation>operations;
	public Compte() {
		super();
	}




	/**
	 * @return the type_Compte
	 */
	public String getType_Compte() {
		return Type_Compte;
	}




	/**
	 * @param type_Compte the type_Compte to set
	 */
	public void setType_Compte(String type_Compte) {
		Type_Compte = type_Compte;
	}






	public Compte(String codeCompte, String password, String nom, String prenom, String email, String type_Compte,
			Date dateCreation, double solde, boolean isvalide, Client client) {
		super();
		this.codeCompte = codeCompte;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		Type_Compte = type_Compte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.isvalide = isvalide;
		this.client = client;
	}




	/**
	 * @return the isvalide
	 */
	public boolean isIsvalide() {
		return isvalide;
	}




	/**
	 * @param isvalide the isvalide to set
	 */
	public void setIsvalide(boolean isvalide) {
		this.isvalide = isvalide;
	}




	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}




	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}




	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}




	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getCodeCompte() {
		return codeCompte;
	}
	/**
	 * @param codeCompte the codeCompte to set
	 */
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	/**
	 * @return the email
	 */
	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	/**
	 * @return the client
	 */
	@JsonBackReference
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonBackReference
	public Collection<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

}
