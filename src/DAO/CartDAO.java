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
	
	
	public void addToCart(int bid, int quantity, String user) throws SQLException {
		
		//constructs the initial query
		String query = "insert into CART(username, bid, quantity) values('" + user + "', " + bid + "," + quantity + ")";
		//retrieves the user's shopping cart
		ArrayList<CartBean> userCart = this.retrieveCart(user);
		
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		
		//checks if this user's cart already contains the book
		//if so, query is adjusted to update quantity. if not, new item is added to cart
		for (CartBean cart : userCart) {
		
			if (cart.getBid() == bid) {
				int cid = cart.getCid();
				query = "update cart set quantity = quantity + " + quantity + " where cid = " + cid + " and username = '" + user + "'";
			}
		}
		
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		
	}
	
	public void addShoppingCart(ArrayList<CartBean> userCart, String user) throws SQLException {
					
		for (CartBean cart : userCart) {
			this.addToCart(cart.getBid(), cart.getQuantity(), cart.getUsername());
		}

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
			
		ArrayList<CartBean> shoppingCart = new ArrayList<CartBean>();
		
		String query = "select * from cart join books on cart.bid = books.bid where username = '" + user + "'";
				   
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			CartBean cartItem = new CartBean();
			int bid = r.getInt("bid");
			cartItem.setCid(r.getInt("cid"));
			cartItem.setBid(bid);
			cartItem.setUsername(user);
			cartItem.setPrice(r.getDouble("price"));
			cartItem.setTitle(r.getString("title"));
			cartItem.setQuantity(r.getInt("quantity"));
			cartItem.setAuthor(r.getString("author"));
			shoppingCart.add(cartItem);
		}
		
		p.close();
		con.close();
		r.close();
		
		return shoppingCart;
		
	}
	
	public void clearVisitorCart() throws SQLException {
		
		String query = "delete from CART where username = 'visitor'";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		
	}
	
}





















