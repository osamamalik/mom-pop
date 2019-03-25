package bean;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productReport")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class BookWrapper {
	//@XmlAttribute(name="bid")
	private String bid;
	//@XmlAttribute(name="title")
	private String title;
	//@XmlAttribute(name="author")
	private String author;
	//@XmlAttribute(name="price")
	private double price;
	//@XmlAttribute(name="description")
	private String description;
	//@XmlAttribute(name="publishYear")
	private int publishYear;
	//@XmlAttribute(name="rating")
	private double rating;
	//@XmlAttribute(name="category")
	private String category;
	//@XmlAttribute(name="url")
	private String url;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public BookWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookWrapper(String bid, String title, String author, double price, String description, int publishYear,
			double rating, String category) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.price = price;
		this.description = description;
		this.publishYear = publishYear;
		this.rating = rating;
		this.category = category;
		this.url = url;
	}
	
	
}
