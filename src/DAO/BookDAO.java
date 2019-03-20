package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.*;

public class BookDAO {
	
	private DataSource ds;
	
	public BookDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, BookBean> retrieveAllBooks() throws SQLException {
		String query = "select * from BOOKS";
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			String bid = r.getString("bid");
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.put(bid, bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public BookBean retrieveBook(String bid) throws SQLException {
		String query = "select * from BOOKS where bid = '" + bid + "'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		BookBean bb = new BookBean();
		if(r.next()){
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
		}
		p.close();
		con.close();
		r.close();
		return bb;
	}
	
	public Map<String, BookBean> retrieveByAuthor(String author) throws SQLException {
		String query = "select * from BOOKS where author like '%" + author + "%'";
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			String bid = r.getString("bid");
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.put(bid, bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public Map<String, BookBean> retrieveByTitle(String title) throws SQLException {
		String query = "select * from BOOKS where title like '%" + title + "%'";
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			String bid = r.getString("bid");
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.put(bid, bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public Map<String, BookBean> retrieveByCategory(String category) throws SQLException {
		String query = "select * from BOOKS where category like '%" + category + "%'";
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			String bid = r.getString("bid");
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.put(bid, bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public Map<String, BookBean> retrieveByPriceRange(int lowerRange, int higherRange) throws SQLException {
		String query = "select * from BOOKS where price >= " + lowerRange + " and price <= " + higherRange;
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			String bid = r.getString("bid");
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setReview(Double.parseDouble(r.getString("review")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.put(bid, bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
		
}