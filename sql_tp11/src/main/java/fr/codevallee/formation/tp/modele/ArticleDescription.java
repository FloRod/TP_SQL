package fr.codevallee.formation.tp.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

@Entity
public class ArticleDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDescription;
	
	@Column(length = 100)
	private String description;

	
	// constructeur par défaut
	public ArticleDescription() {
	}

	// Surcharge du constructeur
	public ArticleDescription(String description) {
		this.description = description;
	}
	
	
	// Getters et Setters

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

}
