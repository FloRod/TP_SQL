package fr.codevallee.formation.tp.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LigneFacture {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLigneFacture;
	
	private int quantite;
	
	@OneToOne
	private Article article;

	// constructeur par défaut
	public LigneFacture() {
	}

	// Surcharge du constructeur
	public LigneFacture(int quantite, Article article) {
		this.quantite = quantite;
		this.article = article;
	}

	
	// Getters et Setters
	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	
	
	
}
