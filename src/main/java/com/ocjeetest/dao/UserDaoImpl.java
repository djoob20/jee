package com.ocjeetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ocjeetest.beans.User;

public class UserDaoImpl implements UserDao {
	
	private DaoFactory daoFactory;
	
	UserDaoImpl(DaoFactory daoFactory){
		this.daoFactory = daoFactory;
	}

	@Override
	public void addUser(User user) {
		
		String sqlQuery = "INSERT INTO noms(nom, prenom) VALUES(?,?);";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = this.daoFactory.getConnetion();
			preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setString(1, user.getLastname());
			preparedStatement.setString(2, user.getFirstname());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = this.daoFactory.getConnetion();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT nom, prenom FROM noms;");

			while (resultSet.next()) {
				String lastname = resultSet.getString("nom");
				String firstname = resultSet.getString("prenom");
				
				User user = new User();
				user.setLastname(lastname);
				user.setFirstname(firstname);

				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return users;
	}

}
