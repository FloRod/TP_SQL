package fr.codevallee.formation.tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;

public class ConnectionJDBC {

	private static  Connection connect;


	public static Connection SeConnecter() throws SQLException {


		try {
			// Step 1: Allocate a database 'Connection' object
			connect = (DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "1234"));
			// MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

			// Step 2: Allocate a 'Statement' object in the Connection
//			Statement stmt = conn.createStatement();
//
//			// Step 3: Execute a SQL SELECT query, the query result is returned in a 'ResultSet' object.
//			String strSelect = "select nom, date, total, num_table from restaurant.Commande";
//			System.out.println("The SQL query is: " + strSelect); // Echo For
//																	// debugging
//			System.out.println();
//
//			ResultSet rset = stmt.executeQuery(strSelect);
//
//			// Step 4: Process the ResultSet by scrolling the cursor forward via next(). For each row, retrieve the contents of the cells with getXxx(columnName).
//			System.out.println("The records selected are:");
//			int rowCount = 0;
//			while (rset.next()) { // Move the cursor to the next row, return
//									// false
//									// if no more row
//
//				String nom = rset.getString("nom");
//				String date = rset.getString("date");
//				double total = rset.getDouble("total");
//				int numTable = rset.getInt("num_table");
//				System.out.println(nom + ", " + date + ", " + total + ", " + numTable);
//				++rowCount;
//			}
//			System.out.println("Total number of records = " + rowCount);
		} catch (SQLException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		
		return connect;
	}


	public Connection getConnect() {
		return connect;
	}



}
