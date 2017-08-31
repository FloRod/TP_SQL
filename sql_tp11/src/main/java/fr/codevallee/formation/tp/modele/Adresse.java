package fr.codevallee.formation.tp.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdresse;
	
	@Column(length = 100)
	private String rue;
	
	private int codePostale;
	
	@Column(length = 100)
	private String ville;
	
	// constructeur par défaut
	public Adresse() {
	}

	// Surcharge du constructeur
	public Adresse(String rue, int codePostale, String ville) {
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
	}

	public String toString(){
		return this.rue + " , " + this.codePostale + " , " + this.ville;
	}
	
	// Getters et Setters
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
	
	

}