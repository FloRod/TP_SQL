package fr.codevallee.formation.tp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class LigneFacture {
	
	@Id 
	@JoinColumn(name = "ID_Article", referencedColumnName = "")
	private long id;

}
