function reviewValidate() {
	var reviewError;
	reviewError = document.getElementById("reviewError");
	
	var reviewErrorStatus;
	reviewErrorStatus = false;
	
	var review = document.getElementById("review").value;
	if (review.length == 0 || review.length > 2500) {
		reviewError.innerHTML = "*";
		reviewError.style.color = "red";
		reviewErrorStatus = true;
	}
	else {
		reviewError.innerHTML = "";
	}
	
	if (reviewErrorStatus) {
		alert("Please enter a review that is not empty and less than 2500 characters.");
		return false;
	}
	
	return true;
}