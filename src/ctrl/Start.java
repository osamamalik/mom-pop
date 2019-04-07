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
@WebServlet({"/Start", "/Start/*"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean loggedIn;
	boolean adminLoggedIn;
	boolean activeSearch;
	boolean activeFilter;
	
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
		adminLoggedIn = Boolean.parseBoolean(this.getServletContext().getInitParameter("adminLoggedIn"));
		activeSearch = Boolean.parseBoolean(this.getServletContext().getInitParameter("activeSearch"));
		activeFilter = Boolean.parseBoolean(this.getServletContext().getInitParameter("activeFilter"));

		target = "/Home.jspx";
		error = false;
		books = new ArrayList<BookBean>();
		
		try {
			context.setAttribute("myModel", new Model());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			context.setAttribute("query", new QueryConstructor());
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
			INITIALIZATION OF MODEL AND QUERY
		 ****************************************************************/
		Model myModel = (Model) this.getServletContext().getAttribute("myModel");
		QueryConstructor query = (QueryConstructor) this.getServletContext().getAttribute("query");
		request.getSession().setAttribute("query", query);
		
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
		
		if (request.getParameter("addReviewButton") != null) {
			this.addReview(request, response, myModel);
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
			PRODUCT CATALOG SERVICES
		 ****************************************************************/
		if (request.getParameter("PCSGenerateButton") != null) {
			this.CatalogService(request, response, myModel);
		}
		
		
		/***************************************************************
			SHOPPING SERVICES
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
		
		
		
		System.out.println(target);

		
		
		
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
	
	protected void redirector(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
						
		//checks if a 'Single Book' has been clicked on
		if (request.getParameter("title") != null) {
			target = "/SingleBook.jspx";
		}
		//once a review has been submitted, the page is reloaded
		if (request.getParameter("addReviewButton") != null) {
			target = "/SingleBook.jspx";
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
				
		//checks if services access is requested
		//checks if user is logged in as admin
		if (request.getParameter("servicesButton") != null) {
			if (request.getSession().getAttribute("loggedInUser").equals(null) || !request.getSession().getAttribute("loggedInUser").equals("admin")) {
				target = "/Login.jspx";
			}
			else if (!request.getSession().getAttribute("loggedInUser").equals(null) && request.getSession().getAttribute("loggedInUser").equals("admin")){
				target = "/Services.jspx";
				System.out.println("AUUUUUUUU");
			}		
		}
		
		//checks if analytics access is requested
		//checks if user is logged in as admin
		if (request.getParameter("analyticsButton") != null) {
			if (request.getSession().getAttribute("loggedInUser").equals(null) || !request.getSession().getAttribute("loggedInUser").equals("admin")) {
				target = "/Login.jspx";
			}
			else if (!request.getSession().getAttribute("loggedInUser").equals(null) && request.getSession().getAttribute("loggedInUser").equals("admin")){
				target = "/Analytics.jspx";
			}		
		}
				
		if (request.getParameter("addToCart") != null) {
			target = "/ShoppingCart.jspx";
		}
		
		//checks if PCS was requested
		if (request.getParameter("PCSRequestButton") != null) {
			target = "/ProductCatalogService.jspx";	
		}
		
		//checks if 'Home' button was pressed, sets target to the Sign Up page if true
		if (request.getParameter("homeButton") != null) {
			if (adminLoggedIn) {
				adminLoggedIn = false;
				loggedIn = false;
				request.getSession().setAttribute("loggedInSession", loggedIn);				
			}
			target = "/Home.jspx";
		}
		
	}
		
	protected void logIn(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {

		this.activeSearch = false;
		this.activeFilter = false;
		
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPassword"); 
		
		// Sets errors, if any
		myModel.checkLoginError(username, password);
		
		// No errors, user is successfully logged in
		if (!myModel.getErrorStatus()) {		
			loggedIn = true;
			request.getSession().setAttribute("loggedInSession", loggedIn);
			request.getSession().setAttribute("loggedInUser", username);
			
			if (request.getSession().getAttribute("loggedInUser").equals("admin")) {
				this.adminLoggedIn = true;
				this.target = "/Admin.jspx";
			}else {
				this.target = "/Home.jspx";
			}			
		}
		
		else {
			String loginErrorMessage = myModel.getErrorMessage();
			error = true;
			this.target = "/Login.jspx";
			request.setAttribute("error", loginErrorMessage);
		}
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		
		this.activeSearch = false;
		this.activeFilter = false;
		
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
		
		this.activeSearch = false;
		this.activeFilter = false;
		
		loggedIn = false;
		request.getSession().setAttribute("loggedInSession", loggedIn);
	}
	

	protected void listAllBooks(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		
		this.activeSearch = false;
		this.activeFilter = false;

		query = "select * from BOOKS";
		request.getSession().setAttribute("query", query);
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);
	}
	
	protected void listBooksByCategory(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		
		this.activeSearch = false;
		this.activeFilter = false;
		
		String category = request.getParameter("headerCategory");
				
		query = "select * from BOOKS where category = '" + category + "'";
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
		
		this.activeSearch = true;
		
		//obtains the searched term
		String searchTerm = request.getParameter("searchBar").toUpperCase();
		
		query = "select * from BOOKS where UPPER(title) like '%" + searchTerm + "%' or UPPER(author) like '%" + searchTerm + "%' or UPPER(category) like '%" + searchTerm + "%'";
		request.getSession().setAttribute("query", query);
		
		//does a store-wide search by with the retrieveBySearch query
		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);	
	}
	
	protected void filter(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {		
			
		ArrayList<String> filterQueryList = new ArrayList<String>();
		Boolean filterSelected = false;
		
		// saves the state of the session query without any filters applied to it
		if (!activeFilter) {
			request.getSession().setAttribute("rawQuery", query);
		}
		
		query = (String) request.getSession().getAttribute("query");
		
		// checks if any filters were selected, if so, adds either 'and' or 'where' to the end of the existing query
		if (request.getParameter("categoryFilter") != null || request.getParameter("reviewFilter") != null || !request.getParameter("priceLowFilter").equals("") || !request.getParameter("priceHighFilter").equals("")) {
			filterSelected = true;
		}	
		
		// checks if a filter was selected
		if (filterSelected) {
			
			// obtains the selected category filter
			if (request.getParameter("categoryFilter") != null) {	
				String categoryFilter = request.getParameter("categoryFilter");
				String categoryFilterQuery = "category = '" + categoryFilter + "'";
				filterQueryList.add(categoryFilterQuery);
			}

			// obtains the selected review filter
			if (request.getParameter("reviewFilter") != null) {
			
				String reviewFilter = request.getParameter("reviewFilter");
				String reviewFilterQuery;
				
				if (reviewFilter.equals("above1")) {
					reviewFilterQuery = "review >= 1";
				}
				else if (reviewFilter.equals("above2")) {
					reviewFilterQuery = "review >= 2";
				}
				else if (reviewFilter.equals("above3")) {
					reviewFilterQuery = "review >= 3";
				}			
				else {
					reviewFilterQuery = "review >= 4";
				}
				filterQueryList.add(reviewFilterQuery);
			}
			
			// obtains the selected price range filter
			if (!request.getParameter("priceLowFilter").equals("") || !request.getParameter("priceHighFilter").equals("")) {
				
				String priceFilterQuery;	
				double priceLowFilter;
				double priceHighFilter;
				
				if (!request.getParameter("priceLowFilter").equals("") && !request.getParameter("priceHighFilter").equals("")) {
					priceLowFilter = Double.parseDouble(request.getParameter("priceLowFilter"));
					priceHighFilter = Double.parseDouble(request.getParameter("priceHighFilter"));
					priceFilterQuery = "price >= '" + priceLowFilter + "' and price <= '" + priceHighFilter + "'";
					System.out.println("HITS HERE");
				}
				else if (!request.getParameter("priceLowFilter").equals("") && request.getParameter("priceHighFilter").equals("")) {
					priceLowFilter = Double.parseDouble(request.getParameter("priceLowFilter"));
					priceFilterQuery = "price >= '" + priceLowFilter + "'";

				}
				else{
					priceHighFilter = Double.parseDouble(request.getParameter("priceHighFilter"));
					priceFilterQuery = "price <= '" + priceHighFilter + "'";
				}
				filterQueryList.add(priceFilterQuery);
			}
			
			
			if (activeFilter) {
				query = (String) request.getSession().getAttribute("rawQuery");
			}
			
			// if the session query already contains a 'where' clause, appends it with 'and'
			if (query.contains("where")) {
				query += " and ";
			}
			// if the session query does not contain a 'where' clause, appends it with 'where'
			else {
				query += " where ";
			}
			
			// if multiple filters were selected, adds 'and' terms in between
			if (filterQueryList.size() > 1) {
				int index = 1;
				while (index <= filterQueryList.size() - 1) {
					filterQueryList.add(index, " and ");
					index += 2;
				}
			}
			
			// iteratively adds the filterQuery items to the end of session query
			for (int i = 0; i < filterQueryList.size(); i++) {
				query += filterQueryList.get(i);
			}
			
			request.getSession().setAttribute("query", query);
			
			this.activeFilter = true;
					
		}
			

		System.out.println("ACTIVE FILTER: " + activeFilter);

		books = myModel.retrieveByQuery(query);
		request.setAttribute("booksMap", books);
	}

	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response, Model myModel, String bid)throws ServletException, IOException, SQLException {
		
		Object b =  request.getSession().getAttribute("loggedInSession");
		
		boolean flag = (Boolean) b;
		System.out.println(flag);
		
		if(flag == true) {
			
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
	
	protected void openBook(HttpServletRequest request, HttpServletResponse response, Model myModel, String bookID) throws ServletException, IOException {
		BookBean singleBook = myModel.retrieveBook(bookID);
		request.setAttribute("singleBook", singleBook);
		
		// Retrieve user review for book if it exists, otherwise give option to add review:
		if (request.getSession().getAttribute("loggedInUser") != null) {
			String username = request.getSession().getAttribute("loggedInUser").toString();
			ArrayList<String> review = myModel.retrieveReviewByUsernameAndBook(username, Integer.parseInt(bookID));
			if (!review.isEmpty()) {
				request.setAttribute("userReviewExists", true);
				request.setAttribute("userReview", review.get(0));
				request.setAttribute("userRating", review.get(1));
			}
			else {
				request.setAttribute("userReviewExists", false);
				request.setAttribute("userReview", null);
				request.setAttribute("userRating", null);
			}
		}
	}
	
	protected void addReview(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		String username = request.getSession().getAttribute("loggedInUser").toString();
		int bookID = Integer.parseInt(request.getParameter("title"));
		String review = request.getParameter("review");
		int rating = Integer.parseInt(request.getParameter("rating"));
		myModel.addReview(username, bookID, review, rating);
		openBook(request, response, myModel, request.getParameter("title"));
	}
	
	protected void CatalogService(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException{
		
		String bid = request.getParameter("bid");
		String f = "xmlExports/" + request.getSession().getId()+".xml";
		String filename = this.getServletContext().getRealPath("/" + f);
		request.getSession().setAttribute("filenameProductService", filename);
		request.setAttribute("fProductService", f);
		System.out.println(filename);
		try {
			myModel.exportProductServices(bid, filename);
			request.setAttribute("PCSResultReady", true);
			target = "ProductCatalogService.jspx";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
