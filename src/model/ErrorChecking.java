package model;

import java.sql.SQLException;

import DAO.*;
import bean.*;

public class ErrorChecking {

	private Model myModel;
	private boolean errorStatus;
	private String errorMessage;

	public ErrorChecking() {
		myModel = new Model();
		this.errorStatus = false;
		this.errorMessage = null;
	}
	

	public void checkLoginError(String username, String password) {
		setErrorMessage(null);
		setErrorStatus(false);
		if (username == "" || password == "") {
			setErrorStatus(true);
			if(username == "") {
				setErrorMessage("BLANKUSERNAME");
			}
			else {
				setErrorMessage("BLANKPASSWORD");
			}
		}
		else if (!checkUserExists(username)) {
			setErrorStatus(true);
			setErrorMessage("USERNOTFOUND");
		}
		else if (!passwordValidation(username, password)){
			setErrorStatus(true);
			setErrorMessage("WRONGPASSWORD");
		}
	
	}
	
	public void checkSignUpError(String username, String email, String password, String passwordConf) {
		setErrorMessage(null);
		setErrorStatus(false);
		if (username == "" || email == "" || password == "") {
			setErrorStatus(true);
			if(username == "") {
				setErrorMessage("BLANKUSERNAME");
			}else if (email == ""){
				setErrorMessage("BLANKEMAIL");
			}else {
				setErrorMessage("BLANKPASSWORD");
			}
			return;
		}
		else if (!email.contains("@") || email.length() < 3) {
			setErrorStatus(true);
			setErrorMessage("EMAILFORMAT");
		}
		else if (password.length() < 6) {
			setErrorStatus(true);
			setErrorMessage("SHORTPASSWORD");
		}
		else if(!password.equals(passwordConf)) {
			setErrorStatus(true);
			setErrorMessage("PASSWORDMISMATCH");
		}
	}
	
	public boolean passwordValidation(String username, String password) {
		UserBean ub = new UserBean();
		ub = myModel.retrieveUser(username);
		return ub.getPassword().equals(password);
	}
	
	public boolean checkUserExists(String username) {
		return myModel.checkUserExists(username);
	}
	
	
	public void setErrorStatus(boolean status) {
		this.errorStatus = status;
	}
	
	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}
	
	public boolean getErrorStatus() {
		return this.errorStatus;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
	
}