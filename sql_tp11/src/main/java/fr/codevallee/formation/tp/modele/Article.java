package fr.codevallee.formation.tp.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArticle;
	
	@Column(length = 40)
	private String nom;
	
	private double prix;
	
	@ManyToOne
	private ArticleDescription articleDescription;
	
	
	// constructeur par défaut
	public Article() {
	}

	// Surcharge du constructeur
	public Article(String nom, double prix, ArticleDescription articleDescription) {
		this.nom = nom;
		this.prix = prix;
		this.articleDescription = articleDescription;
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
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the articleDescription
	 */
	public ArticleDescription getArticleDescription() {
		return articleDescription;
	}

	/**
	 * @param articleDescription the articleDescription to set
	 */
	public void setArticleDescription(ArticleDescription articleDescription) {
		this.articleDescription = articleDescription;
	}
	
	
}
