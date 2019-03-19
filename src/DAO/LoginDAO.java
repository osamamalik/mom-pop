package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.LoginBean;

public class LoginDAO {
	DataSource ds;

	public LoginDAO() throws ClassNotFoundException{
		try {
			this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public LoginBean retrieveUser(String username) throws SQLException {
		String query = "select * from USERS where username ='" + username + "'";
		LoginBean lb = new LoginBean();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if(r.next()){
			lb.setUsername(r.getString("username"));
			lb.setPassword(r.getString("password"));
		}

		return lb;	
	}
	
	public boolean checkUserExists(String username) throws SQLException {
		String query = "select * from USERS where username ='" + username + "'";
		LoginBean lb = new LoginBean();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		return r.next();	
	}
}