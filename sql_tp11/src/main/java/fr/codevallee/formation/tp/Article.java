package fr.codevallee.formation.tp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_Article;
	
	private double prix;
	
	@ManyToOne
	private ArticleDescription articleDescription;

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
