package bean;

import java.util.HashMap;

public class OrderBean {
	private int oid;
	private String orderDate;
	private String username;
	private HashMap<BookBean, Integer> orderedBooks;
	private AddressBean shippingAddress;
	private AddressBean billingAddress;

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

	public HashMap<BookBean, Integer> getOrderedBooks() {
		return orderedBooks;
	}

	public void setOrderedBooks(HashMap<BookBean, Integer> orderedBooks) {
		this.orderedBooks = orderedBooks;
	}

	public AddressBean getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressBean shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public AddressBean getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressBean billingAddress) {
		this.billingAddress = billingAddress;
	}






}
