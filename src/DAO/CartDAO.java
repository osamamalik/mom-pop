package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.BookBean;
import model.Model;

public class CartDAO {

	private DataSource ds;
	
	public CartDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void addToCart(String bid, String user) throws SQLException {
			
			String query ="INSERT INTO Cart(username, bid) VALUES('" + user + "','" + Integer.parseInt(bid) + "')";
			Connection con = this.ds.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			con.close();		
	}
	
	public ArrayList<BookBean> retrieveCart(String user, Model myModel) throws SQLException {
			
			ArrayList<BookBean> list = new ArrayList<BookBean>();
			
			String query = "Select * from Cart where username = '" + user + "'";
			Connection con = this.ds.getConnection();
			PreparedStatement p = con.prepareStatement(query);
			
			ResultSet r = p.executeQuery();
			if(r.next()){
				BookBean bb;
				String bid = r.getString("bid");
				bb = myModel.retrieveBook(bid);
				list.add(bb);
			}
			p.close();
			con.close();
			r.close();
			
			return list;
	}
}
