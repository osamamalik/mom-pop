package bean;

import javax.xml.bind.annotation.XmlAccessorType;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "purchaseOrder")
@XmlAccessorType(XmlAccessType.NONE)
public class OrderWrapper {

	@XmlAttribute(name="orderDate")
	private String date;
	//	
	//	@XmlValue
	//	String date2 = this.getDate();

	@XmlElement(name="ShipTo")
	private AddressBean ShippingAddress;

	@XmlElement(name="BillTo")
	private AddressBean BillingAddress;


	@XmlElement(name="Items") //Book Map
	HashMap<BookBean, Integer> Item;

	private int bid;
	private int oid;

	private String user;

	public OrderWrapper(AddressBean ship, AddressBean bill, HashMap<BookBean, Integer> bMap, String date) {
		this.ShippingAddress = ship;
		this.BillingAddress = bill;
		this.Item = bMap;
		this.date = date;
	}


	public AddressBean getShippingAddress() {
		return ShippingAddress;
	}


	public void setShippingAddress(AddressBean shippingAddress) {
		ShippingAddress = shippingAddress;
	}


	public AddressBean getBillingAddress() {
		return BillingAddress;
	}


	public void setBillingAddress(AddressBean billingAddress) {
		BillingAddress = billingAddress;
	}


	public HashMap<BookBean, Integer> getbMap() {
		return Item;
	}


	public void setbMap(HashMap<BookBean, Integer> bMap) {
		this.Item = bMap;
	}



	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public OrderWrapper(int bid, String date, int oid, String user) {
		this.oid = oid;
		this.bid = bid;
		this.date = date;
		this.user = user;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public OrderWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}


}