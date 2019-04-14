function opsValidate() {
	var BookidError;
	bookIDError = document.getElementById("BookidError");
	
	var bookIDErrorStatus;
	bookIDErrorStatus = false;
	
	var bookID = document.getElementById("Bookid").value;
	if (isNaN(bookID) || bookID == ""){
		bookIDError.innerHTML = "*";
		bookIDError.style.color = "red";
		bookIDErrorStatus = true;
	}else{
		bookIDError.innerHTML = "";
	}
	
	if (bookIDErrorStatus) {
		alert("Please enter a valid book id.");
		return false;
	}
	
	return true;
}