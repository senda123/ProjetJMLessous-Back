package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity

@Table()
//@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

	private static final long serialVersionUID = 1L;
	
	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CompteEpargne(double taux) {
		super();
		this.taux = taux;
	}



	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}



	public CompteEpargne(String codeCompte, String password, String nom, String prenom, String email,
			String type_Compte, Date dateCreation, double solde, boolean isvalide, Client client) {
		super(codeCompte, password, nom, prenom, email, "compteEparne", dateCreation, solde, isvalide, client);
		// TODO Auto-generated constructor stub
	}




	

}
