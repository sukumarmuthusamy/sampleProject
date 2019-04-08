package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.User;

public class UserDAO {
	public User getUser(User user)throws SQLException
	{
		User user1 = null;
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/festivaldatabase", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="insert into user values(?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, user.getUser());
		statement.setString(2,user.getPass());
		statement.setString(3, user.getLoc());
		statement.executeUpdate();
		String sql1="select * from user";
		PreparedStatement stmt=connection.prepareStatement(sql1);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			user1 = new User();
			user1.setUser(rs.getString("user"));
			user1.setPass(rs.getString("pass"));
			user1.setLoc(rs.getString("loc"));
		}
		return user1;
	}

}
