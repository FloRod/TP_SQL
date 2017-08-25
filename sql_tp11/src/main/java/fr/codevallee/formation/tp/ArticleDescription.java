package fr.codevallee.formation.tp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class ArticleDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID_Description;
	
	private String description;
	
	@OneToMany(mappedBy = "articleDescription")
	private Article article;

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
