package com.revature.bankingapp.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {


	
	public static Connection getConnection() {
		
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "postgres";
		String password = "Moomoos1!";
		Connection conn = null;
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e){
			
			System.out.println("Could not connect to the database");
		}
		
		return conn;
	}
	
	//public static void main(String[] args) {
		
		//getConnection();
	//}
}
