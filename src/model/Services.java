package model;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import bean.*;
import model.*;


public class Services {
	
	private DatabaseOperator databaseOperator;

	public Services() {
		databaseOperator = new DatabaseOperator();
	}

	
	public void exportProductServices(int bid, String filename) throws Exception {
	
		BookBean bb = databaseOperator.retrieveBook(bid);
		String title = bb.getTitle();
		String author = bb.getAuthor();
		String description = bb.getDescription();
		double price = bb.getPrice();
		int publishYear = bb.getPublishYear();
		double rating = bb.getRating();
		String cat = bb.getCategory();
	
	
		BookWrapper bw = new BookWrapper(bid, title, author, price, description, publishYear, rating, cat);
		
		JAXBContext jc = JAXBContext.newInstance(bw.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
	
		StringWriter sw = new StringWriter();
		sw.write("\n");
		
		marshaller.marshal(bw, new StreamResult(sw));
	
		System.out.println(sw.toString()); // for debugging
	
		FileWriter fw = new FileWriter(filename);
		fw.write(sw.toString());
		fw.close();
		
	}
	
	public void exportOrderServices(int bid, String filename) throws Exception {
		
		ArrayList<OrderBean> aob = databaseOperator.retrieveOrdersByBid(bid);
		
			
		for(int i = 0; i < aob.size() ; i++) {
			OrderBean ob = aob.get(i);
			String date = ob.getOrderDate();
			int oid = ob.getOid();
			String user = ob.getUsername();
			UserBean ub = databaseOperator.retrieveUser(user);
			String firstName = ub.getFirstName();
			String lastName = ub.getLastName();
			
			AddressBean shippingAdress = ob.getShippingAddress();
			AddressBean billingAdress = ob.getBillingAddress();
			shippingAdress.setName(firstName+" "+lastName);
			/*
			String shippingStreet = shippingAdress.getAddressLine1();
			String shippingCity = shippingAdress.getCity();
			String shippingState = shippingAdress.getProvince();
			String shippingZip = shippingAdress.getZip();
			
			String billingStreet = billingAdress.getAddressLine1();
			String billingCity = billingAdress.getCity();
			String billingState = billingAdress.getProvince();
			String billingZip = billingAdress.getZip();
			*/
			HashMap<BookBean, Integer> bMap = ob.getOrderedBooks();
			
			OrderWrapper  ow = new OrderWrapper(bid, date, oid, user);
			OrderWrapper ow2 = new OrderWrapper(shippingAdress, billingAdress, bMap, date);
			
			JAXBContext jc = JAXBContext.newInstance(ow2.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			
			StringWriter sw = new StringWriter();
			sw.write("\n");
			
			marshaller.marshal(ow2, new StreamResult(sw));
	
			System.out.println(sw.toString()); // for debugging
	
			FileWriter fw = new FileWriter(filename);
			fw.append(sw.toString());
			fw.close();
	
		}
	}
	
	public String exportProductWebServices(int bid) throws Exception {

		BookBean bb = databaseOperator.retrieveBook(bid);
		String title = bb.getTitle();
		String author = bb.getAuthor();
		double price = bb.getPrice();
		String description = bb.getDescription();
		int publishYear = bb.getPublishYear();
		double rating = bb.getRating();
		String cat = bb.getCategory();

	
		BookWrapper bw = new BookWrapper(bid, title, author, price, description, publishYear, rating, cat);
		
		JAXBContext jc = JAXBContext.newInstance(bw.getClass());
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

		StringWriter sw = new StringWriter();
		sw.write("\n");
		
		marshaller.marshal(bw, new StreamResult(sw));

		System.out.println(sw.toString()); // for debugging

	
		return sw.toString();
		
	}
	
	public String exportOrderWebServices(int bid) throws Exception {
		ArrayList<OrderBean> aob = databaseOperator.retrieveOrdersByBid(bid);
		String toReturn = "";
		
		for(int i = 0; i < aob.size() ; i++) {
			OrderBean ob = aob.get(i);
			String date = ob.getOrderDate();
			int oid = ob.getOid();
			String user = ob.getUsername();
			UserBean ub = databaseOperator.retrieveUser(user);
			String firstName = ub.getFirstName();
			String lastName = ub.getLastName();
			
			AddressBean shippingAdress = ob.getShippingAddress();
			AddressBean billingAdress = ob.getBillingAddress();
			shippingAdress.setName(firstName+" "+lastName);
			HashMap<BookBean, Integer> bMap = ob.getOrderedBooks();
			
			OrderWrapper  ow = new OrderWrapper(bid, date, oid, user);
			OrderWrapper ow2 = new OrderWrapper(shippingAdress, billingAdress, bMap, date);
			
			JAXBContext jc = JAXBContext.newInstance(ow2.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			
			StringWriter sw = new StringWriter();
			sw.write("\n");
			
			marshaller.marshal(ow2, new StreamResult(sw));
	
			System.out.println(sw.toString()); // for debugging
	
			
			toReturn += sw.toString();
			
	
		}
		return toReturn;
	}
	
	
	
}