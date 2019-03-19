package model;

import java.sql.SQLException;
import java.util.Map;

import DAO.*;
import bean.*;

public class Model {
	private LoginDAO loginDAO;
	private SignUpDAO signUpDAO;
	
	public Model() {
		try {
			loginDAO = new LoginDAO();
			signUpDAO = new SignUpDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginBean retrieveUser(String username) throws Exception {
		return loginDAO.retrieveUser(username);
	}
	
	public void addUser(String username, String email, String password) {
		try {
			signUpDAO.addUser(username, email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkUserExists(String username) {
		try {
			return loginDAO.checkUserExists(username);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
