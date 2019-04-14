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