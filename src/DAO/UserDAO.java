package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.*;

public class UserDAO {
	
	private DataSource ds;
	
	public UserDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String username, String email, String password) throws SQLException {
		String query ="INSERT INTO USERS(username, email, password) VALUES('" + username + "','" + email + "','" + password+ "')";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
	}
	
	public void updatePassword(String username, String newPassword) throws SQLException {
		String query ="UPDATE USERS SET password = '" + newPassword + "' WHERE username = '" + username + "'";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
	}
	
	public UserBean retrieveUser(String username) throws SQLException {
		String query = "SELECT * from USERS where username ='" + username + "'";
		UserBean ub = new UserBean();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if(r.next()){
			ub.setUsername(r.getString("username"));
			ub.setPassword(r.getString("password"));
		}
		p.close();
		con.close();
		r.close();
		return ub;
	}
	
	public boolean checkUserExists(String username) throws SQLException {
		String query = "SELECT * from USERS where username ='" + username + "'";
		Connection con = this.ds.getConnection();
		con.setAutoCommit(false);
		PreparedStatement p = con.prepareStatement(query);
		Boolean exists = p.executeQuery().next();
		p.close();
		con.close();
		return exists;
	}

}