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

import com.sun.javafx.collections.MappingChange.Map;

import bean.*;
import model.*;
import DAO.*;


public class CartDAO {

	private DataSource ds;
	
	public CartDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void addToCart(int bid, String user) throws SQLException {
		
		
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		boolean updated = false;
		String query = "insert into CART(username, bid, quantity) values('" + user + "', " + bid + "," + 1 + ")";
		
		//retrieves the user's shopping cart
		ArrayList<CartBean> userCart = this.retrieveCart(user);

		
		//checks if this user's cart already contains the book
		//if so, query is adjusted to updte quantity. if not, new item is added to cart
		for (CartBean cart : userCart) {
		
			if (cart.getBid() == bid) {
				updated = true;
				query = "update cart set quantity = quantity + 1 where cid = " + cart.getCid() + " and username = '" + user + "'";
			}
		}
		
	
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		
	}
	
	public void removeFromCart(int bid, String user) throws SQLException {

		String query = "delete from CART where username = '" + user + "' and bid = " + bid;
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
				
	}
	
	public void updateQuantity(int bid, String user, int quantity) throws SQLException {

		String query = "update cart set quantity = " + quantity + " where bid = " + bid + " and username = '" + user + "'";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
				
	}
	
	public ArrayList<CartBean> retrieveCart(String user) throws SQLException {
			
		Model myModel = new Model();
		ArrayList<CartBean> shoppingCart = new ArrayList<CartBean>();
		
		String query = "select * from cart join books on cart.bid = books.bid where username = '" + user + "'";
				   
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			CartBean cart = new CartBean();
			int bid = r.getInt("bid");
			cart.setCid(r.getInt("cid"));
			cart.setBid(bid);
			cart.setUsername(user);
			cart.setPrice(r.getDouble("price"));
			cart.setTitle(r.getString("title"));
			cart.setQuantity(r.getInt("quantity"));
			shoppingCart.add(cart);
		}
		
		p.close();
		con.close();
		r.close();
		
		return shoppingCart;
		
	}
	
}
