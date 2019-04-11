package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.javafx.collections.MappingChange.Map;

import bean.*;
import model.*;
import DAO.*;


public class OrderDAO {

	private DataSource ds;
	
	public OrderDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addtoOrders(ArrayList<CartBean> shoppingCart) throws SQLException {
		
		LocalDate date = LocalDate.now();
		String user = shoppingCart.get(0).getUsername();
		String query = "insert into ORDERS(odate, username) values('" + date + "', '" + user + "')";

		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		
		this.addOrderDetails(shoppingCart);
	}
	
	public void addOrderDetails(ArrayList<CartBean> shoppingCart) throws SQLException {
		int lastOID = this.getLastOrderId();
		
		for (CartBean cartItem : shoppingCart) {
			this.addSingleOrderDetails(lastOID, cartItem.getBid());
		}
	}
	
	public void addSingleOrderDetails(int oid, int bid) throws SQLException {
		
		String query = "insert into ORDERDETAILS(oid, bid) values(" + oid + ", " + bid + ")";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
	}
	

	public int getOrderCount() throws SQLException {
		
		String query = "select count(*) as totalCount from ORDERS";
		int count = -1;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		if (r.next()) {
			count = r.getInt("totalCount");
		}
		
		p.close();
		con.close();
		r.close();
		
		return count;
	}
	
	public int getLastOrderId() throws SQLException {
		String query = "select max(oid) as lastOrderId from orders";
		int lastOrderId = -1;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()) {
			lastOrderId = r.getInt("lastOrderId");
		}
		
		p.close();
		con.close();
		r.close();
		
		return lastOrderId;
	}
	
	public ArrayList<OrderBean> retrieveOrders(int bid) throws SQLException{
		String query = "select * from OrderDetails where bid = " + bid;
		ArrayList<OrderBean> aob= new ArrayList<OrderBean>(); 
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		while (r.next()){
			
			OrderBean ob = new OrderBean();
			int oid = Integer.parseInt(r.getString("oid"));
			
			String query2 = "select * from Orders where oid = " + oid;
			PreparedStatement p2 = con.prepareStatement(query2);
			ResultSet r2 = p2.executeQuery();
			
			ob.setOid(oid);
			while (r2.next()) {
				ob.setUsername(r2.getString("username"));
				ob.setOrderDate(r2.getString("odate"));
			}
			r2.close();
			p2.close();
			aob.add(ob);
		}
		
		p.close();
		con.close();
		r.close();
		return aob;
	}
	
	
	public ArrayList<OrderWrapper> retrieveOrdersByMonth(int month) throws SQLException{
		String query = "select * from Orders where MONTH(odate) = " + month;
		ArrayList<OrderWrapper> aob= new ArrayList<OrderWrapper>(); 
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		while (r.next()){
			int oid = Integer.parseInt(r.getString("oid"));
			String query2 = "select * from OrderDetails where oid = " + oid;
			PreparedStatement p2 = con.prepareStatement(query2);
			ResultSet r2 = p2.executeQuery();
			
			while (r2.next()) {
				OrderWrapper ob = new OrderWrapper();
				ob.setOid(oid);
				int bid = Integer.parseInt(r2.getString("bid"));
				ob.setBid(bid);
				ob.setUser(r.getString("username"));
				ob.setDate(r.getString("odate"));
				aob.add(ob);
			}
			r2.close();
			p2.close();
		}
		
		p.close();
		con.close();
		r.close();
		return aob;
	}
	
	/* for analytics top 10.
	 * I need to fix the query.
	 * Right now it returns books but its not in order and
	 * im not sure if it is returning the correct top ten.*/
	public ArrayList<BookBean> getTop10() throws SQLException, ClassNotFoundException{
		
		ArrayList<BookBean> abb= new ArrayList<BookBean>(); 
		String query = "Select bid as bid from OrderDetails group by bid Order by count(bid) fetch first 10 rows only";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		BookDAO bookDAO = new BookDAO();
		
		while(r.next()) {
			String bid = r.getString("bid");
			BookBean bb = bookDAO.retrieveBook(Integer.parseInt(bid));
			abb.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return abb;
	}
	

}


















