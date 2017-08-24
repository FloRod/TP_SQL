package fr.codevallee.formation.tp;

import java.util.Set;

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
	
	@OneToOne(mappedBy="maire")
	private Commune commune ;
	
	@OneToMany
	private Set<Elu> Elu ;
}
