package model;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import DAO.*;
import bean.*;

public class Model {
	private UserDAO userDAO;
	private BookDAO bookDAO;

	private boolean errorStatus;
	private String errorMessage;

	public Model() {

		this.errorStatus = false;
		this.errorMessage = null;

		try {
			userDAO = new UserDAO();
			bookDAO = new BookDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***************************************************************
	DATABASE USER OPERATIONS
    ****************************************************************/
	
	public UserBean retrieveUser(String username){
		try {
			return userDAO.retrieveUser(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(String username, String email, String password) {
		try {
			userDAO.addUser(username, email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(String username, String newPassword) {
		try {
			userDAO.updatePassword(username, newPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***************************************************************
	DATABASE BOOK OPERATIONS
    ****************************************************************/
	
	public ArrayList<BookBean> retrieveAllBooks(){
		try {
			return bookDAO.retrieveAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

}
	
	public BookBean retrieveBook(String bid){
			try {
				return bookDAO.retrieveBook(bid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public ArrayList<BookBean> retrieveByAuthor(String author){
		try {
			return bookDAO.retrieveByAuthor(author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BookBean> retrieveByTitle(String title){
		try {
			return bookDAO.retrieveByTitle(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<BookBean>retrieveByCategory(String category){
		try {
			return bookDAO.retrieveByCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BookBean> retrieveByPriceRange(int lowerRange, int higherRange){
		try {
			return bookDAO.retrieveByPriceRange(lowerRange, higherRange);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BookBean>retrieveByQuery(String query){
		try {
			return bookDAO.retrieveBookByQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> retrieveUniqueCategories(){
		try {
			return bookDAO.retrieveUniqueCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/***************************************************************
		ERROR CHECKING METHODS
	 ****************************************************************/
	
	public void checkLoginError(String username, String password) {
		this.errorMessage = null;
		this.errorStatus = false;
		if (username == "" || password == "") {
			this.errorStatus = true;
			if(username == "") {
				this.errorMessage = "BLANKUSERNAME";
			}
			else {
				this.errorMessage = "BLANKPASSWORD";
			}
		}
		else if (!checkUserExists(username)) {
			this.errorStatus = true;
			this.errorMessage = "USERNOTFOUND";
		}
		else if (!passwordValidation(username, password)){
			this.errorStatus = true;
			this.errorMessage = "WRONGPASSWORD";
		}

	}
	
	public void checkSignUpError(String username, String email, String password, String passwordConf) {
		this.errorMessage = null;
		this.errorStatus = false;
		if (username == "" || email == "" || password == "") {
			this.errorStatus = true;
			if(username == "") {
				this.errorMessage = "BLANKUSERNAME";
			}else if (email == ""){
				this.errorMessage = "BLANKEMAIL";
			}else {
				this.errorMessage = "BLANKPASSWORD";
			}
			return;
		}
		else if (!email.contains("@") || email.length() < 3) {
			this.errorStatus = true;
			this.errorMessage = "EMAILFORMAT";
		}
		else if (password.length() < 6) {
			this.errorStatus = true;
			this.errorMessage = "SHORTPASSWORD";
		}
		else if(!password.equals(passwordConf)) {
			this.errorStatus = true;
			this.errorMessage = "PASSWORDMISMATCH";
		}
	}
	
	public boolean passwordValidation(String username, String password) {
		UserBean ub = new UserBean();
		try {
			ub = retrieveUser(username);
			System.out.println(ub.getPassword());
			return ub.getPassword().equals(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkUserExists(String username) {
		try {
			return userDAO.checkUserExists(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getErrorStatus() {
		return this.errorStatus;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
		}

	/***************************************************************
			Product Catalog Component/Service
	 ****************************************************************/
	
public void exportProductServices(String bid, String filename) throws Exception{
		
	
		BookBean bb = retrieveBook(bid);
		String title = bb.getTitle();
		String author = bb.getAuthor();
		double price = bb.getPrice();
		String description = bb.getDescription();
		int publishYear = bb.getPublishYear();
		double rating = bb.getRating();
		String cat = bb.getCategory();
		
		BookWrapper bw = new BookWrapper(bid, title, author, price, description, publishYear,
			rating, cat);
		
		//String path = filename.split("export")[0]+"export";
		//SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		//Schema schema = sf.newSchema(new File(path+"/SIS.xsd"));
		
		JAXBContext jc = JAXBContext.newInstance(bw.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);


		StringWriter sw = new StringWriter();
		
		sw.write("\n");
		
		//marshaller.setSchema (schema);
		marshaller.marshal(bw, new StreamResult(sw));
		
		System.out.println(sw.toString());
		
		
		FileWriter fw = new FileWriter(filename);
		
		fw.write(sw.toString());
		fw.close();
	}
	
}














