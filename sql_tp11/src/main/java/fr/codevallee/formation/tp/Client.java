package fr.codevallee.formation.tp;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom;
	
	private String prenom;

	@OneToOne
	private Adresse adresseFacturation;
	
	@OneToMany(mappedBy = "clientLivraison")
	private Set<Adresse> adresseLivraisons;

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
	 * @return the adresseFacturation
	 */
	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	/**
	 * @param adresseFacturation the adresseFacturation to set
	 */
	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	/**
	 * @return the adresseLivraisons
	 */
	public Set<Adresse> getAdresseLivraisons() {
		return adresseLivraisons;
	}

	/**
	 * @param adresseLivraisons the adresseLivraisons to set
	 */
	public void setAdresseLivraisons(Set<Adresse> adresseLivraisons) {
		this.adresseLivraisons = adresseLivraisons;
	}


}