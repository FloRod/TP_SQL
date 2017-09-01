package fr.codevallee.formation.tp.modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.action.internal.OrphanRemovalAction;
//import javax.persistence.OneToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;
	
	@Column(length = 40)
	private String nom;
	
	@Column(length = 40)
	private String prenom;

	@ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REMOVE})
	private Adresse adresseFacturation;
	
	@OneToMany
	private Set<Adresse> adresseLivraisons = new HashSet<Adresse>();
	
	@OneToMany (mappedBy = "client")
	@Column(nullable = true)
	private Set<Facture> factures = new HashSet<Facture>();

	// constructeur par défaut
	public Client() {
	}

	// Surcharge du constructeur
	public Client(String nom, String prenom, Adresse adresseFacturation, Set<Adresse> adresseLivraisons,
			Set<Facture> factures) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraisons = adresseLivraisons;
		this.factures = factures;
	}

	
	// Getters et Setters
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

	/**
	 * @return the factures
	 */
	public Set<Facture> getFactures() {
		return factures;
	}

	/**
	 * @param factures the factures to set
	 */
	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	
	


}