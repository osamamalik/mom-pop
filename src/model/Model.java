package model;

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
}
