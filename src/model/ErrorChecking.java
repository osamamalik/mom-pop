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

		//checks if username or password values are blank
		if (username == "" || password == "") {
			setErrorStatus(true);
			if(username == "") {
				setErrorMessage("BLANK USERNAME");
			}
			else {
				setErrorMessage("BLANK PASSWORD");
			}
			return;
		}
		//checks if username and password fields match character limitations in the database
		if (username.length() > 30 || password.length() > 20) {
			setErrorStatus(true);
			if (username.length() > 30) {
				setErrorMessage("USERNAME IS TOO LONG. MUST BE LESS THAN 30 CHARACTERS");
			}
			else if (password.length() > 20) {
				setErrorMessage("PASSWORD IS TOO LONG. MUST BE BETWEEN 6 AND 20 CHARACTERS");
			}
			return;
		}
		//checks if the entered user exists in the database
		else if (!checkUserExists(username)) {
			setErrorStatus(true);
			setErrorMessage("USER NOT FOUND");
			return;
		}
		//checks if user entered the correct password
		else if (!passwordValidation(username, password)){
			setErrorStatus(true);
			setErrorMessage("INCORRECT PASSWORD");
			return;
		}

	}

	public void checkSignUpError(String username, String email, String password, String passwordConf, AddressBean shippingAB, AddressBean billingAB) {
		setErrorMessage(null);
		setErrorStatus(false);

		//checks if username, email, or password are blank
		if (username == "" || passwordConf == "" || email == "" || password == "") {
			setErrorStatus(true);
			if(username == "") {
				setErrorMessage("BLANK USERNAME");
			}
			else if (email == ""){
				setErrorMessage("BLANK EMAIL");
			}
			else if (passwordConf == ""){
				setErrorMessage("BLANK CONFIRMATION PASSWORD");
			}else {
				setErrorMessage("BLANK PASSWORD");
			}
			return;
		}
		//checks if username, password, and email fields match character limitations in the database
		if (username.length() > 30 || passwordConf.length() > 30 || password.length() > 20 || email.length() > 30) {
			setErrorStatus(true);
			if (username.length() > 30) {
				setErrorMessage("USERNAME IS TOO LONG. MUST BE LESS THAN 30 CHARACTERS");
			}
			else if (password.length() > 20) {
				setErrorMessage("PASSWORD IS TOO LONG. MUST BE BETWEEN 6 AND 20 CHARACTERS");
			}
			else if (passwordConf.length() > 20) {
				setErrorMessage("CONFIRMATION PASSWORD IS TOO LONG. MUST BE BETWEEN 6 AND 20 CHARACTERS");
			}
			else if (email.length() > 30) {
				setErrorMessage("EMAIL IS TOO LONG. MUST BE LESS THAN 30 CHARACTERS");
			}
			return;
		}
		//checks if password is too short
		else if (password.length() < 6) {
			setErrorStatus(true);
			setErrorMessage("PASSWORD IS TOO SHORT");
			return;
		}
		//checks if entered passwords don't match
		else if(!password.equals(passwordConf)) {
			setErrorStatus(true);
			setErrorMessage("PASSWORDS DO NOT MATCH");
			return;
		}
		//checks if username already exists in database
		else if(databaseOperator.retrieveUser(username).getUsername() != null) {
			setErrorStatus(true);
			setErrorMessage("USER ALREADY EXISTS");
			return;
		}
		//checks for errors for the entered address fields
		this.checkAddressError(shippingAB, billingAB);

	}

	public void checkAddressError(AddressBean shippingAB, AddressBean billingAB) {

		setErrorMessage(null);
		setErrorStatus(false);

		//checks if any of shipping address fields are blank
		if(shippingAB.getAddressLine1() == "" || shippingAB.getCountry() == "" || shippingAB.getProvince() == "" || shippingAB.getCity() == "" || shippingAB.getPhoneNumber() == "" || shippingAB.getZip() == "") {
			setErrorStatus(true);
			if (shippingAB.getAddressLine1() == "") {
				setErrorMessage("SHIPPING ADDRESS LINE 1 CANNOT BE BLANK");
			}
			else if(shippingAB.getCountry() == "" ) {
				setErrorMessage("SHIPPING ADDRESS COUNTRY CANNOT BE BLANK");
			}
			else if(shippingAB.getProvince() == "" ) {
				setErrorMessage("SHIPPING ADDRESS PROVINCE CANNOT BE BLANK");
			}
			else if(shippingAB.getCity() == "" ) {
				setErrorMessage("SHIPPING ADDRESS CITY CANNOT BE BLANK");
			}
			else if(shippingAB.getPhoneNumber() == "" ) {
				setErrorMessage("SHIPPING ADDRESS PHONE NUMBER CANNOT BE BLANK");
			}
			else if(shippingAB.getZip() == "" ) {
				setErrorMessage("SHIPPING ADDRESS ZIP CODE CANNOT BE BLANK");
			}
			return;
		}

		//checks if any of shipping address fields match character limitations in the database
		if (shippingAB.getAddressLine1().length() > 100 || shippingAB.getAddressLine2().length() > 100 || shippingAB.getCountry().length() > 20 || shippingAB.getProvince().length() > 20 || shippingAB.getCity().length() > 30 || shippingAB.getZip().length() > 20 || shippingAB.getPhoneNumber().length() > 20) {
			setErrorStatus(true);
			if (shippingAB.getAddressLine1().length() > 100) {
				setErrorMessage("SHIPPING ADDRESS LINE 1 IS TOO LONG");
			}
			else if (shippingAB.getAddressLine2().length() > 100) {
				setErrorMessage("SHIPPING ADDRESS LINE 2 IS TOO LONG");
			}
			else if(shippingAB.getCountry().length() > 20 ) {
				setErrorMessage("SHIPPING ADDRESS COUNTRY IS TOO LONG");
			}
			else if(shippingAB.getProvince() .length() > 20) {
				setErrorMessage("SHIPPING ADDRESS PROVINCE IS TOO LONG");
			}
			else if(shippingAB.getCity().length() > 30) {
				setErrorMessage("SHIPPING ADDRESS CITY IS TOO LONG");
			}
			else if(shippingAB.getPhoneNumber().length() > 20) {
				setErrorMessage("SHIPPING ADDRESS PHONE NUMBER IS TOO LONG");
			}
			else if(shippingAB.getZip().length() > 20) {
				setErrorMessage("SHIPPING ADDRESS ZIP CODE IS TOO LONG");
			}
			return;
		}


		//checks if any of billing address fields are blank
		if(billingAB.getAddressLine1() == "" || billingAB.getCountry() == "" || billingAB.getProvince() == "" || billingAB.getCity() == "" || billingAB.getPhoneNumber() == "" || billingAB.getZip() == "") {
			setErrorStatus(true);
			if (billingAB.getAddressLine1() == "") {
				setErrorMessage("BILLING ADDRESS LINE 1CANNOT BE BLANK");
			}
			else if(billingAB.getCountry() == "" ) {
				setErrorMessage("BILLING ADDRESS COUNTRY CANNOT BE BLANK");
			}
			else if(billingAB.getProvince() == "" ) {
				setErrorMessage("BILLING ADDRESS PROVINCE CANNOT BE BLANK");
			}
			else if(billingAB.getCity() == "" ) {
				setErrorMessage("BILLING ADDRESS CITY CANNOT BE BLANK");
			}
			else if(billingAB.getPhoneNumber() == "" ) {
				setErrorMessage("BILLING ADDRESS PHONE NUMBER CANNOT BE BLANK");
			}
			else if(billingAB.getZip() == "" ) {
				setErrorMessage("BILLING ADDRESS ZIP CODE CANNOT BE BLANK");
			}
			return;
		}

		//checks if any of billing address fields match character limitations in the database
		if (billingAB.getAddressLine1().length() > 100 || billingAB.getAddressLine2().length() > 100 || billingAB.getCountry().length() > 20 || billingAB.getProvince().length() > 20 || billingAB.getCity().length() > 30 || billingAB.getZip().length() > 20 || billingAB.getPhoneNumber().length() > 20) {
			setErrorStatus(true);
			if (billingAB.getAddressLine1().length() > 100) {
				setErrorMessage("BILLING ADDRESS LINE 1 IS TOO LONG");
			}
			else if (billingAB.getAddressLine2().length() > 100) {
				setErrorMessage("BILLING ADDRESS LINE 2 IS TOO LONG");
			}
			else if(billingAB.getCountry().length() > 20 ) {
				setErrorMessage("BILLING ADDRESS COUNTRY IS TOO LONG");
			}
			else if(billingAB.getProvince() .length() > 20) {
				setErrorMessage("BILLING ADDRESS PROVINCE IS TOO LONG");
			}
			else if(billingAB.getCity().length() > 30) {
				setErrorMessage("BILLING ADDRESS CITY IS TOO LONG");
			}
			else if(billingAB.getPhoneNumber().length() > 20) {
				setErrorMessage("BILLING ADDRESS PHONE NUMBER IS TOO LONG");
			}
			else if(billingAB.getZip().length() > 20) {
				setErrorMessage("BILLING ADDRESS ZIP CODE IS TOO LONG");
			}
			return;
		}
	}

	public void checkPaymentInformation(String creditCardNumber, String expiryMonth, String expiryDay, String securityCode) {

		setErrorMessage(null);
		setErrorStatus(false);

		//checks if any of the payment fields are blank
		if (creditCardNumber == "" || expiryMonth == "" || expiryDay == "" || securityCode == "") {
			setErrorStatus(true);
			if (creditCardNumber == "") {
				setErrorMessage("BLANK CREDIT CARD NUMBER");
			}
			else if (expiryMonth == "") {
				setErrorMessage("BLANK EXPIRY MONTH");
			}
			else if (expiryDay == "") {
				setErrorMessage("BLANK EXPIRY DAY");
			}
			else if (securityCode == "") {
				setErrorMessage("BLANK SECURITY CODE");
			}
			return;
		}

		//checks if the payment fields have the correct lengths
		if (creditCardNumber.length() != 12 || expiryMonth.length() != 2 || expiryDay.length() != 2 || securityCode.length() != 3) {
			setErrorStatus(true);
			if (creditCardNumber.length() != 12) {
				setErrorMessage("CREDIT CARD NUMBER MUST BE 12 DIGITS");
			}
			else if (expiryMonth.length() != 2) {
				setErrorMessage("EXPIRY MONTH MUST BE 2 DIGITS");
			}
			else if (expiryDay.length() != 2) {
				setErrorMessage("EXPIRY DAY MUST BE 2 DIGITS");
			}
			else if (securityCode.length() != 3) {
				setErrorMessage("SECURITY CODE MUST BE 3 DIGITS");
			}
			return;
		}

	}

	public void checkServicesError(String id) {

		setErrorMessage(null);
		setErrorStatus(false);

		//checks if the BID value is blank
		if (id == "") {
			setErrorMessage("BLANK BID VALUE");
			setErrorStatus(true);
		}
	}

	public void checkReviewError(String review) {

		setErrorMessage(null);
		setErrorStatus(false);

		//checks if the BID value is blank
		if (review == "") {
			setErrorMessage("REVIEW CANNOT BE BLANK");
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