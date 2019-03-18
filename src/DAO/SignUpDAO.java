package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SignUpDAO {
	DataSource ds;
	
	public SignUpDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String username, String password, String email) throws SQLException {
		String query ="INSERT INTO USER(username, password, email) VALUES('" + username + "','" + password + "','" + email+ "')";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		int r = p.executeUpdate();
		p.close();
		con.close();
	}

}