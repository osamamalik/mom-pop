package model;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import bean.*;
import model.*;


public class Services {
	
	private Model myModel;

	public Services() {
		myModel = new Model();
	}

	
	public void exportProductServices(int bid, String filename) throws Exception {
	
		BookBean bb = myModel.retrieveBook(bid);
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
	
		FileWriter fw = new FileWriter(filename);
		fw.write(sw.toString());
		fw.close();
		
	}
	
	public void exportOrderServices(int bid, String filename) throws Exception {
		
		ArrayList<OrderBean> aob = myModel.retrieveOrders(bid);
	
		for(int i = 0; i < aob.size() ; i++) {
			OrderBean ob = aob.get(i);
			String date = ob.getOrderDate();
			int oid = ob.getOid();
			String user = ob.getUsername();
			
			OrderWrapper  ow = new OrderWrapper(bid, date, oid, user);
			JAXBContext jc = JAXBContext.newInstance(ow.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			
			StringWriter sw = new StringWriter();
			sw.write("\n");
			
			marshaller.marshal(ow, new StreamResult(sw));
	
			System.out.println(sw.toString()); // for debugging
	
			FileWriter fw = new FileWriter(filename);
			fw.write(sw.toString());
			fw.close();
	
		}
	}
	
	
	
}
