package fr.codevallee.formation.tp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	private static  Connection connect;


	public static Connection SeConnecter() throws SQLException {


		try {
			connect = (DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "1234"));
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
