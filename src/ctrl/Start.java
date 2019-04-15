package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.*;
import bean.*;


/**
 * Servlet implementation class Start
 */
@Path("service") 
@WebServlet({"/Start", "/Start/*"})
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean loggedIn;
	boolean adminLoggedIn;
	boolean error;
	int orderCount;
	String target;
	String redirectedTarget;
	ArrayList <BookBean> books;
	ArrayList <CartBean> cart;
	
	
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
		
		target = "/Home.jspx";
		redirectedTarget = "/Books.jspx";
		error = false;
		books = new ArrayList<BookBean>();
		cart = new ArrayList<CartBean>();
		DatabaseOperator databaseOperator = new DatabaseOperator();
		databaseOperator.clearVisitorCart();
		orderCount = databaseOperator.getOrderCount();

		try {
			context.setAttribute("databaseOperator", new DatabaseOperator());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			context.setAttribute("services", new Services());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			context.setAttribute("errorChecking", new ErrorChecking());
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
			INITIALIZATION OF MODEL CLASSES
		 ****************************************************************/
		DatabaseOperator databaseOperator = (DatabaseOperator) this.getServletContext().getAttribute("databaseOperator");
		Services services = (Services) this.getServletContext().getAttribute("services");
		ErrorChecking errorChecking = (ErrorChecking) this.getServletContext().getAttribute("errorChecking");
		QueryConstructor queryObject = (QueryConstructor) this.getServletContext().getAttribute("query");
		request.getSession().setAttribute("query", queryObject);
		
		/***************************************************************
			PAGE REDIRECTIONS
		 ****************************************************************/
		this.redirector(request, response, databaseOperator, queryObject);
		
		/***************************************************************
			SIGN UP
		 ****************************************************************/
		if (request.getParameter("signUpButton") != null) {
			this.signUp(request, response, databaseOperator, errorChecking, queryObject);
		}
		
		/***************************************************************
			LOGIN
		****************************************************************/
		if (request.getParameter("loginButton") != null) {
			String username = request.getParameter("loginName");
			String password = request.getParameter("loginPassword"); 
			this.logIn(request, response, databaseOperator, errorChecking, username, password, queryObject);
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
			this.listAllBooks(request, response, databaseOperator, queryObject);
		}
		
		// Calls method for listing books by category
		if (request.getParameter("headerCategory") != null) {
			this.listBooksByCategory(request, response, databaseOperator, queryObject);
		}
		
		/***************************************************************
			BOOK SORTINGS
		****************************************************************/
		if (request.getParameter("sortButton") != null) {
			this.sortBooks(request, response, databaseOperator, queryObject);	
		}
		
		/***************************************************************
			FILTER
		****************************************************************/
		if (request.getParameter("filterButton") != null || request.getParameter("resetFilterButton") != null ) {
			this.filter(request, response, databaseOperator, queryObject);
		}
	
		/***************************************************************
			SINGLE BOOK PAGE
		****************************************************************/
		if (request.getParameter("viewSingleBook") != null) {
			int title = (Integer.parseInt(request.getParameter("viewSingleBook")));
			request.getSession().setAttribute("title", title);
			this.openBook(request, response, databaseOperator, title);
		}
		
		if (request.getParameter("addReviewButton") != null) {
			this.addReview(request, response, databaseOperator, errorChecking);
		}
		
		/***************************************************************
			SEARCH BAR
		****************************************************************/
		if (request.getParameter("searchButton") != null) {
			this.searchStore(request, response, databaseOperator, queryObject);
		}
		
		/***************************************************************
			SHOW SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("showShoppingCart") != null) {
			this.showCart(request, response, databaseOperator);
		}
		
		/***************************************************************
			ADD TO SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("addToCart") != null) {
			this.addToCart(request, response, databaseOperator);
		}
		
		
		/***************************************************************
			REMOVE FROM SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("removeItem") != null) {
			this.removeFromCart(request, response, databaseOperator);
		}
		
		/***************************************************************
			UPDATE SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("updateCart") != null) {
			this.updateCart(request, response, databaseOperator);
		}
		
		/***************************************************************
			PAYMENT
		****************************************************************/
		if (request.getParameter("placeOrder") != null) {
			this.payment(request, response, databaseOperator, errorChecking);
		}
		
		/***************************************************************
			PRODUCT CATALOG SERVICES
		 ****************************************************************/
		if (request.getParameter("PCSGenerateButton") != null) {
			this.productCatalogService(request, response, databaseOperator, errorChecking, services);
		}
		
		/***************************************************************
			ORDER PROCESSING SERVICES
		 ****************************************************************/
		if (request.getParameter("OPSGenerateButton") != null) {
			this.orderProcessingService(request, response, databaseOperator, errorChecking, services);
		}
		
		/***************************************************************
			ANALYTICS
		 ****************************************************************/
		if (request.getParameter("WhichMonth") != null) {
			this.ordersByMonth(request, response, databaseOperator, errorChecking);
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
	
	protected void redirector(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {
						
		//checks if a 'Single Book' has been clicked on
		if (request.getParameter("viewSingleBook") != null) {
			target = "/SingleBook.jspx";
		}
		//once a review has been submitted, the page is reloaded
		else if (request.getParameter("addReviewButton") != null) {
			target = "/SingleBook.jspx";
		}

		//checks if 'Sign Up' button was pressed, sets target to the Sign Up page if true
		else if (request.getParameter("signUpPageButton") != null) {
			request.setAttribute("differentAddressTypes", true);
			target = "/SignUp.jspx";
		}
		//checks if 'Login' button was pressed, sets target to the Login page if true
		else if (request.getParameter("loginPageButton") != null) {
			target = "/Login.jspx";
		}
		//checks if 'List Books', 'Sort', or a search was submitted, sets target to the Login page if true
		else if (request.getParameter("booksPageButton") != null || (request.getParameter("searchButton") != null) || (request.getParameter("sortButton") != null) || (request.getParameter("filterButton") != null) || (request.getParameter("headerCategory") != null)) {
			target = "/Books.jspx";
			//Retrieves unique categories and sets the filter display
			ArrayList <String>categories = new ArrayList<String>();
			categories = databaseOperator.retrieveUniqueCategories();
			request.setAttribute("categoriesFilterList", categories);
		}
					
		//checks if 'Home' button was pressed, sets target to the Sign Up page if true
		 if (request.getParameter("homeButton") != null) {
			if (adminLoggedIn) {
				adminLoggedIn = false;
				loggedIn = false;
				queryObject.reset();
				queryObject.resetFilter();
				queryObject.resetSort();
				request.getSession().setAttribute("loggedInSession", loggedIn);				
			}
			target = "/Home.jspx";
		}
		
		//checks if Shopping Cart was requested
		else if (request.getParameter("showShoppingCart") != null) {
			target = "/ShoppingCart.jspx";	
		}
		
		//checks if Checkout was requested
		else if (request.getParameter("checkoutButton") != null) {
			if (!loggedIn) {
				this.redirectedTarget = "/Payment.jspx";
				this.target = "/Login.jspx";
			}
			else {
				this.target = "/Payment.jspx";
			}
		}
		 
		//checks if services access is requested
		//checks if user is logged in as admin
		else if (request.getParameter("servicesButton") != null) {
			if (!adminLoggedIn) {
				target = "/Login.jspx";
			}
			else if (adminLoggedIn){
				target = "/Services.jspx";
			}		
		}
		
		//checks if analytics access is requested
		//checks if user is logged in as admin
		else if (request.getParameter("analyticsButton") != null) {
			if (!adminLoggedIn) {
				target = "/Login.jspx";
			}
			else if (adminLoggedIn){
				target = "/Analytics.jspx";
			}		
		}
				
		//checks if PCS was requested
		if (request.getParameter("PCSRequestButton") != null) {
			target = "/ProductCatalogService.jspx";	
		}
		
		//checks if OPS was requested
		if (request.getParameter("OPSRequestButton") != null) {
			target = "/OrderProcessingService.jspx";	
		}
		
		//checks if monthly orders were requested
		if (request.getParameter("OrdersByMonth") != null) {
			target = "/OrdersByMonth.jspx";	
		}
		
		//checks if top10 orders were requested
		if(request.getParameter("top10") != null) {
			target = "/Top10.jspx";	
		}
	}
		
	protected void logIn(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking, String username, String password, QueryConstructor queryObject) throws ServletException, IOException {
		
		// Sets errors, if any
		errorChecking.checkLoginError(username, password);
		
		// No errors, user is successfully logged in
		if (!errorChecking.getErrorStatus()) {		
			loggedIn = true;
			request.getSession().setAttribute("loggedInSession", loggedIn);
			request.getSession().setAttribute("loggedInUser", username);
			
			//if admin logs in, redirects to the admin page
			if (request.getSession().getAttribute("loggedInUser").equals("admin")) {
				this.adminLoggedIn = true;
				this.target = "/Admin.jspx";
			}else {
				this.target = redirectedTarget;
				this.redirectedTarget = "/Books.jspx";
				this.listAllBooks(request, response, databaseOperator, queryObject);
			}		
			
			//clears the 'visitor' shopping cart
			databaseOperator.clearVisitorCart();
			
			//sets the user's cart
			this.setCart(request, response, databaseOperator, username);
			
			//sets the user's address information
			this.setAddress(request, response, databaseOperator, username);
		}
		
		else {
			String loginErrorMessage = errorChecking.getErrorMessage();
			error = true;
			this.target = "/Login.jspx";
			request.setAttribute("error", loginErrorMessage);
		}
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking, QueryConstructor queryObject) throws ServletException, IOException {
		
		String firstName = request.getParameter("signUpFirstName");
		String lastName = request.getParameter("signUpLastName");
		String username = request.getParameter("signUpUsername");
		String email = request.getParameter("signUpEmail");
		String password = request.getParameter("signUpPassword");
		String passwordConf = request.getParameter("signUpPasswordConf");
		
		AddressBean shippingAB = new AddressBean();
		AddressBean billingAB = new AddressBean();
		shippingAB.setType("shipping");
		shippingAB.setUsername(username);
		shippingAB.setAddressLine1(request.getParameter("shippingLine1"));
		shippingAB.setAddressLine2(request.getParameter("shippingLine2"));
		shippingAB.setCountry(request.getParameter("shippingCountry"));
		shippingAB.setProvince(request.getParameter("shippingProvince"));
		shippingAB.setCity(request.getParameter("shippingCity"));
		shippingAB.setZip(request.getParameter("shippingZip"));
		shippingAB.setPhoneNumber(request.getParameter("addressPhone"));
		
		if (request.getParameter("sameTypesCheckbox") != null) {
			billingAB.setType("billing");
			billingAB.setUsername(username);
			billingAB.setAddressLine1(shippingAB.getAddressLine1());
			billingAB.setAddressLine2(shippingAB.getAddressLine2());
			billingAB.setCountry(shippingAB.getCountry());
			billingAB.setProvince(shippingAB.getProvince());
			billingAB.setCity(shippingAB.getCity());
			billingAB.setZip(shippingAB.getZip());
			billingAB.setPhoneNumber(shippingAB.getPhoneNumber());
			errorChecking.checkSignUpError(username, email, password, passwordConf, shippingAB, shippingAB);
		}
		else {
			billingAB.setType("billing");
			billingAB.setUsername(username);
			billingAB.setAddressLine1(request.getParameter("billingLine1"));
			billingAB.setAddressLine2(request.getParameter("billingLine2"));
			billingAB.setCountry(request.getParameter("billingCountry"));
			billingAB.setProvince(request.getParameter("billingProvince"));
			billingAB.setCity(request.getParameter("billingCity"));
			billingAB.setZip(request.getParameter("billingZip"));
			billingAB.setPhoneNumber(request.getParameter("billingPhone"));
			errorChecking.checkSignUpError(username, email, password, passwordConf, shippingAB, billingAB);
		}
		
		//Sets errors, if any
		if (!errorChecking.getErrorStatus()) {
			databaseOperator.addUser(username, firstName, lastName, email, password);
			databaseOperator.addAddress(shippingAB);
			databaseOperator.addAddress(billingAB);
			
			//checks if there are items in the visitor shopping cart
			//if so, adds these items to the database for the newly created user
			ArrayList<CartBean> shoppingCart = (ArrayList<CartBean>) request.getSession().getAttribute("cart");
			
			for (CartBean cartItem : shoppingCart) {
				cartItem.setUsername(username);
			}

			databaseOperator.addShoppingCart(shoppingCart, username);
			
			this.logIn(request, response, databaseOperator, errorChecking, username, password, queryObject);
			
			this.target = redirectedTarget;
			this.redirectedTarget = "/Books.jspx";

		}else {
			
			String signUpErrorMessage = errorChecking.getErrorMessage();
			error = true;
			target = "/SignUp.jspx";
			request.setAttribute("error", signUpErrorMessage);
		}
	}
	
	protected void signOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		loggedIn = false;
		request.getSession().setAttribute("loggedInSession", loggedIn);
		request.getSession().setAttribute("loggedInUser", null);
		request.getSession().setAttribute("cart", null);
		request.getSession().setAttribute("totalPrice", null);
	}
	

	protected void listAllBooks(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {
	
		queryObject.setCategory(null);
		queryObject.setSearchTerm(null);
		queryObject.resetFilter();
		
		queryObject.setAllBooks(true);
		books = databaseOperator.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
	}
	
	protected void listBooksByCategory(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {
		
		queryObject.setAllBooks(false);
		queryObject.setSearchTerm(null);
		
		String category = request.getParameter("headerCategory");
		queryObject.setCategory(category);
		books = databaseOperator.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
		
	}
	
	protected void sortBooks(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {
		
		//obtains the sort option
		String sortOption = request.getParameter("sortOption");
		queryObject.resetSort();

		queryObject.setSort(true);

		if (sortOption.equals("Newest to Oldest")) {
			queryObject.setSortNewestToOldest(true);
		}
		else if (sortOption.equals("Oldest to Newest")) {
			queryObject.setSortOldestToNewest(true);
		}
		else if (sortOption.equals("Rating")) {
			queryObject.setSortReviewHighToLow(true);
		}
		else if (sortOption.equals("Price - Low to High")) {
			queryObject.setSortPriceLowtoHigh(true);
		}
		else if (sortOption.equals("Price - High to Low")) {
			queryObject.setSortPriceHighToLow(true);
		}
		
		books = databaseOperator.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
		
	}
	
	protected void searchStore(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {
		
		queryObject.setAllBooks(false);
		queryObject.setCategory(null);

		//obtains the searched term
		String searchTerm = request.getParameter("searchBar").toUpperCase();
		
		queryObject.setSearchTerm(searchTerm);
			
		books = databaseOperator.queryConstructor(queryObject);
		request.setAttribute("booksList", books);	
	}
	
	protected void filter(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, QueryConstructor queryObject) throws ServletException, IOException {		
		
		//if user chose to reset the filter, queryObject's filter attributes are reset
		//if not, queryObject's filter attributes are initialized
		if (request.getParameter("resetFilterButton") != null) {
			queryObject.resetFilter();
			books = databaseOperator.queryConstructor(queryObject);
			request.setAttribute("booksList", books);		
			
			//Retrieves unique categories and sets the filter display
			ArrayList <String>categories = new ArrayList<String>();
			categories = databaseOperator.retrieveUniqueCategories();
			request.setAttribute("categoriesFilterList", categories);
		}
		else {
		
			// checks if any filters were selected
			if (request.getParameter("categoryFilter") != null || request.getParameter("ratingFilter") != null || !request.getParameter("priceLowFilter").equals("") || !request.getParameter("priceHighFilter").equals("")) {
				
				queryObject.setFilter(true);
	
				// obtains the selected category filter, adds it to queryObject
				if (request.getParameter("categoryFilter") != null) {
					String categoryFilter = request.getParameter("categoryFilter");
					queryObject.setCategoryFilter(categoryFilter);
				}
	
				// obtains the selected review filter, adds it to queryObject
				if (request.getParameter("ratingFilter") != null) {
				
					String ratingFilter = request.getParameter("ratingFilter");
					
					if (ratingFilter.equals("above1")) {
						queryObject.setRatingFilter(1);
					}
					else if (ratingFilter.equals("above2")) {
						queryObject.setRatingFilter(2);
					}
					else if (ratingFilter.equals("above3")) {
						queryObject.setRatingFilter(3);
					}			
					else {
						queryObject.setRatingFilter(4);
					}
					
				}
				
				// obtains the selected price range filter
				if (!request.getParameter("priceLowFilter").equals("") || !request.getParameter("priceHighFilter").equals("")) {
					
					double priceLowFilter;
					double priceHighFilter;
					
					if (!request.getParameter("priceLowFilter").equals("") && !request.getParameter("priceHighFilter").equals("")) {
						priceLowFilter = Double.parseDouble(request.getParameter("priceLowFilter"));
						priceHighFilter = Double.parseDouble(request.getParameter("priceHighFilter"));
						queryObject.setPriceFilterHigh(priceHighFilter);
						queryObject.setPriceFilterLow(priceLowFilter);
					}
					else if (!request.getParameter("priceLowFilter").equals("") && request.getParameter("priceHighFilter").equals("")) {
						priceLowFilter = Double.parseDouble(request.getParameter("priceLowFilter"));
						queryObject.setPriceFilterLow(priceLowFilter);
						queryObject.setPriceFilterHigh(Double.MAX_VALUE);
					}
					else{
						priceHighFilter = Double.parseDouble(request.getParameter("priceHighFilter"));
						queryObject.setPriceFilterHigh(priceHighFilter);
						queryObject.setPriceFilterLow(0);

					}
				}
							
			}
				
			books = databaseOperator.queryConstructor(queryObject);
			request.setAttribute("booksList", books);
		}
	}

	
	protected void showCart(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator) throws ServletException, IOException {

		String username;	
		//obtains the username if the user is logged in. If not, sets username as "visitor"
		if (loggedIn) {
			username = (String) request.getSession().getAttribute("loggedInUser");
		}
		else {
			username = "visitor";
		}
		
		ArrayList<CartBean> databaseShoppingCart = databaseOperator.retrieveCart(username);
		
		if (databaseShoppingCart.size() > 0) {
			request.setAttribute("nonEmptyCart", true);
		}
		else {
			request.setAttribute("nonEmptyCart", false);
		}
		
		System.out.println(username + "'s cart size is: ");
		System.out.println(databaseShoppingCart.size());
		
	}
	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator) throws ServletException, IOException {

		String username;
		
		//obtains bid of the book being added to cart
		int bid = Integer.parseInt(request.getParameter("addToCart"));
		
		//obtains the username if the user is logged in. If not, sets username as "visitor"
		if (loggedIn) {
			username = (String) request.getSession().getAttribute("loggedInUser");
		}
		else {
			username = "visitor";
		}

		databaseOperator.addToCart(bid, 1, username);
		this.setCart(request, response, databaseOperator, username);	
		this.showCart(request, response, databaseOperator);
		this.openBook(request, response, databaseOperator, bid);

	}
	
	protected void removeFromCart(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator) throws ServletException, IOException {
		
		String username;

		//obtains bid of the book being removed from cart
		int bid = Integer.parseInt(request.getParameter("removeItem"));
		
		//obtains the username if the user is logged in. If not, sets username as "visitor"
		if (loggedIn) {
			username = (String) request.getSession().getAttribute("loggedInUser");
		}
		else {
			username = "visitor";
		}
		
		databaseOperator.removeFromCart(bid, username);
		this.setCart(request, response, databaseOperator, username);
		this.showCart(request, response, databaseOperator);
	}
	
	protected void updateCart(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator) throws ServletException, IOException {

		String username;
		int quantity;
			
		//obtains the username if the user is logged in. If not, sets username as "visitor"
		if (loggedIn) {
			username = (String) request.getSession().getAttribute("loggedInUser");
		}
		else {
			username = "visitor";
		}
		
		ArrayList<CartBean> databaseShoppingCart = databaseOperator.retrieveCart(username);
		
		for (CartBean cartItem : databaseShoppingCart) {
			
			//gets the bid of the item being inspected from the database
			String databaseBid = Integer.toString(cartItem.getBid()); 
			//gets the quantity that appears in the current state of cart of the same item		
			quantity = Integer.parseInt(request.getParameter(databaseBid));
			//checks if the inspected item's quantity has been changed
			//if so, updates database. if not, inspects the next item
			if (quantity != cartItem.getQuantity()) {
				databaseOperator.updateQuantity(cartItem.getBid(), cartItem.getUsername(), quantity);
			}
		}
		
		this.setCart(request, response, databaseOperator, username);
		this.showCart(request, response, databaseOperator);
	}
	
	protected void setCart(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, String username) throws ServletException, IOException {
		ArrayList<CartBean> shoppingCart = databaseOperator.retrieveCart(username);
		double totalPrice = databaseOperator.getTotalPrice(username);
		request.getSession().setAttribute("cart", shoppingCart);
		request.getSession().setAttribute("totalPrice", totalPrice);
	}
			
	protected void openBook(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, int bookID) throws ServletException, IOException {
		BookBean singleBook = databaseOperator.retrieveBook(bookID);
		request.setAttribute("singleBook", singleBook);
		
		// Retrieve user review for book if it exists, otherwise give option to add review:
		if (request.getSession().getAttribute("loggedInUser") != null) {
			String username = request.getSession().getAttribute("loggedInUser").toString();
			ArrayList<String> review = databaseOperator.retrieveReviewByUsernameAndBook(username, bookID);
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
	
	protected void addReview(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking) throws ServletException, IOException {
		
		String review = request.getParameter("review");
		int bookID = Integer.parseInt(request.getSession().getAttribute("title").toString());

		//checks if anything was added to the review field before submission of review
		errorChecking.checkReviewError(review);
		
		if (!errorChecking.getErrorStatus()) {
			String username = request.getSession().getAttribute("loggedInUser").toString();
			int rating = Integer.parseInt(request.getParameter("rating"));
			databaseOperator.addReview(username, bookID, review, rating);
			openBook(request, response, databaseOperator, bookID);	
		}
		else {
			target = "/SingleBook.jspx";
			openBook(request, response, databaseOperator, bookID);	
			request.setAttribute("error", errorChecking.getErrorMessage());
		}
	}
	protected void payment(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking){
			
		String username = request.getSession().getAttribute("loggedInUser").toString();
		String creditCardNumber = request.getParameter("creditCardNumber");
		String expiryMonth = request.getParameter("creditCardExpiryMonth");
		String expiryDay = request.getParameter("creditCardExpiryDay");
		String securityCode = request.getParameter("creditCardSecurity");
		
		errorChecking.checkPaymentInformation(creditCardNumber, expiryMonth, expiryDay, securityCode);
		
		//check if the new order number is a multiple of 3		
		if ((orderCount + 1) % 3 == 0) {
			error = true;
			target = "/Payment.jspx";
			request.setAttribute("error", "CREDIT CARD AUTHORIZATION FAILED");
			this.orderCount++;
		}
		//if there are errors, sets the appropriate error message
		else if (errorChecking.getErrorStatus()) {
			error = true;
			target = "/Payment.jspx";
			request.setAttribute("error", errorChecking.getErrorMessage());
		}
		else {			
						
			ArrayList<CartBean> shoppingCart = databaseOperator.retrieveCart(username);
			
			//obtains the entered addresses for payment
			AddressBean paymentShippingAB = this.retrievePaymentAddresses(request, response, databaseOperator, errorChecking).get(0);
			AddressBean paymentBillingAB = this.retrievePaymentAddresses(request, response, databaseOperator, errorChecking).get(1);
			
			//obtains the default addresses of user
			AddressBean defaultShippingAB  = databaseOperator.retrieveAddress(username, "shipping");
			AddressBean defaultBillingAB  = databaseOperator.retrieveAddress(username, "billing");

			//checks if addresses are default addresses in database
			boolean defaultShippingAddressUsed = errorChecking.compareAddresses(paymentShippingAB, defaultShippingAB);
			boolean defaultBillingAddressUsed = errorChecking.compareAddresses(paymentBillingAB, defaultBillingAB);
			
			//default shipping and billing address added to orderDetails - update to address table not necessary
			if (defaultShippingAddressUsed && defaultBillingAddressUsed) {
				
				databaseOperator.addtoOrders(shoppingCart, defaultShippingAB, defaultBillingAB);

			}//default shipping and new billing address added to orderDetails - billing address will be updated
			else if (defaultShippingAddressUsed && !defaultBillingAddressUsed) {
				databaseOperator.updateAddress(paymentBillingAB);
				databaseOperator.addtoOrders(shoppingCart, defaultShippingAB, defaultBillingAB);

			}//new shipping and default billing address added to orderDetails - shipping address will be updated
			else if (!defaultShippingAddressUsed && defaultBillingAddressUsed) {

				databaseOperator.updateAddress(paymentShippingAB);
				databaseOperator.addtoOrders(shoppingCart, defaultShippingAB, defaultBillingAB);

			}//new shipping and new new address added to orderDetails - both addresses will be updated
			else if (!defaultShippingAddressUsed && !defaultBillingAddressUsed) {
				
				databaseOperator.updateAddress(paymentBillingAB);
				databaseOperator.updateAddress(paymentShippingAB);
				databaseOperator.addtoOrders(shoppingCart, defaultShippingAB, defaultBillingAB);
			}

			// i and Order are needed for listener!
			int i = 0;
			request.getSession().setAttribute("Order", i++);
			target = "/SuccessfulOrder.jspx";
		}
	}
	
	protected void setAddress(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, String username) throws ServletException, IOException {

		//obtains user's shipping and billing addresses for confirmation on the payment page
		AddressBean shippingAB = databaseOperator.retrieveAddress(username, "shipping");
		AddressBean billingAB = databaseOperator.retrieveAddress(username, "billing");

		//sets user's shipping address details 
		request.getSession().setAttribute("paymentShippingLine1", shippingAB.getAddressLine1());
		request.getSession().setAttribute("paymentShippingLine2", shippingAB.getAddressLine2());
		request.getSession().setAttribute("paymentShippingCountry", shippingAB.getCountry());
		request.getSession().setAttribute("paymentShippingProvince", shippingAB.getProvince());
		request.getSession().setAttribute("paymentShippingCity", shippingAB.getCity());
		request.getSession().setAttribute("paymentShippingZip", shippingAB.getZip());
		
		//sets user's billing address details 
		request.getSession().setAttribute("paymentBillingLine1", billingAB.getAddressLine1());
		request.getSession().setAttribute("paymentBillingLine2", billingAB.getAddressLine2());
		request.getSession().setAttribute("paymentBillingCountry", billingAB.getCountry());
		request.getSession().setAttribute("paymentBillingProvince", billingAB.getProvince());
		request.getSession().setAttribute("paymentBillingCity", billingAB.getCity());
		request.getSession().setAttribute("paymentBillingZip", billingAB.getZip());
		
		//sets user's phone number
		request.getSession().setAttribute("paymentAddressPhone", shippingAB.getPhoneNumber());
	}
	
	protected ArrayList<AddressBean> retrievePaymentAddresses(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking) {
		
		AddressBean shippingAB = new AddressBean();
		AddressBean billingAB = new AddressBean();
		ArrayList<AddressBean> paymentAddresses = new ArrayList<AddressBean>();

		String username = request.getSession().getAttribute("loggedInUser").toString();
		
		//gets user's payment shipping address details 
		shippingAB.setType("shipping");
		shippingAB.setUsername(username);
		shippingAB.setAddressLine1(request.getParameter("paymentShippingLine1"));
		shippingAB.setAddressLine2(request.getParameter("paymentShippingLine2"));
		shippingAB.setCountry(request.getParameter("paymentShippingCountry"));
		shippingAB.setProvince(request.getParameter("paymentShippingProvince"));
		shippingAB.setCity(request.getParameter("paymentShippingCity"));
		shippingAB.setZip(request.getParameter("paymentShippingZip"));
		shippingAB.setPhoneNumber(request.getParameter("paymentAddressPhone"));

		
		//gets user's payment billing address details 
		billingAB.setType("billing");
		billingAB.setUsername(username);
		billingAB.setAddressLine1(request.getParameter("paymentBillingLine1"));
		billingAB.setAddressLine2(request.getParameter("paymentBillingLine2"));
		billingAB.setCountry(request.getParameter("paymentBillingCountry"));
		billingAB.setProvince(request.getParameter("paymentBillingProvince"));
		billingAB.setCity(request.getParameter("paymentBillingCity"));
		billingAB.setZip(request.getParameter("paymentBillingZip"));
		billingAB.setPhoneNumber(request.getParameter("paymentAddressPhone"));

		paymentAddresses.add(shippingAB);
		paymentAddresses.add(billingAB);
		
		return paymentAddresses;
	}
	

	protected void productCatalogService(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking, Services services) throws ServletException, IOException{
		
		String bidString = request.getParameter("bid");
		errorChecking.checkServicesError(bidString);

		if (!errorChecking.getErrorStatus()) {
			int bid = (Integer.parseInt(bidString));
			String f = "xmlExports/" + request.getSession().getId()+".xml";
			String filename = this.getServletContext().getRealPath("/" + f);
			request.getSession().setAttribute("filenameProductService", filename);
			request.setAttribute("fProductService", f);
			System.out.println(filename);
			try {

				services.exportProductServices(bid, filename);

				request.setAttribute("PCSResultReady", true);
				target = "ProductCatalogService.jspx";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			String signUpErrorMessage = errorChecking.getErrorMessage();
			error = true;
			target = "/ProductCatalogService.jspx";
			request.setAttribute("error", signUpErrorMessage);
		}
	}

	
	protected void orderProcessingService(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking, Services services) throws ServletException, IOException{
		
		String bidString = request.getParameter("bid");
		errorChecking.checkServicesError(bidString);

		if (!errorChecking.getErrorStatus()) {
			int bid = (Integer.parseInt(bidString));
			String f = "xmlExports/" + request.getSession().getId()+".xml";
			String filename = this.getServletContext().getRealPath("/" + f);
			request.getSession().setAttribute("filenameOrderService", filename);
			request.setAttribute("fOrderService", f);
			System.out.println(filename);
			try {
				services.exportOrderServices(bid, filename);
				request.setAttribute("OPSResultReady", true);
				target = "/OrderProcessingService.jspx";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String signUpErrorMessage = errorChecking.getErrorMessage();
			error = true;
			target = "/OrderProcessingService.jspx";
			request.setAttribute("error", signUpErrorMessage);
		}
	}
	
	public void ordersByMonth(HttpServletRequest request, HttpServletResponse response, DatabaseOperator databaseOperator, ErrorChecking errorChecking) {
		// gets month to  select
		String month = request.getParameter("monthOption");
		
		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		int num = monthList.indexOf(month) + 1;
		
		ArrayList<OrderBean> ow = databaseOperator.retrieveOrdersByMonth(num);
		request.getSession().setAttribute("OrderByMonth", ow);
		request.setAttribute("OBMResultsReady", true);
		target = "/OrdersByMonth.jspx";
	}

	@GET
    @Path("/pcs/")
	@Produces(MediaType.TEXT_XML)
	public String getProductCatalogService(@QueryParam("bid") String bookid) {
		int bid = Integer.parseInt(bookid);
		Services services = new Services();
		try {
			String toReturn = services.exportProductWebServices(bid);
			
			target = "/ProductProcessingService.jspx";
			
			return toReturn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	@GET
    @Path("/ops/")
	@Produces(MediaType.TEXT_XML)
	public String getOrerCatalogService(@QueryParam("bid") String bookid) {
		int bid = Integer.parseInt(bookid);
		Services services = new Services();
		try {
			String toReturn = services.exportOrderWebServices(bid);
			
			target = "/ProductProcessingService.jspx";
			
			return toReturn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

	
}