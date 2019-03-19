package ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		boolean error = false;

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
		
		/***************************************************************
			SIGN UP
		 ****************************************************************/

		//Checks if there was a sign up attempt, takes appropriate action
		if (request.getParameter("signUpButton") != null) {

			String username = request.getParameter("signUpName");
			String email = request.getParameter("signUpEmail");
			String password = request.getParameter("signUpPassword"); 
			
			// Sets errors, if any
			myModel.checkSignUpError(username, email, password);
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
			TESTING BLOCK
		 ****************************************************************/
//		
//		BookBean bb;
//		try {
//			bb = myModel.retrieveBook("b001");
//			System.out.println(bb.getAuthor());
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		Map<String, BookBean> books = new HashMap<String, BookBean>();
		books = myModel.retrieveByTitle("Mechanics");
		
	
		for (Map.Entry<String, BookBean> entry : books.entrySet()){
			System.out.println(entry.getValue().getBid());
		}
			
		//TODO
			
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
