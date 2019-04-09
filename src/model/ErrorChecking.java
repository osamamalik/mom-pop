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
	
	public void checkSignUpError(String username, String email, String password, String passwordConf, AddressBean shippingAB, AddressBean billingAB) {
		setErrorMessage(null);
		setErrorStatus(false);
		
		//checks if username, email, or password are blank
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
		//checks if password is too short
		else if (password.length() < 6) {
			setErrorStatus(true);
			setErrorMessage("SHORTPASSWORD");
		}
		//checks if entered passwords don't match
		else if(!password.equals(passwordConf)) {
			setErrorStatus(true);
			setErrorMessage("PASSWORDMISMATCH");
		}
		//checks if username already exists in database
		else if(myModel.retrieveUser(username).getUsername() != null) {
			setErrorStatus(true);
			setErrorMessage("EXISTINGUSER");
		}
		
		this.checkAddressError(shippingAB, billingAB);
		
	}
	
	public void checkAddressError(AddressBean shippingAB, AddressBean billingAB) {
		
		//checks if any of shipping address fields are blank
		if(shippingAB.getAddressLine1() == "" || shippingAB.getCountry() == "" || shippingAB.getProvince() == "" || shippingAB.getCity() == "" || shippingAB.getPhoneNumber() == "" || shippingAB.getZip() == "") {
			setErrorStatus(true);
			if (shippingAB.getAddressLine1() == "") {
				setErrorMessage("BLANKSHIPPINGADDRESSLINE1");
			}
			else if(shippingAB.getCountry() == "" ) {
				setErrorMessage("BLANKSHIPPINGADDRESSCOUNTRY");
			}
			else if(shippingAB.getProvince() == "" ) {
				setErrorMessage("BLANKSHIPPINGADDRESSPROVINCE");
			}
			else if(shippingAB.getCity() == "" ) {
				setErrorMessage("BLANKSHIPPINGADDRESSCITY");
			}
			else if(shippingAB.getPhoneNumber() == "" ) {
				setErrorMessage("BLANKSHIPPINGADDRESSPHONENUMBER");
			}
			else if(shippingAB.getZip() == "" ) {
				setErrorMessage("BLANKSHIPPINGADDRESSZIPCODE");
			}
		}
		
		//checks if any of billing address fields are blank
		if(billingAB.getAddressLine1() == "" || billingAB.getCountry() == "" || billingAB.getProvince() == "" || billingAB.getCity() == "" || billingAB.getPhoneNumber() == "" || billingAB.getZip() == "") {
			setErrorStatus(true);
			if (billingAB.getAddressLine1() == "") {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
			else if(billingAB.getCountry() == "" ) {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
			else if(billingAB.getProvince() == "" ) {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
			else if(billingAB.getCity() == "" ) {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
			else if(billingAB.getPhoneNumber() == "" ) {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
			else if(billingAB.getZip() == "" ) {
				setErrorMessage("BLANKBILLINGADDRESSZIPCODE");
			}
		}
	}
	
	
	public void checkPCSError(String bid) {
		
		setErrorMessage(null);
		setErrorStatus(false);
		
		if (bid == "") {
			setErrorMessage("BLANKBID");
			setErrorStatus(true);
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