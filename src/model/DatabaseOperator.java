package model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.*;
import bean.*;

public class DatabaseOperator {
	private UserDAO userDAO;
	private BookDAO bookDAO;
	private CartDAO cartDAO;
	private AddressDAO addressDAO;
	private OrderDAO orderDAO;

	public DatabaseOperator() {

		try {
			userDAO = new UserDAO();
			bookDAO = new BookDAO();
			cartDAO = new CartDAO();
			addressDAO = new AddressDAO();
			orderDAO = new OrderDAO();
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

	public void addToCart(int bid, int quantity, String user) {
		try {
			cartDAO.addToCart(bid, quantity, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addShoppingCart(ArrayList<CartBean> userCart, String user) {
		try {
			cartDAO.addShoppingCart(userCart, user);
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
		DATABASE ORDER OPERATIONS
	****************************************************************/
	
	public int getOrderCount() {
		try {
			return orderDAO.getOrderCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public void addtoOrders(ArrayList<CartBean> shoppingCart) {
		try {
			orderDAO.addtoOrders(shoppingCart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<OrderBean> retrieveOrders(int bid){
		try {
			return orderDAO.retrieveOrders(bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public ArrayList<OrderWrapper> retrieveOrdersByMonth(int month){
		try {
			return orderDAO.retrieveOrdersByMonth(month);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<BookBean> getTop10Orders() throws ClassNotFoundException{
		
		try {
			return orderDAO.getTop10();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}












