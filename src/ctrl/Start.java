package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import bean.*;


/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean loggedIn;
	String target;
	String query;
	boolean error;
	ArrayList <BookBean>books;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Start() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context = getServletContext();
		loggedIn = Boolean.parseBoolean(this.getServletContext().getInitParameter("loggedIn"));
		target = "/Home.jspx";
		error = false;
		books = new ArrayList<BookBean>();
		try {
			context.setAttribute("myModel", new Model());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/***************************************************************
			INITIALIZATION OF MODEL
		 ****************************************************************/
		Model myModel = (Model) this.getServletContext().getAttribute("myModel");

		/***************************************************************
			PAGE REDIRECTIONS
		 ****************************************************************/
		this.redirector(request, response, myModel);
		
		/***************************************************************
			SIGN UP
		 ****************************************************************/
		if (request.getParameter("signUpButton") != null) {
			this.signUp(request, response, myModel);
		}
		
		/***************************************************************
			LOGIN
		****************************************************************/
		if (request.getParameter("loginButton") != null) {
			this.logIn(request, response, myModel);
		}
		
		/***************************************************************
			SIGN OUT
	    ****************************************************************/
		if (request.getParameter("signoutButton") != null) {
			this.signOut(request, response);
		}
		
		/***************************************************************
			BOOK LISTINGS
		****************************************************************/
		
		// Calls method for listing all books
		if (request.getParameter("booksPageButton") != null) {
			this.listAllBooks(request, response, myModel);
		}
		
		// Calls method for listing books by category
		if (request.getParameter("headerCategory") != null) {
			this.listBooksByCategory(request, response, myModel);
		}
		
		/***************************************************************
			BOOK SORTINGS
		****************************************************************/
		if (request.getParameter("sortButton") != null) {
			this.sortBooks(request, response, myModel);	
		}
		
		/***************************************************************
			SINGLE BOOK PAGE
		****************************************************************/
		if (request.getParameter("title") != null ) {
			this.openBook(request, response, myModel, request.getParameter("title"));
		}
		
		/***************************************************************
			FILTER
		****************************************************************/
		if (request.getParameter("filterButton") != null) {
			this.filter(request, response, myModel);
		}
		
		/***************************************************************
			SEARCH BAR
		****************************************************************/
		if (request.getParameter("searchButton") != null) {
			this.searchStore(request, response, myModel);
		}
		
		/***************************************************************
					Product Catalog Services
		 ****************************************************************/
		if (request.getParameter("PCSbutton") != null) {
			this.CatalogService(request, response, myModel);
		}
		
		
		/***************************************************************
						Shopping Cart 
		 ****************************************************************/
		if (request.getParameter("addToCart") != null) {
			String bid = request.getParameter("title");
			try {
				this.addToCart(request, response, myModel, bid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		/***************************************************************
			TESTING BLOCK
		 ****************************************************************/
		
		
		
		
		
		
		
		/***************************************************************
			TESTING BLOCK
		****************************************************************/
		
		request.getRequestDispatcher(target).forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void logIn(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {

		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPassword"); 
		
		// Sets errors, if any
		myModel.checkLoginError(username, password);

		if (!myModel.getErrorStatus()) {		// No errors, user is successfully logged in
			loggedIn = true;
			request.getSession().setAttribute("loggedInSession", (Boolean)loggedIn);
			request.getSession().setAttribute("loggedInUser", username);
			this.target = "/Home.jspx";

		}
		else {
			String loginErrorMessage = myModel.getErrorMessage();
			error = true;
			target = "/Login.jspx";
			request.setAttribute("error", loginErrorMessage);
		}
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		String username = request.getParameter("signUpName");
		String email = request.getParameter("signUpEmail");
		String password = request.getParameter("signUpPassword"); 
		String passwordConf = request.getParameter("signUpPasswordConf"); 

		// Sets errors, if any
		myModel.checkSignUpError(username, email, password, passwordConf);
		if (!myModel.getErrorStatus()) {
			myModel.addUser(username, email, password);
			loggedIn = true;
			request.getSession().setAttribute("loggedInSession", loggedIn);
			request.getSession().setAttribute("loggedInUser", username);
			this.target = "/Home.jspx";

		}else {
			String signUpErrorMessage = myModel.getErrorMessage();
			error = true;
			target = "/SignUp.jspx";
			request.setAttribute("error", signUpErrorMessage);
		}
	}
	
	protected void signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loggedIn = false;
		request.getSession().setAttribute("loggedInSession", loggedIn);
	}
	
	protected void redirector(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		// checks if a 'Single Book' has been clicked on
		if (request.getParameter("title") != null) {
			target = "/SingleBook.jspx";
		}
		//checks if 'Home' button was pressed, sets target to the Sign Up page if true
		if (request.getParameter("homeButton") != null) {
			target = "/Home.jspx";
		}
		//checks if 'Sign Up' button was pressed, sets target to the Sign Up page if true
		if (request.getParameter("signUpPageButton") != null) {
			target = "/SignUp.jspx";
		}
		//checks if 'Login' button was pressed, sets target to the Login page if true
		if (request.getParameter("loginPageButton") != null) {
			target = "/Login.jspx";
		}
		//checks if 'List Books', 'Sort', or a search was submitted, sets target to the Login page if true
		if (request.getParameter("booksPageButton") != null || (request.getParameter("searchButton") != null) || (request.getParameter("sortButton") != null) || (request.getParameter("filterButton") != null) || (request.getParameter("headerCategory") != null)) {
			target = "/Books.jspx";
			//Retrieves unique categories and sets the filter display
			ArrayList <String>categories = new ArrayList<String>();
			categories = myModel.retrieveUniqueCategories();
			request.setAttribute("categoriesFilterList", categories);
		}
		
		if (request.getParameter("ProductCatalogServices") != null) {
			target = "/ProductCatalogService.jspx";
		}
	
		if (request.getParameter("PCSbutton") != null){
			target = "/DonePCS.jspx";
		}
		if (request.getParameter("addToCart") != null) {
			target = "/ShoppingCart.jspx";
		}
		
	}
	
	protected void openBook(HttpServletRequest request, HttpServletResponse response, Model myModel, String bookID)throws ServletException, IOException {
		BookBean singleBook = myModel.retrieveBook(bookID);
		request.setAttribute("singleBook", singleBook);
	}
	
	protected void listAllBooks(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		query = "select * from BOOKS";
		request.getSession().setAttribute("query", query);
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);
	}
	
	protected void listBooksByCategory(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		String category = request.getParameter("headerCategory");
		
		query = "select * from BOOKS where category like '%" + category + "%'";
		request.getSession().setAttribute("query", query);
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);
	}
	
	protected void sortBooks(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		//obtains the sort option
		String sortOption = request.getParameter("sortOption");
		
		query = (String) request.getSession().getAttribute("query");
		
		if (sortOption.equals("Newest to Oldest")) {
			query += " order by publishYear desc";
		}
		else if (sortOption.equals("Oldest to Newest")) {
			query += " order by publishYear asc";
		}
		else if (sortOption.equals("Review")) {
			query += " order by review desc";
		}
		else if (sortOption.equals("Price - Low to High")) {
			query += " order by price asc";
		}
		else if (sortOption.equals("Price - High to Low")) {
			query += " order by price desc";
		}
		
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);
		
	}
	
	protected void searchStore(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		//obtains the searched term
		String searchTerm = request.getParameter("searchBar").toUpperCase();
		
		query = "select * from BOOKS where UPPER(title) like '%" + searchTerm + "%' or UPPER(author) like '%" + searchTerm + "%' or UPPER(category) like '%" + searchTerm + "%'";
		request.getSession().setAttribute("query", query);
		
		//does a store-wide search by with the retrieveBySearch query
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);	
	}
	
	protected void filter(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {		
		//Sets default query skeleton
		//query = "select * from BOOKS where";
		
		query = (String) request.getSession().getAttribute("query");
		
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);	
	}
	
	
	
	protected void CatalogService(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException{
		ServletContext context = this.getServletContext();
		
		String bid = request.getParameter("bid");
		String f = "export/" + request.getSession().getId()+".xml";
		String filename = context.getRealPath("/" + f);
		request.getSession().setAttribute("filenameProductService", filename);
		request.setAttribute("fProductService", f);
		
		try {
			myModel.exportProductServices(bid, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response, Model myModel, String bid)throws ServletException, IOException, SQLException {
		
		if((Boolean)request.getSession().getAttribute("loggedInSession") == true) {
			
			String user = request.getSession().getAttribute("loggedInUser").toString();
			myModel.addToCart(bid, user);
			ArrayList<BookBean> userCart = new ArrayList<BookBean>();
			userCart = myModel.retrieveCart(user);
			request.getSession().setAttribute("Cart", userCart);
		}
		else {
			System.out.println("must be signed in");
		}
		
		
		
		
	}
}
