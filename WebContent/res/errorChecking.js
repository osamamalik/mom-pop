function loginValidate() {
	var loginNameError, loginPasswordError;
	loginNameError = document.getElementById("loginNameError");
	loginPasswordError = document.getElementById("loginPasswordError");
	
	var loginNameErrorStatus, loginPasswordErrorStatus;
	loginNameErrorStatus = false;
	loginPasswordErrorStatus = false;
	
	var loginName = document.getElementById("loginName").value;
	if (loginName == "") {
		loginNameError.innerHTML = "*";
		loginNameError.style.color = "red";
		loginNameErrorStatus = true;
	}
	else {
		loginNameError.innerHTML = "";
	}
	
	var loginPassword = document.getElementById("loginPassword").value;
	if (loginPassword == "") {
		loginPasswordError.innerHTML = "*";
		loginPasswordError.style.color = "red";
		loginPasswordErrorStatus = true;
	}
	else {
		loginNameError.innerHTML = "";
	}
	
	if (loginNameErrorStatus) {
		alert("Please enter a valid login name.");
		return false;
	}
	
	if (loginPasswordErrorStatus) {
		alert("Please enter a valid password.");
		return false;
	}
	
	return true;
}

function signUpValidate() {
	var signUpFirstNameError, signUpLastNameError, signUpEmailError, signUpPasswordError, signUpPasswordConfirmationError;
	signUpFirstNameError = document.getElementById("signUpFirstNameError");
	signUpLastNameError = document.getElementById("signUpLastNameError");
	signUpEmailError = document.getElementById("signUpEmailError");
	signUpPasswordError = document.getElementById("signUpPasswordError");
	signUpPasswordConfirmationError = document.getElementById("signUpPasswordConfirmationError");
	
	var shippingLine1Error, shippingLine2Error, shippingCountryError, shippingProvinceError, shippingCityError, shippingZipError;
	shippingLine1Error = document.getElementById("shippingLine1Error");
	shippingLine2Error = document.getElementById("shippingLine2Error");
	shippingCountryError = document.getElementById("shippingCountryError");
	shippingProvinceError = document.getElementById("shippingProvinceError");
	shippingCityError = document.getElementById("shippingCityError");
	shippingZipError = document.getElementById("shippingZipError");

	var billingLine1Error, billingLine2Error, billingCountryError, billingProvinceError, billingCityError, billingZipError;
	billingLine1Error = document.getElementById("billingLine1Error");
	billingLine2Error = document.getElementById("billingLine2Error");
	billingCountryError = document.getElementById("billingCountryError");
	billingProvinceError = document.getElementById("billingProvinceError");
	billingCityError = document.getElementById("billingCityError");
	billingZipError = document.getElementById("billingZipError");
	
	var signUpFirstNameErrorStatus, signUpLastNameErrorStatus, signUpEmailErrorStatus, signUpPasswordErrorStatus, signUpPasswordConfirmationErrorStatus;
	signUpFirstNameErrorStatus = false;
	signUpLastNameErrorStatus = false;
	signUpEmailErrorStatus = false;
	signUpPasswordErrorStatus = false;
	signUpPasswordConfirmationErrorStatus = false;
	
	var signUpFirstName = document.getElementById("signUpFirstName").value;
	if (signUpFirstName == "" || signUpFirstName.length > 30) {
		signUpFirstNameError.innerHTML = "*";
		signUpFirstNameError.style.color = "red";
		signUpFirstNameErrorStatus = true;
	}
	else {
		signUpFirstNameError.innerHTML = "";
	}
	
	var signUpLastName = document.getElementById("signUpLastName").value;
	if (signUpLastName == "" || signUpLastName.length > 30) {
		signUpLastNameError.innerHTML = "*";
		signUpLastNameError.style.color = "red";
		signUpLastNameErrorStatus = true;
	}
	else {
		signUpLastNameError.innerHTML = "";
	}
	
	if (signUpFirstNameErrorStatus) {
		alert("Please enter a valid first name that is not empty and less than 30 characters.");
		return false;
	}
	if (signUpLastNameErrorStatus) {
		alert("Please enter a valid last name that is not empty and less than 30 characters.");
		return false;
	}

	return true;
}

function validate(){

	var nameError, creditError;
	nameError = document.getElementById("nameError");
	creditError = document.getElementById("creditError");
	
	var nameErrorStatus, creditErrorStatus;
	nameErrorStatus = false;
	creditErrorStatus = false;

	var namePrefix = document.getElementById("namePrefix").value;
	if (namePrefix == ""){
		nameError.innerHTML = "*";
		nameError.style.color = "red";
		nameErrorStatus = true;
	}else{
		nameError.innerHTML = "";
	}

	
	var minCreditTaken = document.getElementById("minCreditTaken").value;
	if (isNaN(minCreditTaken) || minCreditTaken <= 0){
		creditError.innerHTML = "*";
		creditError.style.color = "red";
		creditErrorStatus = true;
	}else{
		creditError.innerHTML = "";
	}

	if (nameErrorStatus){
		alert("Please enter a valid name");
		return false;
	}
	
	if (creditErrorStatus){
		alert("Please enter a valid credit value");
		return false;
	}
		
	
	return true;
}