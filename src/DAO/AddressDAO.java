package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.javafx.collections.MappingChange.Map;

import bean.*;
import model.*;
import DAO.*;


public class AddressDAO {

	private DataSource ds;
	
	public AddressDAO() throws ClassNotFoundException{
		try {
		  this.ds = (DataSource)(new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	

	public void addAddress(AddressBean ab) throws SQLException {
		String username = ab.getUsername();
		String address_type = ab.getType();
		String line1 = ab.getAddressLine1();
		String line2 = ab.getAddressLine2();
		String country = ab.getCountry();
		String province = ab.getProvince();
		String city = ab.getCity();
		String zip = ab.getZip();
		String phone = ab.getPhoneNumber();
		String query = "insert into ADDRESS (username, address_type, line1, line2, country, province, city, zip, phone) VALUES ('" + username + "','" + address_type + "','" + line1 + "','" + line2 + "','"  + country + "','" + province + "','"  + city + "','" + zip + "','" + phone + "')";
		Connection con = this.ds.getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
	}
	
	public AddressBean retrieveAddress(String username, String type) throws SQLException {
		String query = "select * from ADDRESS where username = '" + username + "' and address_type = '" + type + "'";
		Connection con = this.ds.getConnection();
		PreparedStatement p = con.prepareStatement(query);
		ResultSet r = p.executeQuery();
		AddressBean address = new AddressBean();
		if(r.next()){
			address.setUsername(username);
			address.setType(type);
			address.setAddressLine1(r.getString("line1"));
			address.setAddressLine2(r.getString("line2"));
			address.setCountry(r.getString("country"));
			address.setProvince(r.getString("province"));
			address.setCity(r.getString("city"));
			address.setZip(r.getString("zip"));
			address.setPhoneNumber(r.getString("phone"));
		}
		p.close();
		con.close();
		r.close();
		return address;
	}

}