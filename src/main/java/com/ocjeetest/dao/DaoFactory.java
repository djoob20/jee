package com.ocjeetest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private static final String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private String url;
	private String username;
	private String password;

	DaoFactory(String url, String username, String password) {
		
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DaoFactory getInstance() {
		// Charger le Driver
		try {
			Class.forName(MYSQL_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/javaee", "root", "779311199");
		
		
		return instance;
	}
	
	public Connection getConnetion() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(false);
		connection.setAutoCommit(false);
		return connection;
	}
	
	public UserDao getUserDao() {
		return new UserDaoImpl(this);
	}
}
