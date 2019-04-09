package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.*;
import model.QueryConstructor;

public class BookDAO {
	
	private DataSource ds;
	
	public BookDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BookBean> retrieveAllBooks() throws SQLException {
		String query = "select * from BOOKS";
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public BookBean retrieveBook(int bid) throws SQLException {
		String query = "select * from BOOKS where bid = " + bid;
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
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
		}
		p.close();
		con.close();
		r.close();
		return bb;
	}
	
	public ArrayList<BookBean> retrieveByAuthor(String author) throws SQLException {
		String query = "select * from BOOKS where author like '%" + author + "%'";
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public ArrayList<BookBean> retrieveByTitle(String title) throws SQLException {
		String query = "select * from BOOKS where title like '%" + title + "%'";
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public ArrayList<BookBean> retrieveByCategory(String category) throws SQLException {
		String query = "select * from BOOKS where category like '%" + category + "%'";
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public ArrayList<BookBean> retrieveByPriceRange(double lowerRange, double higherRange) throws SQLException {
		String query = "select * from BOOKS where price >= " + lowerRange + " and price <= " + higherRange;
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	public ArrayList<BookBean> retrieveByRating(double lowerRange) throws SQLException {
		String query = "select * from BOOKS where rating >= " + lowerRange;
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		return books;
		
	}

	public ArrayList<BookBean> retrieveBookByQuery(String query) throws SQLException {
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		
		p.close();
		con.close();
		r.close();
		return books;
	}
	
	
	public ArrayList<String> retrieveUniqueCategories() throws SQLException {
		String query = "select distinct category from BOOKS";
		ArrayList<String> categories = new ArrayList<String>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			categories.add(r.getString("category"));
		}
		p.close();
		con.close();
		r.close();
		return categories;
	}
	
	public ArrayList<String> retrieveReviewByUsernameAndBook(String username, int bookID) throws SQLException {
		String query = "select review, rating from reviews where username = '" + username + "' and bid = " + bookID;
		ArrayList<String> review = new ArrayList<String>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		while(r.next()){
			review.add(r.getString("review"));
			review.add(r.getString("rating").toString());
		}
		p.close();
		con.close();
		r.close();
		return review;
	}
	
	public void addReview(String username, int bookID, String review, int rating) throws SQLException {
		review = review.replace("'","''");
		String query = "INSERT INTO REVIEWS (username, bid, review, rating) VALUES ('" + username + "'," + bookID + ",'" + review + "'," + rating + ")";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
	}
	
	
	//completes a query based on the attributes of the 'query' object passed as a parameter
	public ArrayList<BookBean> constructQuery(QueryConstructor query) throws SQLException {
		
		String constructedQuery = "select * from books";
		ArrayList<BookBean> filterBooks = new ArrayList<BookBean>();
		
		//constructs a query based on the category attribute of the 'query' object
		//note: this is not a filter; this denotes browsing by category
		if (query.getCategory() != null) {
			String category = query.getCategory();
			constructedQuery += " where category like '%" + category + "%'";
		}

		//checks if a search term has been passed to the object, resets the query
		if (query.getSearchTerm() != null) {
			String searchTerm = query.getSearchTerm();
			constructedQuery = "select * from BOOKS where UPPER(title) like '%" + searchTerm + "%' or UPPER(author) like '%" + searchTerm + "%' or UPPER(category) like '%" + searchTerm + "%'";
		}

		//sets the query to all books if user clicked the 'Browse' button
		if (query.isAllBooks()) {
			constructedQuery = "select * from books";
		}
		
		//checks if any filters were added, prepares a bookBean filterBooks that holds the intersection of filters
		if (query.isFilter()) {
			
			ArrayList<BookBean> ratingFilterBooks = new ArrayList<BookBean>();
			ArrayList<BookBean> priceFilterBooks = new ArrayList<BookBean>();
			ArrayList<BookBean> categoryFilterBooks = new ArrayList<BookBean>();
			ArrayList<BookBean> tempBooks = new ArrayList<BookBean>();
			
			//if category filter was chosen, books with this request are obtained
			if (query.getCategoryFilter() != null) {
				categoryFilterBooks = this.retrieveByCategory(query.getCategoryFilter());
			}
			
			// if rating filter was chosen, books with this request are obtained
			if (query.getRatingFilter() != 0) {
				ratingFilterBooks = this.retrieveByRating(query.getRatingFilter());
			}
			
			// if the price filter was chosen, books with this request are obtained
			if (query.getPriceFilterLow() != 0 || query.getPriceFilterHigh() != Double.MAX_VALUE) {
				double priceLowFilter = query.getPriceFilterLow();
				double priceHighFilter = query.getPriceFilterHigh();				
				priceFilterBooks = this.retrieveByPriceRange(priceLowFilter, priceHighFilter);
			}

			//if all filters return books, takes the intersection, stores in filterBooks
			if (!ratingFilterBooks.isEmpty() && !priceFilterBooks.isEmpty() && !categoryFilterBooks.isEmpty()) {
				
				//first takes the intersection of rating and price filters, stores in tempBook
				for (BookBean ratingBook : ratingFilterBooks) {
					for (BookBean priceBook : priceFilterBooks) {
		            	if (ratingBook.getBid() == priceBook.getBid()) {
		            		tempBooks.add(ratingBook);
		            	}
		            }
		        }
				//takes intersection of tempBook with categoryBook
				for (BookBean tempBook : tempBooks) {
					for (BookBean categoryBook : categoryFilterBooks) {
		            	if (tempBook.getBid() == categoryBook.getBid()) {
		            		filterBooks.add(tempBook);
		            	}
		            }
		        }
			}
			
			//if only rating and price filters return books, takes the intersection, stores in filterBooks
			else if (!ratingFilterBooks.isEmpty() && !priceFilterBooks.isEmpty()) {
							
				for (BookBean ratingBook : ratingFilterBooks) {
					for (BookBean priceBook : priceFilterBooks) {
		            	if (ratingBook.getBid() == priceBook.getBid()) {
		            		filterBooks.add(ratingBook);
		            	}
		            }
		        }
			}
			
			//if only price and category filters return books, takes the intersection, stores in filterBooks
			else if (!ratingFilterBooks.isEmpty() && !priceFilterBooks.isEmpty()) {
							
				for (BookBean priceBook : priceFilterBooks) {
					for (BookBean categoryBook : categoryFilterBooks) {
		            	if (priceBook.getBid() == categoryBook.getBid()) {
		            		filterBooks.add(priceBook);
		            	}
		            }
		        }
			}
			
			//if only rating and category filters return books, takes the intersection, stores in filterBooks
			else if (!ratingFilterBooks.isEmpty() && !priceFilterBooks.isEmpty()) {
							
				for (BookBean ratingBook : ratingFilterBooks) {
					for (BookBean categoryBook : categoryFilterBooks) {
		            	if (ratingBook.getBid() == categoryBook.getBid()) {
		            		filterBooks.add(ratingBook);
		            	}
		            }
		        }
			}
			
			//if only rating filter returns books, stores them in ratingOrPriceBooks
			else if(!ratingFilterBooks.isEmpty()){
				filterBooks = ratingFilterBooks;
			}
			
			//if only price filter returns books, stores them in ratingOrPriceBooks
			else if(!priceFilterBooks.isEmpty()){
				filterBooks = priceFilterBooks;
			}
			//if only category filter returns books, stores them in ratingOrPriceBooks
			else if(!priceFilterBooks.isEmpty()){
				filterBooks = categoryFilterBooks;
			}
			
		}
		
				
		//adds the sorting elements to the end of the query if the user has chosen sorting
		if (query.isSort()) {
			
			if (query.isSortNewestToOldest()) {
				constructedQuery += " order by publishYear desc";
			}
			else if (query.isSortOldestToNewest()) {
				constructedQuery += " order by publishYear asc";
			}
			else if (query.isSortReviewHighToLow()) {
				constructedQuery += " order by rating desc";
			}
			else if (query.isSortPriceLowtoHigh()) {
				constructedQuery += " order by price asc";
			}
			else if (query.isSortPriceHighToLow()) {
				constructedQuery += " order by price desc";
			}
		}
		
		
		System.out.println("*********************************************");
		System.out.println(constructedQuery);
		System.out.println("*********************************************");

				
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(constructedQuery);
		ResultSet r = p.executeQuery();
		while(r.next()){
			BookBean bb = new BookBean();
			int bid = (Integer.parseInt(r.getString("bid")));
			bb.setBid(bid);
			bb.setTitle(r.getString("title"));
			bb.setAuthor(r.getString("author"));
			bb.setPrice(Double.parseDouble(r.getString("price")));
			bb.setDescription(r.getString("description"));
			bb.setPublishYear(Integer.parseInt(r.getString("publishYear")));
			bb.setRating(Double.parseDouble(r.getString("rating")));
			bb.setCategory(r.getString("category"));
			bb.setUrl(r.getString("url"));
			books.add(bb);
		}
		p.close();
		con.close();
		r.close();
		
		//checks if a filter was applied, if so, returns the intersection of
		//'book' obtained by query and filterBooks obtained by filter intersections
		if (query.isFilter()) {
			ArrayList<BookBean> result = new ArrayList<BookBean>();
			for (BookBean book : books) {
				for (BookBean filterBook : filterBooks) {
	            	if (book.getBid() == filterBook.getBid()) {
	            		result.add(book);
	            	}
	            }
	        }
			return result;
		}
		else {
			return books;
		}
		
		
		
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}