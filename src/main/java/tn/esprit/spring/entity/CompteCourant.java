package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table()
//@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private static final long serialVersionUID = 1L;
private double decouvert;

public CompteCourant() {
	super();
}



public CompteCourant(double decouvert) {
	super();
	this.decouvert = decouvert;
}





public CompteCourant(String codeCompte, String password, String nom, String prenom, String email, String type_Compte,
		Date dateCreation, double solde, boolean isvalide, Client client) {
	super(codeCompte, password, nom, prenom, email, "compteCourant", dateCreation, solde, isvalide, client);
	// TODO Auto-generated constructor stub
	
}



/**
 * @return the decouvert
 */
public double getDecouvert() {
	return decouvert;
}

/**
 * @param decouvert the decouvert to set
 */
public void setDecouvert(double decouvert) {
	this.decouvert = decouvert;
}

}
