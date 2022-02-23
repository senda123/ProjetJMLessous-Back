package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idClient")
	private Long codeClient;
	private Long Cin;
	private  String nom;
	private String prenom;
	private String email;
	private String Adresse;
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte>comptes;
	public Client() {
		super();
	}

	/**
	 * @return the codeClient
	 */
	public Long getCodeClient() {
		return codeClient;
	}

	/**
	 * @param codeClient the codeClient to set
	 */
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}

	public Client(Long id, Long cin, String nom, String prenom, String email, String adresse, String phone,
			Date dateNaissance, Collection<Compte> comptes) {
		super();
		this.codeClient = id;
		Cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		Adresse = adresse;
		this.phone = phone;
		this.dateNaissance = dateNaissance;
		this.comptes = comptes;
	}

	/**
	 * @return the cin
	 */
	public Long getCin() {
		return Cin;
	}

	/**
	 * @param cin the cin to set
	 */
	public void setCin(Long cin) {
		Cin = cin;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return Adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return codeClient;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.codeClient = id;
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
	public  String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the comptes
	 */
	@JsonBackReference
	public Collection<Compte> getComptes() {
		return comptes;
	}
	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

}
