function loginValidate() {
	return true;
}

function signUpValidate() {
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