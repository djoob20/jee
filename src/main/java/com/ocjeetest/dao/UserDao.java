package com.ocjeetest.dao;

import java.util.List;

import com.ocjeetest.beans.User;

public interface UserDao {
	
	void addUser(User user);
	List<User> getUsers();

}
