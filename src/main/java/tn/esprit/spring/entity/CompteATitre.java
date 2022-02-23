package tn.esprit.spring.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tn.esprit.spring.entity.TypeMob;
@Entity
//@DiscriminatorValue("CT")
@Table()

public class CompteATitre extends Compte {

	private static final long serialVersionUID = 1L;
@Enumerated(EnumType.STRING)
@Column(name="valeur_mobiliere")
TypeMob type_valeur_mobil;
private double valeur;
private int nombre;
private double dernier_cours;
private double prix_revient;
private double montant_investi;
@Temporal(TemporalType.DATE)
private Date date;








public CompteATitre(TypeMob type_valeur_mobil, double valeur, int nombre, double dernier_cours, double prix_revient,
		double montant_investi, Date date) {
	super();
	this.type_valeur_mobil = type_valeur_mobil;
	this.valeur = valeur;
	this.nombre = nombre;
	dernier_cours = dernier_cours;
	this.prix_revient = prix_revient;
	montant_investi = montant_investi;
	this.date = date;
}






public CompteATitre() {
	super();
	// TODO Auto-generated constructor stub
}



/**
 * @return the type_valeur_mobil
 */
public TypeMob getType_valeur_mobil() {
	return type_valeur_mobil;
}






/**
 * @param type_valeur_mobil the type_valeur_mobil to set
 */
public void setType_valeur_mobil(TypeMob type_valeur_mobil) {
	this.type_valeur_mobil = type_valeur_mobil;
}






/*
 * 
 * 
 * @return the valeur
 */
public double getValeur() {
	return valeur;
}
/**
 * @param valeur the valeur to set
 */
public void setValeur(double valeur) {
	this.valeur = valeur;
}
/**
 * @return the nombre
 */
public int getNombre() {
	return nombre;
}
/**
 * @param nombre the nombre to set
 */
public void setNombre(int nombre) {
	this.nombre = nombre;
}
/**
 * @return the dernier_cours
 */

/**
 * @return the prix_revient
 */
public double getPrix_revient() {
	return prix_revient;
}
/**
 * @param prix_revient the prix_revient to set
 */
public void setPrix_revient(double prix_revient) {
	this.prix_revient = prix_revient;
}
/**
 * @return the montant_investi
 */

/**
 * @return the date
 */
public Date getDate() {
	return date;
}
/**
 * @return the dernier_cours
 */
public double getDernier_cours() {
	return dernier_cours;
}






/**
 * @param dernier_cours the dernier_cours to set
 */
public void setDernier_cours(double dernier_cours) {
	this.dernier_cours = dernier_cours;
}






/**
 * @return the montant_investi
 */
public double getMontant_investi() {
	return montant_investi;
}






/**
 * @param montant_investi the montant_investi to set
 */
public void setMontant_investi(double montant_investi) {
	this.montant_investi = montant_investi;
}






/**
 * @param date the date to set
 */
public void setDate(Date date) {
	this.date = date;
}


}
