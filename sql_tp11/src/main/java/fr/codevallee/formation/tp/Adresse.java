package fr.codevallee.formation.tp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_Adresse;
	
	private String rue;
	
	private int codePostale;
	
	private String ville;
	
	@OneToOne(mappedBy = "adresseFacturation")
	private Client clientFacturation;
	
	@ManyToOne
	private Client clientLivraison;

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostale
	 */
	public int getCodePostale() {
		return codePostale;
	}

	/**
	 * @param codePostale the codePostale to set
	 */
	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the clientFacturation
	 */
	public Client getClientFacturation() {
		return clientFacturation;
	}

	/**
	 * @param clientFacturation the clientFacturation to set
	 */
	public void setClientFacturation(Client clientFacturation) {
		this.clientFacturation = clientFacturation;
	}

	/**
	 * @return the clientLivraison
	 */
	public Client getClientLivraison() {
		return clientLivraison;
	}

	/**
	 * @param clientLivraison the clientLivraison to set
	 */
	public void setClientLivraison(Client clientLivraison) {
		this.clientLivraison = clientLivraison;
	}


}
