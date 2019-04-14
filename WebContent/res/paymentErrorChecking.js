function paymentValidate() {
	var paymentShippingLine1Error, paymentShippingCountryError, paymentShippingProvinceError, paymentShippingCityError, paymentShippingZipError;
	paymentShippingLine1Error = document.getElementById("paymentShippingLine1Error");
	paymentShippingCountryError = document.getElementById("paymentShippingCountryError");
	paymentShippingProvinceError = document.getElementById("paymentShippingProvinceError");
	paymentShippingCityError = document.getElementById("paymentShippingCityError");
	paymentShippingZipError = document.getElementById("paymentShippingZipError");

	var paymentBillingLine1Error, paymentBillingCountryError, paymentBillingProvinceError, paymentBillingCityError, paymentBillingZipError;
	paymentBillingLine1Error = document.getElementById("paymentBillingLine1Error");
	paymentBillingCountryError = document.getElementById("paymentBillingCountryError");
	paymentBillingProvinceError = document.getElementById("paymentBillingProvinceError");
	paymentBillingCityError = document.getElementById("paymentBillingCityError");
	paymentBillingZipError = document.getElementById("paymentBillingZipError");
	
	var paymentShippingLine1ErrorStatus, paymentShippingCountryErrorStatus, paymentShippingProvinceErrorStatus, paymentShippingCityErrorStatus, paymentShippingZipErrorStatus;
	paymentShippingLine1ErrorStatus = false;
	paymentShippingCountryErrorStatus = false;
	paymentShippingProvinceErrorStatus = false;
	paymentShippingCityErrorStatus = false;
	paymentShippingZipErrorStatus = false;
	
	var paymentBillingLine1ErrorStatus, paymentBillingCountryErrorStatus, paymentBillingProvinceErrorStatus, paymentBillingCityErrorStatus, paymentBillingZipErrorStatus;
	paymentBillingLine1ErrorStatus = false;
	paymentBillingCountryErrorStatus = false;
	paymentBillingProvinceErrorStatus = false;
	paymentBillingCityErrorStatus = false;
	paymentBillingZipErrorStatus = false;
	
	var paymentAddressPhoneErrorStatus = false;
	
	var creditCardNumberErrorStatus, creditCardExpiryMonthErrorStatus, creditCardExpiryDayErrorStatus, creditCardSecurityErrorStatus;
	creditCardNumberErrorStatus = false;
	creditCardExpiryMonthErrorStatus = false;
	creditCardExpiryDayErrorStatus = false;
	creditCardSecurityErrorStatus = false;
	
	var paymentShippingLine1 = document.getElementById("paymentShippingLine1").value;
	if (paymentShippingLine1 == "" || paymentShippingLine1.length > 100) {
		paymentShippingLine1Error.innerHTML = "*";
		paymentShippingLine1Error.style.color = "red";
		paymentShippingLine1ErrorStatus = true;
	}
	else {
		paymentShippingLine1Error.innerHTML = "";
	}
	
	var paymentShippingCountry = document.getElementById("paymentShippingCountry").value;
	if (paymentShippingCountry == "" || paymentShippingCountry.length > 20) {
		paymentShippingCountryError.innerHTML = "*";
		paymentShippingCountryError.style.color = "red";
		paymentShippingCountryErrorStatus = true;
	}
	else {
		paymentShippingCountryError.innerHTML = "";
	}
	
	var paymentShippingProvince = document.getElementById("paymentShippingProvince").value;
	if (paymentShippingProvince == "" || paymentShippingProvince.length > 20) {
		paymentShippingProvinceError.innerHTML = "*";
		paymentShippingProvinceError.style.color = "red";
		paymentShippingProvinceErrorStatus = true;
	}
	else {
		paymentShippingProvinceError.innerHTML = "";
	}
	
	var paymentShippingCity = document.getElementById("paymentShippingCity").value;
	if (paymentShippingCity == "" || paymentShippingCity.length > 30) {
		paymentShippingCityError.innerHTML = "*";
		paymentShippingCityError.style.color = "red";
		paymentShippingCityErrorStatus = true;
	}
	else {
		paymentShippingCityError.innerHTML = "";
	}
	
	var paymentShippingZip = document.getElementById("paymentShippingZip").value;
	if (paymentShippingZip == "" || paymentShippingCity.length > 20) {
		paymentShippingZipError.innerHTML = "*";
		paymentShippingZipError.style.color = "red";
		paymentShippingZipErrorStatus = true;
	}
	else {
		paymentShippingZipError.innerHTML = "";
	}
	
	var paymentBillingLine1 = document.getElementById("paymentBillingLine1").value;
	if (paymentBillingLine1 == "" || paymentBillingLine1.length > 100) {
		paymentBillingLine1Error.innerHTML = "*";
		paymentBillingLine1Error.style.color = "red";
		paymentBillingLine1ErrorStatus = true;
	}
	else {
		paymentBillingLine1Error.innerHTML = "";
	}
	
	var paymentBillingCountry = document.getElementById("paymentBillingCountry").value;
	if (paymentBillingCountry == "" || paymentBillingCountry.length > 20) {
		paymentBillingCountryError.innerHTML = "*";
		paymentBillingCountryError.style.color = "red";
		paymentBillingCountryErrorStatus = true;
	}
	else {
		paymentBillingCountryError.innerHTML = "";
	}
	
	var paymentBillingProvince = document.getElementById("paymentBillingProvince").value;
	if (paymentBillingProvince == "" || paymentBillingProvince.length > 20) {
		paymentBillingProvinceError.innerHTML = "*";
		paymentBillingProvinceError.style.color = "red";
		paymentBillingProvinceErrorStatus = true;
	}
	else {
		paymentBillingProvinceError.innerHTML = "";
	}
	
	var paymentBillingCity = document.getElementById("paymentBillingCity").value;
	if (paymentBillingCity == "" || paymentBillingCity.length > 30) {
		paymentBillingCityError.innerHTML = "*";
		paymentBillingCityError.style.color = "red";
		paymentBillingCityErrorStatus = true;
	}
	else {
		paymentBillingCityError.innerHTML = "";
	}
	
	var paymentBillingZip = document.getElementById("paymentBillingZip").value;
	if (paymentBillingZip == "" || paymentBillingCity.length > 20) {
		paymentBillingZipError.innerHTML = "*";
		paymentBillingZipError.style.color = "red";
		paymentBillingZipErrorStatus = true;
	}
	else {
		paymentBillingZipError.innerHTML = "";
	}
	
	var paymentAddressPhone = document.getElementById("paymentAddressPhone").value;
	if (paymentAddressPhone == "" || paymentAddressPhone.length > 20) {
		paymentAddressPhoneError.innerHTML = "*";
		paymentAddressPhoneError.style.color = "red";
		paymentAddressPhoneErrorStatus = true;
	}
	else {
		paymentAddressPhoneError.innerHTML = "";
	}
	
	var creditCardNumber = document.getElementById("creditCardNumber").value;
	if (creditCardNumber == "" || creditCardNumber.length > 15) {
		creditCardNumberError.innerHTML = "*";
		creditCardNumberError.style.color = "red";
		creditCardNumberErrorStatus = true;
	}
	else {
		creditCardNumberError.innerHTML = "";
	}
	
	var creditCardExpiryMonth = document.getElementById("creditCardExpiryMonth").value;
	if (creditCardExpiryMonth == "" || creditCardExpiryMonth < 1 || creditCardExpiryMonth > 12) {
		creditCardExpiryMonthError.innerHTML = "*";
		creditCardExpiryMonthError.style.color = "red";
		creditCardExpiryMonthErrorStatus = true;
	}
	else {
		creditCardExpiryMonthError.innerHTML = "";
	}
	
	var creditCardExpiryDay = document.getElementById("creditCardExpiryDay").value;
	if (creditCardExpiryDay == "" || creditCardExpiryDay < 1 || creditCardExpiryDay > 31) {
		creditCardExpiryDayError.innerHTML = "*";
		creditCardExpiryDayError.style.color = "red";
		creditCardExpiryDayErrorStatus = true;
	}
	else {
		creditCardExpiryDayError.innerHTML = "";
	}
	
	var creditCardSecurity = document.getElementById("creditCardSecurity").value;
	if (creditCardSecurity == "" || creditCardSecurity.length != 3) {
		creditCardSecurityError.innerHTML = "*";
		creditCardSecurityError.style.color = "red";
		creditCardSecurityErrorStatus = true;
	}
	else {
		creditCardSecurityError.innerHTML = "";
	}
	
	if (paymentShippingLine1ErrorStatus) {
		alert("Please enter a valid shipping line 1 that is not empty and less than 100 characters.");
		return false;
	}
	if (paymentShippingCountryErrorStatus) {
		alert("Please enter a valid shipping country that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentShippingProvinceErrorStatus) {
		alert("Please enter a valid shipping province that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentShippingCityErrorStatus) {
		alert("Please enter a valid shipping city that is not empty and less than 30 characters.");
		return false;
	}
	if (paymentShippingZipErrorStatus) {
		alert("Please enter a valid shipping city that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentBillingLine1ErrorStatus) {
		alert("Please enter a valid billing line 1 that is not empty and less than 100 characters.");
		return false;
	}
	if (paymentBillingCountryErrorStatus) {
		alert("Please enter a valid billing country that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentBillingProvinceErrorStatus) {
		alert("Please enter a valid billing province that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentBillingCityErrorStatus) {
		alert("Please enter a valid billing city that is not empty and less than 30 characters.");
		return false;
	}
	if (paymentBillingZipErrorStatus) {
		alert("Please enter a valid billing city that is not empty and less than 20 characters.");
		return false;
	}
	if (paymentAddressPhoneErrorStatus) {
		alert("Please enter a valid phone-number.");
		return false;
	}
	if (creditCardNumberErrorStatus) {
		alert("Please enter a valid credit card number.");
		return false;
	}
	if (creditCardExpiryMonthErrorStatus) {
		alert("Please enter a valid expiry month.");
		return false;
	}
	if (creditCardExpiryDayErrorStatus) {
		alert("Please enter a valid expiry day.");
		return false;
	}
	if (creditCardSecurityErrorStatus) {
		alert("Please enter a valid three digit credit card security code.");
		return false;
	}

	return true;
}

function billingAddressVisibility() {
	
	checkbox = document.getElementById("sameTypesCheckbox");
	billingAddressDiv = document.getElementById("billingAddress");
	
	if (checkbox.checked){
		billingAddressDiv.style.visibility = 'hidden'
	}
	else{
		billingAddressDiv.style.visibility = 'visible'
	}
}