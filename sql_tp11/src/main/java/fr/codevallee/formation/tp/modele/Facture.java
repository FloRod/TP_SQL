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

@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFacture;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(cascade ={CascadeType.REMOVE})
	private Set<LigneFacture> ligneFactures = new HashSet<LigneFacture>();
	
	@Column(length = 40)
	private String nomClient;
	
	@Column(length = 100)
	private String adresseFacturation;
	
	@Column(length = 40)
	private String date;
	
	private String statut;

	// constructeur par défaut
	public Facture() {
	}

	// Surcharge du constructeur
	public Facture(Client client, Set<LigneFacture> ligneFactures, String date, Statut statut) {
		this.client = client;
		this.ligneFactures = ligneFactures;
		this.date = date;
		this.statut = statut.name();
		this.adresseFacturation = client.getAdresseFacturation().toString();
		this.nomClient = client.getNom();
	}

	
	// Getters et Setters
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the ligneFactures
	 */
	public Set<LigneFacture> getLigneFactures() {
		return ligneFactures;
	}

	/**
	 * @param ligneFactures the ligneFactures to set
	 */
	public void setLigneFactures(Set<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	//somme des lignes de facture

}