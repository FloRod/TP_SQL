package fr.codevallee.formation.tp1;

public class SortieNav {

	private String nom;
	private String date;
	private double total;
	private int numTable;
	
	public SortieNav(String nom, String date, double total, int numTable) {
		super();
		this.nom = nom;
		this.date = date;
		this.total = total;
		this.numTable = numTable;
	}

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
