package model;

import java.sql.SQLException;
import java.util.Map;

import DAO.*;
import bean.*;

public class Model {
	private UserDAO userDAO;
	private boolean errorStatus;
	private String errorMessage;

	public Model() {

		this.errorStatus = false;
		this.errorMessage = null;

		try {
			userDAO = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean retrieveUser(String username) throws Exception {
		return userDAO.retrieveUser(username);
	}

	public void addUser(String username, String email, String password) {
		try {
			userDAO.addUser(username, email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/***************************************************************
		ERROR CHECKING METHODS
	 ****************************************************************/
	
	public void checkLoginError(String username, String password) {
		this.errorMessage = null;
		this.errorStatus = false;
		if (username == "" || password == "") {
			this.errorStatus = true;
			if(username == "") {
				this.errorMessage = "BLANKUSERNAME";
			}
			else {
				this.errorMessage = "BLANKPASSWORD";
			}
		}
		else if (!checkUserExists(username)) {
			this.errorStatus = true;
			this.errorMessage = "USERNOTFOUND";

		}
		else if (!passwordValidation(username, password)){
			this.errorStatus = true;
			this.errorMessage = "WRONGPASSWORD";

		}
	}
	
	public boolean passwordValidation(String username, String password) {
		UserBean ub = new UserBean();
		try {
			ub = retrieveUser(username);
			System.out.println(ub.getPassword());
			return ub.getPassword().equals(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkUserExists(String username) {
		try {
			return userDAO.checkUserExists(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getErrorStatus() {
		return this.errorStatus;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}















}
