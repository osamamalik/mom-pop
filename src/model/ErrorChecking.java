package model;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import bean.*;

public class ErrorChecking {

	private DatabaseOperator databaseOperator;
	private boolean errorStatus;
	private String errorMessage;

	public ErrorChecking() {
		databaseOperator = new DatabaseOperator();
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
		else if(databaseOperator.retrieveUser(username).getUsername() != null) {
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
	
	
	public void checkServicesError(String id) {
		
		setErrorMessage(null);
		setErrorStatus(false);
		
		if (id == "") {
			setErrorMessage("BLANKBID");
			setErrorStatus(true);
		}
		
	}
	
	
	public boolean passwordValidation(String username, String password) {
		UserBean ub = new UserBean();
		ub = databaseOperator.retrieveUser(username);
		return ub.getPassword().equals(password);
	}
	
	public boolean checkUserExists(String username) {
		return databaseOperator.checkUserExists(username);
	}
	
	public boolean compareAddresses(AddressBean ab1, AddressBean ab2) {
		String ab1ln1 = ab1.getAddressLine1();
		String ab2ln1 = ab2.getAddressLine1();
		String ab1ln2 = ab1.getAddressLine2();
		String ab2ln2 = ab2.getAddressLine2();
		String ab1Cnt = ab1.getCountry();
		String ab2Cnt = ab2.getCountry();
		String ab1Prov = ab1.getProvince();
		String ab2Prov = ab2.getProvince();
		String ab1City = ab1.getCity();
		String ab2City = ab2.getCity();
		String ab1Zip = ab1.getZip();
		String ab2Zip = ab2.getZip();
		String ab1Number = ab1.getPhoneNumber();
		String ab2Number = ab2.getPhoneNumber();
		
		if (ab1ln1.equals(ab2ln1) && ab1ln2.equals(ab2ln2) && ab1Cnt.equals(ab2Cnt) && ab1Prov.equals(ab2Prov) && ab1City.equals(ab2City) && ab1Zip.equals(ab2Zip) && ab1Number.equals(ab2Number)){
			return true;
		}
		else {
			return false;
		}
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