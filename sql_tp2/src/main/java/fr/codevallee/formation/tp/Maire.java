package fr.codevallee.formation.tp;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Maire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 40)
	private String nom;
	
	@OneToOne(mappedBy="maire", cascade ={CascadeType.REMOVE, CascadeType.PERSIST})
	private Commune commune ;
	
	@OneToMany
	private Set<Elu> Elu ;

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
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/**
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	/**
	 * @return the elu
	 */
	public Set<Elu> getElu() {
		return Elu;
	}

	/**
	 * @param elu the elu to set
	 */
	public void setElu(Set<Elu> elu) {
		Elu = elu;
	}
}
