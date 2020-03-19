/**
 * 
 */
package com.savan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.savan.config.DBConnection;
import com.savan.dao.RegisterAddressDao;
import com.savan.model.RegisterAddressModel;

/**
 * @author inex2
 *
 */
public class RegistrAddressDaoImpl implements RegisterAddressDao {

	// Connection object
	Connection con = null;

	// Address model class object
	RegisterAddressModel addressModel = null;

	@Override
	public boolean insert(List<List<String>> addressList, int lastId) {

		// Insert Query
		String sql = "INSERT INTO user_address (line_1,line_2,city,state,country,zipcode,user_id) VALUES(?,?,?,?,?,?,?);";

		try {
			con = DBConnection.getConnection();

			/*
			 * ps.setString(1, addressModel.getAddress1()); ps.setString(2,
			 * addressModel.getAddress2()); ps.setString(3, addressModel.getCity());
			 * ps.setString(4, addressModel.getState()); ps.setString(5,
			 * addressModel.getCountry()); ps.setString(6, addressModel.getZipcode());
			 */
			
			int ans = 0;
			int index = 0;
			while (addressList.size() > index) {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, addressList.get(index).get(0));
				ps.setString(2, addressList.get(index).get(1));
				ps.setString(3, addressList.get(index).get(2));
				ps.setString(4, addressList.get(index).get(3));
				ps.setString(5, addressList.get(index).get(4));
				ps.setString(6, addressList.get(index).get(5));
				ps.setInt(7, lastId);
				ans = ps.executeUpdate();
				index++;
			}
			
			if (ans > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public JSONObject fatchAddress(int userId) {

		// Validate User
		String sql = "SELECT * FROM user_address WHERE user_id=?";

		try {
			con = DBConnection.getConnection();
			addressModel = new RegisterAddressModel();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			// list to store user addresslist
			List<List<String>> addressList = new ArrayList<List<String>>();
			
			//Creating a JSONObject object
		      JSONObject jsonObject = new JSONObject();
			
			//Creating a json array
		     JSONArray array = new JSONArray();
			
			while (rs.next()) {
				
				JSONObject record = new JSONObject();
				
				// Inserting key-value pairs into the json object
				record.put("AddressID", rs.getInt(1));
				record.put("home", rs.getString(2));
				record.put("landmark", rs.getString(3));
				record.put("city", rs.getString(4));
				record.put("state", rs.getString(5));
				record.put("country", rs.getString(6	));
				array.add(record);
				
				/*
				 * addressModel.setAddress1(rs.getString(2));
				 * addressModel.setAddress2(rs.getString(3));
				 * addressModel.setCity(rs.getString(4));
				 * addressModel.setCountry(rs.getString(5));
				 * addressModel.setState(rs.getString(6));
				 * addressModel.setZipcode(rs.getString(7));
				 * addressModel.setUserId(rs.getInt(8));
				 */
				
				// List to store address depratly
				List<String> address = new ArrayList<String>();

				address.add(Integer.toString(rs.getInt(1)));
				address.add(rs.getString(2));
				address.add(rs.getString(3));
				address.add(rs.getString(4));
				address.add(rs.getString(5));
				address.add(rs.getString(6));
				address.add(rs.getString(7));

				// appaend seprate addresses to addresslist
				addressList.add(address);
			}
			jsonObject.put("addressList", array);

			return jsonObject;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<List<String>> fetchAllUserAddress() {

		// list to store the user info
		//List<RegisterAddressModel> userAddressList = null;

		// Validate User
		String sql = "SELECT * FROM user_address";

		try {
			con = DBConnection.getConnection();
			addressModel = new RegisterAddressModel();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			// list to store user addresslist
			List<List<String>> addressList = new ArrayList<List<String>>();
						
			while (rs.next()) {
				/*
				 * userAddressList = new ArrayList<RegisterAddressModel>();
				 * addressModel.setAddress1(rs.getString(2));
				 * addressModel.setAddress2(rs.getString(3));
				 * addressModel.setCity(rs.getString(4));
				 * addressModel.setCountry(rs.getString(5));
				 * addressModel.setState(rs.getString(6));
				 * addressModel.setZipcode(rs.getString(7));
				 * addressModel.setUserId(rs.getInt(8)); userAddressList.add(addressModel);
				 */
				
				// List to store address depratly
				List<String> address = new ArrayList<String>();

				address.add(rs.getString(2));
				address.add(rs.getString(3));
				address.add(rs.getString(4));
				address.add(rs.getString(5));
				address.add(rs.getString(6));
				address.add(rs.getString(7));

				// appaend seprate addresses to addresslist
				addressList.add(address);
			}
			return addressList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(List<List<String>> addressList, int userId) {
		
		// Update Query
		String sql = "UPDATE user_address SET line_1=?,line_2=?,city=?,state=?,country=?,zipcode=? WHERE address_id=?";

		try {
			con = DBConnection.getConnection();

			/*
			 * ps.setString(1, addressModel.getAddress1()); ps.setString(2,
			 * addressModel.getAddress2()); ps.setString(3, addressModel.getCity());
			 * ps.setString(4, addressModel.getState()); ps.setString(5,
			 * addressModel.getCountry()); ps.setString(6, addressModel.getZipcode());
			 * ps.setInt(7, userId);
			 */
			
			int ans = 0;
			int index = 0;
			while (addressList.size() > index) {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, addressList.get(index).get(1));
				ps.setString(2, addressList.get(index).get(2));
				ps.setString(3, addressList.get(index).get(3));
				ps.setString(4, addressList.get(index).get(4));
				ps.setString(5, addressList.get(index).get(5));
				ps.setString(6, addressList.get(index).get(6));
				ps.setInt(7, userId);
				ans = ps.executeUpdate();
				index++;
			}
			
			if (ans > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean remoeUserAddress(int userId) {

		//delete query
		String sql = "DELETE FROM user_address WHERE user_id=?";
		
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			
			int ans = ps.executeUpdate();
			if (ans > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean remoeSelectedAddress(int addressId) {

		// delete query
		String sql = "DELETE FROM user_address WHERE address_id=?";

		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, addressId);

			int ans = ps.executeUpdate();
			if (ans > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
