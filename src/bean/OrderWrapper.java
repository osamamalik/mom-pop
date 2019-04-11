package bean;

import javax.xml.bind.annotation.XmlAccessorType;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orderReport")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class OrderWrapper {
	
	//@XmlAttribute(name="bid")
	private int bid;
	private int oid;
	private String date;
	private String user;
	
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