package ctrl;

import java.io.IOException;
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
			INITIALIZATION
		 ****************************************************************/
		
		Model myModel = (Model) this.getServletContext().getAttribute("myModel");
		ArrayList <BookBean>books = new ArrayList<BookBean>();
		boolean error = false;
		String query;

		/***************************************************************
			PAGE REDIRECTIONS
		 ****************************************************************/

		//Sets the default redirection target to the Home page
		String target = "/Home.jspx";

		//checks if 'Sign Up' button was pressed, sets target to the Sign Up page if true
		if (request.getParameter("signUpPageButton") != null) {
			target = "/SignUp.jspx";
		}
		//checks if 'Login' button was pressed, sets target to the Login page if true
		if (request.getParameter("loginPageButton") != null) {
			target = "/Login.jspx";
		}
		if (request.getParameter("Analytics") != null) {
			target = "/Analytics.jspx";
		}
		//checks if 'List Books', 'Sort', or a search was submitted, sets target to the Login page if true
		if (request.getParameter("booksPageButton") != null || (request.getParameter("searchButton") != null) || (request.getParameter("sortButton") != null) || (request.getParameter("filterButton") != null)) {
			target = "/Books.jspx";
		}
		
		/***************************************************************
			SIGN UP
		 ****************************************************************/

		//Checks if there was a sign up attempt, takes appropriate action
		if (request.getParameter("signUpButton") != null) {

			String username = request.getParameter("signUpName");
			String email = request.getParameter("signUpEmail");
			String password = request.getParameter("signUpPassword"); 
			String passwordConf = request.getParameter("signUpPasswordConf"); 

			
			// Sets errors, if any
			myModel.checkSignUpError(username, email, password, passwordConf);
			if (!myModel.getErrorStatus()) {
				myModel.addUser(username, email, password);
				//logs in with the user credentials that was created
				loggedIn = true;
				request.getSession().setAttribute("loggedInSession", loggedIn);
				request.getSession().setAttribute("loggedInUser", username);
			}else {
				String signUpErrorMessage = myModel.getErrorMessage();
				error = true;
				target = "/SignUp.jspx";
				request.setAttribute("error", signUpErrorMessage);
			}

		}
		
		/***************************************************************
			LOGIN
		****************************************************************/

		//Checks if there was a sign up attempt, takes appropriate action
		if (request.getParameter("loginButton") != null) {
			String username = request.getParameter("loginName");
			String password = request.getParameter("loginPassword"); 
			
			// Sets errors, if any
			myModel.checkLoginError(username, password);

			if (!myModel.getErrorStatus()) {		// No errors, user is successfully logged in
				loggedIn = true;
				request.getSession().setAttribute("loggedInSession", loggedIn);
				request.getSession().setAttribute("loggedInUser", username);
			}
			else {
				String loginErrorMessage = myModel.getErrorMessage();
				error = true;
				target = "/Login.jspx";
				request.setAttribute("error", loginErrorMessage);
			}
		}
		
		/***************************************************************
			SIGN OUT
	    ****************************************************************/
		if (request.getParameter("signoutButton") != null) {
			loggedIn = false;
			request.getSession().setAttribute("loggedInSession", loggedIn);
		}
		
		/***************************************************************
			BOOK LISTINGS
		****************************************************************/
		
		//Checks if book listings were requested, sets the book map with all books
		if (request.getParameter("booksPageButton") != null) {
			
			query = "select * from BOOKS";
			request.getSession().setAttribute("query", query);
			books = myModel.retrieveByQuery(query);
			request.setAttribute("booksMap", books);
		}
		
		//checks if a listing by category was requested, sets the book map
		if (request.getParameter("fictionCategory") != null || request.getParameter("scienceCategory") != null || request.getParameter("engineeringCategory") != null) {
					
			target = "/Books.jspx";
			
			String category;
			
			if (request.getParameter("fictionCategory") != null) {
				category = "Fiction";
			}
			else if (request.getParameter("scienceCategory") != null ) {
				category = "Science";
			}
			else {
				category = "Engineering";
			}
			
			query = "select * from BOOKS where category like '%" + category + "%'";
			request.getSession().setAttribute("query", query);
			books = myModel.retrieveByQuery(query);
			request.setAttribute("booksMap", books);
		}
		
		/***************************************************************
			BOOK SORTINGS
		****************************************************************/
		
		if (request.getParameter("sortButton") != null) {
			
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
		
		/***************************************************************
			FILTER
		****************************************************************/
		
		if (request.getParameter("filterButton") != null) {
			
			query = "select * from BOOKS where";
			
			//if a price range was selected, add to query
			//if an author was selected, add to query
			//if a category was selected, add to query
			//if a year was selected, add to query
			//if a rating was selected, add to query
			
			books = myModel.retrieveByQuery(query);
			request.setAttribute("booksMap", books);	
		}
		
		/***************************************************************
			SEARCH BAR
		****************************************************************/
		
		if (request.getParameter("searchButton") != null) {
						
			//obtains the searched term
			String searchTerm = request.getParameter("searchBar");
			
			query = "select * from BOOKS where title like '%" + searchTerm + "%' or author like '%" + searchTerm + "%' or category like '%" + searchTerm + "%'";
			request.getSession().setAttribute("query", query);
			
			//does a store-wide search by with the retrieveBySearch query
			books = myModel.retrieveByQuery(query);
			request.setAttribute("booksMap", books);		
			
		}
		
		/***************************************************************
					Analytics
		 ****************************************************************/
		if(request.getParameter("AnalyticsButton") != null) {
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
			target="/DoneAnalytics.jspx";
		}
		
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

}
