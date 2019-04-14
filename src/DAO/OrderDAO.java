package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	
	public void addtoOrders(ArrayList<CartBean> shoppingCart, AddressBean shippingAddress, AddressBean billingAddress) throws SQLException {
		
		LocalDate date = LocalDate.now();
		String username = shoppingCart.get(0).getUsername();
		String query = "insert into ORDERS(odate, username) values('" + date + "', '" + username + "')";

		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		
		int shippingAID = shippingAddress.getAid();
		int billingAID = billingAddress.getAid();
				
		this.addOrderDetails(shoppingCart, shippingAID, billingAID);
	}
	
	public void addOrderDetails(ArrayList<CartBean> shoppingCart, int shippingAID, int billingAID) throws SQLException {
		int lastOID = this.getLastOrderId();
		System.out.println(lastOID);
		for (CartBean cartItem : shoppingCart) {
			this.addSingleOrderDetails(lastOID, cartItem.getBid(), cartItem.getQuantity() ,shippingAID, billingAID);
		}
	}
	
	public void addSingleOrderDetails(int oid, int bid, int quantity,int shippingAID, int billingAID) throws SQLException {
		
		String query = "insert into ORDERDETAILS(oid, bid, quantity, shippingAid, billingAid) values(" + oid + ", " + bid + ", " + quantity + ", " + shippingAID + ", " + billingAID + ")";
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

	public ArrayList<OrderBean> retrieveOrdersByBid(int bid) throws SQLException{
		
		ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
		
		String username;
		String orderDate;
		HashMap<BookBean, Integer> orderedBooks = new HashMap<BookBean, Integer>();
		AddressBean shippingAddress;
		AddressBean billingAddress;
		
		ArrayList<Integer> oidList = this.retrieveOidList(bid);
		
		for (Integer oid : oidList) {
			OrderBean ob = new OrderBean();
			username = this.retrieveUsernameByOid(oid);
			orderDate = this.retrieveDateByOid(oid);
			orderedBooks = this.retrieveBookMapByOid(oid);
			shippingAddress = this.retrieveAddressesByOid(oid).get(0);
			billingAddress = this.retrieveAddressesByOid(oid).get(1);
			ob.setOid(oid);
			ob.setUsername(username);
			ob.setOrderDate(orderDate);
			ob.setOrderedBooks(orderedBooks);
			ob.setShippingAddress(shippingAddress);
			ob.setBillingAddress(billingAddress);
			orderList.add(ob);
		}
		return orderList;
	}
	
	public ArrayList<Integer> retrieveOidList(int bid) throws SQLException{
		String query = "select oid from OrderDetails where bid = " + bid;
		ArrayList<Integer> oidList = new ArrayList<Integer>(); 
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			oidList.add(r.getInt("oid"));	
		}
		p.close();
		con.close();
		r.close();
		return oidList;
	}
	
	public String retrieveUsernameByOid(int oid) throws SQLException{
		String query = "select username from orders where oid = " + oid;
		String username = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()){
			username = (r.getString("username"));	
		}
		p.close();
		con.close();
		r.close();
		return username;
	}
	
	public String retrieveDateByOid (int oid) throws SQLException{
		String query = "select odate from orders where oid = " + oid;
		String date = null;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		if (r.next()){
			date = (r.getString("odate"));	
		}
		p.close();
		con.close();
		r.close();
		return date;
	}
	
	public HashMap<BookBean, Integer> retrieveBookMapByOid (int oid) throws SQLException{
		String query = "select bid, quantity from orderdetails where oid = " + oid;
		
		HashMap<BookBean, Integer> orderedBooks = new HashMap<BookBean, Integer>();
		DatabaseOperator databaseOperator = new DatabaseOperator();
		
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while (r.next()){
			orderedBooks.put(databaseOperator.retrieveBook(r.getInt("bid")), r.getInt("quantity"));
		}
		p.close();
		con.close();
		r.close();
		return orderedBooks;
	}
	
	public ArrayList<AddressBean> retrieveAddressesByOid (int oid) throws SQLException{
		String query = "select shippingAid, billingAid from orderdetails where oid = " + oid;
		ArrayList<AddressBean> addresses = new ArrayList<AddressBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		DatabaseOperator databaseOperator = new DatabaseOperator();
		
		if (r.next()){
			addresses.add(databaseOperator.retrieveAddressByAid(r.getInt("shippingAid")));
			addresses.add(databaseOperator.retrieveAddressByAid(r.getInt("billingAid")));
		}
		p.close();
		con.close();
		r.close();
		return addresses;
	}
	
	public ArrayList<OrderBean> retrieveOrdersByMonth(int month) throws SQLException{
		String query = "select oid from Orders where MONTH(odate) = " + month;
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();
		
		String username;
		String orderDate;
		HashMap<BookBean, Integer> orderedBooks = new HashMap<BookBean, Integer>();
		AddressBean shippingAddress;
		AddressBean billingAddress;
	
		ArrayList <Integer> oidList = new ArrayList<Integer>();
		while(r.next()) {
			oidList.add(r.getInt("oid"));
		}
		p.close();
		con.close();
		r.close();
		
		for (Integer oid : oidList) {
			OrderBean ob = new OrderBean();
			username = this.retrieveUsernameByOid(oid);
			orderDate = this.retrieveDateByOid(oid);
			orderedBooks = this.retrieveBookMapByOid(oid);
			shippingAddress = this.retrieveAddressesByOid(oid).get(0);
			billingAddress = this.retrieveAddressesByOid(oid).get(1);
			ob.setOid(oid);
			ob.setUsername(username);
			ob.setOrderDate(orderDate);
			ob.setOrderedBooks(orderedBooks);
			ob.setShippingAddress(shippingAddress);
			ob.setBillingAddress(billingAddress);
			orderList.add(ob);
		}
		return orderList;
	}
	
	/* for analytics top 10.
	 * I need to fix the query.
	 * Right now it returns books but its not in order and
	 * im not sure if it is returning the correct top ten.*/
	public ArrayList<BookBean> getTop10() throws SQLException, ClassNotFoundException{
		
		ArrayList<BookBean> abb= new ArrayList<BookBean>(); 
		String query = "Select bid, count(bid) as Nbid from OrderDetails group by bid Order by Nbid desc fetch first 10 rows only";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		BookDAO bookDAO = new BookDAO();
		
		while(r.next()) {
			String Nbid = r.getString("Nbid");
			String bid = r.getString("bid");
			BookBean bb = bookDAO.retrieveBook(Integer.parseInt(bid));
			abb.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return abb;
	}
		
	public void printOrderDetails() throws SQLException{
	
		String query = "Select * from orderdetails";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		
		while(r.next()) {
			System.out.println("ODID: " + r.getInt("odid"));
			System.out.println("OID: " + r.getInt("oid"));
			System.out.println("BID: " + r.getInt("bid"));
			System.out.println("shippingAid: " + r.getInt("shippingAid"));
			System.out.println("billingAid: " + r.getInt("billingAid"));
		}
		p.close();
		con.close();
		r.close();	
	}
	
}


















