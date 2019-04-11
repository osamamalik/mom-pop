package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	boolean error;
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
		Model model = new Model();
		model.clearVisitorCart();
		
		try {
			context.setAttribute("myModel", new Model());
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
			INITIALIZATION OF MODEL AND QUERY
		 ****************************************************************/
		Model myModel = (Model) this.getServletContext().getAttribute("myModel");
		ErrorChecking errorChecking = (ErrorChecking) this.getServletContext().getAttribute("errorChecking");
		QueryConstructor queryObject = (QueryConstructor) this.getServletContext().getAttribute("query");
		request.getSession().setAttribute("query", queryObject);
		
		/***************************************************************
			PAGE REDIRECTIONS
		 ****************************************************************/
		this.redirector(request, response, myModel, queryObject);
		
		/***************************************************************
			SIGN UP
		 ****************************************************************/
		if (request.getParameter("signUpButton") != null) {
			this.signUp(request, response, myModel, errorChecking);
		}
		
		/***************************************************************
			LOGIN
		****************************************************************/
		if (request.getParameter("loginButton") != null) {
			String username = request.getParameter("loginName");
			String password = request.getParameter("loginPassword"); 
			this.logIn(request, response, myModel, errorChecking, username, password);
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
			this.listAllBooks(request, response, myModel, queryObject);
		}
		
		// Calls method for listing books by category
		if (request.getParameter("headerCategory") != null) {
			this.listBooksByCategory(request, response, myModel, queryObject);
		}
		
		/***************************************************************
			BOOK SORTINGS
		****************************************************************/
		if (request.getParameter("sortButton") != null) {
			this.sortBooks(request, response, myModel, queryObject);	
		}
		
		/***************************************************************
			FILTER
		****************************************************************/
		if (request.getParameter("filterButton") != null || request.getParameter("resetFilterButton") != null ) {
			this.filter(request, response, myModel, queryObject);
		}
	
		/***************************************************************
			SINGLE BOOK PAGE
		****************************************************************/
		if (request.getParameter("viewSingleBook") != null) {
			int title = (Integer.parseInt(request.getParameter("viewSingleBook")));
			this.openBook(request, response, myModel, title);
		}
		
		if (request.getParameter("addReviewButton") != null) {
			this.addReview(request, response, myModel);
		}
		
		/***************************************************************
			SEARCH BAR
		****************************************************************/
		if (request.getParameter("searchButton") != null) {
			this.searchStore(request, response, myModel, queryObject);
		}
				
		/***************************************************************
			ADD TO SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("addToCart") != null) {
			this.addToCart(request, response, myModel);
		}
		
		/***************************************************************
			REMOVE FROM SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("removeItem") != null) {
			this.removeFromCart(request, response, myModel);
		}
		
		/***************************************************************
			UPDATE SHOPPING CART
		 ****************************************************************/
		if (request.getParameter("updateCart") != null) {
			this.updateCart(request, response, myModel);
		}
		
		/***************************************************************
			PAYMENT
		****************************************************************/
		if (request.getParameter("placeOrder") != null) {
			this.payment(request, response, myModel, errorChecking);
		}
		
		/***************************************************************
			PRODUCT CATALOG SERVICES
		 ****************************************************************/
		if (request.getParameter("PCSGenerateButton") != null) {
			this.productCatalogService(request, response, myModel, errorChecking);
		}
		
		
		/***************************************************************
			ORDER PROCESSING SERVICES
		 ****************************************************************/
		if (request.getParameter("OPSGenerateButton") != null) {
			this.orderProcessingService(request, response, myModel, errorChecking);
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
	
	protected void redirector(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {
						
		//checks if a 'Single Book' has been clicked on
		if (request.getParameter("viewSingleBook") != null) {
			target = "/SingleBook.jspx";
		}
		//once a review has been submitted, the page is reloaded
		if (request.getParameter("addReviewButton") != null) {
			target = "/SingleBook.jspx";
		}

		//checks if 'Sign Up' button was pressed, sets target to the Sign Up page if true
		if (request.getParameter("signUpPageButton") != null) {
			request.setAttribute("differentAddressTypes", true);
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
			if (!adminLoggedIn) {
				target = "/Login.jspx";
			}
			else if (adminLoggedIn){
				target = "/Services.jspx";
			}		
		}
		
		//checks if analytics access is requested
		//checks if user is logged in as admin
		if (request.getParameter("analyticsButton") != null) {
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
		if (request.getParameter("showShoppingCart") != null) {
			target = "/ShoppingCart.jspx";	
		}
		
		//checks if Checkout was requested
		if (request.getParameter("checkoutButton") != null) {
			if (!loggedIn) {
				this.redirectedTarget = "/Payment.jspx";
				this.target = "/Login.jspx";
			}
			else {
				this.target = "/Payment.jspx";
			}
		}
				
	}
		
	protected void logIn(HttpServletRequest request, HttpServletResponse response, Model myModel, ErrorChecking errorChecking, String username, String password) throws ServletException, IOException {
		
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
			}		
			
			//clears the 'visitor' shopping cart
			myModel.clearVisitorCart();
			
			//sets the user's cart
			this.setCart(request, response, myModel, username);
			
			//sets the user's address information
			this.setShippingAddress(request, response, myModel, username);
		}
		
		else {
			String loginErrorMessage = errorChecking.getErrorMessage();
			error = true;
			this.target = "/Login.jspx";
			request.setAttribute("error", loginErrorMessage);
		}
	}
	
	protected void signUp(HttpServletRequest request, HttpServletResponse response, Model myModel, ErrorChecking errorChecking) throws ServletException, IOException {
		
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
			myModel.addUser(username, firstName, lastName, email, password);
			myModel.addAddress(shippingAB);
			myModel.addAddress(billingAB);
			
			//checks if there are items in the visitor shopping cart
			//if so, adds these items to the database for the newly created user
			ArrayList<CartBean> shoppingCart = (ArrayList<CartBean>) request.getSession().getAttribute("cart");
			
			for (CartBean cartItem : shoppingCart) {
				cartItem.setUsername(username);
			}

			myModel.addShoppingCart(shoppingCart, username);
			this.setCart(request, response, myModel, username);
			
			this.logIn(request, response, myModel, errorChecking, username, password);
			
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
	

	protected void listAllBooks(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {
	
		queryObject.setCategory(null);
		queryObject.setSearchTerm(null);
		queryObject.resetFilter();
		
		queryObject.setAllBooks(true);
		books = myModel.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
	}
	
	protected void listBooksByCategory(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {
		
		queryObject.setAllBooks(false);
		queryObject.setSearchTerm(null);
		
		String category = request.getParameter("headerCategory");
		queryObject.setCategory(category);
		books = myModel.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
		
	}
	
	protected void sortBooks(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {
		
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
		
		books = myModel.queryConstructor(queryObject);
		request.setAttribute("booksList", books);
		
	}
	
	protected void searchStore(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {
		
		queryObject.setAllBooks(false);
		queryObject.setCategory(null);

		//obtains the searched term
		String searchTerm = request.getParameter("searchBar").toUpperCase();
		
		queryObject.setSearchTerm(searchTerm);
			
		books = myModel.queryConstructor(queryObject);
		request.setAttribute("booksList", books);	
	}
	
	protected void filter(HttpServletRequest request, HttpServletResponse response, Model myModel, QueryConstructor queryObject) throws ServletException, IOException {		
		
		//if user chose to reset the filter, queryObject's filter attributes are reset
		//if not, queryObject's filter attributes are initialized
		if (request.getParameter("resetFilterButton") != null) {
			queryObject.resetFilter();
			books = myModel.queryConstructor(queryObject);
			request.setAttribute("booksList", books);		
			
			//Retrieves unique categories and sets the filter display
			ArrayList <String>categories = new ArrayList<String>();
			categories = myModel.retrieveUniqueCategories();
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
				
			books = myModel.queryConstructor(queryObject);
			request.setAttribute("booksList", books);
		}
	}

	
	protected void addToCart(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {

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

		myModel.addToCart(bid, 1, username);
		this.setCart(request, response, myModel, username);		
		this.openBook(request, response, myModel, bid);

	}
	
	protected void removeFromCart(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {
		
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
		
		myModel.removeFromCart(bid, username);
		this.setCart(request, response, myModel, username);
		
	}
	
	protected void updateCart(HttpServletRequest request, HttpServletResponse response, Model myModel) throws ServletException, IOException {

		String username;
		int quantity;
			
		//obtains the username if the user is logged in. If not, sets username as "visitor"
		if (loggedIn) {
			username = (String) request.getSession().getAttribute("loggedInUser");
		}
		else {
			username = "visitor";
		}
		
		ArrayList<CartBean> databaseShoppingCart = myModel.retrieveCart(username);
		
		for (CartBean cartItem : databaseShoppingCart) {
			
			//gets the bid of the item being inspected from the database
			String databaseBid = Integer.toString(cartItem.getBid()); 
			//gets the quantity that appears in the current state of cart of the same item		
			quantity = Integer.parseInt(request.getParameter(databaseBid));
			//checks if the inspected item's quantity has been changed
			//if so, updates database. if not, inspects the next item
			if (quantity != cartItem.getQuantity()) {
				myModel.updateQuantity(cartItem.getBid(), cartItem.getUsername(), quantity);
			}
		}
		
		this.setCart(request, response, myModel, username);
		
	}
	
	protected void setCart(HttpServletRequest request, HttpServletResponse response, Model myModel, String username) throws ServletException, IOException {
		ArrayList<CartBean> shoppingCart = myModel.retrieveCart(username);
		double totalPrice = myModel.getTotalPrice(username);
		request.getSession().setAttribute("cart", shoppingCart);
		request.getSession().setAttribute("totalPrice", totalPrice);
	}
	
	protected void setShippingAddress(HttpServletRequest request, HttpServletResponse response, Model myModel, String username) throws ServletException, IOException {

		//obtains user's shipping and billing addresses for confirmation on the payment page
		AddressBean shippingAB = myModel.retrieveAddress(username, "shipping");
		AddressBean billingAB = myModel.retrieveAddress(username, "shipping");
		
		//sets user's shipping address details 
		request.getSession().setAttribute("shippingLine1", shippingAB.getAddressLine1());
		request.getSession().setAttribute("shippingLine2", shippingAB.getAddressLine2());
		request.getSession().setAttribute("shippingCountry", shippingAB.getCountry());
		request.getSession().setAttribute("shippingProvince", shippingAB.getProvince());
		request.getSession().setAttribute("shippingCity", shippingAB.getCity());
		request.getSession().setAttribute("shippingZip", shippingAB.getZip());
		
		//sets user's billing address details 
		request.getSession().setAttribute("billingLine1", billingAB.getAddressLine1());
		request.getSession().setAttribute("billingLine2", billingAB.getAddressLine2());
		request.getSession().setAttribute("billingCountry", billingAB.getCountry());
		request.getSession().setAttribute("billingProvince", billingAB.getProvince());
		request.getSession().setAttribute("billingCity", billingAB.getCity());
		request.getSession().setAttribute("billingZip", billingAB.getZip());
		
		//sets user's phone number
		request.getSession().setAttribute("addressPhone", shippingAB.getPhoneNumber());

	}
		
	protected void openBook(HttpServletRequest request, HttpServletResponse response, Model myModel, int bookID) throws ServletException, IOException {
		BookBean singleBook = myModel.retrieveBook(bookID);
		request.setAttribute("singleBook", singleBook);
		
		// Retrieve user review for book if it exists, otherwise give option to add review:
		if (request.getSession().getAttribute("loggedInUser") != null) {
			String username = request.getSession().getAttribute("loggedInUser").toString();
			ArrayList<String> review = myModel.retrieveReviewByUsernameAndBook(username, bookID);
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
		int title = (Integer.parseInt(request.getParameter("title")));
		openBook(request, response, myModel, title);
	}
		
	protected void payment(HttpServletRequest request, HttpServletResponse response, Model myModel, ErrorChecking errorChecking){
		
	
		//check if the new order number is a multiple of 3
		int orderCount = myModel.getOrderCount();
		if ((orderCount + 1) % 3 == 0) {
			error = true;
			target = "/Payment.jspx";
			request.setAttribute("error", "ORDER DENIED");
		}
		else {
			ArrayList<CartBean> shoppingCart = (ArrayList<CartBean>) request.getSession().getAttribute("cart");
			myModel.addtoOrders(shoppingCart);
			target = "/SuccessfulOrder.jspx";
		}
	}

	protected void productCatalogService(HttpServletRequest request, HttpServletResponse response, Model myModel, ErrorChecking errorChecking) throws ServletException, IOException{
		
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
				myModel.exportProductServices(bid, filename);
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
	
	protected void orderProcessingService(HttpServletRequest request, HttpServletResponse response, Model myModel, ErrorChecking errorChecking) throws ServletException, IOException{
		
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
				myModel.exportOrderServices(bid, filename);
				request.setAttribute("OPSResultReady", true);
				target = "OrderProcessingService.jspx";
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
	
	
	
	
	
	
	
	
	
}
