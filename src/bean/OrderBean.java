package bean;

import java.util.ArrayList;

public class OrderBean {
	private int oid;
	private String orderDate;
	private String username;
	private ArrayList<BookBean> orderedBooks;
	
	public OrderBean() {
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<BookBean> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(ArrayList<BookBean> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}
		
	
}
