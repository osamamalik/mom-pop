function signUpValidate() {
	var signUpFirstNameError, signUpLastNameError, signUpUsernameError, signUpEmailError, signUpPasswordError, signUpPasswordConfirmationError;
	signUpFirstNameError = document.getElementById("signUpFirstNameError");
	signUpLastNameError = document.getElementById("signUpLastNameError");
	signUpUsernameError = document.getElementById("signUpUsernameError");
	signUpEmailError = document.getElementById("signUpEmailError");
	signUpPasswordError = document.getElementById("signUpPasswordError");
	signUpPasswordConfirmationError = document.getElementById("signUpPasswordConfirmationError");
	
	var shippingLine1Error, shippingCountryError, shippingProvinceError, shippingCityError, shippingZipError;
	shippingLine1Error = document.getElementById("shippingLine1Error");
	shippingCountryError = document.getElementById("shippingCountryError");
	shippingProvinceError = document.getElementById("shippingProvinceError");
	shippingCityError = document.getElementById("shippingCityError");
	shippingZipError = document.getElementById("shippingZipError");

	var billingLine1Error, billingCountryError, billingProvinceError, billingCityError, billingZipError;
	billingLine1Error = document.getElementById("billingLine1Error");
	billingCountryError = document.getElementById("billingCountryError");
	billingProvinceError = document.getElementById("billingProvinceError");
	billingCityError = document.getElementById("billingCityError");
	billingZipError = document.getElementById("billingZipError");
	
	var signUpFirstNameErrorStatus, signUpLastNameErrorStatus, signUpUsernameErrorStatus, signUpEmailErrorStatus, signUpPasswordErrorStatus, signUpPasswordConfirmationErrorStatus;
	signUpFirstNameErrorStatus = false;
	signUpLastNameErrorStatus = false;
	signUpUsernameErrorStatus = false;
	signUpEmailErrorStatus = false;
	signUpPasswordErrorStatus = false;
	signUpPasswordConfirmationErrorStatus = false;
	
	var shippingLine1ErrorStatus, shippingCountryErrorStatus, shippingProvinceErrorStatus, shippingCityErrorStatus, shippingZipErrorStatus;
	shippingLine1ErrorStatus = false;
	shippingCountryErrorStatus = false;
	shippingProvinceErrorStatus = false;
	shippingCityErrorStatus = false;
	shippingZipErrorStatus = false;
	
	var billingLine1ErrorStatus, billingCountryErrorStatus, billingProvinceErrorStatus, billingCityErrorStatus, billingZipErrorStatus;
	billingLine1ErrorStatus = false;
	billingCountryErrorStatus = false;
	billingProvinceErrorStatus = false;
	billingCityErrorStatus = false;
	billingZipErrorStatus = false;
	
	var addressPhoneErrorStatus = false;
	
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
	
	var signUpUsername = document.getElementById("signUpUsername").value;
	if (signUpUsername == "" || signUpUsername.length > 30) {
		signUpUsernameError.innerHTML = "*";
		signUpUsernameError.style.color = "red";
		signUpUsernameErrorStatus = true;
	}
	else {
		signUpUsernameError.innerHTML = "";
	}
	
	var signUpEmail = document.getElementById("signUpEmail").value;
	if (signUpEmail == "" || signUpEmail.length > 30) {
		signUpEmailError.innerHTML = "*";
		signUpEmailError.style.color = "red";
		signUpEmailErrorStatus = true;
	}
	else {
		signUpEmailError.innerHTML = "";
	}
	
	var signUpPassword = document.getElementById("signUpPassword").value;
	if (signUpPassword.length < 6 || signUpPassword.length > 20) {
		signUpPasswordError.innerHTML = "*";
		signUpPasswordError.style.color = "red";
		signUpPasswordErrorStatus = true;
	}
	else {
		signUpPasswordError.innerHTML = "";
	}
	
	var signUpPasswordConfirmation = document.getElementById("signUpPasswordConfirmation").value;
	if (signUpPasswordConfirmation != signUpPassword) {
		signUpPasswordConfirmationError.innerHTML = "*";
		signUpPasswordConfirmationError.style.color = "red";
		signUpPasswordConfirmationErrorStatus = true;
	}
	else {
		signUpPasswordConfirmationError.innerHTML = "";
	}
	
	var shippingLine1 = document.getElementById("shippingLine1").value;
	if (shippingLine1 == "" || shippingLine1.length > 100) {
		shippingLine1Error.innerHTML = "*";
		shippingLine1Error.style.color = "red";
		shippingLine1ErrorStatus = true;
	}
	else {
		shippingLine1Error.innerHTML = "";
	}
	
	var shippingCountry = document.getElementById("shippingCountry").value;
	if (shippingCountry == "" || shippingCountry.length > 20) {
		shippingCountryError.innerHTML = "*";
		shippingCountryError.style.color = "red";
		shippingCountryErrorStatus = true;
	}
	else {
		shippingCountryError.innerHTML = "";
	}
	
	var shippingProvince = document.getElementById("shippingProvince").value;
	if (shippingProvince == "" || shippingProvince.length > 20) {
		shippingProvinceError.innerHTML = "*";
		shippingProvinceError.style.color = "red";
		shippingProvinceErrorStatus = true;
	}
	else {
		shippingProvinceError.innerHTML = "";
	}
	
	var shippingCity = document.getElementById("shippingCity").value;
	if (shippingCity == "" || shippingCity.length > 30) {
		shippingCityError.innerHTML = "*";
		shippingCityError.style.color = "red";
		shippingCityErrorStatus = true;
	}
	else {
		shippingCityError.innerHTML = "";
	}
	
	var shippingZip = document.getElementById("shippingZip").value;
	if (shippingZip == "" || shippingCity.length > 20) {
		shippingZipError.innerHTML = "*";
		shippingZipError.style.color = "red";
		shippingZipErrorStatus = true;
	}
	else {
		shippingZipError.innerHTML = "";
	}
	
	var billingLine1 = document.getElementById("billingLine1").value;
	if (billingLine1 == "" || billingLine1.length > 100) {
		billingLine1Error.innerHTML = "*";
		billingLine1Error.style.color = "red";
		billingLine1ErrorStatus = true;
	}
	else {
		billingLine1Error.innerHTML = "";
	}
	
	var billingCountry = document.getElementById("billingCountry").value;
	if (billingCountry == "" || billingCountry.length > 20) {
		billingCountryError.innerHTML = "*";
		billingCountryError.style.color = "red";
		billingCountryErrorStatus = true;
	}
	else {
		billingCountryError.innerHTML = "";
	}
	
	var billingProvince = document.getElementById("billingProvince").value;
	if (billingProvince == "" || billingProvince.length > 20) {
		billingProvinceError.innerHTML = "*";
		billingProvinceError.style.color = "red";
		billingProvinceErrorStatus = true;
	}
	else {
		billingProvinceError.innerHTML = "";
	}
	
	var billingCity = document.getElementById("billingCity").value;
	if (billingCity == "" || billingCity.length > 30) {
		billingCityError.innerHTML = "*";
		billingCityError.style.color = "red";
		billingCityErrorStatus = true;
	}
	else {
		billingCityError.innerHTML = "";
	}
	
	var billingZip = document.getElementById("billingZip").value;
	if (billingZip == "" || billingCity.length > 20) {
		billingZipError.innerHTML = "*";
		billingZipError.style.color = "red";
		billingZipErrorStatus = true;
	}
	else {
		billingZipError.innerHTML = "";
	}
	
	var addressPhone = document.getElementById("addressPhone").value;
	if (addressPhone == "" || addressPhone.length > 20) {
		addressPhoneError.innerHTML = "*";
		addressPhoneError.style.color = "red";
		addressPhoneErrorStatus = true;
	}
	else {
		addressPhoneError.innerHTML = "";
	}
	
	if (signUpFirstNameErrorStatus) {
		alert("Please enter a valid first name that is not empty and less than 30 characters.");
		return false;
	}
	if (signUpLastNameErrorStatus) {
		alert("Please enter a valid last name that is not empty and less than 30 characters.");
		return false;
	}
	if (signUpUsernameErrorStatus) {
		alert("Please enter a valid username that is not empty and less than 30 characters.");
		return false;
	}
	if (signUpEmailErrorStatus) {
		alert("Please enter a valid email that is not empty and less than 30 characters.");
		return false;
	}
	if (signUpPasswordErrorStatus) {
		alert("Please enter a valid password that is between 6 and 20 characters.");
		return false;
	}
	if (signUpPasswordConfirmationErrorStatus) {
		alert("Passwords do not match.");
		return false;
	}
	if (shippingLine1ErrorStatus) {
		alert("Please enter a valid shipping line 1 that is not empty and less than 100 characters.");
		return false;
	}
	if (shippingCountryErrorStatus) {
		alert("Please enter a valid shipping country that is not empty and less than 20 characters.");
		return false;
	}
	if (shippingProvinceErrorStatus) {
		alert("Please enter a valid shipping province that is not empty and less than 20 characters.");
		return false;
	}
	if (shippingCityErrorStatus) {
		alert("Please enter a valid shipping city that is not empty and less than 30 characters.");
		return false;
	}
	if (shippingZipErrorStatus) {
		alert("Please enter a valid shipping city that is not empty and less than 20 characters.");
		return false;
	}
	if (billingLine1ErrorStatus) {
		alert("Please enter a valid billing line 1 that is not empty and less than 100 characters.");
		return false;
	}
	if (billingCountryErrorStatus) {
		alert("Please enter a valid billing country that is not empty and less than 20 characters.");
		return false;
	}
	if (billingProvinceErrorStatus) {
		alert("Please enter a valid billing province that is not empty and less than 20 characters.");
		return false;
	}
	if (billingCityErrorStatus) {
		alert("Please enter a valid billing city that is not empty and less than 30 characters.");
		return false;
	}
	if (billingZipErrorStatus) {
		alert("Please enter a valid billing city that is not empty and less than 20 characters.");
		return false;
	}
	if (addressPhoneErrorStatus) {
		alert("Please enter a valid phone-number.");
		return false;
	}

	return true;
}