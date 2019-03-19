package ctrl;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

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

		//initializes the model object
		Model myModel = (Model) this.getServletContext().getAttribute("myModel");
		

		//****************************************************
		//Manages page redirections

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

		//Checks if there was a sign up attempt, takes appropriate action
		if (request.getParameter("signUpButton") != null) {

			/* CHECK ERROR HERE */

			String username = request.getParameter("signUpName");
			String email = request.getParameter("signUpEmail");
			String password = request.getParameter("signUpPassword"); 

			myModel.addUser(username, email, password);

		}

		//Checks if there was a sign up attempt, takes appropriate action
		if (request.getParameter("loginButton") != null) {

			/* CHECK ERROR HERE */

			String username = request.getParameter("loginName");
			String password = request.getParameter("loginPassword"); 

			// Check if user exists in database and set log in status
			boolean userExists = myModel.checkUserExists(username);
			if (userExists) {
				loggedIn = true;
				request.getSession().setAttribute("loggedInSession", loggedIn);
				request.getSession().setAttribute("loggedInUser", username);
			}
			else {
				// ERROR
				System.out.println("User Not Found. Could not login.");
			}
			
		}


		/* Used For Testing Purposes */

		try {
			System.out.println("Does Baris exist: " + myModel.checkUserExists("baris"));
			System.out.println("Does user exist: " + myModel.checkUserExists("fsff"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Login status: (application): " + loggedIn);
		System.out.println("Login status (session): " + request.getSession().getAttribute("loggedInSession"));
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
