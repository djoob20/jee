package com.ocjeetest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ocjeetest.beans.User;

/**
 * Communication avec notre BDD.
 * 
 * @author dembadiop
 *
 */
public class Names {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/javaee";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "779311199";
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private Connection connection = null;
	

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();
		
		loadDB();
		
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT nom, prenom FROM noms;");
			
			while(resultSet.next()) {
				User user = new User();
				user.setLastname(resultSet.getString("nom"));
				user.setFirstname(resultSet.getString("prenom"));
				
				users.add(user);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return users;

	}
	
	private void loadDB() {
		
		// Charger le Driver
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection( DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addUser(User user) {
		loadDB();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?,?);");
			preparedStatement.setString(1, user.getLastname());
			preparedStatement.setString(2, user.getFirstname());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
