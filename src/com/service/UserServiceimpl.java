package com.service;

import java.sql.SQLException;

import com.dao.UserDAO;
import com.entity.User;

public class UserServiceimpl {
	public User getUser(User user)
	{
		UserDAO udao = new UserDAO();
		User user1=null;
		 try {
			user1=udao.getUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}

}
