package model;

import java.io.FileWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import DAO.*;
import bean.*;

public class Model {
	private UserDAO userDAO;
	private BookDAO bookDAO;
	private CartDAO cartDAO;
	private AddressDAO addressDAO;

	private boolean errorStatus;
	private String errorMessage;

	public Model() {

		this.errorStatus = false;
		this.errorMessage = null;

		try {
			userDAO = new UserDAO();
			bookDAO = new BookDAO();
			cartDAO = new CartDAO();
			addressDAO = new AddressDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***************************************************************
		DATABASE USER OPERATIONS
    ****************************************************************/
	
	public UserBean retrieveUser(String username){
		try {
			return userDAO.retrieveUser(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(String username, String firstName, String lastName, String email, String password) {
		try {
			userDAO.addUser(username, firstName, lastName, email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(String username, String newPassword) {
		try {
			userDAO.updatePassword(username, newPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkUserExists(String username){
		try {
			return userDAO.checkUserExists(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/***************************************************************
		DATABASE BOOK OPERATIONS
    ****************************************************************/
	
	public ArrayList<BookBean> retrieveAllBooks(){
		try {
			return bookDAO.retrieveAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public BookBean retrieveBook(int bid){
			try {
				return bookDAO.retrieveBook(bid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public ArrayList<BookBean> retrieveByAuthor(String author){
		try {
			return bookDAO.retrieveByAuthor(author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BookBean> retrieveByTitle(String title){
		try {
			return bookDAO.retrieveByTitle(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BookBean>retrieveByCategory(String category){
		try {
			return bookDAO.retrieveByCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BookBean> retrieveByPriceRange(int lowerRange, int higherRange){
		try {
			return bookDAO.retrieveByPriceRange(lowerRange, higherRange);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<BookBean>retrieveByQuery(String query){
		try {
			return bookDAO.retrieveBookByQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> retrieveUniqueCategories(){
		try {
			return bookDAO.retrieveUniqueCategories();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BookBean> queryConstructor(QueryConstructor query){
		try {
			return bookDAO.constructQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public double getTotalPrice(String username) {
		
		double totalPrice = 0;
		ArrayList<CartBean> shoppingCart = retrieveCart(username);
		
		if (shoppingCart.size() != 0 || shoppingCart != null) {
			for (CartBean cartItem : shoppingCart) {
				totalPrice += cartItem.getPrice() * cartItem.getQuantity();
			}
		}

		
		return totalPrice;
		
	}
	
	/***************************************************************
		DATABASE REVIEW OPERATIONS
    ****************************************************************/

	public ArrayList<String> retrieveReviewByUsernameAndBook(String username, int bookID) {
		try {
			return bookDAO.retrieveReviewByUsernameAndBook(username, bookID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addReview(String username, int bookID, String review, int rating) {
		try {
			bookDAO.addReview(username, bookID, review, rating);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/***************************************************************
		DATABASE SHOPPING CART OPERATIONS
	****************************************************************/

	public void addToCart(int bid, String user) {
		try {
			cartDAO.addToCart(bid, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeFromCart(int bid, String user) {
		try {
			cartDAO.removeFromCart(bid, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateQuantity(int bid, String user, int quantity) {
		try {
			cartDAO.updateQuantity(bid, user, quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<CartBean> retrieveCart(String user) {
		try {
			return cartDAO.retrieveCart(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void clearVisitorCart() {
		try {
			cartDAO.clearVisitorCart();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/***************************************************************
		DATABASE ADDRESS OPERATIONS
	 ****************************************************************/
	public void addAddress(AddressBean ab) {
		try {
			addressDAO.addAddress(ab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AddressBean retrieveAddress(String username, String type) {
		try {
			return addressDAO.retrieveAddress(username, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	/***************************************************************
		SERVICES
	****************************************************************/

	public void exportProductServices(int bid, String filename) throws Exception {

		BookBean bb = retrieveBook(bid);
		String title = bb.getTitle();
		String author = bb.getAuthor();
		double price = bb.getPrice();
		String description = bb.getDescription();
		int publishYear = bb.getPublishYear();
		double rating = bb.getRating();
		String cat = bb.getCategory();

	
		BookWrapper bw = new BookWrapper(bid, title, author, price, description, publishYear, rating, cat);
		
		JAXBContext jc = JAXBContext.newInstance(bw.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

		StringWriter sw = new StringWriter();
		sw.write("\n");
		
		marshaller.marshal(bw, new StreamResult(sw));

		System.out.println(sw.toString()); // for debugging

		FileWriter fw = new FileWriter(filename);
		fw.write(sw.toString());
		fw.close();
		
	}
	
	public void exportOrderServices(int orderID, String filename) throws Exception {

	}
	
	
}












