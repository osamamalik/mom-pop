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