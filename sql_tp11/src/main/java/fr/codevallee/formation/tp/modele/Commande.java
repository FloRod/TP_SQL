package fr.codevallee.formation.tp.modele;

import javax.persistence.Column;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")

public class Commande {
//	@Column(name = "ID_Commande")

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "ID_Commande")
	private Integer ID_Commande;

	private String nom;
	
	private String date;
	
	private double total;
	
	private int numTable;
	
//	public Commande(String nom, String date, double total, int numTable) {
//		this.nom = nom;
//		this.date = date;
//		this.total = total;
//		this.numTable = numTable;
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the numTable
	 */
	public int getNumTable() {
		return numTable;
	}

	/**
	 * @param numTable the numTable to set
	 */
	public void setNumTable(int numTable) {
		this.numTable = numTable;
	}

}
